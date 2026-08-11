from kafka import KafkaProducer # kafka로 데이터를 보내는 producer 객체를 만들기 위한 클래스
import json
import random
import time

# kafka 객체 생성
producer = KafkaProducer(bootstrap_servers = ['localhost:9092'], # kafka의 기본 통신 포트 9092
                         value_serializer=lambda v : json.dumps(v).encode('utf-8') # python dict -> json 문자열 -> utf-8 문자열 변환
                         )

# 데이터를 보낼 kafka topic 이름 지정
topic = 'press-force'
print("Producer 시작 : 1초 마다 Force 데이터 전송")

# 데이터를 보낼 때, 강제 종료될 때까지 계속 반복하며 제이터 전송
while True:
    force = round(random.uniform(130, 150), 2)
    message = {
        "machine_id" : "press_01",
        "force" : force
    }

    #kafka의 press-force topic 으로 message 데이터를 전송
    producer.send(topic, value=message)
    producer.flush() # producer 내부 버퍼에 남아 있는 데이터 실시간 전송

    print("전송: ", message)

    time.sleep(1)