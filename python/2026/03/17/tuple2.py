tp = (1,1,2,2,2,3,3,3,3)

print(tp)
print(tp.count(3)) # 원하는 값의 개수를 새줌
print(tp.index(1)) # 원하는 값의 시작 인덱스를 표기
print(tp.__len__()) # 튜블의 데이터 개수 표기
print(len(tp)) # 위 와 같음
print(tp.__str__())

ti = (1, 2, 'a', 'b')
# del ti[0] 튜플은 수정 안됨 슬라이싱, 등등 여러방법으로 ti자체를 재정의 해야함
print(ti)
print(ti[0])
a = ti[0]
print(a)
ti[1:]
