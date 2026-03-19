def profile(name, age, *lang):
  print(f"이름 : {name}, 나이 : {age}, 언어: ", end=" ")
  if not lang:
    print("없음")
  else:
    for e in lang:
      print(e, end=" ")
    print()

profile("나희도", 18, "Python", "Java", "C", "C++", "React", "Kotlin")
profile("조세호", 38, "Python", "Java")
profile("유재석", 48, "Python", "Java", "C", "C++")
profile("박야몽", 30)