#include <stdio.h>

int add(int a, int b){
  return a + b;
}

int sub(int a, int b){
  return a - b;
}

int main(void){
  int (*fp)(int,int);
  
  fp = add;

  printf("결과 : %d \n", fp(100, 200));
}