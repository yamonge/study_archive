const arr = [10, 20, 30, 40, 50, 60, 70];
arr.forEach((e) => {
  console.log(e);
});

let fruits = ["Banana", "Orange", "Apple", "Mango"];
console.log(fruits.toString());
console.log(fruits.join(" * "));
console.log(arr.pop());
console.log(arr);

arr.push(100);
console.log(arr);
console.log(arr.filter((e) => e > 20));
console.log(
  arr
    .filter((e) => e > 20)
    .map((e) => {
      return e.toString();
    }),
);
