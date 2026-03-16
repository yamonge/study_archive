nums = 0
rst = 0

while True:
  nums = input("3개의 정수를 입력하십시오: ").split()
  if len(nums) != 3:
    print("잘못된 입력입니다 3개의 정수를 입력해주세요. 예) 10 10 10 ")
    continue
  if not (all(x.isdigit() for x in nums)):
    print("잘못된 입력입니다. 숫자만 입력해주세요.")
    continue
  break

for i in (nums):
  if rst < int(i):
    rst = int(i)

print(f"가장 큰 값은: {rst}입니다.") 

  

