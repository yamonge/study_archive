const pwd = "1234";
console.log(pwd.padStart(8, "*"));

const email = "jks2024@naver.com";
const rst1 = email.split("@");
console.log(rst1[0]);

const phone = "010-1234-5678";
const masked = phone.slice(0, 4) + "****" + phone.slice(8);
console.log(masked);

const jumin = "990101-1234567";
const temp1 = jumin.substring(0, 6).concat("-*******");
console.log(temp1);

const str = "나는 JavaScript와 React를 공부 합니다.";
const rst2 = str
  .split("")
  .map((c) => (c === c.toUpperCase() ? c.toLowerCase() : c.toUpperCase()))
  .join("");

console.log(rst2);

let today = new Date();
let fullYear = Number(
  (() => {
    if (jumin.charAt(7) == "1" || jumin.charAt(7) == "2") {
      return "19" + jumin.slice(0, 2);
    } else {
      return "20" + jumin.slice(0, 2);
    }
  })(),
);
let birtgDay2 = `${jumin.slice(0, 2)}년${jumin.slice(3, 4)}월${jumin.slice(5, 6)}일`;
let birthRst = birtgDay2.replace("0", "");
let age = today.getFullYear() - fullYear;
let gender = () => {
  if (jumin.charAt(7) == "1" || jumin.charAt(7) == "3") {
    return "남성";
  } else {
    return "여성";
  }
};

console.log(`생년월일 : ${birthRst}`);
console.log(`나이 : ${age}`);
console.log(`성별 : ${gender()}`);
