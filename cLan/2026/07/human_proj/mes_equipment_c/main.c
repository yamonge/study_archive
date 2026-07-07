/* POSIX에서 nanosleep을 쓰기 위해 필요 */
#ifndef _WIN32
    #define _POSIX_C_SOURCE 199309L
#endif

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <pthread.h>

#include "net.h"
#include "protocol.h"
#include "api_client.h"
#include "collector.h"
#include "config.h"

#ifdef _WIN32
    #include <windows.h>
#endif

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

int main(void)
{
    srand((unsigned int)time(NULL));

    if (net_init() != 0) {
        fprintf(stderr, "네트워크 초기화 실패\n");
        return 1;
    }
    if (api_client_init() != 0) {
        fprintf(stderr, "libcurl 초기화 실패\n");
        net_cleanup();
        return 1;
    }

    printf("수집기 가동 시작....\n");

    Collector collector;
    collector_init(&collector);
    collector_connect_to_device(&collector, L1_IP, L1_PORT);

    /* 원본 C#의 `_ = Task.Run(...)`에 대응: 수신 루프를 별도 스레드로 계속 실행 */
    pthread_t recv_tid;
    pthread_create(&recv_tid, NULL, collector_receive_loop, &collector);
    pthread_detach(recv_tid);

    for (;;) {
        WorkOrder order;
        bool has_order = api_poll_work_order(BASE_URL, MACHINE_ID, &order);

        if (has_order) {
            printf("작업 수주 : %s / 진행:%d/%d / 상태:%s\n",
                   order.product_code, order.current_qty, order.target_qty, order.status);
            collector_dispatch_work_order(&collector, order.id, order.product_code, order.target_qty);
        } else {
            printf("[-] 현재 할당된 작업이 없습니다.\n");
        }

        sleep_ms(POLLING_INTERVAL_MS);
    }

    /* 도달하지 않지만 형식상 정리 코드 */
    collector_destroy(&collector);
    api_client_cleanup();
    net_cleanup();
    return 0;
}