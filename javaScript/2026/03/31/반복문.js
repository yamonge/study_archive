const prompt = require("prompt-sync")();

let age = Number(prompt("나이 입력: "));
console.log("당신은 " + (age >= 19 ? "성인" : "미성년자") + " 입니다");

// 국어 영어 수학 성적을 입력받아 평균 if else문으로 등급 출력
// 90 > A, 80 > B, 70 > C, 60 > D, etc F
// 국어 영어 수학 성적 입력은 0~100 값
function check(num) {
  if (num > 0 && num < 100) {
    return num;
  } else {
    return 0;
  }
}
while (true) {
  let kor = Number(prompt("국어 점수: "));
  let eng = Number(prompt("영어 점수: "));
  let mat = Number(prompt("수학 점수: "));
  let list = [kor, eng, mat];
  for (let num of list) {
    let rst = check(num);
    if (rst == 0) {
      console.log("숫자의 범위가 잘못됨");
      continue;
    }
  }
  let avg = (kor + eng + mat) / 3;
  let grade;
  if (avg >= 90) {
    grade = "A";
  } else if (avg >= 80) {
    grade = "B";
  } else if (avg >= 70) {
    grade = "C";
  } else if (avg >= 60) {
    grade = "D";
  } else {
    grade = "F";
  }

  console.log(`당신의 등급은 "${grade}" 입니다.`);
  break;
}
