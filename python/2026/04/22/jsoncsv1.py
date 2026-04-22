import json

customer = {
  "id" : 123456,
  "name" : "My phone",
  "history": [
    {"date" : "2023-05-05", "product" : "iPhone 14 Pro"},
    {"date" : "2026-05-10", "product" : "Galaxy S23 Ultra"}
  ],
  "made" : "yamonge"

}

json_string = json.dumps(customer, ensure_ascii=False, indent=4)
print(json_string)
print(customer["history"][0]["date"])