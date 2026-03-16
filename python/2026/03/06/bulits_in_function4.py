from datetime import datetime
import calendar

print(datetime.today().month)
print(datetime.today().day)
print(datetime.today().hour)
print(datetime.today().minute)
print(datetime.today().second)

now = datetime.now()

formatted = now.strftime("오늘은 %Y년 %m월%d일 %A %H시%M분 입니다.")

print(formatted)

print(calendar.calendar(2023))
print(calendar.calendar(2023, m=4))
print(calendar.month(2023, 9))
print(calendar.monthrange(2023, 9))