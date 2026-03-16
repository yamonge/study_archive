phrase = "가장 큰 실수는 포기, 가장 어리석은 일은 남의 결점 찾기, 가장 좋은 선물은 용서"
print(phrase.find("가장"))
print(phrase.rfind("가장"))

print(phrase.index("포기"))

print(phrase.find("나에게"))
# print(phrase.index("나에게"))

new_phrase = phrase.replace("가장", "나에게")
print(new_phrase)

input_a = """
  안녕하세요.
문자열 함수를 알아 봅니다.

"""

print(input_a)
print(input_a.strip())