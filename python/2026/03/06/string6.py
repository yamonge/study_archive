url = input("사이트 : ")

my_str = url.replace("http://", "").replace("https://", "")
my_str = my_str[:my_str.index(".")]
password = my_str[:3] + str(len(my_str)) + str(my_str.count("o")) + str(my_str.count("k")) + "!" + "jks"

print("비밀번호 : " + password)