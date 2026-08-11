from kafka import KafkaConsumer
import json
import time
# kafka consumer 객체 생성
consumer = KafkaConsumer("press-force",                             #구독할 topic 이름 정의
                         bootstrap_servers=['localhost:9092'],             # broker 주소 지정
                         auto_offset_reset='latest',                        # consumer 가 처음 실행 될때 최신 데이터로부터 읽도록 설정
                         group_id='basic-consumer-group',                   # consumer 그룹 ID 지정
                         value_deserializer=lambda m: json.loads(m.decode('utf-8')) # producer json -> decode
                         )

print("Consumer_basic 시작 : press-force topic 데이터를 수신합니다.")

# 1초 동안 수신할 메세지 개수를 저장
count_per_second = 0

# 프로그램 시작후 전체 수신 메세지 개수 저장
total_count = 0

# tps 측정
start_time = time.time()

print("TPS Consumer 시작 : 초당 수신 건수를 계산합니다.")

for message in consumer:
    data = message.value        # producer 에서 value 가져옴
    count_per_second += 1       # 1초 동안 누적되는 메세지 개수 +10
    total_count += 1            # 전체 누적 개수 증가
    current_time = time.time()  # 현재 시간 담기

    if current_time - start_time >= 1.0 :       # 마지막 수신의 시간과 첫 실행 시간의 차이가 1.0초 이상일때
        print(f"현재 TPS = {count_per_second} 건/초, "
              f"누적 수신 {total_count} 건"
              f"최근  force = {data['force']}")
        count_per_second = 0        # 값 초기화

        start_time = current_time   # 시작시간을 현재 시간으로