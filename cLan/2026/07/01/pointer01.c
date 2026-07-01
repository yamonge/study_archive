#include <stdio.h>

void double_value(int*);
void swap(int*, int*);

int main(void){
  int n = 100;
  int *ptr = &n;
  printf("n의 값 : %d \n", *ptr);
  printf("n의 주소 : %p \n", ptr);


  // 1. 정수 변수 num을 선언하고, 그 변수를 가리키는 포인트 p를 만드세요. 
  int num = 300;
  int* p = &num;
  // 다음에 출력하는 프로그램을 작성
  // - num의 값
  printf("%d \n", num);
  // - num의 주소
  printf("%p \n", &num);
  // - p가 가르키는 값
  printf("%d \n", *p);

  int x = 200;
  // 2. 함수 double_value(int *x)를 작성하세요. 이 함수는 포인터로 전달받은 변수의 값을 2배로 만듭니다. (반환값 없이 포인터로 원본을 직접 수정)
  double_value(&x);

  printf("x의 값 : %d \n", x);
  // 3. 포인터를 이용해 두 정수의 값을 서로 바꾸는 swap(int *a, int *b) 함수를 작성하세요.

  int a = 100;
  int b = 200;
  printf("a: %d, b: %d \n", a, b);
  swap(&a, &b);
  printf("a: %d, b: %d \n", a, b);
}

void double_value(int* x){
  *x = *x * 2;
}

void swap(int* a, int* b){
  int oa = *a;
  int ob = *b;

  *a = ob;
  *b = oa;
}