import random

numbers = set()

while True:
  number = random.randrange(1,46)
  numbers.add(number)
  if len(numbers) ==  6 : break

print(sorted(numbers))