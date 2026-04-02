const names = ["김철수", "이영희", "박민준"];
console.log(names.map((e) => "학생 : " + e));

const prices = [10000, 25000, 8000, 45000];
console.log(prices.map((e) => Math.floor(e * 1.1)));

const people = [
  { name: "김철수", age: 17 },
  { name: "이영희", age: 25 },
  { name: "박민준", age: 19 },
  { name: "최수지", age: 22 },
];

console.log(people.filter((e) => e.age > 20));

const emails = [
  "kim@naver.com",
  "lee@daum.com",
  "park@gmail.com",
  "choi@kakao.net",
];

console.log(emails.filter((e) => e.includes(".com")));

const employees = [
  { name: "김부장", salary: 72000000, active: true },
  { name: "이과장", salary: 48000000, active: true },
  { name: "박대리", salary: 38000000, active: false },
  { name: "최주임", salary: 55000000, active: true },
  { name: "정사원", salary: 32000000, active: true },
];

console.log(
  employees
    .filter((e) => e.salary > 50000000 && e.active == true)
    .map((e) => {
      return { name: e.name, salary: e.salary };
    }),
);
