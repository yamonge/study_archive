num = input("3자리 정수를 입력하시오: ")
nums = []
maxnum = 0

if len(num) == 3 :
  nums = list(map(int, num))
  for i in range(0, len(nums)):
    if nums[i] > maxnum:
      maxnum = nums[i]
  print(f"숫자 리스트 : {nums}")
  print(f"가장 큰수 : {maxnum}")
else:
  print("3자리 정수가 아닙니다 다시 입력해주세요.")