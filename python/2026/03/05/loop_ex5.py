word = 0

while True:
  word = input("단어를 입력해주세요.: ").split()[0]
  if (len(word) > 100 or len(word) < 0):
    print("잘못된 입력입니다.")
    continue
  else:
    break

text = word.swapcase()
print(text);