from sklearn.ensemble import RandomForestClassifier
import numpy as np
import joblib

X = np.random.randn(200, 3)
y = (X[:,0] + X[:,1] > 0).astype(int)

model = RandomForestClassifier()
model.fit(X, y)

joblib.dump(model, "model.pkl")
print("model.pkl 생성 완료!")