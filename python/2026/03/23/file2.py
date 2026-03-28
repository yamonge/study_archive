score_file = open("score.txt", "r", encoding="utf-8")
print(score_file.read())
score_file.close()

score_file = open("score.txt", "r", encoding="utf-8")
while True:
  line = score_file.readline()
  if not line : break
  print(line, end="")
score_file.close

score_file = open("score.txt", "r", encoding="utf-8")
lines = score_file.readlines()
for line in lines:
  print(line, end="")
score_file.close()