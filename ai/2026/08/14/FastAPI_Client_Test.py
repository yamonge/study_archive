from fastapi import FastAPI
import requests               # http 통신용
import json

# 서버 접속
SERVER_URL = "http://0.0.0.0:8000/"
print("AI 서버 클라이언트 시작(종료 = exit) \n")

# 사용자 입력
while True:
  mode = input("score or grade : ").strip()

  text = input("grade or id : ").strip()

  payload = {"mode" : mode, "text" : text}
  if payload["mode"] == "score":
    response = requests.get(
      SERVER_URL + "students/search",
      params={"min_score"  : payload["text"]}
    )
    result = response.json()
    print(f"\n 서버 응답 : \n {json.dumps(result, ensure_ascii=False, indent=2)}")

  elif payload["mode"] == "grade":
    response = requests.get(SERVER_URL + f"students/{payload['text']}/grade")
    result = response.json()
    print(f"\n 서버 응답 : \n {json.dumps(result, ensure_ascii=False, indent=2)}")