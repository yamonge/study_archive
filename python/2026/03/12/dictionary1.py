coffee_menu = {"Americano": 2500, "Espresso" : 2500, "Latte" : 4000, "Moca" : 4500 }
tea_menu = {"Black tea" : 4000, "Green Tea" : 4000, "Milk tea" : 3500}
food_menu = {"Cake" : 5000, "Bakery" : 6000, "Icecream" : 7000}

print(coffee_menu)
print(tea_menu)
print(food_menu)
print(coffee_menu["Americano"])
print(coffee_menu.get("Americano"))

coffee_menu["ColdBrew"] = 5000
print(coffee_menu)
coffee_menu["ColdBrew"] = 4500
print(coffee_menu)
del coffee_menu["Latte"]
print(coffee_menu)

if "Bakery" in food_menu :
  print(food_menu["Bakery"])
else:
  print("해당 메뉴가 없습니다.")

coffee_menu.update({"Americano" : 3000, "Espresso" : 3000, "Latte": 4500, "Moca": 5000})
print(coffee_menu)
