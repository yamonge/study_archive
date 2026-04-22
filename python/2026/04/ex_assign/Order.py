from decimal import Decimal
from Product import Product

class Order:
  def __init__(self):
    self.products: list[Product] = []
    self.total = 0
  
  def add_item(self, product: Product):
    self.products.append(product)
    self.total += Decimal(product.price)

  def get_item(self, name: str):
    for product in self.products:
      if product.get_name() == name:
        return name
    return print(f"{name} 의 상품을 찾을수없습니다.")
  
  def remove_item(self, name: str):
    for product in self.products:
      if product.get_name() == name:
        self.products.remove(product)
        return True
    return False

  def calculate_final_price(self, tax_rate: Decimal):
    return round(self.total * (Decimal("1") + tax_rate), 2)