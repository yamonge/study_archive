let x = 4000;
(function () {
  let x = 200;
  let y = 300;
  console.log(x + y);
})();

function sum(x, y) {
  return x + y;
}

const sum2 = (x, y) => {
  return x + y;
};

console.log(sum2(100, 200));
console.log(((a, b) => a + b)(100, 200));
