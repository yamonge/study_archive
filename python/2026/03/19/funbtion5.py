import time

def perform_operation(x, y, callback):
  result = 0
  for e in range(x):
    result += e + x + y
    time.sleep(x)
    callback(result)
  

def callback_function(result):
  print(f"Operation result is : {result}")

perform_operation(2, 20, callback_function)