sayHello();

function sayHello() {
  console.log("안녕하세요!");
}
// 함수 표현식은 변수에 함수를 넣는것이기 때문에 변수다음에 사용해야함
// sayGoodbye();

const sayGoodbye = function () {
  console.log("안녕히 가세요.");
};

sayGoodbye();
