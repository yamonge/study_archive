line_dict = {}
total_sales = ["총합: ", 0, 0, 0, 0]
all_sales = ["4일간 총 판매량: ", 0]


with open("starbucks.txt", "r", encoding="utf-8") as file:
  for index, content in enumerate(file, start=1):
    line_dict[index] = content.split()

with open("4days_coffe.txt", "w", encoding="utf-8") as file:
  line_dict[1].append("하루 판매량")
  for i in range(1, 6):
    day_sale = 0
    for k in range(1,5):
      if i == 1:
        continue
      day_sale += int(line_dict[i][k])
    if not i == 1:
      line_dict[i].append(day_sale)
    all_sales[1] += day_sale
    content = "       ".join(map(str,line_dict[i]))
    for j in range(1, 5):
      if i == 1:
        continue
      total_sales[j] += int(line_dict[i][j])
    file.write(content + "\n")
  
  total_sales = "       ".join(map(str, total_sales))
  all_sales = "       ".join(map(str, all_sales))
  file.write(total_sales + "\n")
  file.write(all_sales + "\n")
    
    


    