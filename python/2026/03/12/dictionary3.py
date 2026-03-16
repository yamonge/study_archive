menu = {
  "americano" : ["coffee", 2000, "기본 커피 입니다."],
  "latte" : ["coffee", 3000, "우유가 들어간 커피 입니다."],
  "moca" : ["coffee", 3500, "초콜릿이 들어간 커피 입니다."],
  "black tea" : ["tea", 2500, "홍차 입니다."],
  "green tea" : ["tea", 2500, "녹차 입니다."],
}

def isNumber(s):
  try:
    float(s)
    return True
  except ValueError:
    return False

def print_menu():
  for key in menu.keys():
    print(f"{key} : {menu[key]}")

def get_menu(name):
  if name in menu:
    print(menu[name])
  else:
    print("False")

def add_menu(name, categoery, price, desc):
  if not isNumber(price):
    print("가격은 숫자여야 합니다.")
    return
  if name not in menu:
    menu[name] = [categoery, price, desc]
    print(f"{name} 메뉴가 추가 되었습니다.")
  else:
    print("메뉴가 이미 존재합니다.")

def del_menu(name):
  if name in menu:
    del menu[name]
    print(f"{name} 메뉴가 삭제 되었습니다.")
  else:
    print("삭제할 메뉴가 없습니다.")

def modify_menu(name, category, price, desc):
  if not isNumber(price):
    print("가격은 숫자여야 합니다.")
    return
  if name in menu:
    menu[name] = [category, price, desc]
    print("메뉴 정보가 수정 되었습니다.")
  else:
    print("수정할 메뉴가 없습니다.")   

while True:
  print("메뉴를 선택 하세요: ") 
  choice = int(input("[1]전체 메뉴 보기 [2]메뉴 검색 [3]메뉴 추가 [4]메뉴 삭제 [5]메뉴 수정 [6]종료 : "))
  if choice == 1:
    print_menu()
  elif choice == 2:
    name = input("검색할 메뉴 이름을 입력하세요: ")
    get_menu(name)
  elif choice == 3:
    name = input("추가할 메뉴 이름을 입력하세요: ")
    category = input("카테고리를 입력하세요 (coffee/tea): ")
    price = int(input("가격을 입력하세요: "))
    desc = input("메뉴 설명을 입력하세요: ")
    add_menu(name, category, price, desc)
  elif choice == 4:
    name = input("삭제할 메뉴 이름을 입력하세요: ")
    del_menu(name)
  elif choice == 5:
    name = input("수정할 메뉴 이름을 입력하세요: ")
    category = input("새로운 카테고리를 입력하세요 (coffee/tea): ")
    price = int(input("새로운 가격을 입력하세요: "))
    desc = input("새로운 메뉴 설명을 입력하세요: ")
    modify_menu(name, category, price, desc)
  elif choice == 6:
    print("프로그램을 종료합니다.")
    break
  else:
    print("잘못된 선택입니다. 다시 시도하세요.")
