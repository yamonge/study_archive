from package import test_module1

name = input("이름을 입력하세요: ")
greeting = test_module1.greeting(name)
print(greeting)