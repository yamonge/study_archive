import threading
import socket
import json
import struct

HOST = "192.168.133.118"

PORT = 9997

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect((HOST, PORT))

print("서버에 연결되었습니다. (종료하려면 'exit' 입력) \n")

# 송수신 루프

while True:
  mode = input("분석모드 (length / sentiment / keyword : )").strip()

  if mode.lower() == 'exit':
    client_socket.sendall(mode.encode())
    break

  text = input("분석할 문장 입력: ").strip()

  # 요청 json 구성
  request = {"mode" : mode, "text" : text}

  client_socket.sendall(json.dumps(request, ensure_ascii=False).encode())

  # 서버 응답 수신

  data = client_socket.recv(2048).decode()
  try:
    response = json.loads(data)
    print(f"\n 서버 응답 : {json.dumps(response, ensure_ascii=False, indent=2)}\n")
  except:
    print(f"서버 응답 오류: {data} \n")

client_socket.close()
print("클라이언트 서버 종료")
