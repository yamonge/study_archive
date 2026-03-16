#todo : LSTM을 이용한 차량 세이프티 학습 프로젝트
# 1. 데이터 수집
# 2. 데이터 전처리
# 3. 모델 설계
# 4. 모델 학습
# 5. 모델 평가
# 6. 모델 개선
# 7. 모델 배포

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import tensorflow as tf
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import MinMaxScaler
# 1. 데이터 수집
# 데이터는 CSV 파일로 가정
data = pd.read_csv('vehicle_safety_data.csv')
# 2. 데이터 전처리
# 결측치 처리
data.fillna(method='ffill', inplace=True)
# 특성 및 라벨 분리
X = data.drop('safety_label', axis=1).values
y = data['safety_label'].values
# 데이터 정규화
scaler = MinMaxScaler()
X_scaled = scaler.fit_transform(X)
# 시퀀스 데이터로 변환 (예: 10 타임스텝
def create_sequences(X, y, time_steps=10):
    Xs, ys = [], []
    for i in range(len(X) - time_steps):
        Xs.append(X[i:(i + time_steps)])
        ys.append(y[i + time_steps])
    return np.array(Xs), np.array(ys)
X_seq, y_seq = create_sequences(X_scaled, y)
# 3. 모델 설계
model = tf.keras.Sequential([
    tf.keras.layers.LSTM(64, return_sequences=True, input_shape=(X_seq.shape[1], X_seq.shape[2])),
    tf.keras.layers.LSTM(32),
    tf.keras.layers.Dense(1, activation='sigmoid')
])
model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])
# 4. 모델 학습
X_train, X_test, y_train, y_test = train_test_split(X_seq, y_seq, test_size=0.2, random_state=42)
history = model.fit(X_train, y_train, epochs=20, batch_size=32, validation_data=(X_test, y_test))
# 5. 모델 평가  
loss, accuracy = model.evaluate(X_test, y_test)
print(f'Test Loss: {loss}, Test Accuracy: {accuracy}')
# 6. 모델 개선
# 모델 개선을 위해 하이퍼파라미터 튜닝, 더 많은 데이터 수집, 또는 모델 아키텍처 변경 등을 고려할 수 있습니다.
