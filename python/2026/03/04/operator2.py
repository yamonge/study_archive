tax_rate = 0.10
income = input("당신의 수입 : ")
if income.isdigit():
  income = int(income)
  print(f"당신이 내야할 세금은 {income * tax_rate:.2f}입니다.")
else:
  print("잘못 입력된 값 입니다.")

if income * tax_rate > 50 :
  print("gg")
else:
  print("xx")