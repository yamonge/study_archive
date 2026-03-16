import random

print(max(32, 45, 48, 57, 84))
print(min(32, 45, 48, 57, 84))

print(sum([29, 95, 15, 85, 66]))
print(sum([29, 95, 15, 85, 66]) / 5)

print(divmod(sum([29, 95, 15, 85, 66]), 5))

num = []
count = 0

while True:
  rand = random.randint(1, 100)
  count += 1
  num.append(rand)
  if count == 10:
    break
rst = divmod(sum(num), len(num))

print(sum(num))
print(len(num))
print(f"{rst}")

print(sorted(num, reverse=True))
print(sorted(num))