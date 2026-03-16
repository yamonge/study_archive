import random

count = 0
while True:
  Dice1 = random.randint(1, 6)
  Dice2 = random.randint(1, 6)
  count += 1
  print(f"주사위1: {Dice1}, 주사위2: {Dice2} 굴린횟수: {count}")
  if Dice1 == Dice2:
    break

print(f"주사위 굴린 횟수: {count}")