id = input("아이디를 입력하세요: ")

if len(id) < 8:
  print("아이디는 반드시 8자리 이상이어야 합니다.")
else:
  pw = input("비밀번호를 입력하세요 : ")
  if len(pw) < 8 or len(pw) > 16:
    print("비밀번호는 8자리 이상, 16자리 이하여야 합니다.")
  elif id in pw:
    print("비밀번호에 아이디를 포함할 수 없습니다.")
  else:
    print("회원가입이 완료되었습니다.")