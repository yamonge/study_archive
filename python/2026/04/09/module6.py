import requests

from bs4 import BeautifulSoup

url="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108"

response = requests.get(url)

soup = BeautifulSoup(response.text, "html.parser")

for loc in soup.select("location"):
  print("도시 : ", loc.select_one("city").string)
  print("날씨 : ", loc.select_one("wf").string)
  print("최저기온 : ", loc.select_one("tmn").string)
  print("최고기온 : ", loc.select_one("tmx").string)
  print("-"*20)
