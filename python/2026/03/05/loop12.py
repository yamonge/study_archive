while True:
  num = int(input("점수를 입력하세요(음수는 종료) : "))
  if num < 0:
    break

  if num > 100:
    print("올바른 점수가 아닙니다. \n 0~100 사이의 점수를 입력하세요")
    continue
  if num >= 90:
    grade = 'A'
  elif num >= 80:
    grade = 'B'
  elif num >= 70:
    grade = 'C'
  elif num >= 60:
    grade = 'D'
  
  print(f"{num}점의 학점은 \"{grade}\"입니다.")