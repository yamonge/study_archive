# 1~입력받은값 까지 소수들의 합 구하기
number_list =  []
while True:
  try:
    number = input("정수를 입력하시오: ")
    f = float(number)
    if int(f) < 0:
      print("양수만 입력해주세요.")
      continue
    if int(f) == 0:
      print("프로그램을 종료합니다.")
      break
    number_list = [x for x in range(2, int(f) + 1) if all(x % i != 0 for i in range(2, int(x**0.5) + 1))]
    print(f"{int(f)}의 소수는 {number_list} 입니다.")
    rst = 0
    for i in number_list:
      rst += i
    print(f"소수들의 합은 {rst} 입니다.")
  except:
    print("숫자를 입력해주세요.") 