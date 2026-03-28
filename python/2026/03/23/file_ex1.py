header_line = []
menus = {}

with open("starbucks.txt", "r", encoding="utf-8") as file:
  header = file.readline()
  header_line = header.split()

  for data in file:
    menu = data.split()
    menus[menu[0]] = menu[1:]

  #일 평균 판매량
  header_line.append("일 평균 판매량")
  for key in menus:
    rst = sum(map(int, menus[key]))
    avg = int(rst / len(menus[key]))
    menus[key].append(avg)    

  #각 메뉴별 전체 판매량
  total_sell = ["각 메뉴별 전체 판매량"]
  for i in range(len(menus)):
    rst = 0
    for key in menus:
      rst += int(menus[key][i])
    total_sell.append(rst)

print(header_line)
print(menus)