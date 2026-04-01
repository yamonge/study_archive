let nickname = "곰돌이";
let age = 23;
let addr = "충남 천안시";

let test10 = "1000.0";

console.log(nickname);
console.log(age);
console.log(addr);
console.log(test10);

nickname = "홍길동";
addr = "서울시 강남구";
age = 30;
let greeting = `안녕하세요. ${nickname}님 환영 합니다.~`;

console.log(nickname + " : " + addr);
console.log(greeting);

for (let i = 2; i <= 9; i++) {
  for (let j = 1; j <= 9; j++) {
    console.log(`${i} * ${j}  = ${i * j}`);
  }
  console.log();
}

const prompt = require("prompt-sync")();
let num1 = parseInt(prompt("첫번째 정수 입력: "));
let num2 = parseInt(prompt("두번째 정수 입력: "));

console.log(num1 + num2);

function check(num) {
  if (num < 0) {
    console.log(`${num} 은 음수 입니다`);
  } else {
    console.log(`${num} 은 양수 입니다`);
  }
}

check(num1);
check(num2);
