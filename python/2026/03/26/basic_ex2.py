def check_num(num):
  try:
    f = float(num)
    if f < 0:
      return -1, "음수는 지원하지 않습니다"
    return 1, int(f)
  except:
    return -1, "문자는 지원하지 않습니다."

def square_num(num):
  matrix = []
  cnt = 1
  for i in range(1, num + 1):
    arr = []
    for j in range(1, num + 1):
      arr.append(cnt)
      cnt += 1
    matrix.append(arr)
  return matrix

while True:
  num = input("정수를 입력해주세요: ").strip()
  num_tu = check_num(num)
  if num_tu[0] == -1:
    print(num_tu[1])
    continue
  matrix = square_num(num_tu[1])
  for e in matrix:
    print(" ".join(f"{x:3d}" for x in e))
  break