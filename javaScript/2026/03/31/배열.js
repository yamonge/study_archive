let brands = ["애플", "구글", "삼성전자", "아마존", true, 100];

for (let i = 0; i < brands.length; i++) {
  console.log(brands[i]);
}
for (let brand of brands) {
  process.stdout.write(brand + " ");
}
console.log();
const person = {
  name: "곰돌이",
  job: "프로그래머",
  addr: "경기도 수원시",
};

for (let key in person) {
  process.stdout.write(person[key] + "  ");
}

console.log();
