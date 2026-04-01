const persons = [
  {
    name: "홍길동",
    job: "도적",
    addr: "서울시",
  },
  {
    name: "김철수",
    job: "개발자",
    addr: "경기도 성남시",
  },
  {
    name: "이영희",
    job: "디자이너",
    addr: "부산광역시",
  },
  {
    name: "박민수",
    job: "기획자",
    addr: "대전광역시",
  },
];

for (let person of persons) {
  for (let key in person) {
    process.stdout.write(`${key} : ${person[key]} `);
  }
  console.log();
}
