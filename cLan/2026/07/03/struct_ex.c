#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct 
{
    int id;
    char title[100];
    char author[100];
    int price;
    char pub_date[11];
} Book;

const char *data[][4] = {
    {"클린 코드", "로버트 마틴", "32000", "2013-03-01"},
    {"리팩터링", "마틴 파울러", "38000", "2020-05-12"},
    {"디자인 패턴", "GoF", "42000", "1994-10-21"},
    {"운영체제", "실버샤츠", "48000", "2019-02-28"},
    {"컴퓨터 네트워크", "타넨바움", "36000", "2021-07-15"},
    {"데이터베이스 시스템", "엘마스리", "52000", "2018-09-30"},
    {"인공지능 개론", "스튜어트 러셀", "44000", "2023-01-10"},
    {"자료구조와 알고리즘", "토마스 코멘", "49000", "2022-06-20"},
    {"소프트웨어 공학", "로저 프레스먼", "35000", "2016-04-05"},
    {"알고리즘 문제 해결", "구종만", "55000", "2012-11-06"},
};


void print_book(Book b) {
    printf("ID: %d\n", b.id);
    printf("제목: %s\n", b.title);
    printf("저자: %s\n", b.author);
    printf("가격: %d원\n", b.price);
    printf("출판일: %s\n", b.pub_date);
    printf("----------------------\n");
}

void search_book(Book* books, int id){
  print_book(books[id - 1]);
}

void show_all(Book* books, int count){
  for (int i = 0; i < count; i++) {
      print_book(books[i]);
  }
}

void save_book(int* next_id, Book* books){
    int num = *next_id;
    
    getchar();

    printf("제목 입력: ");
    fgets(books[num - 1].title, sizeof(books[num - 1].title), stdin);

    printf("저자 입력: ");
    fgets(books[num - 1].author, sizeof(books[num - 1].author), stdin);

    printf("가격 입력: ");
    scanf("%d", &books[num - 1].price);

    printf("출판일 입력(YYYY-MM-DD): ");
    scanf("%s", books[num - 1].pub_date);

    books[num-1].id = num;

    *next_id += 1;

    print_book(books[num - 1]);
}

void fix_book(Book* books){
    getchar();

    int num;
    printf("번호 입력: ");
    scanf("%d", &num);

    if(num > 20){
      printf("잘못된 입력입니다.");
      exit(0);
    }

    getchar();

    printf("제목 입력: ");
    fgets(books[num - 1].title, sizeof(books[num - 1].title), stdin);

    printf("저자 입력: ");
    fgets(books[num - 1].author, sizeof(books[num - 1].author), stdin);

    printf("가격 입력: ");
    scanf("%d", &books[num - 1].price);

    getchar();

    printf("출판일 입력(YYYY-MM-DD): ");
    scanf("%s", books[num - 1].pub_date);

    print_book(books[num - 1]);
}

void del_book(Book** books){
  getchar();

  int num;
  printf("번호 입력: ");
  scanf("%d", &num);

  if(num > 20){
    printf("잘못된 입력입니다.");
    exit(1);
  }

  for(int i = num - 1; i < 20 - 1; i++){
    (*books)[i] = (*books)[i + 1];
  }

  Book* tmp = realloc(*books, sizeof(Book) * 19);
  if (tmp == NULL) {
    printf("재할당 실패\n");
  } 

  *books = tmp;
}

int main(){
  // 전역 변수로 생성
  // 유일해야 함
  // 동적 할당으로 20개의 도서 정보를 저장할 공간 생성
  // 10개의 데이터는 사전에 만들어진 값 대입
  Book *books = NULL;
  int count = 20;
  int next_id = 1;
  books = malloc(sizeof(Book) * count);
  for(int i = 0; i < 10; i++){
      books[i].id = next_id;
      strcpy(books[i].title, data[i][0]);
      strcpy(books[i].author, data[i][1]);
      books[i].price = atoi(data[i][2]);
      strcpy(books[i].pub_date, data[i][3]);
      next_id++;
  }
  int search_id = 0;
  // 검색
  printf("ID를 입력해주세요: ");
  scanf("%d", &search_id);
  search_book(books, search_id);
  // 전체 조회
  show_all(books, 10);
  // 추가
  save_book(&next_id, books);
  // 수정
  fix_book(books);
  // 삭제
  del_book(&books);

  show_all(books, count);
}