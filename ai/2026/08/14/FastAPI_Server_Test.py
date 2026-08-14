from fastapi import FastAPI
from pydantic import BaseModel
from transformers import pipeline
import uvicorn
import json


students = [
  {"id" : 1, "name" : "홍길동", "score" : 85},
  {"id" : 2, "name" : "김철수", "score" : 72},
  {"id" : 3, "name" : "이영희", "score" : 95},
  {"id" : 4, "name" : "박민수", "score" : 60}
]

# FastAPI 인스턴스 생성
app = FastAPI(
  title = "학생 평균 점수 계산"
)

# 엔드포인트 정의
# 특정 점수 이상의 학생 정보를 반환
@app.get("/students/search")
def get_students(min_score : int):
  result = []
  for student in students:
    if student["score"] >= min_score:
      result.append(student)

  return result

@app.get("/students/{id}/grade")
def get_grade(id : int):
  result = {}
  for student in students:
    if student["id"] == id:
      result = student
      break

  if not result:
    print(f"{id} 는 존재 하지 않습니다.")
    return {"error" : f"{id} 는 존재하지 않습니다."}

  grade = ""

  if result["score"] >= 90:
    grade = "A"
  elif result["score"] >= 80:
    grade = "B"
  elif result["score"] >= 70:
    grade = "C"
  elif result["score"] >= 60:
    grade = "D"
  else:
    grade = "F"

  response = {
    "name" : result["name"],
    "score" : result["score"],
    "grade" : grade
  }

  return response

if __name__ == "__main__":
  uvicorn.run(app, host="0.0.0.0", port=8000)