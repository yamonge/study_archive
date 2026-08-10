import json
import numpy as np

students = [
  {"name" : "철수", "score" : 80},
  {"name" : "영희", "score" : 55},
  {"name" : "민수", "score" : 90}
]

new_students = []

arr = np.array([
  [10, 20, 30],
  [40, 50, 60]
])

# 매개변수로 리스트를 받고 평균 계산후 return 반환 하기
def get_avg(students):
  rst = 0
  avg = 0
  for student in students:
    rst += student["score"]

  avg = rst / len(students)
  return avg


# 매개변수로 리스트를 받고 60점 이상의 학생만 배열에 추가후 json 저장후 성공 여부 return 하기
def save_students(students):
  for student in students:
    if (student["score"] >= 60) :
      new_students.append(student)
  with open("result.json", "w", encoding="utf-8") as file:
    json.dump(new_students, file, ensure_ascii=False, indent= 2)
  return True

# 매개변수로 파일이름을 받아 파일이있는지 없는지 확인후 예외 처리 및 변수 저장
def load_students(file_name):
  try:
    with open(file_name, "r", encoding="utf-8") as file: 
      students = json.load(file)
      return students
    
  except FileNotFoundError:
    print(f"파일을 찾을수 없습니다.")
    return False



print(f"평균 : {get_avg(students)}")
if(save_students(students)):
  print(f"성공적으로 저장 되었습니다.")
students = load_students("result2.json")
print(arr[:, 0:2])
print(arr[1, :] + 10)