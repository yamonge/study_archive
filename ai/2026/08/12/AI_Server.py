import socket
import struct  # 데이터 길이를 byte 형태로 변환하기 위한 라이브러리
import json
import numpy as np
import tensorflow as tf
from PIL import Image
from io import BytesIO

# CIFAR10 클래스 정의
CLASS_NAMES = [
    "airplane",
    "automobile",
    "bird",
    "cat",
    "deer",
    "dog",
    "frog",
    "horse",
    "ship",
    "truck"
]

# 학습된 모델 로드
print("AI 모델 로딩 시작")

model = tf.keras.models.load_model("./model/cifar10_model.h5")
print("AI 모델 로딩 완료")


## 데이터 수신 함수
def recv_all(sock, size):
    data = b''
    while len(data) < size:
        packet = sock.recv(size - len(data))
        if not packet:
            return None

        data += packet

        return data


## 이미지 추론 함수( 예측)
def predict_image(image_bytes):
    '''
  1. 클라이언트 분석 요청을 위해 이미지를 서버에 전송
  2. 이미지 바이트 처리
  3. 추론 실행
  4. 이미지 분류 결과 출력
  '''
    # byte -> pil image
    image = Image.open(BytesIO(image_bytes))

    # rgb 변환
    image = image.convert("RGB")

    # CIFA10 이미지 크기 맞춤
    image = image.resize((32, 32))

    image = np.array(image)

    # 정규화
    image = image / 255.0

    image = np.expand_dims(image, axis=0)
    print("입력 shape :", image.shape)

    # 모델 추론
    pred = model.predict(image, verbose=0)

    # 예측 결과 출력
    print("예측확률")
    print(pred)

    # 가장 높은 확률 찾기
    class_idx = np.argmax(pred[0])
    confidence = np.max(pred[0])

    print("예측 클래스 :", class_idx)
    print("신뢰도 :", confidence)

    # 결과 생성
    return {
        "class_id": int(class_idx),
        "class_name": CLASS_NAMES[class_idx],
        "confidence": float(confidence)
    }

## 서버 설정
HOST = "0.0.0.0"
PORT = 9997

## 서버 소켓 생성
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind((HOST, PORT))
server_socket.listen()

while True:
    client_socket, addr = server_socket.accept()
    print(f"클라이언트 {addr}가 연결되었습니다.")

    try:
        # 이미지 크기 수신
        header = recv_all(client_socket, 4)

        if header is None:
            print("서버 연결 종료 또는 데이터 수신 살패")
            break

        # 4 byte -> 정수 변환
        image_size = struct.unpack(">I", header)[0]
        print("이미지 크기 :", image_size)

        image_bytes = recv_all(client_socket, image_size)
        print("이미지 수신 완료")

        # AI 추론
        result = predict_image(image_bytes)
        print("추론 결과: ", result)

        # JSON 으로 변환
        result_json =  json.dumps(result, ensure_ascii=False).encode()

        # 결과 길이 전송
        client_socket.sendall((struct.pack(">I", len(result_json))))

        # 결과 데이터를 클라이언트에 전송
        client_socket.sendall(result_json)
        print("결과 전송 완료")

    except Exception as e:
        print("데이터 수신 중 오류 발생 :", e)
        break
    finally:
        client_socket.close()
        print(f"클라이언트 {addr} 연결 종료")
