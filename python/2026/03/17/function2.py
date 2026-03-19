def open_account(name):
  print(f"{name}님의 계좌를 개설하였습니다.")
  
def deposit(balance, in_val):
  print(f"{in_val} 입금 되었습니다. 잔액은 {balance + in_val} 입니다.")
  return balance + in_val

def withdraw(balance, out_val):
  if balance >= out_val:
    balance -= out_val
    print(f"{out_val} 이 출금되었습니다. 잔액은 {balance} 입니다.")
  else:
    print(f"출금에 실패했습니다. 잔액은 {balance} 입니다")
  return balance

balance = 0
name = input("계좌 개설 이름 입력: ")
open_account(name)
balance = deposit(balance, 1000)
balance = deposit(balance, 2000)
balance = withdraw(balance, 2500)
print(f"{name}의 잔액은 {balance}입니다.")