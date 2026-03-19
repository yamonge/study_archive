from datetime import datetime
import time

make_cnt = 0

def select_option(prompt, options):
  while True:
    print(prompt)
    for idx, option in enumerate(options, start=1):
      print(f"{idx}. {option}")
    sel = input("선택하세요: ")
    if sel in map(str, range(1, len(options) + 1)):
      return sel
    
def choice_pad():
  return select_option("<< iPad Pro 구입하기 >>", ("구입하기", "종료하기"))

def select_screen():
  return select_option("디스플레이를 선택 하세요.", ("11인치", "13인치"))

def select_color():
  return select_option("컬러를 선택 하세요.", ("스페이스그레이", "실버"))

def select_memory():
  return select_option("용량을 선택 하세요.", ("128GB", "256GB", "512GB", "1TB"))

def select_network():
  return select_option("네트워크를 선택 하세요.", ("Wi-Fi", "Wi-Fi+Cellular"))

def select_name_service():
  sel = select_option("각인 서비스를 선택하세요.", ("각인 서비스 신청", "신청 안함"))
  if sel == "1":
    return input("이름을 입력하세요: ")
  return "NONE"

def make_ipad(screen, color, memory, network, name):
  global make_cnt
  make_cnt += 1

  screen_option = ("", "11인치", "12.9인치")
  color_option = ("", "스페이스그레이", "실버")
  memory_option = ("", "128GB", "256GB", "512GB", "1TB")
  network_option = ("", "Wi-Fi", "Wi-Fi+Cellular")

  serial_screen = "11" if screen == "1" else "13"
  serial_network = "W" if network == "1" else "C"
  serial_date = datetime.today().strftime("%Y%m%d")
  serial_number = f"iPad{serial_screen}{serial_network}{serial_date}{make_cnt}"

  print("\n아이패드 제작중...")

  for i in range(1, 31):
    print(f"\r제작중... [{i * 100 // 30}%]", end='')
    time.sleep(1)

  print("\n\niPad Pro가 출고 되었습니다.")
  print("="*34)
  print(f"화면 크기 : {screen_option[int(screen)]}")
  print(f"제품 색상 : {color_option[int(color)]}")
  print(f"제품 용량 : {memory_option[int(memory)]}")
  print(f"네트워크 : {network_option[int(network)]}")
  print(f"이름 : {name}")
  print(f"시리얼 넘버 : {serial_number}")
  print("-" * 34)

while True:
  if choice_pad() == "2":
    print("iPad pro 구입을 종료합니다.")
    break

  screen = select_screen()
  color = select_color()
  memory = select_memory()
  network = select_network()
  name = select_name_service()
  make_ipad(screen, color, memory, network, name)



  

