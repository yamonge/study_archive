n = int(input("정수를 입력하세요: "))
total = 0
while n > 0:
  total += n
  n -= 1
print(f"합: {total}")