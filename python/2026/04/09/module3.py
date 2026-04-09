def add(a, b):
  return a + b

def sub(a, b):
  return a - b

def password(url):
  my_str = url.replace("http://", "")
  my_str = my_str[:my_str.index(".")]
  password = my_str[:3] + str(len(my_str)) + str(my_str.count("o")) + str(my_str.count("o")) + "!" + "jks" + "2024"
  return password

if __name__ == "__main__":
  print(add(1,4))
  print(sub(4,2))