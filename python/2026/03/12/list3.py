list_all = [0,1,2,3,4,5,6,7,8,9,"a","b","c","d","e","f","korea","seoul","gangnam"]
list_all2 = ["a","b","c","d","e","f","korea","seoul","gangnam",0,1,2,3,4,5,6,7,8,9]

print(list_all)
print(list_all2)
list_all.pop(10)
print(list_all)
list_all.insert(8, 9)
print(list_all)
list_all.insert(8, "asd")
print(list_all)
del list_all[15]
print(list_all)
list_all.clear()
print(list_all)