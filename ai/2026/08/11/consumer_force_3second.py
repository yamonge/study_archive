from kafka import KafkaConsumer
import json
import time
import matplotlib.pyplot as plt
from collections import deque

topic = 'press-force'

consumer = KafkaConsumer(
    topic,
    bootstrap_servers=['localhost:9092'],
    auto_offset_reset='latest',
    group_id='force_consumer',
    value_deserializer=lambda m: json.loads(m.decode('utf-8'))
)

MAX_POINTS = 1000

x_data = deque(maxlen=MAX_POINTS)

force_data = deque(maxlen=MAX_POINTS)

# 실시간 모드
plt.ion()
fig, ax = plt.subplots(figsize=(12,6))
line, = ax.plot([], [], linewidth=2)

ax.set_title(
    "Real-Time Press Force Monitoring"
)

ax.set_xlabel("Sample")
ax.set_ylabel("Press Force")
ax.grid(True)

# 샘플 번호
sample_no = 0

# 마지막 그래프 갱신 시간
last_update_time = time.time()

# 갱신 시간 3초
UPDATE_INTERVAL = 3

print("3초 단위 그래프 업데이트 시작")

for message in  consumer:
    data = message.value
    sample_no += 1
    force = data['force']
    x_data.append(sample_no)
    force_data.append(force)

    print(
        f"수신 Sample={sample_no}"
        f"Force={force}"
    )

    # 현재 시간
    current_time = time.time()

    if current_time - last_update_time >= UPDATE_INTERVAL:
        print("\n===================================")
        print(f"{UPDATE_INTERVAL} 초 데이터 수집 완료")
        print(f"총 데이터 수 : {len(force_data)}")
        print("그래프 업데이트")
        print("===================================\n")

        # 그래프 갱신

        line.set_data(
            list(x_data),
            list(force_data)
        )

        # x 축 범위 지정

        ax.set_xlim(
            min(x_data),
            max(x_data)
        )

        # y 축 범위 지정
        ax.set_ylim(
            min(force_data),
            max(force_data)
        )

        # 그래프 다시 그리기
        fig.canvas.draw()
        fig.canvas.flush_events()

        # 다음 3초 측정
        last_update_time = current_time