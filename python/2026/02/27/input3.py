str1, str2 = input("이름과 주소 입력 : ").split()
print(str1, str2)

kor, eng, mat = map(int, input("국어 영어 수학 : ").split())
print(kor,eng,mat)

hour, min, sec = input("시:분:초 : ").split(":")
print(f"{hour}시{min}분{sec}초")

a, b, c = map(int, input('정수 입력 : ').split(":"))
if a == 12:
  print(f"오후{a:02}시{b:02}분{c:02}초")
elif a > 12:
  a -= 12
  print(f"오후{a:02}시{b:02}분{c:02}초")
else:
  print(f"오전{a:02}시{b:02}분{c:02}초")