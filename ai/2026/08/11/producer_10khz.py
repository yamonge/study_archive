#  producer : 0.1초 마다 데이터 전송
#  consumer : 초당 약 10건씩 수신 tps 출력


from kafka import KafkaProducer
import random
import time
import json
from datetime import datetime

producer = KafkaProducer(bootstrap_servers='localhost:9092',
                         value_serializer=lambda v: json.dumps(v).encode('utf-8'))

topic = "press-force"
seq = 0 # 메세지의 순번을 지정하기 위한 변수 생성
print("Producer 시작 : 0.1초 마다 Force 데이터 전송")
while True:
    seq += 1
    force = random.uniform(130, 150)

    # 5% 확률로 이상 force 데이터 발생
    if random.random() < 0.05:
        force = random.uniform(175, 210)

    # 메세지 구성
    message = {
        "machin_id" : "press_01",
        "timestamp" : datetime.now().strftime("%Y-%m-%d %H:%M:%S.%f")[:-3],         # 현재시간을 밀리초 단위까지 문자열 저장
        "seq" : seq,
        "force" : round(force, 2)
    }

    producer.send(topic, value=message)
    producer.flush()

    print(f"전송 seq={message['seq']}, force={message['force']}")

    time.sleep(0.1)