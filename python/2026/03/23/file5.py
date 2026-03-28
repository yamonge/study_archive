import pickle

data = {'name' : 'Alice', 'age' : 30, 'city' : "New York"}
with open("data.pickle", 'wb') as file:
  pickle.dump(data, file)

with open('data.pickle', 'rb') as file:
  restored_data = pickle.load(file)

print(restored_data)