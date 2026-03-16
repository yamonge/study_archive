db.getCollection("users_collection").find({})

db.users_collection.insertMany(
    [
    { name:"David", age:45, address:"서울" },
	{ name:"DaveLee", age:25, address:"경기도" },
	{ name:"Andy", age:50, hobby:"골프", address:"경기도" },
	{ name:"Kate", age:35, address:"수원시" },
	{ name:"Brown", age:8 }
    ]
)

db.users_collection.find()

//use testDB
//db.users.drop()
//db.dropDatabase()

// test2 db 만들기(사용하기)
use test2

show dbs

// collection 만들기
db.createCollection("collection1")

show collections

db.createCollection("collection2")

show collections

db.stats()

db.collection1.isCapped()

db.createCollection("log", { capped: true, size : 5242880, max: 5000})

db.log.isCapped()

// human db 만들기
use human
db.createCollection("users")
db.stats()

db.createCollection("log")

// collection 이름 변경
db.log.renameCollection("log1")

db.users.insertOne({ subject: "codding", author: "human", views: 50})

db.users.insertMany([
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
    ])

db.users.find()

db.users.drop()

// 연습문제
// 1. users collection 생성
db.createCollection("users", { capped: true, size: 100000})

// 2. Document 데이터 넣기
db.users.insertMany([
    { name:"David", age:45, address:"서울" },
	{ name:"DaveLee", age:25, address:"경기도" },
	{ name:"Andy", age:50, hobby:"골프", address:"경기도" },
	{ name:"Kate", age:35, address:"수원시" },
	{ name:"Brown", age:8 }
])

db.users.find()

// select * from users
db.users.find({}, {name:1, address:1, _id:0})

db.users.find({address: "서울"}, {_id: 0})

// 연습문제
// users collection에서 name이 DaveLee인 document 의 name, age, address, _id 출력
db.users.find({name: "DaveLee"}, {name:1, age:1, address:1, _id:1})

// users collection에서 name가 Kate인 document의 name, age, address 출력
db.users.find({name: "Kate"}, {name:1, age:1, address:1, _id:0})

// 비교문법
db.users.find({ age: { $gt: 25, $lt: 50 } })

db.users.find({ age: { $lt: 25 } })

db.users.find({age: {$gt: 8}})

db.users.find({ age: { $gt: 25, $lte: 50 } })

// 연습문제
db.users.find({age: {$gt: 20}}, {name:1, _id:0})

db.users.find({age: {$eq: 50}, address: {$eq: "경기도"}}, {name:1, _id:0})

db.users.find({age: {$lt: 30}}, {name:1, age:1, _id:0})

// 논리 연산 문법 $or $and $not
db.users.find({ $or: [ { address: "경기도" } , { age: 45 } ] })
db.users.find({ age: { $not: { $eq: 45 } } })
//연습문제
//1. users Collection 에서 name 가 Brown 이거나, age가 35인 Document 의 모든 필드 출력
db.users.find({$or: [{name: "Brown"}, {age: 35}]})

// users Collection 에서 name 가 Brown 이 아니고, age 가 45 가 아닌 모든 필드 출력
db.users.find({
      name: {
        $not: {
          $eq: "Brown"
        }
      },
      age: {
        $not: {
          $eq: 45
        }
      }
    })

db.users.find({
      $and: [
        {
          name: {
            $not: {
              $eq: "Brown"
            }
          }
        },
        {
          age: {
            $not: {
              $eq: 45
            }
          }
        }
      ]
    })
    
db.users.find({name: /Lee/})

db.users.find( { name: { $regex: /Lee/ } } )

db.users.find( { address: "경기도" } ).sort( { age: 1 } ) // 오름차순

db.users.find( { address: "경기도" } ).sort( { age: -1 } ) // 내림차순

db.users.count() // 모든 Document의 수 

db.users.find().count()

db.users.count({ address: {$exists: true}})

db.users.find({ address: {$exists: true}})

db.users.find({ address: {$exists: false}})

db.users.distinct("address")

db.users.findOne()

db.users.find().limit(1)

/* 배열과 $all
배열(array)을 사용하여 여러 값을 하나의 필드에 저장 가능
배열은 대괄호([])로 묶인 값들의 리스트로 표현
 */
db.users.insertMany([
   { name: "유진", age: 25, hobbies: ["독서", "영화", "요리"] },
   { name: "동현", age: 30, hobbies: ["축구", "음악", "영화"] },
   { name: "혜진", age: 35, hobbies: ["요리", "여행", "독서"] }
])

db.users.find()

// 배열 필드가 주어진 모든 값을 포함하는 문서 찾기($all)
// 취미 필드가 "축구"와 "요리"를 모두 포함하는 모든 문서를 찾는 명령
db.users.find( { hobbies: { $all: [ "축구", "음악" ] } } )

// 여러 값 중 하나와 일치하는 문서 찾기($in)
db.users.find( { hobbies: { $in: [ "축구", "요리" ] } } )

// 여러 값 중 어떤 것과도 일치하지 않는 문서 찾기($nin)
db.users.find( { hobbies: { $nin: [ "축구", "요리" ] } } )

db.users.updateMany({age: {$gt: 25}}, {$set: {address: "서울"}})

db.users.updateMany( { address: "서울" } , { $inc: { age: 3 } } )

db.users.find()

// 연습문제
// age 가 40 보다 큰 Document 의 address 를 수원시 로 변환하기
db.users.updateMany( {age: {$gt: 40}}, {$set: {address: "수원시"}})

db.users.find()

db.users.updateOne( { name: "유진" }, { $set: { age: 26 } } )

db.users.updateOne(   { name: "자르반40세" },
    { $set: {"name": "자르반4세", age: 40, hobbies: ["축구", "음악", "영화"]}} )
    
db.users.updateOne( { name: "유진" }, { $unset: { age: 1 } } ) // age가 없어짐

db.users.updateOne(   
    { name: "민준" },    
    { $set: { name: "민준", age: 22, hobbies: ["음악", "여행"] }},    
    { upsert: true } )    


db.users.updateMany({age: {$lte: 25}}, {$set: {hobbies: ["독서"]}})

db.users.updateOne({name: "유진"}, {$push: {hobbies: "운동"}})

db.users.find({}, {hobbies: 1, _id: 0})
