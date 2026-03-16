for i in range(1, 6):
  for j in range(1, i+1):
    print("*", end="")
  print()
  print()

num = 6
for i in range(1, num):
  for j in range(1, num):
    print("*", end="")
  num -= 1
  print()

num3 = 6
num2 = 0
for i in range(1, num3):
  for k in range(1, num2 + 1):
    print(" ", end="")

  for j in range(1, num3):
    print("*", end="")
  num3 -= 1
  num2 += 1
  print()

n = 5
for i in range(n):
    for k in range(i):
        print(" ", end="")
    for j in range(n-i):
        print("*", end="")
    print()