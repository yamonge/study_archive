name = input("이름을 입력하시오: ")
age = 0
gender = 0
jobs = 0

while True:
  val1 = input("나이를 입력하시오: ")
  if not val1.isdigit():
    print("숫자만 입력 가능합니다.")
    continue
  
  age = int(val1)

  if age < 0 or age > 200:
    print("잘못된 입력입니다. 다시 입력하십시오.")
    continue
  else:
    break;

while True:
  gender = input("성별을 입력하시오: ")
  if gender not in ["M", "m", "F", "f"]:
    print("잘못된 입력입니다. 다시 입력하십시오.")
    continue
  else:
    if gender in ["M", "m"]:
      gender = "남성"
    elif gender in ["F", "f"]:
      gender = "여성"
    break

while True:
  val2 = input("직업을 입력하십시오: ")

  if not val2.isdigit():
    print("숫자만 입력 가능합니다.")
    continue

  jobs = int(val2)

  if jobs > 4 or jobs < 0:
    print("잘못된 입력입니다. 다시 입력하십시오.")
    continue
  else:
    if jobs == 1:
      jobs = "학생"
    
    elif jobs == 2:
      jobs = "회사원"
    elif jobs == 3:
      jobs = "주부"
    else:
      jobs = "무직"      
            
    break

print(f"""
이름:    {name}
나이:    {age}
성별:    {gender}
직업:    {jobs}
""")
