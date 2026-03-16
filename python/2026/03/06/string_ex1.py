time = []

while True:
  time = input("시간을 입력하시오: ").split(":")
  time_vaild = True
  if len(time) != 3:
    print("시간 형식을 갖춰 주세요. 예) 00:00:00")
    continue

  for i in time:
    if len(i) != 2:
      print("잘못된 입력입니다 2자리의 숫자를 입력주세요.")
      time_vaild = False
      break
    if not i.isdigit():
      print("숫자만 입력해주세요.")
      time_vaild = False
      break
  
  if time_vaild:
    break

print(f"현재 시간은 {time[0]}시 {time[1]}분 {time[2]}초 입니다.")
  
  
