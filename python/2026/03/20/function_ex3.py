def avg(list):
  total = 0
  for i in list:
    total += int(i)
  return total, total / len(list)

def check(list):
    try:
      for i in list:
        f = float(i)
        return True, int(f)
    except ValueError:
      print("잘못된 입력입니다.")
      return False, None
    
while True:
  num_list = list(input("숫자를 입력해주세요.").split())
  if int(num_list[0]) == 0:
    print("종료 합니다.")
    break
  if not check(num_list)[0]:
    continue
  rst = avg(num_list)
  print(f"{rst[0]} / {len(num_list)} 의 평균값은 {rst[1]:.2f} 입니다.")
