name = "정경수"
age = 20
gender = "남성"
jobs = "소프트웨어 개발자"
addr = "경기도 수원시"

print("====== C 스타일 ======")
print("이름 : %s"%(name))
print("나이 : %d"%(age))
print("성별 : %s"%(gender))
print("직업 : %s"%(jobs))
print("주소 : %s"%(addr))

print("====== 파이썬 스타일 1 ======")
print("이름: {}{}".format(name, addr))
print("나이: {}".format(age))
print("성별: {}".format(gender))
print("직업: {}".format(jobs))
print("주소: {}".format(addr))

print("====== 파이썬 스타일 2 ======")
print(f"이름 : {name}")
print(f"나이 : {age}")
print(f"성별 : {gender}")
print(f"직업 : {jobs}")
print(f"주소 : {addr}")

print("====== 자바 스타일 ======")
print("이름 : " + name)
print("나이 : " + str(age))
print("성별 : " + gender)
print("직업 : " + jobs)
print("주소 : " + addr)

