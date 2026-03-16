a = b = c = 1
print(a, b, c)

a, b, c = 1, 2, "정경수"
print(a, b, c)

lang = input("배우고 싶은 언어를 입력하세요: ")
print(f"입력된 언어는 {lang}입니다.")

num = 10
print(type(num))

print(int("10") + 5)
print(f"{10 + 5}")
print(f"{str(30)} + 살 입니다.")
print(str(30) + "살 입니다.")
print(float("10.5") + 2.3)

print(bool(0))
print(bool(1))
print(bool(""))
print(bool("python"))