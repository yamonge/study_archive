count = 0
times = []
youngSik_cost = 0
minSik_cost = 0


while True:
  count = input("통화 개수 입력: ")
  if not count.isdigit():
    print("숫자를 입력해주세요.")
    continue
  else:
    count = int(count)
    if count > 20 or count < 0:
      print("잘못된 입력입니다.")
      continue  
    break
while True:
  isPass = True
  times = input("통화 개수에 따른 시간을 입력해주세요: ").split()
  if len(times) != count:
    print("통화개수와 시간 개수가 맞지 않습니다.")
    continue
  for i in range(0, len(times)):
    if not times[i].isdigit():
      print("숫자를 입력해주세요.")
      isPass = False
      break
    elif not (0 < int(times[i]) <= 10000):
      print("잘못된 입력입니다.")
      isPass = False
      break

  if isPass == False:
    continue
  else:
    times = list(map(int, times))
    break

for i in range(0, len(times)):
  youngSik_cost += (times[i] // 30) * 10 + 10
  minSik_cost += (times[i] // 60) * 15 + 15

if youngSik_cost > minSik_cost:
  print(f"M {minSik_cost}")
elif youngSik_cost < minSik_cost:
  print(f"Y {youngSik_cost}")
else:
  print(f"""
Y {minSik_cost}
M {youngSik_cost}
""")

  
