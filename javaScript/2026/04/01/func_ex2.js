function orderCoffee(name, object) {
  setTimeout(() => {
    object.callback(`주문하신 ${name} 커피 나왔습니다!`);
  }, 2000);
}

function display(msg) {
  console.log(msg);
}

orderCoffee("아메리카노", {
  callback: display,
});
