import json

jsonString = '''{
  "name" : "KH",
  "id" : 123456,
  "history" : [
    {"date" : "2023-05-10", "item" : "iPhone 14 Pro"},
    {"date" : "2023-05-04", "item" : "Galuxy S23 Ultra"}
  ]
}'''

print(jsonString)

dict = json.loads(jsonString)

print(dict["name"])
for h in dict["history"]:
  print(h["date"], h["item"])