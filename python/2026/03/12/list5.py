a = [1,4,5,666,999,1000,2,3,4,5]
a.sort()
print(a)
a.sort(reverse=True)
print(a)

x = ["John", "George", "Paul", "Ringo"]
for i in range(len(x)):
  print(f"x[{i}] = {x[i]}", end=" ,")
  
print()

for i in x:
  print(i, end=" ,")
  
print()

x = [15, 64, 7, 3.14, [32, 55], "ABC"]
for i in range(len(x)):
  print(f"x[{i}] = {x[i]}", end=" ,")
  
print()
