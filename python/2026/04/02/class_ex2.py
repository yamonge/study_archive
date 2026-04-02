import time  # sleep 사용을 위해서
from datetime import datetime  # 운영체제로 부터 현재 시간 날짜/시간을 가져 오기 위함

class AirCon:
  def __init__(self, power, set_temp, cooler, heater, step):
    month_temp = [-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4]
    month = datetime.now().month - 1   # 1을 빼는 이유는 인덱스 맞추기 위해서
    self.curr_temp = month_temp[month]  # 현재 온도
    self.power = power  # 전원
    self.set_temp = set_temp  # 설정 온도
    self.cooler = cooler      # 에어컨 동작 (더울 때)
    self.heater = heater      # 히터 동작 (추울 때)
    self.step = step          # 바람 세기

  def display_air_con(self):
    print("="*10 + "에어컨 정보" + "="*10)
    print(f"전원    : {'On' if self.power else 'OFF'}")
    print(f"현재 온도: {self.curr_temp}도")
    print(f"설정 온도: {self.set_temp}도")
    print(f"히터    : {'ON' if self.heater else 'OFF'}")
    print(f"쿨러    : {'ON' if self.cooler else 'OFF'}")
    print(f"바람 세기 : {self.step}단계")
  
  def configure(self):
    print(f"\n현재 실내 온도는 {self.curr_temp}도 입니다.")
    self.set_tmep = int(input("설정할 온도 입력: "))
    self.step = int(input("바람 세기 설정: "))
    if self.curr_temp > self.set_temp:
      self.cooler = True
      self.heater = False
    elif self.curr_temp < self.set_temp:
      self.cooler = False
      self.heater = True
    else:
      self.cooler = self.heater = False

  def temp_change(self):
    interval = {1: 60, 2: 30, 3: 20}
    elapsed = 0

    while True:
      time.sleep(1)
      elapsed += 10

      if elapsed >= interval.get(self.step, 60):
        if self.cooler : self.curr_temp -= 1
        elif self.heater : self.curr_temp += 1

        self.display_air_con()
        elapsed = 0
      if self.curr_temp == self.set_temp:
        print("설정 온도에 도달했습니다. 에어컨을 종료합니다.")
        break

my_aircon = AirCon(False, 20, False, False, 1)
on_off = input("에어컨을 켜시겠습니까? (yes / no) : ").strip().lower()
if on_off == 'yes':
  my_aircon.configure()
  my_aircon.temp_change()
else:
  print("에어컨을 종료합니다.")