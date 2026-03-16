def is_number(s) :
  try:
    float(s)
    return True
  except ValueError:
    return False

lists = []

while(True):
  list = input("무작위 값들을 입력해주세요: ").split()
  isNumber = True
  list_a = []
  list_b = []
  for i in list:
    if not is_number(i):
      print("숫자만 입력해주세요!")
      isNumber = False
      break
    x = int(i)
    if (x % 2 == 0) and (not x in list_a):
      list_a.append(x)
    if (x % 2 != 0) and (not x in list_b):
      list_b.append(x)
  if isNumber :
    lists.append(list_a)
    lists.append(list_b)
    print(sorted(lists[0]))
    print(sorted(lists[1]))
    break
