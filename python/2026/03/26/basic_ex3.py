import random

lotto = []
while True:
  if len(lotto) == 6:
    break
  num = random.randrange(1, 46)
  if not num in lotto:
    lotto.append(num)

lotto.sort()  
print(" \n".join(f"{x:2d}" for x in lotto))