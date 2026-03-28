class TV:
  def __init__(self, name, isOn, channel, volume):
    self.name = name
    self.isOn = isOn
    self.channel = channel
    self.volume = volume
  def set_on(self, isOn):
    self.isOn = isOn
  def set_channel(self, channel):
    self.channel = channel
  def set_volume(self, volume):
    self.volume = volume
  def get_on(self):
    return self.isOn
  def get_channel(self):
    return self.channel
  def get_volume(self):
    return self.volume
  def view_tv(self):
    power = ("OFF", "ON")
    print(f"이름 : {self.name}")
    print(f"전원 : {power[self.isOn]}")
    print(f"채널 : {self.channel}")
    print(f"볼륨 : {self.volume}")

lg_tv = TV("LG", False, 10, 10)
samsumg_tv = TV("SAMSUMG", False, 20, 20)
samsumg_tv.view_tv()
lg_tv.view_tv()