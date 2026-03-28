def check(list):
  try:
    rst_list  = []
    for i in list:
      f = int(float(i))
      if int(f) < 0:
        print("양수만 입력해주세요.")
        return -1
      if len(str(f)) != 3:
        print("3자리 숫자만 입력해주세요.")
        return -1
      rst_list.append(f)
    return rst_list
  except ValueError:
    print("숫자만 입력해주세요.") 
    return -1

def check_bigNum(list):
  big = 0
  for i in list:
    if i > big:
      big = i
  return big

while True:
  num_list = input("정수 리스트를 입력해수세요: ").split()
  total_list = check(num_list)
  if total_list == -1:
    print("잘못된 입력입니다.")
    continue
  rst_big = check_bigNum(total_list)
  print(f"{total_list} 에서 가장큰값은?")
  print(f"{rst_big} 입니다.")
  break
    