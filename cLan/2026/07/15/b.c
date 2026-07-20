#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>
#include <pthread.h>
#include <stdint.h>
#include <unistd.h>

int main(void){
  int sock;
  struct sockaddr_in client_addr;

  sock = socket(AF_INET, SOCK_STREAM, 0);

  if(sock == -1){
    perror("socket 생성 실패");
    exit(1);
  }

  printf("socket 생성 성공!");

  memset(client_addr, 0, sizeof(client_addr));

  client_addr.sin_family = AF_INET;
  client_addr.sin_addr.s_addr = htonl(INADDR_ANY);
  client_addr.sin_port = htons(5000);
}