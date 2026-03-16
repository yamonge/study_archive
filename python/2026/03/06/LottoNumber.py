import random
lotto = []
count = 0

while True:
  rand = random.randint(1, 45)
  if not (rand in lotto):
    lotto.append(rand)
    count += 1
  if count == 6:
    break

print(lotto)
print(lotto)