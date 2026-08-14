from fastapi import FastAPI
from pydantic import BaseModel
from transformers import pipeline
import uvicorn

# 감성 분석 모델 로드
# hugging Face의 사전 학습된 모델을 사용
sentiment_analyzer = pipeline("sentiment-analysis")

# Fast API 앱 인스턴스 생성
app = FastAPI(
  title = "ai 분석 서버"
)

# 데이터 구조 정의

class AnalysisRequest(BaseModel):
  mode : str # 분석 모드 (length/ sentiment/ keyword)
  text : str # 분석할 문장

# 분석 API를 위한 엔드포인트 정의
@app.post("/analyze")
async def analyze(request : AnalysisRequest):
  # 요청값 읽기
  mode = request.mode.lower()
  text = request.text

  # 문장 길이 분석
  if mode == "length":
    result = {
      "result" : len(text),
      "desc" : f"문장의 길이는  {len(text)} 자 입니다."
    }

  # 감성분석
  elif mode == "sentiment":
    analysis = sentiment_analyzer(text)[0]
    label = analysis["label"]
    score = round(analysis["score"], 3)
    result = {
      "result" : label,
      "confidence" : score,
      "desc" : f"감정 : {label}, 신뢰도 : {score}"
    }

  # 키워드 감지
  elif mode == "keyword":
    keywords = ["ai", "press", "factory", "defect", "data", "불량"]
    found = [w for w in keywords if w.lower() in text.lower()]
    result = {
      "result" : found,
      "desc" : f"키워드 발견 : {','.join(found) if found else '없음'}"
    }

  # 지원하지 않는 모드 처리
  else:
    result = {
      "error" : f"지원하지 않는 모드입니다: {mode}"
    }

  return result # json 결과 반환


# 서버 실행부
if __name__ == "__main__":
  uvicorn.run(app, host="0.0.0.0", port=8000)
