knife = 10
def game(player):
  knife2 = knife - player
  print(f"남아 있는 칼은 {knife2} 자루 입니다.")

def game2(player, knife):
  knife = knife - player
  print(f"남아 있는 칼은 {knife} 자루 입니다.")

player = int(input("경기에 참여하는 선수가 몇명 입니까? "))
game(player)
# game2(player, knife)