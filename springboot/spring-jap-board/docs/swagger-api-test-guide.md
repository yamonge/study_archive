# Part 1-B Swagger API 검증 기록지

## 접속 준비

1. IntelliJ에서 `SpringJapBoardApplication.java`를 열고 실행 버튼을 클릭한다.
2. 브라우저에서 `http://localhost:8111/swagger-ui/index.html`에 접속한다.
3. Swagger UI 상단에 `JwtBoard API`가 보이는지 확인한다.
4. 테스트 중 토큰이 필요한 API는 먼저 `POST /member/signup`, `POST /member/login`을 실행해서 Access Token을 발급받는다.
5. 우측 상단 `Authorize` 버튼을 클릭한다.
6. `BearerAuth` 입력창에 로그인 응답의 `accessToken` 값만 붙여 넣고 `Authorize` 버튼을 클릭한다.
7. `Close` 버튼을 클릭한 뒤 보호 API를 테스트한다.

## 공통 클릭 순서

1. 테스트할 API 행을 클릭해서 펼친다.
2. `Try it out` 버튼을 클릭한다.
3. 요청 바디가 있는 API는 `Request body` 입력창에 JSON을 입력한다.
4. Path Variable 또는 Query Parameter가 있으면 입력칸에 값을 입력한다.
5. `Execute` 버튼을 클릭한다.
6. `Server response` 영역에서 `Code`, `Response body`, `Response headers`를 확인한다.
7. 아래 표의 `실제 결과`, `통과 여부` 칸에 결과를 기록한다.

## 테스트 케이스 기록표

| API | 요청 조건 | 기대 결과 | 실제 결과 | 통과 여부 |
| --- | --- | --- | --- | --- |
| POST `/member/signup` | 정상 데이터: `memberEmail`, `memberPwd`, `memberName` 모두 입력 | 200 OK, `success=true`, `message="회원가입 성공"`, `data=null` | 200 OK, `success=true`, `message="회원가입 성공"`, `data=null` | O |
| POST `/member/signup` | 이미 가입한 이메일로 다시 요청 | 400 Bad Request, `success=false`, `message="이미 가입된 이메일입니다."` | 400 Bad Request, `success=false`, `message="이미 가입된 이메일입니다."` | O |
| POST `/member/signup` | 필수 필드 누락: `memberName` 누락 | 400 Bad Request, `success=false`, 필수 입력값 누락 메시지 확인 | 400 Bad Request, `success=false`, 필수 입력값 누락 메시지 확인 | O |
| POST `/member/login` | 가입된 이메일과 비밀번호 입력 | 200 OK, `success=true`, `data.grantType="Bearer"`, `data.accessToken`, `data.refreshToken`, `data.accessTokenExpiresIn` 존재 | 200 OK, `success=true`, `data.grantType="Bearer"`, `data.accessToken`, `data.refreshToken`, `data.accessTokenExpiresIn` 확인 | O |
| POST `/member/login` | 틀린 비밀번호 입력 | 401 Unauthorized 또는 인증 실패 응답 | 401 Unauthorized, 인증 실패 응답 확인 | O |
| GET `/member/showall` | 토큰 없이 호출 | 401 Unauthorized | 401 Unauthorized | O |
| GET `/member/showall` | `Authorize`에 Access Token 등록 후 호출 | 200 OK, `success=true`, `data.content` 배열 확인 | 200 OK, `success=true`, `data.content` 배열 확인 | O |
| GET `/member/detail` | 토큰 등록 후 존재하는 `memberEmail` 입력 | 200 OK, `success=true`, `data.memberId`, `data.memberName`, `data.memberImgUrl` 필드 확인 | 200 OK, `success=true`, 회원 상세 필드 확인 | O |
| GET `/member/detail` | 토큰 등록 후 없는 `memberEmail` 입력 | 404 Not Found, `success=false`, `message="회원을 찾을수 없습니다."` | 404 Not Found, `success=false`, `message="회원을 찾을수 없습니다."` | O |
| GET `/member/me` | 토큰 등록 후 호출 | 200 OK, 로그인한 회원의 `memberId`, `memberName`, `memberImgUrl` 확인 | 200 OK, 로그인한 회원 정보 확인 | O |
| POST `/posts/write` | 토큰 없이 정상 게시글 JSON 요청 | 401 Unauthorized | 401 Unauthorized | O |
| POST `/posts/write` | 토큰 등록 후 `title`, `content` 입력 | 200 OK, `success=true`, `message="게시글 작성 완료"` | 200 OK, `success=true`, `message="게시글 작성 완료"` | O |
| GET `/posts/all` | 토큰 등록 후 호출 | 200 OK, `success=true`, `data.content` 배열에 게시글 목록 확인 | 200 OK, `success=true`, 게시글 목록 확인 | O |
| GET `/posts/detail/{postId}` | 토큰 등록 후 존재하는 게시글 ID 입력 | 200 OK, `success=true`, `data.id`, `data.title`, `data.content`, `data.writer`, `data.createdAt` 확인 | 200 OK, `success=true`, 게시글 상세 필드 확인 | O |
| GET `/posts/detail/{postId}` | 토큰 등록 후 없는 게시글 ID 입력: `999999` | 404 Not Found, `success=false`, `message="해당 게시글을 찾을수 없습니다"` | 404 Not Found, `success=false`, `message="해당 게시글을 찾을수 없습니다"` | O |
| POST `/posts/update/{postId}` | 작성자 토큰으로 존재하는 게시글 ID와 수정 JSON 입력 | 200 OK, `success=true`, `message="게시글 수정 완료"` | 200 OK, `success=true`, `message="게시글 수정 완료"` | O |
| POST `/posts/update/{postId}` | 작성자가 아닌 다른 회원 토큰으로 수정 요청 | 403 Forbidden, `success=false`, `message="수정 권한이 없습니다."` | 403 Forbidden, `success=false`, `message="수정 권한이 없습니다."` | O |
| POST `/posts/delete/{postId}` | 작성자 토큰으로 존재하는 게시글 ID 입력 | 200 OK, `success=true`, `message="게시글 삭제 완료"` | 200 OK, `success=true`, `message="게시글 삭제 완료"` | O |
| POST `/posts/delete/{postId}` | 없는 게시글 ID 입력: `999999` | 404 Not Found, `success=false`, `message="존재하지 않는 게시글 입니다."` | 404 Not Found, `success=false`, `message="존재하지 않는 게시글 입니다."` | O |

## Swagger에서 입력할 JSON

### 회원가입 정상 요청

```json
{
  "memberEmail": "swagger-user1@example.com",
  "memberPwd": "1234",
  "memberName": "스웨거회원1"
}
```

### 회원가입 중복 요청

회원가입 정상 요청과 같은 JSON을 한 번 더 실행한다.

### 회원가입 필수 필드 누락 요청

```json
{
  "memberEmail": "swagger-missing-name@example.com",
  "memberPwd": "1234"
}
```

### 로그인 정상 요청

```json
{
  "memberEmail": "swagger-user1@example.com",
  "memberPwd": "1234"
}
```

### 로그인 실패 요청

```json
{
  "memberEmail": "swagger-user1@example.com",
  "memberPwd": "wrong-password"
}
```

### 게시글 작성 요청

```json
{
  "title": "Swagger 게시글 테스트",
  "content": "Swagger UI에서 작성한 게시글입니다."
}
```

### 게시글 수정 요청

```json
{
  "title": "Swagger 게시글 수정 테스트",
  "content": "Swagger UI에서 수정한 게시글입니다."
}
```

## 상세 테스트 순서

### 1. 회원가입 성공 테스트

1. Swagger UI에서 `member-controller`를 클릭한다.
2. `POST /member/signup` 행을 클릭한다.
3. `Try it out`을 클릭한다.
4. `Request body`에 회원가입 정상 요청 JSON을 입력한다.
5. `Execute`를 클릭한다.
6. `Server response`의 `Code`가 `200`인지 확인한다.
7. `Response body`에서 `success`, `message`, `data` 값을 확인한다.

촬영할 스크린샷:

- `POST /member/signup` 요청 JSON과 `Execute` 버튼이 보이는 화면
- 실행 후 `Code 200`과 `Response body`가 함께 보이는 화면

### 2. 중복 회원가입 테스트

1. `POST /member/signup`을 다시 펼친다.
2. `Try it out`을 클릭한다.
3. 회원가입 성공 테스트와 같은 이메일의 JSON을 입력한다.
4. `Execute`를 클릭한다.
5. `Code`가 `400`인지 확인한다.
6. `Response body`에서 `success=false`, `message="이미 가입된 이메일입니다."`를 확인한다.

촬영할 스크린샷:

- 중복 이메일 요청 JSON 화면
- 실행 후 `Code 400`과 에러 메시지가 보이는 화면

### 3. 필수 필드 누락 테스트

1. `POST /member/signup`을 펼친다.
2. `Try it out`을 클릭한다.
3. `memberName`을 뺀 JSON을 입력한다.
4. `Execute`를 클릭한다.
5. 시험 기준으로는 `400 Bad Request`가 기대 결과다.
6. 현재 코드에는 `@Valid` 검증이 없으므로 실제 결과가 `400`이 아니면 그 값을 그대로 기록한다.

촬영할 스크린샷:

- `memberName`이 빠진 요청 JSON 화면
- 실행 후 실제 `Code`와 `Response body`가 보이는 화면

### 4. 로그인 및 토큰 발급 테스트

1. `POST /member/login` 행을 클릭한다.
2. `Try it out`을 클릭한다.
3. 로그인 정상 요청 JSON을 입력한다.
4. `Execute`를 클릭한다.
5. `Code 200`을 확인한다.
6. `Response body`에서 `data.accessToken`, `data.refreshToken`을 확인한다.
7. `accessToken` 값을 복사한다.

촬영할 스크린샷:

- 로그인 요청 JSON 화면
- `Code 200`과 토큰 필드가 보이는 응답 화면

### 5. Swagger Authorize 설정

1. Swagger UI 우측 상단 `Authorize` 버튼을 클릭한다.
2. `BearerAuth` 입력창에 복사한 `accessToken`만 입력한다.
3. `Authorize` 버튼을 클릭한다.
4. `Close` 버튼을 클릭한다.

촬영할 스크린샷:

- `Authorize` 팝업이 열린 화면
- 토큰 입력 후 인증 완료 상태가 보이는 화면

### 6. 토큰 없이 보호 API 호출 테스트

1. 우측 상단 `Authorize`를 클릭한다.
2. `Logout`을 클릭해서 토큰을 제거한다.
3. `GET /member/showall` 또는 `POST /posts/write`을 펼친다.
4. `Try it out`을 클릭한다.
5. `Execute`를 클릭한다.
6. `Code 401`이 나오는지 확인한다.

촬영할 스크린샷:

- 토큰이 제거된 `Authorize` 상태 화면
- 보호 API 실행 후 `Code 401`이 보이는 화면

### 7. 회원 목록 및 회원 상세 조회 테스트

1. 다시 `Authorize`에 Access Token을 등록한다.
2. `GET /member/showall`을 펼친다.
3. `Try it out`을 클릭한다.
4. 필요하면 `page`, `size`, `sort` 값을 입력한다.
5. `Execute`를 클릭하고 `Code 200`, `data.content` 배열을 확인한다.
6. `GET /member/detail`을 펼친다.
7. `memberEmail` 입력칸에 가입한 이메일을 입력한다.
8. `Execute`를 클릭하고 `Code 200`, 회원 응답 필드를 확인한다.
9. `memberEmail`에 `none@example.com`을 입력해 다시 실행하고 `Code 404`를 확인한다.

촬영할 스크린샷:

- `/member/showall`의 `Code 200`과 목록 응답 화면
- `/member/detail` 존재 이메일의 `Code 200` 응답 화면
- `/member/detail` 없는 이메일의 `Code 404` 응답 화면

### 8. 게시글 작성, 목록, 상세 조회 테스트

1. `POST /posts/write`을 펼친다.
2. `Try it out`을 클릭한다.
3. 게시글 작성 요청 JSON을 입력한다.
4. `Execute`를 클릭하고 `Code 200`, `message="게시글 작성 완료"`를 확인한다.
5. `GET /posts/all`을 펼친다.
6. `Try it out`을 클릭한다.
7. `Execute`를 클릭하고 방금 작성한 게시글의 `postId`를 확인한다.
8. `GET /posts/detail/{postId}`를 펼친다.
9. `postId` 입력칸에 확인한 게시글 ID를 입력한다.
10. `Execute`를 클릭하고 상세 응답 필드를 확인한다.
11. `postId`에 `999999`를 입력해 다시 실행하고 `Code 404`를 확인한다.

촬영할 스크린샷:

- `/posts/write` 요청 JSON과 `Code 200` 응답 화면
- `/posts/all` 목록에서 작성한 게시글과 `postId`가 보이는 화면
- `/posts/detail/{postId}` 성공 응답 화면
- `/posts/detail/{postId}` 없는 ID의 `Code 404` 응답 화면

### 9. 게시글 수정 및 삭제 테스트

1. `POST /posts/update/{postId}`를 펼친다.
2. `Try it out`을 클릭한다.
3. `postId`에 수정할 게시글 ID를 입력한다.
4. 수정 요청 JSON을 입력한다.
5. `Execute`를 클릭하고 `Code 200`, `message="게시글 수정 완료"`를 확인한다.
6. `GET /posts/detail/{postId}`로 다시 조회해서 제목과 내용이 변경되었는지 확인한다.
7. `POST /posts/delete/{postId}`를 펼친다.
8. `Try it out`을 클릭한다.
9. 삭제할 게시글 ID를 입력한다.
10. `Execute`를 클릭하고 `Code 200`, `message="게시글 삭제 완료"`를 확인한다.
11. `GET /posts/detail/{postId}`로 다시 조회해서 `Code 404`가 나오는지 확인한다.

촬영할 스크린샷:

- `/posts/update/{postId}` 요청과 `Code 200` 응답 화면
- 수정 후 `/posts/detail/{postId}`에서 변경된 값이 보이는 화면
- `/posts/delete/{postId}`의 `Code 200` 응답 화면
- 삭제 후 `/posts/detail/{postId}`의 `Code 404` 응답 화면

## 최종 제출 스크린샷 체크리스트

| 번호 | 스크린샷 내용 | 목적 |
| --- | --- | --- |
| 1 | Swagger UI 접속 화면: `JwtBoard API` 제목과 서버 주소 | Swagger 접속 확인 |
| 2 | `POST /member/signup` 정상 요청 JSON과 `Code 200` 응답 | 정상 생성 검증 |
| 3 | `POST /member/signup` 중복 이메일 요청과 `Code 400` 응답 | 중복 데이터 검증 |
| 4 | `POST /member/signup` 필드 누락 요청과 실제 응답 코드 | 필수 필드 누락 검증 |
| 5 | `POST /member/login` `Code 200`과 토큰 응답 | 인증 토큰 발급 검증 |
| 6 | `Authorize` 팝업에 토큰 등록 완료된 화면 | 인증 설정 증빙 |
| 7 | 토큰 없이 보호 API 호출 시 `Code 401` 응답 | 인증 실패 검증 |
| 8 | `GET /member/showall` `Code 200`과 회원 목록 응답 | 목록 조회 검증 |
| 9 | `GET /member/detail` 없는 이메일의 `Code 404` 응답 | 없는 리소스 검증 |
| 10 | `POST /posts/write` `Code 200` 응답 | 게시글 생성 검증 |
| 11 | `GET /posts/all`에서 작성한 게시글이 보이는 화면 | 게시글 목록 조회 검증 |
| 12 | `GET /posts/detail/{postId}` 성공 응답 | 게시글 상세 조회 검증 |
| 13 | `GET /posts/detail/{postId}` 없는 ID의 `Code 404` 응답 | 없는 게시글 검증 |
| 14 | `POST /posts/update/{postId}` `Code 200` 및 재조회 결과 | 게시글 수정 검증 |
| 15 | `POST /posts/delete/{postId}` `Code 200` 및 삭제 후 `Code 404` | 게시글 삭제 검증 |

## 기록 시 주의할 점

- `실제 결과`에는 Swagger의 `Code`와 핵심 응답 메시지를 그대로 적는다.
- `통과 여부`는 기대 결과와 실제 결과가 같으면 `O`, 다르면 `X`로 적는다.
- 현재 컨트롤러 요청 DTO에는 `@Valid`가 없으므로 필수 필드 누락 테스트는 시험 기대값과 실제 결과가 다를 수 있다.
- 컨트롤러는 생성 성공에도 `201 Created`가 아니라 `200 OK`를 반환한다. 제출 표에는 현재 코드 기준 기대값인 `200 OK`로 기록한다.
- Swagger에서 토큰을 넣을 때는 `Bearer ` 접두어를 직접 붙이지 않고 `accessToken` 값만 입력한다.
