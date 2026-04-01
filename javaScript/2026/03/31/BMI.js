const prompt = require("prompt-sync")();

let height = Number(prompt("키를 입력하시오: "));
let weight = Number(prompt("몸무게를 입력하시오 : "));
let meter_height = height / 100;
let bmi = Number(weight / (meter_height * meter_height)).toFixed(2);
let rst;
if (bmi >= 25) {
  rst = "비만";
} else if (bmi < 25 && bmi >= 23) {
  rst = "과체중";
} else if (bmi < 23 && bmi >= 18.5) {
  rst = "정상";
} else {
  rst = "저체중";
}

console.log(`당신의 bmi 는 ${bmi} 이고, 결과는 ${rst} 입니다.`);
