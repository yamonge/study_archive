/* POSIX에서 localtime_r, nanosleep을 쓰기 위해 필요 */
#ifndef _WIN32
    #define _POSIX_C_SOURCE 199309L
#endif

#include "collector.h"
#include "protocol.h"
#include "api_client.h"
#include "config.h"

#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>

#ifdef _WIN32
    #include <windows.h>
#endif

void collector_init(Collector *c)
{
    c->sock = SOCKET_INVALID;
    c->connected = 0;
    c->current_order_id = 0;
    c->current_product_code[0] = '\0';
    c->has_order = 0;
    pthread_mutex_init(&c->lock, NULL);
}

void collector_destroy(Collector *c)
{
    pthread_mutex_destroy(&c->lock);
}

static void sleep_ms(int ms)
{
#ifdef _WIN32
    Sleep(ms);
#else
    struct timespec ts;
    ts.tv_sec = ms / 1000;
    ts.tv_nsec = (long)(ms % 1000) * 1000000L;
    nanosleep(&ts, NULL);
#endif
}

void collector_connect_to_device(Collector *c, const char *ip, int port)
{
    for (;;) {
        pthread_mutex_lock(&c->lock);
        int already = c->connected;
        pthread_mutex_unlock(&c->lock);
        if (already) {
            return;
        }

        socket_t s = net_connect(ip, port);
        if (s != SOCKET_INVALID) {
            pthread_mutex_lock(&c->lock);
            c->sock = s;
            c->connected = 1;
            pthread_mutex_unlock(&c->lock);
            printf("L1 장비 연결 성공\n");
            return;
        }

        printf("L1 연결 실패. 재 시도 중....\n");
        sleep_ms(3000);
    }
}

static void handle_temperature(int temp)
{
    if (temp >= 80) {
        printf("[경고] 과열: %d C\n", temp);
    }
}

/* GUID 8자리 대체용 랜덤 8자리 hex (완전한 유일성 보장은 아님, 8장 참고) */
static void make_serial_no(char *out, size_t out_size, const char *product_code)
{
    time_t now = time(NULL);
    struct tm tm_now;
#ifdef _WIN32
    localtime_s(&tm_now, &now);
#else
    localtime_r(&now, &tm_now);
#endif
    char date_part[16];
    strftime(date_part, sizeof(date_part), "%Y%m%d", &tm_now);

    unsigned int rand_part = ((unsigned int)(rand() & 0xFFFF) << 16) | (unsigned int)(rand() & 0xFFFF);
    snprintf(out, out_size, "%s-%s-%08X", product_code, date_part, rand_part);
}

static void handle_production_result(Collector *c, int result)
{
    pthread_mutex_lock(&c->lock);
    int has_order = c->has_order;
    long order_id = c->current_order_id;
    char product_code[64];
    snprintf(product_code, sizeof(product_code), "%s", c->current_product_code);
    pthread_mutex_unlock(&c->lock);

    if (!has_order) {
        printf("[WARN] 현재 작업 지시가 없어 생산 결과를 처리할 수 없습니다.\n");
        return;
    }

    char serial_no[128];
    make_serial_no(serial_no, sizeof(serial_no), product_code);

    ProductionReport report;
    memset(&report, 0, sizeof(report));
    report.order_id = order_id;
    snprintf(report.machine_id, sizeof(report.machine_id), "%s", MACHINE_ID);
    snprintf(report.serial_no, sizeof(report.serial_no), "%s", serial_no);
    snprintf(report.result, sizeof(report.result), "%s", (result == 1) ? "OK" : "NG");
    report.defect_code[0] = '\0';

    const char *status = api_report_production(BASE_URL, &report);

    if (strcmp(status, "SHORTAGE") == 0) {
        printf(" [ALARM] 자재 재고가 부족합니다! \n");
    } else {
        printf("생산 보고 : %s (%s)\n", report.result, status);
    }
}

void *collector_receive_loop(void *arg)
{
    Collector *c = (Collector *)arg;
    uint8_t buf[PACKET_SIZE];

    for (;;) {
        pthread_mutex_lock(&c->lock);
        int connected = c->connected;
        socket_t sock = c->sock;
        pthread_mutex_unlock(&c->lock);

        if (!connected) {
            collector_connect_to_device(c, L1_IP, L1_PORT);
            continue;
        }

        int n = net_recv_exact(sock, buf, PACKET_SIZE);
        if (n <= 0) {
            pthread_mutex_lock(&c->lock);
            net_close(c->sock);
            c->sock = SOCKET_INVALID;
            c->connected = 0;
            pthread_mutex_unlock(&c->lock);
            continue;
        }
        if (!packet_validate(buf)) {
            continue;
        }

        uint8_t type = packet_get_type(buf);
        int32_t val = packet_get_value(buf);

        if (type == MSG_TEMPERATURE) {
            handle_temperature(val);
        } else if (type == MSG_PRODUCTION_OR_ORDER) {
            handle_production_result(c, val);
        }
    }
    return NULL;
}

void collector_dispatch_work_order(Collector *c, long order_id, const char *product_code, int target_qty)
{
    pthread_mutex_lock(&c->lock);
    c->current_order_id = order_id;
    snprintf(c->current_product_code, sizeof(c->current_product_code), "%s", product_code);
    c->has_order = 1;
    int connected = c->connected;
    socket_t sock = c->sock;
    pthread_mutex_unlock(&c->lock);

    if (!connected) {
        return;
    }

    uint8_t packet[PACKET_SIZE];
    packet_build(packet, MSG_PRODUCTION_OR_ORDER, target_qty);

    if (net_send(sock, packet, PACKET_SIZE) < 0) {
        printf("연결이 끊어짐.\n");
        return;
    }

    printf("[CMD] 설비에 작업 지시 전달 -> 목표 수량: %d\n", target_qty);
}