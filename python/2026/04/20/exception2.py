try:
  score_file = open("1score.txt", "r", encoding="utf-8")
  print(score_file.read())
  score_file.close()
except FileNotFoundError:
  print("1score.txt 파일이 존재하지 않습니다.")
  pass