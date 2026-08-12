# TCP/IP 클라이언트 예제
# 사용자가 입력한 메시지를 서버로 전송하고,
# 서버의 응답을 받아 출력하는 클라이언트 기능 실습

import socket

# 소켓 생성
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 서버 기본 설정
HOST = "0.0.0.0"
PORT = 9998

# 소켓 연결
client_socket.connect((HOST, PORT))
print(f"서버 {HOST}:{PORT}에 연결되었습니다.")
print("메시지를 입력하세요. (종료할려면 'exit' 입력)\n")

# 클라이언트와 메세지 송수신 루프
while True:
  message = input("보낼 메시지 : ")

  if message == "exit":
    client_socket.sendall(message.encode())
    break

  client_socket.sendall(message.encode())

  data = client_socket.recv(1024).decode()
  print(f"{data} \n")


# 소켓 닫기
client_socket.close()
print("클라이언트 종료 완료")
  




