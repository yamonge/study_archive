const member = {
  email: "jdk2024@gamil.com",
  pwd: "sphb8250",
  name: "곰돌이",
  phone: "010-1000-2000",
};

const post = (val, index) => ({
  postNum: index + 1,
  title: `제목${index + 1}`,
});

const comment = (v, i, val) => ({
  commentNum: i + 1,
  content: `댓글${i + 1}`,
  word: val,
});

const memberList = Array.from({ length: 10 }, () => ({ ...member }));
const postList = Array.from({ length: 10 }, post);
const commentList = Array.from({ length: 10 }, (v, i) =>
  comment(v, i, "sayHello"),
);

console.log(commentList);
