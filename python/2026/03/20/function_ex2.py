def check(num):
  if num % 2 == 1:
    print(f"{num} 은 홀수 입니다.")
  if num % 2 == 0:
    print(f"{num} 은 짝수 입니다.")

while True:
  val = input("정수를 입력해주시요: ")
  try:
    f = float(val)
    if int(f) < 0:
      print("양수만 입력해주세요.")
      continue
    if int(f) == 0:
      print("종료합니다.")
      break
    check(int(f))
  except ValueError:
    print("잘못된 입력입니다. 다시 입력해주세요.")