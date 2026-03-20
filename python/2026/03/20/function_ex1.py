seat_list = [0]*10
money = 12000
total_money = 0

def reservation_seat(num):
  try:
    f = float(num)
    if f.is_integer():
      if int(f) > len(seat_list) or f < 0:
        print("잘못된 입력입니다. 다시 입력해주세요.")
        return -1
      return int(f)
    else:
      print("잘못된 입력입니다. 정수만 입력해주세요.")
      return -1
  except ValueError:
      print("입력한 값은 숫자가 아닙니다.")

def check_seat(num):
    global total_money
    if seat_list[num] == 1:
      print("이미 예약된 좌석입니다.")
    else:
      seat_list[num] = 1
      total_money += money
      print(f"{num}번 좌석이 예약되었습니다.")


while True:
  seat_num = reservation_seat(input("좌석 번호 입력 [0] 종료: "))
  if seat_num == -1:
    continue
  if seat_num == 0:
    print(f"영화관 총매출: {total_money}")
    break

  check_seat(seat_num)
  
