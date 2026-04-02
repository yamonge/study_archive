class Aircon:
  def __init__(self, power, temp, wind_step):
    self.__power = power
    self.__temp = temp
    self.__wind_step = wind_step
    self.__curr_temp = 5

  def set_power(self, is_on):
    self.__power = is_on
  def set_temp(self, temp):
    self.__temp = temp
  def set_wind_step(self, wind_step):
    self.__wind_step = wind_step
  def get_power(self):
    return self.pwoer
  def get_temp(self):
    return self.__temp
  def get_wind_step(self):
    return self.__wind_step
  
  def view_info(self):
    wind_str = "", "1단계", "2단계", "3단계"
    print(f"전원 : {self.__power and 'ON' or 'OFF'}")
    print(f"현재 온도 : {self.__curr_temp}")
    print(f"설정 온도 : {self.__temp}")
    print(f"바람 세기 : {self.__wind_step}")

my_air_con = Aircon(False, 22, 1)