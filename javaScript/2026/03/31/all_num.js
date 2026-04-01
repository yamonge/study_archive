const prompt = require("prompt-sync")();

while (true) {
  let num = Number(prompt("정수 입력:  "));
  if (num < 0) {
    console.log(`잘못된 입력입니다.`);
    continue;
  }
  let rst1 = 0;
  let num2 = num;
  let rst2 = 0;
  while (num > 0) {
    rst1 += num;
    num--;
  }
  for (let i = 1; i <= num2; i++) {
    rst2 += i;
  }
  console.log(`while 문을 활용한 값 ${rst1} for문을 활용한 값  ${rst2}`);
  break;
}
