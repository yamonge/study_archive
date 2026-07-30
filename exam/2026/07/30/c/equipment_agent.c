#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
#include <errno.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <sys/time.h>

#define SERVER_IP "127.0.0.1"
#define SERVER_PORT 5000

#define BUFFER_SIZE 256

// 정상 상태에서 데이터 전송 주기
#define SEND_INTERVAL 5

// 연결이 끊겼을 때 재접속 주기
#define RECONNECT_INTERVAL 3

// 서버 응답을 기다리는 최대 시간
#define RECV_TIMEOUT_SECONDS 3

int connect_to_server(void) {
    int sock;
    struct sockaddr_in server_addr;
    struct timeval timeout;

    // 1. 새로운 TCP 소켓 생성
    sock = socket(AF_INET, SOCK_STREAM, 0);

    if (sock == -1) {
        perror("[C 에이전트] 소켓 생성 실패");
        return -1;
    }

    // 2. recv() 응답 대기시간을 3초로 설정
    timeout.tv_sec = RECV_TIMEOUT_SECONDS;
    timeout.tv_usec = 0;

    if (setsockopt(
            sock,
            SOL_SOCKET,
            SO_RCVTIMEO,
            &timeout,
            sizeof(timeout)
    ) == -1) {
        perror("[C 에이전트] 수신 타임아웃 설정 실패");
        close(sock);
        return -1;
    }

    // 3. 서버 주소 초기화
    memset(&server_addr, 0, sizeof(server_addr));

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(SERVER_PORT);

    if (inet_pton(
            AF_INET,
            SERVER_IP,
            &server_addr.sin_addr
    ) != 1) {
        printf("[C 에이전트] 서버 IP 설정 실패\n");
        close(sock);
        return -1;
    }

    // 4. 서버 접속 시도
    if (connect(
            sock,
            (struct sockaddr *)&server_addr,
            sizeof(server_addr)
    ) == -1) {
        close(sock);
        return -1;
    }

    printf(
        "[C 에이전트] 서버 재접속 성공: %s:%d\n",
        SERVER_IP,
        SERVER_PORT
    );

    return sock;
}

int main(void) {
    int sock = -1;
    int production_count = 100;

    const char *equipment_id = "EQ001";

    char timestamp[32];
    char send_buffer[BUFFER_SIZE];
    char recv_buffer[BUFFER_SIZE];

    srand((unsigned int)time(NULL));

    while (1) {

        /*
         * 서버와 연결되어 있지 않으면
         * 3초마다 다시 접속한다.
         */
        if (sock == -1) {
            printf(
                "[C 에이전트] 서버 연결 시도: %s:%d\n",
                SERVER_IP,
                SERVER_PORT
            );

            sock = connect_to_server();

            if (sock == -1) {
                printf(
                    "[C 에이전트] 연결 실패 - %d초 후 재시도\n\n",
                    RECONNECT_INTERVAL
                );

                sleep(RECONNECT_INTERVAL);
                continue;
            }
        }

        // 설비 상태와 생산수량 생성
        const char *status;
        int produced_now;

        int status_random = rand() % 100;

        if (status_random < 80) {
            status = "RUNNING";
            produced_now = (rand() % 5) + 1;
            production_count += produced_now;
        } else {
            status = "STOPPED";
            produced_now = 0;
        }

        // 현재 시간 생성
        time_t now = time(NULL);
        struct tm *local_time = localtime(&now);

        strftime(
            timestamp,
            sizeof(timestamp),
            "%Y-%m-%dT%H:%M:%S",
            local_time
        );

        // 통신 규격에 맞는 메시지 생성
        snprintf(
            send_buffer,
            sizeof(send_buffer),
            "EQUIPMENT|%s|%s|%d|%s\n",
            equipment_id,
            status,
            production_count,
            timestamp
        );

        printf(
            "[C 에이전트] 생성 데이터: 상태=%s, 이번 생산=%d, 누적=%d\n",
            status,
            produced_now,
            production_count
        );

        // 서버로 데이터 전송
        ssize_t sent_size = send(
            sock,
            send_buffer,
            strlen(send_buffer),

            /*
             * 서버가 갑자기 종료돼도 SIGPIPE 때문에
             * C 프로그램 전체가 종료되는 것을 방지한다.
             */
            MSG_NOSIGNAL
        );

        if (sent_size == -1) {
            perror("[C 에이전트] 전송 실패");

            close(sock);
            sock = -1;

            printf(
                "[C 에이전트] 연결 종료 - 재접속을 시작합니다.\n\n"
            );

            continue;
        }

        printf(
            "[C 에이전트] 데이터 전송: %s",
            send_buffer
        );

        // 서버 ACK 응답 수신
        ssize_t recv_size = recv(
            sock,
            recv_buffer,
            sizeof(recv_buffer) - 1,
            0
        );

        // recv()가 0이면 서버가 정상적으로 연결을 종료한 것
        if (recv_size == 0) {
            printf(
                "[C 에이전트] 서버 연결이 종료되었습니다.\n"
            );

            close(sock);
            sock = -1;

            printf(
                "[C 에이전트] 재접속을 시작합니다.\n\n"
            );

            continue;
        }

        // recv()가 -1이면 오류 또는 타임아웃
        if (recv_size == -1) {

            if (errno == EAGAIN || errno == EWOULDBLOCK) {
                printf(
                    "[C 에이전트] 서버 응답 시간 초과: %d초\n",
                    RECV_TIMEOUT_SECONDS
                );
            } else {
                perror("[C 에이전트] 응답 수신 실패");
            }

            close(sock);
            sock = -1;

            printf(
                "[C 에이전트] 연결을 초기화하고 재접속합니다.\n\n"
            );

            continue;
        }

        recv_buffer[recv_size] = '\0';

        printf(
            "[C 에이전트] 서버 응답: %s",
            recv_buffer
        );

        printf(
            "[C 에이전트] %d초 후 다음 데이터 전송\n\n",
            SEND_INTERVAL
        );

        sleep(SEND_INTERVAL);
    }

    return 0;
}