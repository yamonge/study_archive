import socket
import struct
import json
# 스레드
import threading

HOST = "0.0.0.0"
PORT = 9997
MAX_CLIENTS = 20

# 기본 분석 함수 정의
def analyze_text(request):
  mode = request.get("mode", "")
  text = request.get("text", "")

  # 길이 분석
  if mode == "length" :
    return {"result": len(text), "desc" : f"문자 길이 는 {len(text)} 입니다."}

  # 감정 분석
  elif mode == "sentiment":
    if any(w in text for w in ["좋아", "행복", "기쁨", "멋져"]):
      sentiment = "positive"
    elif any(w in text for w in ["나빠", "싫어", "불만", "짜증"]):
      sentiment = "negative"
    else:
      sentiment = "neutral"

    return {"result" : sentiment, "desc" : f"감성 분석 결과 : {sentiment}"}

  # 키워드 탐지
  elif mode == "keyword":
    keywords = ["전류상승", "속도저하", "불량", "유량저하", "온도상승"]
    found = [k for k in keywords if k in text if k in text]
    return {"result" : found, "desc" : f"발견된 키워드 : {','.join(found) if found else '없음'}"}

  # 기타 모드
  else:
    return {"error" : f"지원하지 않는 모드입니다. : {mode}"}

# 클라이언트 처리 쓰레드 함수
def handle_client(client_socket, address):
  print(f"클라이언트 {address} 연결됨")
  while True:
    try:
      # 클라이언트로부터 데이터 수신
      data = client_socket.recv(2048).decode()

      if not data:
        print(f"{address} 연결 끊김")
        break

      # json 데이터 파싱
      try:
        request = json.loads(data)
        result = analyze_text(request)
      except json.decoder.JSONDecodeError:
        result = {"error" : "잘못된 json 형식 입니다."}

      # 응답 전송 (json -> bytes)
      response = json.dumps(result, ensure_ascii=False)
      client_socket.sendall(response.encode())

    except ConnectionResetError:
      #클라이언트가 비정상적으로 종료될 경우
      print(f"{address} 비정상 종료")
      break

  # 연결 종료 처리
  client_socket.close()
  print(f"클라이언트 {address} 세션 종료 완료")




# 서버 메인 실행부
def start_server():
  server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  server_socket.bind((HOST, PORT))
  server_socket.listen(MAX_CLIENTS)

  print(f"AI 서버 실행 중..... {HOST} : {PORT}")
  print(f"최대 {MAX_CLIENTS} 개의 클라이언트 동시 접속 가능 \n")

  try:
    while True:
      client_socket, addr = server_socket.accept()
      # 쓰레드 생성 및 실행

      client_thread = threading.Thread(target=handle_client, args=(client_socket, addr), daemon=True)
      client_thread.start()

  except KeyboardInterrupt:
    print("\n 서버 수동 종료 감지")
  finally:
    server_socket.close()
    print("서버 완전 종료")

## 실행 시작
if __name__ == "__main__":
  start_server()
