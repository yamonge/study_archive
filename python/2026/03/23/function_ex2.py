rst = []

def check(list):
  try:
    for i in list:
      f = float(i)
      if int(f) < 0:
        print("양수만 입력하시오")
        break
      rst.append(int(f))
    return rst  
  except ValueError:
    print("숫자만 입력하시오")

  
cnt = 0
addr_list = []
number_list = input("정수 리스트 입력: ").split()
find_num = input("찾는 숫자 입력: ")
list_rst = check(number_list)
try:
  for i in range(0, len(list_rst)):
    if number_list[i] == find_num:
      addr_list.append(i)
  print(f"{list_rst}")
  print(f"{find_num}의 개수는 {len(addr_list)}개 입니다.")
  for i in addr_list:
    print(f"{i + 1}번째, ", end=" ")
  print("에 있습니다")
except:
  print("에러발생 프로그램 종료")
  


