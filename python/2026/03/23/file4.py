from datetime import  datetime

with open("password.txt", "w", encoding="utf-8") as f:
  date = datetime.today().strftime("%y%m%d")
  while True:
    url = input("사이트 : ")
    if url == "exit" : break
    my_str = url.replace("https://", "")
    my_str = my_str[:my_str.index(".")]
    password = my_str[:3] + str(len(my_str)) + str(my_str.count("o")) + date + "!" + "jks"
    print("비밀번호 : " + password)
    f.write(password + "\n")
    break

