from simple_colors import *
import threading
import time
import random

class Unit:
  def __init__(self, pp, mp, ph, mh, hp):
    self.p_power = pp
    self.m_power = mp
    self.p_hit = ph
    self.m_hit = mh
    self.hp = hp
    self.alive = True

  def set_damage(self, damage):
    if self.hp > damage:
      self.hp -= damage
      self.alive = True
    else:
      self.hp = 0
      self.alive = False
  
  def is_alive(self):
    return self.alive

class Character(Unit):
  def __init__(self, pp, mp, ph, mh, hp, um, job):
    super().__init__(pp, mp, ph, mh, hp)
    self.ultimate = um
    self.job = job

  def p_attack(self):
    return self.p_power * self.p_hit
  
  def m_attack(self):
    return self.m_power * self.m_hit
  
  def attack_ultra(self):
    return self.ultimate

def print_status(character):
  if character.is_alive():
    print(f"남아 있는 {green(character.job)}의 체력은 {blue(f'{character.hp:.2f}')} 입니다.")
  else:
    print(f"{green(character.job)}가 죽었습니다. 게임을 종료합니다.")

def perform_attack(attacker, defender):
  val = random.choice(["physical", "magical"])
  ul = random.randint(1, 18)

  if val == "physical":
    damage = attacker.p_attack()
    print(f"{blue('물리공격')} >> {defender.job} 에게 {yellow(f"{damage:.2f}")} 데미지 입힘")
  else:
    damage = attacker.m_attack()
    print(f"{blue('마법공격')} >> {defender.job} 에게 {yellow(f"{damage:.2f}")} 데미지 입힘")
  
  defender.set_damage(damage)
  print_status(defender)

  if ul == 1:
    damage = attacker.attack_ultra()
    print(f"{red("궁극기 발동")} >> {defender.job}에게 {red(f"{damage:.2f}")} 데미지 입힘");
    defender.set_damage(damage)
    print_status(defender)

def wizard_thread(x, y):
  while True:
    time.sleep(5)
    if not x.is_alive() or not y.is_alive():
      break
    perform_attack(x, y)

if __name__ == "__main__":
  name1 = input("전사 이름 만들기: ")
  name2 = input("마법사 이름 만들기: ")
  warrior = Character(8, 2, 0.8, 0.5, 150, 40, name1)
  wizard = Character(2, 20, 0.5, 0.9, 60, 55, name2)

  x1 = threading.Thread(target=wizard_thread, args=(warrior, wizard))
  x2 = threading.Thread(target=wizard_thread, args=(wizard, warrior))

  x1.start()
  x2.start()

  x1.join()
  x2.join()
  print('전투가 완전히 종료 되었습니다.')



