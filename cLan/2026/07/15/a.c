#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>
#include <pthread.h>
#include <stdint.h>
#include <unistd.h>

void* recv_process(void* arg);
void* send_process(void* arg);

typedef struct {
    uint8_t type;
    uint16_t device_id;
    uint32_t value;
} Packet;


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
  server_addr.sin_addr.s_addr = htonl(INADDR_ANY);
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

    printf("클라이언트 접속 성공\n");

    pthread_t recv_thread;
    pthread_t send_thread;

    if(pthread_create(&recv_thread, NULL, recv_process, &client_sock) != 0){
      perror("recv 스레드 생성 실패");
      close(client_sock);
      continue;
    };
    if(pthread_create(&send_thread, NULL, send_process, &client_sock) != 0){
      shutdown(client_sock, SHUT_RDWR);
      pthread_join(recv_thread, NULL);

      close(client_sock);
      continue;
    };

    pthread_join(recv_thread, NULL);
    pthread_join(send_thread, NULL);

    close(client_sock);

  }
  return 0;
}

void* recv_process(void* arg){
  int client_sock = *(int*)arg;
  Packet packet;
  while(1){
    unsigned char buffer[7];
    size_t total_received = 0;

    while(total_received < sizeof(buffer)){
      ssize_t recv_size = recv(
        client_sock,
        buffer + total_received,
        sizeof(buffer) - total_received,
        0
      );

      if(recv_size == 0){
        printf("클라이언트 연결 종료\n");
        return NULL;
      }

      if(recv_size == -1){
        perror("recv 실패");
        return NULL;
      }

      total_received += (size_t)recv_size;
    }

    packet.type = buffer[0];

    uint16_t network_device_id;
    memcpy(&network_device_id, buffer + 1, sizeof(network_device_id));
    packet.device_id = ntohs(network_device_id);

    uint32_t network_value;
    memcpy(&network_value, buffer + 3, sizeof(network_value));
    packet.value = ntohl(network_value);

    printf(
      "수신 완료: type=%u, device_id=%u, value=%u\n",
      packet.type,
      packet.device_id,
      packet.value
    );
    

    for(size_t i = 0; i < sizeof(buffer); i++){
      printf("%02x ", buffer[i]);
    }

    printf("\n"); 

  }

  return NULL;
}

void* send_process(void* arg){
  int client_sock = *(int*)arg;
  
  while(1){
    unsigned char buffer[7];

    uint8_t type = 1;
    uint16_t device_id = 1;
    uint32_t temp = rand() % 100;

    buffer[0] = type;

    uint16_t network_device_id = htons(device_id);
    memcpy(buffer + 1, &network_device_id, sizeof(network_device_id));

    uint32_t network_value = htonl(temp);
    memcpy(buffer + 3, &network_value, sizeof(network_value));

    size_t total_sent = 0;

    while(total_sent < sizeof(buffer)){
      ssize_t send_size = send(client_sock, buffer + total_sent, sizeof(buffer) - total_sent, 0);

      if(send_size == 0){
        printf("더 이상 전송할 수 없습니다.");
        return NULL;
      }

      if(send_size == -1){
        perror("send 실패");
        return NULL;
      }

      total_sent += (size_t)send_size;
    }
    
    printf("온도 전송: %u\n", temp);

    sleep(1);
  }

  return NULL;
}