import datetime

def datetime_deco(func):
  def decorated():
    print(datetime.datetime.now())
    func()
    print(datetime.datetime.now())
  return decorated

@datetime_deco # 데코레이션은 1개의 인자만 받을수있음
def for_sum():
  sum = 0
  for i in range(1, 100):
    sum += 1
  print(sum)
@datetime_deco
def a():
  print("hello")


a()