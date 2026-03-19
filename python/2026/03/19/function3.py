lambda_add = lambda x: x % 2 == 1
lambda_even = lambda x : x % 2 == 0

print("입력: ", end=" ")
number = list(map(int, input().split()))
odd = list(filter(lambda_add, number))
even = list(filter(lambda_even, number))

print(f"홀수 : {odd}")
print(f"짝수 : {even}")