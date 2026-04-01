// 좌변 값 연산자 우변값 을 입력 해서 산술 연산을 수행하는 스위치문 만들기

const prompt = require("prompt-sync")();

let mat = prompt("연산자 입력: ");
let num1 = Number(prompt("좌변 입력: "));
let num2 = Number(prompt("우변 입력: "));
let rst;
switch (mat) {
  case "+":
    rst = num1 + num2;
    break;
  case "-":
    rst = num1 - num2;
    break;
  case "/":
    rst = num1 / num2;
    break;
  case "*":
    rst = num1 * num2;
    break;
  default:
    console.log("잘못된 입력입니다.");
}

console.log(`${num1} ${mat} ${num2} = ${rst}`);
