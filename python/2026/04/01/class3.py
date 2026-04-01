from abc import *

class NetworkAdapter(metaclass=ABCMeta):
  @abstractmethod
  def connect(self):
    pass

class LAN(NetworkAdapter):
  def __init__(self, company):
    self.company = company
  def connect(self):
    print(f"{self.company} LAN에 연결 했습니다.")

class WiFi(NetworkAdapter):
  def __init__(self, company):
    self.company = company
  
  def connect(self):
    print(f"{self.company} WiFi에 연결 했습니다.")

class LTE(NetworkAdapter):
  def __init__(self, company):
    self.company = company

  def connect(self):
    print(f"{self.company} LTE에 연결 했습니다")

net = input("연결할 네트워크를 선택 [1]LAN, [2]Wi-Fi, [3]LTE : ")
if net == "1":
  adapter = LAN("KT Megapass")
  adapter.connect()
elif net == "2":
  adapter = WiFi("SK Telecom")
  adapter.connect()
elif net == "3":
  adapter = LTE("LG U+")
  adapter.connect()
else:
  print("연결할 네트워크가 없습니다")