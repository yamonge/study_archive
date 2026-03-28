def check_num(arr):
  try:
    if len(arr) != 10:
      return -1, "10개의 성적이 아닙니다."
    for e in arr:
      f = float(e)
      if int(f) < 0:
        return -1, "양수만 입력 가능합니다."
      if int(f) > 100:
        return -1, "성적은 100점 이상을 넘길수없습니다."
    total_list = list(map(int, arr))
    return 1, total_list
      
  except ValueError:
    return -1, "문자는 입력할수없습니다."


def calculator(list):
  rst_list = []
  rst_list.append(sum(list))
  rst_list.append(sum(list) / len(list))
  rst_list.append(min(list))
  rst_list.append(max(list))
  return rst_list

while True:
  grades = check_num(input("10개의 정수를 입력해주세요.").split())
  if grades[0] == -1:
    print(grades[1])
    continue
  grade_list = grades[1]
  rst = calculator(grade_list)
  print_list = {"총점" : "", "평균": "", "최소 점수": "", "최대 점수": ""}
  for e, e2 in zip(print_list, rst):
    print_list[e] = e2
  print(print_list)