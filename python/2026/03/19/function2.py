def power(n):
  return n * n

square = lambda x: x * x

input = [1,2,3,4,5]

output_a = list(map(square, input))

print(output_a)

my_list = [lambda a, b : a * b, lambda a, b: a + b]

print(my_list[0](5,2))
print(my_list[1](1,3))