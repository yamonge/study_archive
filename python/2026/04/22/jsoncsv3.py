import json

customer = {
  "id" : 123456,
  "name" : "곰돌이 사육사",
  "history" : [
    {"date" : "2025-05-05", "product" : "iPhone 14 Pro"},
    {"date" : "2025-05-10", "product" : "Galaxy S23 Ultra"}
  ]
}

with open('data.json', 'w', encoding="utf-8") as json_file:
    json.dump(customer, json_file, ensure_ascii=False, indent=4)
