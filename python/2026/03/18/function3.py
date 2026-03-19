def add(a, b):
  return a + b

print(add(1,3))

print((lambda a, b: a+b)(1,2))

func1 = lambda a, b : a + b
print(func1(1, 2))

inputlist = map(int, input("정수를 입력해주세요.: ").split())
lista = list(map(lambda x: x**2, inputlist))
print(lista)

