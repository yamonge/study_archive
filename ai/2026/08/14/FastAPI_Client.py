from fastapi import FastAPI
import requests               # http 통신용
import json

# 서버 접속
SERVER_URL = "http://0.0.0.0:8000/analyze"
print("AI 서버 클라이언트 시작(종료 = exit) \n")

# 사용자 입력
while True:
  # 분석 모드 선택
  mode = input("분석 모드 입력(length / sentiment / keyword): ").strip()

  # exit 입력 시 종료
  if mode.lower() == "exit":
    print("클라이언트 종료")
    break

  # 분석할 문장 입력
  text = input("분석할 문장 입력 : ").strip()

  # 요청 데이터(json) 생성
  payload = {"mode" : mode, "text" : text}

  # POST 요청 전송
  try:
    response = requests.post(SERVER_URL, json=payload)
  except requests.exceptions.RequestException as e :
    print(f"서버 연결 오류 : {e} \n")
    continue

  # 서버 응답 처리
  if response.status_code == 200 :                # 정상 처리시
    result = response.json()
    print(f"\n 서버 응답 : \n {json.dumps(result, ensure_ascii=False, indent=2)}")
  else:
    print(f"오류 발생 : {response.status_code}, {response.text} \n")
    
