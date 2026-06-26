#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main(void){

  char gender = 'M';

  printf("%c\n", gender);
  printf("%d\n", (int)gender);

  char num = -1;
  printf("%c %d \n", num, num);

  printf("int 형의 크기: %lu \n", sizeof(int));

  printf("주소의 크기 : %lu \n", sizeof(&num));
  printf("주소의 크기 : %lu \n", sizeof(&gender));

  enum Color { RED, GREEN, BLUE };
  enum Color color = RED;
  printf("Color: %d \n", color);

  struct Member {
    int age;
    char name[20];
    int id;
    char address[100];
    char gender;
  };

  struct Member member1;
  member1.id = 100;
  member1.age = 20;
  member1.gender = 'M';
  strcpy(member1.name, "John Doe");
  strcpy(member1.address, "123 Main St");

  printf("Member ID: %d \n", member1.id);
  printf("Member Age: %d \n", member1.age);
  printf("Member Name: %s \n", member1.name);
  printf("Member Address: %s \n", member1.address);
  printf("Member Gender: %c \n", member1.gender);

  typedef unsigned int uint;

  typedef struct {
    int x;
    int y;
  } Point;

  Point p1;
  p1.x = 10;
  p1.y = 20;

  printf("Point: (%d, %d)\n", p1.x, p1.y);

  

  return 0;
}