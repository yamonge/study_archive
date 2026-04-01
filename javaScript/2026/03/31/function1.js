// 입력 받은 정수보다 미만의 소수의 합을 구하는 함수
// 함수 선언문과 함수 표현식 2개로 구현

// 함수 선언문
function func1(num) {
  let list = [];
  for (let i = 2; i < num; i++) {
    let isPrime = true;
    for (let j = 2; j < i; j++) {
      if (i % j == 0) {
        isPrime = false;
        break;
      }
    }
    if (isPrime) {
      list.push(i);
    }
  }
  return list;
}
// 함수 표현식식
const func2 = function (num) {
  let list = [];
  for (let i = 2; i < num; i++) {
    let isPrime = true;
    for (let j = 2; j < i; j++) {
      if (i % j == 0) {
        isPrime = false;
        break;
      }
    }
    if (isPrime) {
      list.push(i);
    }
  }
  return list;
};

let prompt = require("prompt-sync")();

let number = prompt("정수 입력: ");

const arr1 = func1(number);
const arr2 = func2(number);

const rst1 = arr1.reduce((acc, cur) => acc + cur, 0);
const rst2 = arr2.reduce((acc, cur) => acc + cur, 0);

console.log(`${number} 미만의 소수들의 합은 ${rst1} 입니다. 함수 선언문 사용`);
console.log(`${number} 미만의 소수들의 합은 ${rst2} 입니다. 함수 표현식 사용`);
