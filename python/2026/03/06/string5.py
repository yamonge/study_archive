# 한파의 연속인 1월 입니다.
# 봄을 기다리는 2월 입니다.
# 봄의 기운이 느껴지는 3월 입니다.
# 새싹이 피어나는 4월 입니다.
# 계절의 여왕 5월 입니다.
# 활동하기 좋은 6월 입니다.
# 휴가가 기다려지는 7월 입니다.
# 무더운 8월 입니다.
# 선선한 9월 입니다.
# 천고마비의 계절 10월 입니다.
# 쓸쓸한 늦가을 11월 입니다.
# 올 한해의 마무리 12월 입니다.
name = input("이름 : ")
event = input("제목 : ")
date = input("일시 ex)20001023 : ")
time = input("시간 : ")

# 입력 받은 date에서 몇월인지 추출(슬라이싱)
greeting = ""
month = int(date[4:6])

trans_time = int(time[:2])
if trans_time == 12:
  time_str = "오후" + time[0:2] + "시" + time[2:] + "분"
elif trans_time > 12:
  trans_time = trans_time - 12
  time_str = "오후" + str(trans_time) + "시" + time[2:] + "분"
else:
  time_str = "오전" + time[0:2] + "시" + time[2:] + "분"

if month == 1:
    greeting = "한파의 연속인 1월 입니다."
elif month == 2:
    greeting = "봄을 기다리는 2월 입니다."
elif month == 3:
    greeting = "봄의 기운이 느껴지는 3월 입니다."
elif month == 4:
    greeting = "새싹이 피어나는 4월 입니다."
elif month == 5:
    greeting = "계절의 여왕 5월 입니다."
elif month == 6:
    greeting = "활동하기 좋은 6월 입니다."
elif month == 7:
    greeting = "휴가가 기다려지는 7월 입니다."
elif month == 8:
    greeting = "무더운 8월 입니다."
elif month == 9:
    greeting = "선선한 9월 입니다."
elif month == 10:
    greeting = "천고마비의 계절 10월 입니다."
elif month == 11:
    greeting = "쓸쓸한 늦가을 11월 입니다."
elif month == 12:
    greeting = "올 한해의 마무리 12월 입니다."
else:
    print("달 정보가 잘 못 입력 되었습니다.")

print(f"{name}님")
print(greeting)
print(f"""아래와 같은 일정으로 {event}를
진행하고자 하오니 오셔서 자리를 빛내 주시기 바랍니다.\n""")
print("="*8, "행사안내", "="*8)
print("제목 : " + event)
print(f"일시 : {date[:4]}년 {date[4:6]}월 {date[6:8]}일")
print(f"시간 : {time_str}")