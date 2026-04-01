// 임의의 정수 8개를 입력 받아 홀수와 짝수 나누어 담기
function check(num) {
  if (num % 2 == 0) {
    return true;
  } else {
    return false;
  }
}
const prompt = require("prompt-sync")();
while (true) {
  let val = prompt("8개의 정수 입력: ");
  let strArr = val.split(" ");
  let oddArr = [];
  let evenArr = [];
  if (strArr.length != 8) {
    console.log("8개의 정수가 아닙니다.");
    continue;
  }
  for (let str of strArr) {
    if (check(Number(str))) {
      oddArr.push(Number(str));
    } else {
      evenArr.push(Number(str));
    }
  }

  console.log(oddArr);
  console.log(evenArr);
  break;
}
