n = list(map(int, input("정수를 입력 하세요.: ").split()))

print(f"최대값: {max(n)}")
print(f"최소값: {min(n)}")
print(f"합계 : {sum(n)}")
print(f"평균 : {sum(n) / len(n):.2f}")
print(f"나누기 몫, 나머지 {divmod(sum(n), len(n))}")