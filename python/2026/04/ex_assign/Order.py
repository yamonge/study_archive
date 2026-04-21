from decimal import Decimal
import Product

class Order:
  def __init__(self):
    self.products = []
    self.total = 0
  
  def add_item(self, product: Product):
    self.products.append(product)
    self.total += product.price