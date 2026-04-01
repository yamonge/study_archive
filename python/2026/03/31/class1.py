class Car:
  isinstance_count = 0

  def __init__(self, size, model):
    self.size = size
    self.model = model
    Car.isinstance_count = Car.isinstance_count + 1
    print(f"자동차 객채 생성 수 : {Car.isinstance_count}")

  def move(self, speed):
    self.speed = speed
    print(f"자동차 {self.size} & {self.model}가 시속 {self.speed}로 달립니다.")

  @staticmethod
  def check_type(code):
    if(code <= 10): print("전기차 입니다.")
    elif(code <= 20): print("가솔린차 입니다")
    elif(code <= 30): print("디젤차 입니다.")
    else: print("분류 코드가 없습니다.")

car1 = Car("소형", "모닝")
car2 = Car("중형", "쏘나타")

car1.move(90)
Car.check_type(11)
car2.move(110)