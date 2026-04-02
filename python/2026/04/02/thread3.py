import threading

lock = threading.Lock()
shared_resouce = 0

def increment():
  global shared_resouce
  for _ in range(100000):
    lock.acquire()
    shared_resouce += 1
    lock.release()

thread1 = threading.Thread(target=increment)
thread2 = threading.Thread(target=increment)

thread1.start()
thread2.start()

thread1.join()
thread2.join()

print(shared_resouce)
