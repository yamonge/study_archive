# 미니 MES 설비 상태 알림 프로그램

## 프로젝트 설명
이 프로젝트는 설비 상태값(RUN, STOP, ERROR)을 이용해 C 프로그램, Spring Boot API, React 화면을 연결하는 미니 MES 예제입니다.

## 구성

### 1. C 프로그램
- 설비 상태값을 입력받는다.
- RUN이면 "정상 가동중"을 출력한다.
- STOP이면 "설비 정지"를 출력한다.
- ERROR이면 "이상 발생"을 출력한다.
- ERROR가 연속 3번 발생하면 "긴급 점검 필요"를 출력한다.

### 2. Spring Boot 서버
- POST /api/equipment/status API로 설비 상태 데이터를 받는다.
- 받은 데이터는 리스트에 저장한다.
- GET /api/equipment/status API로 저장된 설비 상태 목록을 조회한다.

### 3. React 화면
- Spring Boot의 GET API를 호출한다.
- 설비 ID, 상태, 메시지를 표 형태로 출력한다.

## 사용한 기술
- C
- Spring Boot
- React
- REST API