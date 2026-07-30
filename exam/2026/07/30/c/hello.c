#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>

#define SERVER_IP "127.0.0.1"
#define SERVER_PORT 5000

int main(void) {
    int sock;
    struct sockaddr_in server_addr;

    sock = socket(AF_INET, SOCK_STREAM, 0);

    if (sock == -1) {
        perror("socket 생성 실패");
        return 1;
    }

    memset(&server_addr, 0, sizeof(server_addr));

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(SERVER_PORT);

    if (inet_pton(
        AF_INET,
        SERVER_IP,
        &server_addr.sin_addr
    ) != 1) {
        printf("서버 IP 설정 실패\n");
        close(sock);
        return 1;
    }

    printf("접속 대상 서버: %s:%d\n", SERVER_IP, SERVER_PORT);

    if (connect(
        sock,
        (struct sockaddr *)&server_addr,
        sizeof(server_addr)
    ) == -1) {
        perror("서버 연결 실패");
        close(sock);
        return 1;
    }

    printf("서버 연결 성공\n");

    close(sock);

    return 0;
}