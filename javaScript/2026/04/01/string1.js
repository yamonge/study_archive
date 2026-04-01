const email = "et3566@naver.com";
if (!email.includes("@")) {
  console.log("올바른 이메일 형태가 아닙니다.");
} else {
  console.log("올바른 이메일 형태입니다.");
}
if (email.indexOf("@") == -1) {
  console.log("올바른 이메일 형태가 아닙니다.");
} else {
  console.log("올바른 이메일 형태입니다.");
}

const str = "Apple, Banana, Kiwi";
console.log(str.slice(7, -2));
console.log(str.substring(7, 13));

const text1 = "지구오락실, 이영지, 안유진, 마마, 이은지";
const newText1 = text1.replace("이은지", "나영석");
console.log(newText1);

const name1 = "안유진";
const name2 = "나영석";
const name3 = name1.concat(" ", name2);
console.log(name3);

const text2 =
  "                                안녕하세요 자바 스크립트 입니다.                           ";
console.log(text2);
console.log(text2.trim());

const text3 = "12345";
console.log(text3.padStart(10, "*"));

const jumin = "010222-3166414";
if (jumin.charAt(7) == "1" || jumin.charAt(7) == "3") {
  console.log("남성입니다.");
} else {
  console.log("여성입니다.");
}

const text4 = "abcdABCD";
for (let i = 0; i < text4.length; i++) {
  process.stdout.write(text4.charCodeAt(i) + " ");
}

const birthDay = "2001-02-01";
const dayArr = birthDay.split("-");
