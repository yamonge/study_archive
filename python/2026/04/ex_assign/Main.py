from Order import Order
from Product import Product
from decimal import Decimal

if __name__ == "__main__":
  my_order = Order()

  my_order.add_item(Product("Apples", "3.16"))
  my_order.add_item(Product("Bananas", "1.06"))

  final_price = my_order.calculate_final_price(Decimal("0.06"))

  print(f"최종 가격 (세금 포함) : {final_price}")