time = int(input("시간을 입력하세요 (0~23) : "))

if time == 0:
  print("오전 12시")
elif time < 12:
  print(f"오전 {time}시")
elif time == 12:
  print("오후 12시")
else:
  print(f"오후 {time - 12}시")
  