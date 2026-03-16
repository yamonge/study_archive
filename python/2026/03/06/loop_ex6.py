total = 1
nums_list = []
count_list = []

while True:
  nums = input("자연수 3개 입력: ").split()
  isValid = True

  if (len(nums) != 3):
    print("3개의 숫자들만 입력해주세요.") 
    continue

  for i in nums:
    if not (i.isdigit()):
      print("숫자를 입력해주세요.")
      isValid = False
      break
    if (len(i) != 3):
      print("3자리 숫자만 입력해주세요.")
      isValid = False
      break

  if isValid:
    nums = list(map(int, nums))
    for i in nums:
      total *= i
    break

nums_list = list(map(int, str(total)))
print(total)
for i in range(0, 10):
  count_num = 0
  for j in nums_list:
    if i == j:
      count_num += 1
  count_list.append(count_num)
  print(count_list[i])
