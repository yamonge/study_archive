n = int(input("정수를 입력 하세요 : "))
for i in range(0, n):
  for j in range(0, n):
    if j % 2 == 0:
      print("@", end=" ")
    else:
      print("*", end=" ")
  print()