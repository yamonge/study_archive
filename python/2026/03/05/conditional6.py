import random

numbers = []
while len(numbers) < 6:
  num = random.randint(1, 45)
  if num not in numbers:
    numbers.append(num)

print(f"생성된 로또 번호: {sorted(numbers)}")