use sample_mflix

db.movies.find()

db.movies.aggregate([
    { $match: { year: 1995 } }
]).itcount()

db.movies.countDocuments({ year: 1995 })

db.comments.aggregate([
    {
        $group: {
            _id: "$movie_id",
            commentCount: { $sum: 1 }   // Document 수를 합산
        }
    }
])

db.movies.aggregate([
    {
        $group: {
            _id: "$year",
            totalMovies: { $sum: 1 }
        }
    }
])

db.movies.aggregate([{
    $group: {
        _id: "$year",
        averageRating: { $avg: "$imdb.rating" }
    }
}])

db.movies.aggregate([
    {
        $group: {
            _id: "$year",
            minRating: { $min: "$imdb.rating" },
            maxRating: { $max: "$imdb.rating" }
        }
    },
    {
        $sort: { _id: 1 } // _id(year)를 기준으로 오름차순(1) 정렬)
    }])

db.movies.aggregate([{
    $group: {
        _id: "$year",
        titles: { $push: "$title" }
    }
}])

db.movies.aggregate([
    {
        $group: {
            _id: "$year",
            genres: { $addToSet: "$genres" }
        }
    }
])

db.movies.aggregate([
    {
        $sort: { "year": 1, "title": 1 }
    },
    {
        $group: {
            _id: "$year",
            firstMovie: { $first: "$title" },
            lastMovie: { $last: "$title" }
        }
    }
])

db.movies.aggregate([{
    $sort: { "year": 1, "title": 1 }
},
{
    $project: {
        _id: 0, //_id는 기본적으로 표시되므로, 제외하고 싶으면 0으로 설정할것
        year: 1,
        "영화제목": "$title",
        lastupdated: 1,
        "타입": "$type"
    }
}])

// unwind : 다풀어헤쳐주세요
db.movies.aggregate([
    { $unwind: "$cast" },
    { $limit: 100 }
])

db.movies.aggregate([
    {
        $group: {
            _id: "$year",
            avgTitleLength: { $avg: { $strLenCP: { $toString: "$title" } } }
        }
    }
]);

db.movies.aggregate([
    { $match: { year: { $gte: 2000 } } },
    { $count: "movies_since_2000" }
]);

db.movies.aggregate([
    { $sort: { "year": 1, "title": 1 } }
]);

db.movies.aggregate([
    { $unwind: "$genres" }
]);

db.movies.aggregate([
    { $sort: { "imdb.rating": -1 } },
    { $limit: 5 }
]);


// 연습문제
//1. 2000년 이후로 출시된 영화의 수는?
db.movies.aggregate([
    { $match: { year: { $gte: 2000 } } },
    { $count: "total_movies" }
]);


//2. 각 연도별 출시된 영화의 수는?
db.movies.aggregate([
    { $group: { _id: "$year", count: { $sum: 1 } } },
    { $sort: { _id: 1 } }
])

//3. 가장 많은 영화가 출시된 연도는?
db.movies.aggregate([
    { $group: { _id: "$year", count: { $sum: 1 } } },
    { $sort: { count: -1 } },
    { $limit: 1 }
])  // max를 사용하는경우 단일 답만 가져오기때문에 max값에 해당하는 년도를 뽑아내는 과정을 따로 거쳐야 하므로 복잡하다. 위처럼 쿼리문을 짜는게 효율적

//4.각 연도별 평균 영화 러닝타임(runtime)은?
db.movies.aggregate([
    { $group: { _id: "$year", avgRuntime: { $avg: "$runtime" } } }, // 년도별 러닝타임의 평균을 구한다.
    { $sort: { avgRuntime: -1 } }
])

//5. 가장 러닝타임이 긴 영화는?
db.movies.aggregate([
    { $sort: { runtime: -1 } },
    { $limit: 1 }
])

// 6. 각 영화 장르별 평균 IMDB 평점은?
db.movies.aggregate([
    { $unwind: "$genres" },
    { $group: { _id: "$genres", avgRating: { $avg: "$imdb.rating" } } },
    { $sort: { avgRating: -1}}
])


// 7. 각 연도별 영화 제목의 평균 길이는?
db.movies.aggregate([
    {$group: {_id: "$year", avgTitleLength: {$avg: {$strLenCP: {$toString: "$title"}}}}},
    {$sort: {_id: 1}}
])

// 8. 각 연도별 가장 먼저 출시된 영화의 제목은?
db.movies.aggregate([
    { $sort: {"year": 1, "released": 1}},
    { $group: { _id: "$year", firstMovie: { $first: "$title"}}},
    { $sort: { _id: 1}}
])

// 9. 각 연도별 가장 마지막에 출시된 영화의 제목은?
db.movies.aggregate([
    { $sort: {"year": 1, "released": 1}},
    { $group: { _id: "$year", lastMovie: { $last: "$title"}}},
    { $sort: { _id: 1}}
])

// 각 연도별로 고유한 영화 장르는?
db.movies.aggregate([
    { $unwind: "$genres"},
    { $group: {_id: "$year", uniqueGenres:{ $addToSet: "$genres"}}},
    { $sort: {_id: 1}}
])

// $project : 출력 문서의 특정 필드를 선택하거나 필드의 형식 변환할때 활용
db.movies.aggregate([
    { $project: {_id: 0, title: 1, year: 1}}
])

db.movies.aggregate([
    { 
        $project: { 
            title: 1,
            year: 1,
            releasedIn: { $concat: ["$title", " (", { $toString: "$year" }, ")"] }
        }
    }
]);

// $contcat : 문자열 필드를 연결하여 새로운 문자열 생성
db.movies.aggregate([
    {
        $project: {
            _id: 0,
            title: 1,
            year: 1,
            titleWithYear: { $concat: ["$title", " (", { $toString: "$year" }, ")"] }
        }
    }
]);

// $lookup : 다른 컬렉션과의 조인(join) 작업을 수행하여 관련 데이터를 결합하는 데 사용
db.comments.aggregate([
   {
      $lookup:
        {
          from: "movies",
          localField: "movie_id",
          foreignField: "_id",
          as: "movie"
        }
   }
])

db.users.aggregate([
   {
      $lookup:
        {
          from: "comments",
          localField: "email",
          foreignField: "email",
          as: "user_comments"
        }
   }
])

// $skip : 스테이지는 파이프라인에서 일정 개수의 문서를 건너뛰고 그 다음 문서들을 출력

//첫 번째 3개의 영화를 건너뛰고 나머지 영화를 출력하는 쿼리입니다:
db.movies.aggregate([
    { $skip: 3 }
]);

// 러닝타임이 100분 이상인 영화 리스트에서 상위 5개의 영화를 건너띄고, 나머지 영화를 출력하는 쿼리입니다:
db.movies.aggregate([
    { $match: { runtime: { $gte: 100 } } },
    { $skip: 5 }
]);

//$facet : 스테이지는 단일 Aggregation 파이프라인 내에서 다중 Aggregation 파이프라인을 정의하여 여러 결과 집합을 생성

//출시 연도별로 영화 수와 최고 평점을 구하는 쿼리입니다:
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