from fastapi import FastAPI
import joblib

app = FastAPI()
model = joblib.load("model.pkl")

@app.get("/predict")
def predict(f1: float, f2: float, f3: float):
    pred = model.predict([[f1, f2, f3]])
    return {"prediction": int(pred[0])}