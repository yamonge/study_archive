show dbs

use myDB

show collections

db.test.find()

db.stats()

db.createCollection("users")

show collections

db.createCollection("log", { capped: true, size: 5242880, max: 5000 } )

db.dropDatabase()

use testDB

db.createCollection("users")

db.createCollection("test_collection")

db.test_collection.drop()

db.users.insertOne(
    {
        subject: "coding",
        author: "human",
        views: 50
    }
)

db.users.insertMany(
    [
      { subject: "coffee", author: "xyz", views: 50 },
      { subject: "Coffee Shopping", author: "efg", views: 5 },
      { subject: "Baking a cake", author: "abc", views: 90  },
      { subject: "baking", author: "xyz", views: 100 },
      { subject: "Café Con Leche", author: "abc", views: 200 },
      { subject: "Сырники", author: "jkl", views: 80 },
      { subject: "coffee and cream", author: "efg", views: 10 },
      { subject: "Cafe con Leche", author: "xyz", views: 10 },
      { subject: "coffees", author: "xyz", views: 10 },
      { subject: "coffee1", author: "xyz", views: 10 }
    ]
  )
  
  db.users.find()
  
  // 연습문제 4.1
  db.users.insertMany(
    [
        { name:"David", age:45, address:"서울" },
	    { name:"DaveLee", age:25, address:"경기도" },
	    { name:"Andy", age:50, hobby:"골프", address:"경기도" },
	    { name:"Kate", age:35, address:"수원시" },
	    { name:"Brown", age:8 }
    ]
  )
  
  db.users.find()