def for_sum(a):
  sum = 0
  for i in range(1, a + 1):
    sum += 1
  return sum

def while_sum(n):
  sum = 0
  while n:
    sum += n
    n -= 1
  return sum

def while2_sum(n):
  sum = 0
  while True:
    sum += n
    n -= 1
    if n == 0: break
  return sum

# 등차 수열
def gaus_sum(a):
  return int(a * (a + 1) / 2)

# 재귀 호출
def recu_sum(a):
  if a == 1: return 1
  return a + recu_sum(a - 1)

a = int(input("정수를 입력 하세요 : "))
print(while_sum(a))