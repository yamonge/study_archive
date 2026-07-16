#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>

int main(void){
  int sock;
  struct sockaddr_in server_addr;
  
  sock = socket(AF_INET, SOCK_STREAM, 0);

  if(sock == -1){
    perror("socket 생성 실패");
    exit(1);
  }

  printf("소켓 생성 성공: %d \n", sock);

  memset(&server_addr, 0, sizeof(server_addr));

  server_addr.sin_family = AF_INET;
  server_addr.sin_addr.s_addr = htnol(INADDR_ANY);
  server_addr.sin_port = htons(5000);

  if(bind(
    sock,
    (struct sockaddr *)&server_addr,
    sizeof(server_addr)
  ) == -1){
    perror("bind 실패");
    exit(1);
  }

  printf("bind 성공\n");

  if(listen(sock, 5) == -1){
    perror("listen 실패");
    exit(1);
  }

  printf("클라이언트 접속 대기 중...\n");

  struct sockaddr_in client_addr;
  socklen_t client_addr_size = sizeof(client_addr);

  while(1){
    int client_sock = accept(
      sock,
      (struct sockaddr *)&client_addr,
      &client_addr_size
    );

    if(client_sock == -1){
      perror("accept 실패");
      continue;
    }

    while(1){

    }

    close(client_sock);

  }
  return 0;
}