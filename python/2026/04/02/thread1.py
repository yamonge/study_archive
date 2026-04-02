import threading

def my_function():
  print("Thread is running")

thread = threading.Thread(target=my_function)
thread.start()
