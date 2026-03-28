class ProtoTV:
  def __init__(self, isOn, channel, volume):
    self.isOn = isOn
    self.channel = channel
    self.volume = volume
  def set_on(self, isOn):
    self.isOn = isOn
  def set_channel(self, channel):
    if 0 < channel < 1000:
      self.channel = channel
      print(f"채널을 {channel}로 변경 하였습니다.")
    else:
      print("채널 설정 범위가 아닙니다.")
  def set_volume(self, volume):
    self.volume = volume
  def get_on(self):
    return self.isOn
  def get_channel(self):
    return self.channel
  def get_volume(self):
    return self.volume

class TV(ProtoTV):
  def set_channel(self, channel):
    if 0 < channel < 2000 :
      self.channel = channel
      print(f"채널을 {channel}로 변경 하였습니다.")
    else:
      print("채널 설정 범위가 아닙니다.")

lg_tv = TV(False, 10, 10)
samsung_tv = TV(False, 20, 20)
samsung_tv.set_channel(1200)

proto = ProtoTV(False, 10, 10)
proto.set_channel(999)