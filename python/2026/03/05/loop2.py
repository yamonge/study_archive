while True:
  age = int(input("나이를 입력하세요: "))
  if 0 < age < 200:
    print("입력완료")
    break
  else:
    print("나이를 잘못 입력했습니다. 다시 시도하세요.")