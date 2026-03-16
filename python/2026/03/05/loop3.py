while True:
  energy: 0
  print("1. 다른 누군가에게 발상, 지식이나 감정을 표현함으로써 에너지를 얻고 활동적이며 적극적입니다.")
  print("2. 지식이나 감정에 대한 자각의 깊이를 늘려감으로써 에너지를 얻고 깊이 있는 대인 관계를 가집니다.")
  print("[에너지 방향] : 1, 2중에 선택 하세요 : ", end=" ")
  energy = input()
  if(energy == "1"):
    mbti = 'E'
    break
  elif (energy == "2"):
    mbti = "I"
    break
  else:
    print("입력 오류 다시 입력 하세요.")

while True:
  recog = 0
  print("1. 실제 경험을 중시하고 현실에 초점을 맞추어 정확하고 철저하게 일처리를 합니다.")
  print("2. 아이디어를 중시하고 미래지향적이고 개연성과 의미에 초점을 맞추어 신속하게 일을 처리 합니다.")
  print("[인식기능] : 1, 2중에 선택 하세요 : ", end=" ")
  recog = input()
  if (recog == "1"):
    mbti = mbti + "S"
    break
  elif (recog == "2"):
    mbti = mbti + "N"
    break
  else:
    print("입력 오류 다시 입력 하세요.")
  
while True:
  judg = 0
  print("1. 업무 중심 타입이며, 진실과 사실에 근거하고 논리적이고 분석적, 객관적으로 사실을 판단 합니다.")
  print("2. 인간 관계 중심이며, 사람과의 관계에 주로 관심이 많습니다, 우호적이고 공감하기를 좋아하고 도적성을 중시 합니다.")
  print("[판단기능] : 1, 2중에 선택 하세요 : ", end=" ")
  judg = input()
  if (judg == "1"):
    mbti = mbti + "T"
    break
  elif (judg == "2"):
    mbti = mbti + "F"
    break
  else:
    print("입력 오류 다시 입력 하세요.")

while True:
  pattern = 0
  print("1. 분명한 목적과 방향을 선호하고 계획적이며 체계적이고 기한을 잘 지킵니다. 정리정돈을 잘하고 뚜렷한 자기의사와 기준으로 신속한 결론을 내립니다.")
  print("2. 유동적이고, 자율적이고 융통성이 있으며 때에 따라 일정을 변경하며, 상황에 적응하고 결정을 보류 합니다.")
  print("[생활양식] : 1, 2중에 선택 하세요 : ", end=" ")
  pattern = input()
  if (pattern == "1"):
    mbti = mbti + "J"
    break
  elif (pattern == "2"):
    mbti = mbti = "P"
    break
  else:
    print("입력 오류 다시 입력 하세요.")

print("당신의 MBTI 유형은 " + mbti + "입니다.")