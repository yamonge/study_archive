#include <stdio.h>

int main(void){
  int a = 100;
  double b = 3.14;
  char c = 'M';
  void* ptr;

  ptr = &a;
  *(int*)ptr = 200;
  printf("%d\n", *(int*)ptr);

  ptr = &b;
  *(double*)ptr = 200.2;
  printf("%.1f\n", *(double*)ptr);
  
  ptr = &c;
  *(char*)ptr = 'B';
  printf("%c\n", *(char*)ptr);

}