my_list = ['A', 'B', 'C', 'D', 'B', 'D', 'E']
new_list = []
for v in my_list:
  if v not in new_list:
    new_list.append(v)

print(new_list)

# 중첩 리스트

matrix = [[1, 2, 3], ["하나", "둘", "셋"]]

print(matrix[0])
print(matrix[0][0])
print(matrix[1][2])

# 내장 함수 사용해보기
my_scores = [100, 88, 77]
your_scores = [90, 88, 77]

print(my_scores, your_scores)
print(sum(my_scores))
print(sum(your_scores))
print(sum(my_scores) / len(my_scores))
print(f"{sum(my_scores) / len(my_scores):.2f}")

for i in my_scores:
  print(i)

print(my_scores[0])