from flask import Flask
import requests
from bs4 import BeautifulSoup


app = Flask(__name__)

@app.route("/weather")
def get_weather():
  url = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108"
  response = requests.get(url).text
  soup = BeautifulSoup(response, "html_parser")
  output = ""

  for loc in soup.select("location"):
    output += f"<h3 stlye='color: royalblue'>{loc.select_one('city').string}"
    output += f"날씨 : {loc.select_one('wf').string}</br>"
    output += f"최저/최고 기온 : {loc.select_one9}"

if __name__ == "__main__":
  app.run()