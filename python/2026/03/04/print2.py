import sys
import time

total_time = 100
steps = 100
sleep_time = total_time / steps

for i in range(1, steps + 1):
  print(f"\r진행률: {i}% 입니다.", end="", flush=True)
  time.sleep(sleep_time)

print()
