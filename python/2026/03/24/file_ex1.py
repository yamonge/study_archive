table = {}
day_sell = []

with open("starbucks.txt", "r", encoding="utf-8") as file:
  header = file.readline().split()
  # for cate in header:
  #   table[cate] = []
  # for line in file:
  #   values = line.split()
  #   for i in range(len(header)):
  #     header_name = header[i]
  #     table[header_name].append(values[i])
  rows = [line.split() for line in file]
  columns = zip(*rows)
  table = {h: list(col) for h, col in zip(header, columns)}
  # 일 평균 판매량 구하기
  # for i in range(len(table["날짜"])):
  #   day_val = 0
  #   for key, val in table.items():
  #     if key == "날짜":
  #       continue
  #     day_val += int(val[i])
  #   day_sell.append(int((day_val) / (len(table) - 1)))

  # table["일 평균 판매량"] = day_sell
  day_sell = [
    int(sum(int(val[i]) for key, val in table.items() if key != "날짜")) for i in range(len(table["날짜"]))
  ]
  day_sell = day_sell[:4]
  table["일 평균 판매량"] = [int(x / len(header)) for x in day_sell]

  # temp_header = [h for h in header if h != "날짜"]
  # day_sell = [
  #   sum(int(table[k][i]) for k in temp_header) / len(temp_header) for i in range(len(table["날짜"]))
  # ]

with open("4days_table", "w", encoding="utf-8") as file:
  header = [key for key in table]
  file.write("      ".join(map(str, header)) + "\n")
  for i in range(0, 4):
    content = [val[i] for val in table.values()]
    file.write("      ".join(map(str, content)) + "\n")
  total_sell = ["메뉴별 전체 판매량: "] + [int(sum(int(x) for x in val[:4])) for key, val in table.items() if key != "날짜" and key != "일 평균 판매량"]
  file.write("      ".join(map(str, total_sell)) + "\n")
  menus_all_sell_list = {key : sum(int(x) for x in table[key][:4]) for key in table if key != "날짜" and key != "일 평균 판매량"}
  best_menu = max(menus_all_sell_list, key=menus_all_sell_list.get)
  best_sell = menus_all_sell_list[best_menu]
  mini_menu = min(menus_all_sell_list, key=menus_all_sell_list.get)
  mini_sell = menus_all_sell_list[mini_menu]
  best_day = table["날짜"][day_sell.index(max(day_sell))]
  print(day_sell)
  print(best_day)
  file.write("판매량이 가장 높은 메뉴: " + str(best_menu) + " " +  str(best_sell) + " 개" + "\n")
  file.write("판매량이 가장 적은 메뉴: " + str(mini_menu) + " " +  str(mini_sell) + " 개"  + "\n")
  file.write("판매량이 가장 많은 날짜: " + str(best_day) + " " + str(max(day_sell)) + " 개" + "\n")