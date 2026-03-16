import random

lotto = []

while(True):
  num = random.randrange(1, 46)
  if num not in lotto:
    lotto.append(num)
  if len(lotto) == 6 :
    lotto.sort()
    print(lotto)
    break