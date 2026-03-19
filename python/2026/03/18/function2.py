def swap_func(a, b):
  tmp = a
  a = b
  b = tmp
  return (a, b)

a, b = swap_func(10, 20)

print(a, b)


def func_square(x, y):
  return x * x, y * y

x, y = map(int, input().split())
x, y = func_square(x, y)
print(x, y)