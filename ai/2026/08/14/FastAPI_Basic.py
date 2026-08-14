# FAST API 기본 실습
# GET 요청 -> 서버 상태 확인
# POST 요청 -> 사용자 데이터를 받아 처리 후 응답

from fastapi import FastAPI
from pydantic import BaseModel
from typing import Optional
import uvicorn
import pymongo

# FAST API 앱 인스턴스 생성
app = FastAPI(
  title = "FastAPI 기본 실습",
  description= "PyCharm에서 실습",
  version= "1.0.0"
)

# 데이터 모델 정의(post 요청 시)
class Item(BaseModel):
  name : str                            # 필수 : 아이템 이름
  price : float                         # 필수 : 가격
  description : Optional[str] = None    # 선택 : 설명

# 기본 엔드포인트 (GET 요청)

## 서버 상태 확인용 기본 엔드 포인트
@app.get("/")
def read_root():
  return {"message" : "FastAPI 서버가 정상적으로 동작 중입니다."}

@app.get("/hello")
def say_hello(name : str = '사용자'):
  return {"message" : f"안녕하세요 {name}님!"}

# 단순 post 요청(body 데이터 받기)
@app.post("/items/")
def create_item(item : Item):
  #간단하 로직 : 부가세 계산
  total_price = item.price * 1.1
  return {
    "name" : item.name,
    "price" : int(total_price),
    "description" : item.description,
    "message" : f"{item.name} 상품이 성공적으로 등록 되었습니다."
  }

# FastAPI 실행(uvicorn)
if __name__ == "__main__":
  uvicorn.run(app, host="0.0.0.0", port=8000)