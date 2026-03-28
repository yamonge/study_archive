with open("textfile.txt", "w", encoding="utf-8") as file:
  file.write("hello\n")
  file.write("안녕하세요\n")
  file.write("50\n")

with open("textfile.txt", "r") as file:
  content = file.read()
print(content)

file = open("textfile.txt", "r")
content = file.read()
print(content)
file.close()