def default_weight(gender, height):
  height_num = height / 100
  man = height_num * height_num * 22
  woamn = height_num * height_num * 21

  if(gender == 1):
    return man
  elif(gender == 2):
    return woamn
  else:
    print("잘못된 입력입니다.")
    return -1

while True:
  try:
    height = int(input("키를 입력해주세요(정수): "))
    gender = int(input("성별을 입력해주세요 [1]남자 [2]여자: "))

    if gender not in [1, 2]:
      print("에러: 성별은 1 또는 2만 입력 가능합니다.")
      continue

    print(f"{default_weight(gender, height):.2f}")
    break

  except ValueError:
    print("에러: 문자가 아닌 숫자를 입력해야 합니다.")


