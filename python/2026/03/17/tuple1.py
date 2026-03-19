person = ('Alice', 30 , 'New York')

# print(person[0])
# print(person[1])

# name, age, city = person
# print(name)
# print(age)
# print(city)

def get_person():
  name = 'Bob'
  age = 25
  city = 'London'
  return name, age, city

# result = get_person()
# print(result)
# print(person)
# person = get_person()
# print(person)
name, age, city = get_person()
print(name)
print(age)
print(city)