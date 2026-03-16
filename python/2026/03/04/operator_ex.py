# year = int(input("년도를 입력하십시오: "))

# if year % 4 == 0:
#   if year % 100 == 0:
#     print("윤년이 아닙니다.")
#   elif year % 400 == 0:
#     print("윤년입니다.")
#   else: 
#     print("윤년이 아닙니다.")
# else:
#   print("윤년이 아닙니다.")

year = int(input("년도를 입력하십시오: "))

if(year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
  print("윤년입니다.")
else:
  print("윤년이 아닙니다.")