import json

menu = {
  "americano" : ["coffee", 2000, "기본 커피 입니다."],
  "espresso" : ["coffee", 2500, "진한 커피 입니다."],
  "latte" : ["coffee", 4000, "우유가 들어 있는 커피"],
  "green tea" : ["tea", 4500, "녹차 입니다."],
  "black tea" : ["tea", 4500, "홍차 입니다."]
}

def print_menu():
  for key in menu.keys():
    print(f"{key} : {menu[key]}")

  print()
  print()

  for key in menu:
    print(f"{key} : {menu[key]}")


def get_menu(name):
  if name in menu:
    print(menu[name])
  else:
    print("찾는 메뉴가 없습니다.")

def add_menu(name, category, price, desc):
  if name in menu:
    print("이미 있는 메뉴 입니다.")
  else:
    menu[name] = [category, price, desc]
    print(f"{name} 메뉴거 추가 되었습니다.")

def modify_menu(name, category, price, desc):
  if name in menu:
    menu[name] = [category, price, desc]
    print(f"{name} 메뉴가 수정되었습니다.")
  else:
    print("해당 메뉴는 존재하지 않습니다.")    

def del_menu(name):
  if name in menu:
    del menu[name]
    print(f"{name} 메뉴가 삭제 되었습니다.")
  else:
    print("삭제할 메뉴가 없습니다.")

def load_menu():
  try:
    with open("menu.json", "r", encoding="utf-8") as file:
      print("로딩중...")
      return json.load(file), print("로딩 완료")
  except FileNotFoundError:
    print("해당 파일이 없습니다.")
  except json.JSONDecodeError:
    print("JSON 디코딩 실패")

def save_menu():
  with open("menu.json", "w", encoding="utf-8") as file:
    json.dump(menu, file, ensure_ascii=False, indent=4)
    print("menu.json 파일에 저장되었습니다.")

while True:
  print("메뉴를 선택하세요")
  choice = int(input("[1]전체 메뉴 [2]조회 [3]추가 [4]삭제 [5]수정 [6]로딩 [7]저장 [0]종료 : ")) 
  if choice == 1: print_menu()
  elif choice == 2:
    name = input("조회할 메뉴 이름 검색 : ")
    get_menu(name)
  elif choice == 3:
    name = input("추가할 메뉴 이름 : ")
    category = input("추가할 메뉴 카테고리 : ")
    price = int(input("추가할 메뉴 가격 : "))
    desc = input("추가할 메뉴 설명 : ")
    add_menu(name, category, price, desc)
  elif choice == 4:
    name = input("삭제할 메뉴 이름 : ")
    del_menu(name)
  elif choice == 5:
    name = input("수정할 메뉴 이름: ")
    category = input("수정할 메뉴 카테고리: ")
    price = int(input("수정할 메뉴 가격: "))
    desc = input("수정할 메뉴 설명 : ")
    modify_menu(name, category, price, desc)
  elif choice == 6:
    load_menu()
  elif choice == 7:
    save_menu()
  elif choice == 0:
    print("프로그램을 종료합니다.")
    break
  else:
    print("잘못된 메뉴 입니다.")