#include <stdio.h>

int main(void){
  int age;

  printf("나이를 입력하세요: ");
  scanf("%d", &age);

  if(age >= 20){
    printf("성인입니다.\n");
  }else{
    printf("미성년자 입니다.\n");
  }

  return 0;
}