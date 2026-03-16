import json

student_map = {}

def reg_student():
  student_id = input("학번 입력: ")
  name = input("이름 입력: ")
  addr = input("주소 입력: ")
  student_map[student_id] = {"이름": name, "주소": addr}
  print(f"{name}님의 정보가 등록 되었습니다.")

def search_student():
  student_id = input("검색할 학번을 입력: ")
  student_info = student_map.get(student_id)
  if student_info :
    print(f"학번 : {student_id}")
    print(f"이름 : {student_info['이름']}")
    print(f"주소 : {student_info['주소']}")
  else:
    print("해당 학번의 학생 정보를 찾을 수 없습니다.")

def save_student():
  with open("students.json", "w", encoding="utf-8") as file:
    json.dump(student_map, file, ensure_ascii=False, indent=4)
  print("학생 정보가 저장되었습니다.")

def load_student():
  try:
    with open('students.json', 'r', encoding='utf-8') as file:
      student_map.clear()
      student_map.update(json.load(file))
    print("학생 정보를 불러왔습니다.")
  except FileExistsError:
    print("학생 정보가 저장된 파일을 찾을 수 없습니다.")

def modify_student() :
  student_id = input("수정할 학번을 입력 하세요 : ")
  student_info = student_map.get(student_id)

  if student_info :
    name = input("새로운 이름을 입력: ")
    addr = input("새로운 주소를 입력: ")
    student_info["이름"] = name
    student_info["주소"] = addr
    print(f"{name}님의 정보가 수정 되었습니다.")
  else:
    print("해당 학번의 학생 정보를 찾을 수 없습니다.")  

def deleted_student():
  student_id = input("삭제할 학번을 입력 하세요 : ")
  if student_map.get(student_id):
    del student_map[student_id]
    print("학생 정보가 삭제 되었습니다.")
  else:
    print("해당 학번의 학생 정보를 찾을 수 없습니다.")

def view_all_student():
  for student_key in student_map:
    student_info = student_map[student_key]
    print(f"학번: {student_key}")
    print(f"이름: {student_info['이름']}")
    print(f"주소: {student_info['주소']}")

while True:
  print("="*5, "학생 정보 관리 프로그램", "="*5)
  choice = int(input("[1]등록 [2]검색 [3]수정 [4]삭제 [5]전체보기 [6]저장 [7]불러오기 [8]종료 : "))
  if choice == 1:
    reg_student()
  elif choice == 2:
    search_student()
  elif choice == 3:
    modify_student()
  elif choice == 4:
    deleted_student()
  elif choice == 5:
    view_all_student()
  elif choice == 6:
    save_student()
  elif choice == 7:
    load_student()
  elif choice == 8:
    break
  else:
    print("선택한 메뉴가 없습니다.")
