// 상근날도 : 햄버거 3개의 값 입력 음료수 2개의 값입력
// 세트 메뉴는 햄버거 3개중 제일 싼 가격 + 음료 두개중 작은가격 - 50
// 배열 이용 : 배열의 값은 push로 넣기

const prompt = require("prompt-sync")();

let menu = [{ hamberger: [] }, { drinks: [] }];

for (let i = 1; i <= 3; i++) {
  let val = Number(prompt(`햄버거${i}번 값 입력: `));
  menu[0].hamberger.push(val);
}
for (let i = 1; i <= 2; i++) {
  let val = Number(prompt(`음료수${i}번 값 입력: `));
  menu[1]["drinks"].push(val);
}

let setMenu =
  Math.min(...menu[0].hamberger) - Math.min(...menu[1]["drinks"]) - 50;

for (let val of menu) {
  console.log(val);
}
console.log(setMenu);


