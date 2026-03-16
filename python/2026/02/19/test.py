print("Hello. Python!")

name = "박유정"
is_student = True
coding_languages = 11

print(f"내 이름은 {name}  이고, 지금까지 {coding_languages}개의 기술을 배웠어. 열공 중인 상태는 {is_student}야.")

tech_stack = ["HTML", "CSS", "JS", "Java", "Python"]

print(tech_stack)

tech_stack.append("React")

print(f"내가 배운 기술 리스트는 {tech_stack} 야, 총 {len(tech_stack)}개를 배웠네!")

score = {"java" : 90, "python" : 100}

print(score["java"])

score["React"] = 80

print(f"나의 파이썬 점수는 {score['React']} 점이야")

print(f"내가 현재까지 배운 기술의 개수는 {len(score)} 개이고, 그중 Java의 점수는 {score['java']} 점 이야")

test_numbers = {1, 2, 3, 4, 5}
test_number2 = [1, 2, 3]

print(test_numbers)
print(test_number2)

test_numbers.update([1, 6])
test_number2.extend([1, 4])

print(test_numbers)
print(test_number2)