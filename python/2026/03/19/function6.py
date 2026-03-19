import datetime

def datetime_deco(func):
  def decorated():
    print(datetime.datetime.now())
    func()
    print(datetime.datetime.now())
  return decorated

# @datetime_deco
def for_sum():
  sum = 0
  for i in range(1, 100):
    sum += 1
  print(sum)

test = datetime_deco(for_sum)
test()