menu_dic = {}

def print_menu():
  for key, val in menu_dic.items():
    print(f"{key} : {val}")

def retrieve_menu(name):
  if name in menu_dic:
    print(menu_dic[name])
  else:
    print("찾는 메뉴가 없습니다.")

def add_menu(name, grp, price, desc):
  if name not in menu_dic:
    menu_dic[name] = [grp, price, desc]
    print(f"{name} 메뉴가 추가 되었습니다.")
  else:
    print("메뉴가 이미 존재합니다.")

def delete_menu(name):
  if name in menu_dic:
    del menu_dic[name]
    print(f"{name} 메뉴가  삭제되었습니다.")
  else:
    print("삭제 할 메뉴가 없습니다.")

def check_num(num):
  try:
    f = float(num)
    if not (int(f) > 0 and int(f) < 10):
      return -1, "잘못된 범위 입니다."
    else:
      return 1, int(f)
  except ValueError:
    return -1, "문자는 허용하지 않습니다."

while True:
  menu = input("[1] 메뉴 보기, [2] 메뉴 조회, [3] 추가 하기, [4] 삭제 하기, [5] 종료 하기 : ")
  choice = check_num(menu)
  if choice[0] == -1:
    print(choice[1])
    continue
  if choice[1] == 1:
    print_menu()
  elif choice[1] == 2:
    name = input("조회할 메뉴 이름 입력: ")
    retrieve_menu(name)   
  elif choice[1] ==  3:
    name = input("추가할 메뉴 이름: ")
    grp = input("추가할 메뉴의 카테고리: ")
    price = input("추가할 메뉴의 가격: ")
    desc = input("추가할 메뉴의 설명: ")
    add_menu(name, grp, price, desc)
  elif choice[1] == 4:
    name = input("삭제할 메뉴 입력: ")
    delete_menu(name)
  elif choice[1] ==  5:
    print("프로그램 종료...")
    break
  else:
    print("예기치 못한 에러 발생")