import json

with open("data.json", "r", encoding="utf-8") as json_file:
  data = json.load(json_file)

print(json.dumps(data, ensure_ascii=False, indent=4))