social_number = 0

while True:
  social_number = input("주민등록번호를 입력하시오: ")

  if len(social_number) != 14:
    print("잘못된 입력입니다. 제대로된 형태로 입력해주세요. 예)000000-0000000")
    continue
  if not all(i.isdigit() for i in social_number[:6]):
    print("숫자를 넣어주세요.")
    continue
  if not all(i.isdigit() for i in social_number[7:14]):
    print("숫자를 넣어주세요.")
    continue
  if social_number[6] != "-":
    print("중간에 - 을 제대로 넣어주세요.")
    continue

  break
if int(social_number[:1]) != 0:
  age = 2026 - int("19" + social_number[:2]) + 1
else:
  age = 2026 - int("20" + social_number[:2]) + 1

print(f"생년월일 : {social_number[:6]}")
print(f"성별 : {social_number[7]}")
print(f"나이 : {age}")
