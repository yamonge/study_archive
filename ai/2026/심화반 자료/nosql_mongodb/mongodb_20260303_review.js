show dbs

use sample_mflix

use test3
db.createCollection("collection3")

db.stats()

use test3
db.collection3.drop() 

// db.users.find({/* 줄 선택 */}, {name:1, address:1 /* 선택 여부*/})

use human

db.users.find()

db.users.find({ hobbies: {$all: ["축구", "음악"]}})

db.users.updateMany({age: {$gt: 25}}, {$set: {address: "서울"}})

db.users.updateMany({address: "서울"}, {$inc: {age: 3}})

db.users.findOne({address:"서울"})

db.users.deleteOne({name: "David"})

db.users.findOne({name: "David"})

use sample_mflix

db.theaters.find()

db.movies.countDocuments({ year: 1995})

db.movies.aggregate([
  {
    $group: {
         _id: "$year",
         averageRating: { $avg: "$imdb.rating" }
    }
  }
]);

db.movies.aggregate([
 {
   $group: {
     _id: "$year",
     titles: { $push: "$title" }
   }
 }
]);

// strLenCP : 문자열의 길이 반환
db.movies.aggregate([
    {
        $group: {
            _id: "$year",
            avgTitleLength: { $avg: { $strLenCP: { $toString: "$title" } } }
        }
    },
    {$sort: {_id: 1}} // 연도의 오름차순으로 정렬
]);

// $sort : 입력 문서를 지정된 필드를 기준으로 정렬, 정렬 필드와 순서(오름차순 : 1, 내림차순 : -1)를 지정
db.movies.aggregate([
    { $sort: { "year": 1, "title": 1 } }
]);


// unwind : 배열 필드를 "풀어"서 각각의 배열 요소가 개별 문서로 처리
db.movies.aggregate([
    { $unwind: "$genres" }
    ])

db.movies.aggregate([
    { $unwind: "$genres" },
    { $group: 
        { 
            _id : "$year", 
            genres : {$addToSet: "$genres"}
            }
        }
]);

// $facet : 단일 Aggregation 파이프라인 내에서 다중 Aggregation 파이프라인을 정의하여 여러 결과 집합을 생성
// 출시 연도별로 영화 수와 최고 평점을 구하는 쿼리
db.movies.aggregate([
    {
        $facet: {
            movieCountByYear: [
                { $group: { _id: "$year", count: { $sum: 1 } } }
            ],
            maxRatingByYear: [
                { $group: { _id: "$year", maxRating: { $max: "$imdb.rating" } } }
            ]
        }
    }
]);

// $redact : 문서 내에서 보안이나 필터링 규칙에 따라 문서를 제어하는 데 사용
// 평균 평점이 7 이상인 영화만을 출력하는 쿼리
// $$KEEP: 이 변수를 사용하면 현재 도큐먼트 또는 임베디드 도큐먼트를 보존하고 다음 하위 도큐먼트를 검토합니다.
// $$PRUNE: 이 변수를 사용하면 현재 도큐먼트 또는 임베디드 도큐먼트를 제거하고 추가 검토를 중지합니다.
db.movies.aggregate([
    {
        $redact: {
            $cond: {
                if: { $gte: ["$imdb.rating", 7] },
                then: "$$KEEP",
                else: "$$PRUNE"
            }
        }
    }
])