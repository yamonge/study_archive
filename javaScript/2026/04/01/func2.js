function buyToy(object) {
  console.log(
    `아이가 ${object.item} 장난감을 ${object.quantity} 개 골라서 가져왔습니다.`,
  );
  setTimeout(() => {
    console.log(`계산이 필요 합니다.`);
    let total = object.price * object.quantity;
    object.callback(total);
  }, 2000);
}

function pay(total) {
  console.log(`엄마: 지불할 금액은 ${total} 입니다.`);
  console.log(`아이: 와! 고마워요, 엄마!`);
}

buyToy({
  item: "건담",
  quantity: 3,
  price: 2000,
  callback: pay,
});
