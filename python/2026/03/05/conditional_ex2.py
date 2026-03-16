day_work = 10030
night_work = day_work * 1.5

when = int(input("주간근무[1], 야간근무[2] 정수를 입력해주세요: "))

time = int(input("근무시간을 입력해주세요.(정수): "))

if when == 1:
  money = day_work * time
  print(f"입력한 시간 동안 근무한 주간 급여는 {money}원 입니다.")
elif when == 2:
  money = night_work * time
  print(f"입력한 시간 동안 근무한 야간 급여는 {money}원 입니다.")
else:
  print("잘못된 입력입니다.")