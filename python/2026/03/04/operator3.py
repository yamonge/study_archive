num1 = 10
num1 += 2
print(num1)
num1 -= 2
print(num1)
num1 *= 2
print(num1)
num1 //= 2
print(num1)
num1 %= 2
print(num1)

a = 10
b = 20
print(a > b)
print(a < b)
print(a == b)
print(a != b)
print(a >= b)
print(a <= b)

x = 10
y = 20

print(x > 5 and y > 15)
print(x > 15 or y > 15)
print(not(x > 15))

num = 100
flag = "짝수" if num % 2 == 0 else "홀수"
print(flag)

result = 5 + 2 * 3
print(result)

result = (5 + 2) * 3
print(result)

print(42 == 0b101010)
print(42 == 0o52)
print(42 == 0x2a)
print(bin(42))
print(oct(42))
print(hex(42))

a = 10
b = 12
print(a & b)
print(a | b)
print(a ^ b)
print(~a)
print(a << 1)
print(a >> 1)