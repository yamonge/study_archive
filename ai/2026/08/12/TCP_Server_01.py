#!/usr/bin/env python
# coding: utf-8

# TCP/IP 서버
# 클라이언트의 접속을 기다리며, 클라이언트가 보낸 메세지를 수신하고
# 간단한 응답을 보내는 기능

import socket


# 서버 기본 설정
HOST = "0.0.0.0"
PORT = 9998

# 소켓 객체 생성
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# IP와 포트를 소켓에 바인딩(연결)
server_socket.bind((HOST, PORT))

# 클라이언트 연결 대시 시작
server_socket.listen()
print(f"서버가 {HOST}:{PORT}에서 연결을 기다리고 있습니다...")

# 클라이언트 연결 수락
client_socket, client_address = server_socket.accept()
print(f"클라이언트 {client_address}가 연결되었습니다.")

# 클라이언트와 메세지 송수신 루프
while True:
    data = client_socket.recv(1024).decode()
    if not data:
        print("데이터 수신 종료 (클라이언트 연결 해제됨)")
        break
    if data.lower() == "exit":
        print("데이터 수신 종료 (클라이언트 연결 해제됨)")
        break

    # 수신된 메세지 출력
    print(f"클라이언트 메시지 : {data}")

    # 서버의 응답 생성
    reply = f"서버 응답 : [{data}] 잘 받았습니다."

    client_socket.sendall(reply.encode())

# 클라이언트 소켓 닫기
server_socket.close()
client_socket.close()
print("서버 종료 완료")




