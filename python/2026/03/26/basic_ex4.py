seat_list = [""]*10
seat_select = [0]*10
seat_price = 12000
total_price = 0

def menu():
  print("="*20)
  print(f"{'MENU':>7}")
  print("="*20)
  val = input("[1]예매하기, [2]종료하기: ")
  return val

def print_select():
  print("="*20)
  print(f"{'좌석선택':>7}")
  print("="*20)
  val = input("좌석번호 입력: ")
  return val

def check_num(val):
  try:
    f = float(val)
    if int(f) == 1 or int(f) == 2:
      return 1, int(f)
    else:
      return -1, "지원하지 않는 범위입니다."
  except ValueError:
    return -1, "문자는 지원하지 않습니다."

def check_select_num(num):
  try:
    f = float(num)
    if not int(f) < 0 and int(f) > 10:
      return -1, "지원하지 않는 범위 입니다."
    return 1, int(f)
  except ValueError:
    return -1, "문자는 지원하지 않습니다."

  
def print_seat(arr):
  for idx, val in enumerate(arr):
    if val == 1:
      seat_list[idx] = "V"
  print(" ".join(f"[{x}]" for x in seat_list))

def choice_seat(num):
  global total_price
  if seat_select[num - 1] == 1:
    return -1, "이미 예약된 좌석입니다."
  seat_select[num - 1] = 1
  total_price += seat_price
  print_seat(seat_select)
  return 1, f"{num}번 좌석이 예약되었습니다."

while True:
  val = menu()
  rst = check_num(val)
  if rst[0] == -1:
    print(rst[1])
    continue
  if rst[1] == 2:
    print(f"총 매출: {total_price}")
    break
  elif rst[1] == 1:
    val  = print_select()
    rst = check_select_num(val)
    if rst[0] == -1:
      print(rst[1])
      continue
    choice_rst = choice_seat(rst[1])
    if choice_rst[0] == -1:
      print(choice_rst[1])
      continue
    else:
      print(choice_rst[1])
      continue