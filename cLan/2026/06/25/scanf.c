#include <stdio.h>

int main(void){
  int age;
  int age2;

  printf("나이를 입력하세요: ");
  scanf("%d %d", &age, &age2);

  printf("입력한 나이: %d\n", age);
  printf("입력한 나이: %d\n", age2);
  
  return 0;
}