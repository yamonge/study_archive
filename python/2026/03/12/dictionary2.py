dict1 = {"자바": 80, "PHP": 90, "HTML": 70}
coffee_menu = {"Americano": 2500, "Espresso" : 2500, "Latte" : 4000, "Moca" : 4500 }


print(dict1.keys())
print(dict1.values())
print(dict1.items())

print("HTML" in dict1)
print("파이썬" in dict1)

print(dict1.get("파이썬"))

for key in coffee_menu:
  print(key, ":", coffee_menu[key])