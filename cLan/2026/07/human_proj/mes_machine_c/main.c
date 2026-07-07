/*
 * mes_machine (L1 장비 시뮬레이터) - C 포팅 버전
 * 원본: mes_machine/Program.cs (C#)
 *
 * TCP 서버로 동작하며, 수집기(L2)가 접속하면:
 *  - 1초마다 온도(0x10) 또는 생산실적(0x20)을 송신
 *  - L2가 보내는 작업지시(0x20)를 별도 스레드에서 수신
 */

/* POSIX에서 nanosleep()을 쓰려면 -std=c11(strict) 모드에서 이 매크로가 필요함 */
#ifndef _WIN32
    #define _POSIX_C_SOURCE 199309L
#endif

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <pthread.h>

#ifdef _WIN32
    #include <windows.h>
#else
    #include <time.h>
#endif

#include "net.h"
#include "protocol.h"

#define PORT 5006

/* 한 클라이언트(L2) 접속에 대한 상태를 묶어서 관리 */
typedef struct {
    socket_t client_sock;
    int target_qty;
    int produced_qty;
    pthread_mutex_t lock;   /* target_qty/produced_qty를 두 스레드가 공유하므로 보호 필요 */
    volatile int connected;
} DeviceState;

/* L2 -> L1 수신 전용 스레드: 작업지시(0x20) 패킷을 받아서 target_qty에 반영 */
static void *recv_thread_func(void *arg)
{
    DeviceState *state = (DeviceState *)arg;
    uint8_t buf[PACKET_SIZE];

    while (state->connected) {
        int n = net_recv_exact(state->client_sock, buf, PACKET_SIZE);
        if (n <= 0) {
            state->connected = 0;
            break;
        }
        if (!packet_validate(buf)) {
            continue; /* STX/ETX가 안 맞으면 무시 */
        }

        uint8_t type = packet_get_type(buf);
        int32_t val = packet_get_value(buf);

        if (type == MSG_PRODUCTION_OR_ORDER) {
            pthread_mutex_lock(&state->lock);
            state->target_qty = val;
            printf("[L2 -> L1] 작업지시 수신: 진행 %d/%d\n", state->produced_qty, state->target_qty);
            pthread_mutex_unlock(&state->lock);
        } else {
            printf("[L2 -> L1] 알 수 없는 명령: 0x%02X, val=%d\n", type, val);
        }
    }
    return NULL;
}

/* 플랫폼 무관 1초 sleep */
static void sleep_one_second(void)
{
#ifdef _WIN32
    Sleep(1000);
#else
    struct timespec ts;
    ts.tv_sec = 1;
    ts.tv_nsec = 0;
    nanosleep(&ts, NULL);
#endif
}

/* 접속 하나에 대한 메인 루프: 온도/생산실적을 계속 송신 */
static void run_device_loop(socket_t client_sock)
{
    DeviceState state;
    state.client_sock = client_sock;
    state.target_qty = 0;
    state.produced_qty = 0;
    state.connected = 1;
    pthread_mutex_init(&state.lock, NULL);

    pthread_t recv_tid;
    pthread_create(&recv_tid, NULL, recv_thread_func, &state);

    int tick = 0;

    while (state.connected) {
        tick++;

        uint8_t msg_type = MSG_TEMPERATURE;
        int value = 20 + (rand() % 70); /* 20~89 */

        pthread_mutex_lock(&state.lock);
        int target = state.target_qty;
        int produced = state.produced_qty;
        pthread_mutex_unlock(&state.lock);

        if (target > 0 && produced < target && (tick % 5 == 0)) {
            msg_type = MSG_PRODUCTION_OR_ORDER;
            value = (((double)rand() / RAND_MAX) > 0.1) ? 1 : 0;

            pthread_mutex_lock(&state.lock);
            state.produced_qty++;
            produced = state.produced_qty;
            pthread_mutex_unlock(&state.lock);

            printf("[L1 생산] 진행 %d/%d  | 결과=%s\n", produced, target, (value == 1) ? "OK" : "NG");
        }

        uint8_t packet[PACKET_SIZE];
        packet_build(packet, msg_type, value);

        if (net_send(state.client_sock, packet, PACKET_SIZE) < 0) {
            printf("연결이 끊어짐.\n");
            state.connected = 0;
            break;
        }

        printf("[L1 -> L2] 송신: 0x%02X | 값: %d\n", msg_type, value);

        sleep_one_second();
    }

    state.connected = 0;
    pthread_join(recv_tid, NULL);
    pthread_mutex_destroy(&state.lock);
    net_close(client_sock);
}

int main(void)
{
    srand((unsigned int)time(NULL));

    if (net_init() != 0) {
        fprintf(stderr, "네트워크 초기화 실패\n");
        return 1;
    }

    socket_t server_sock = net_listen(PORT, 1);
    if (server_sock == SOCKET_INVALID) {
        fprintf(stderr, "listen 실패: %s\n", net_last_error());
        net_cleanup();
        return 1;
    }

    printf("[L1 장비 가동] 수집기 접속 대기 중... (Port : %d)\n", PORT);

    while (1) {
        char client_ip[64];
        socket_t client_sock = net_accept(server_sock, client_ip, sizeof(client_ip));
        if (client_sock == SOCKET_INVALID) {
            fprintf(stderr, "accept 실패: %s\n", net_last_error());
            continue;
        }

        printf("수집기(L2)가 접속 되었습니다. Remote=%s\n", client_ip);
        run_device_loop(client_sock);
        printf("수집기 연결이 종료 되었습니다. 다시 대기 합니다.\n");
    }

    /* 도달하지 않지만 형식상 정리 코드 */
    net_close(server_sock);
    net_cleanup();
    return 0;
}