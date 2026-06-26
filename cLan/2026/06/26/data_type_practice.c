#include <stdio.h>
#include <string.h>

int main(void){
  // 1. 다양한 데이터형 변수 선언 및 출력

  // 아래 요구사항에 맞게 변수를 선언하고, 각 변수의 값과 메모리 크기를 출력하는 프로그램을 작성하세요.

  // - int형 변수에 자신의 나이를 저장하고 출력
  int age = 20;
  printf("%d\n", age);
  // - double형 변수에 원주율(3.14159265)을 저장하고 소수 5자리까지 출력
  const double PI = 3.14159265;
  printf("%.5f\n", PI);
  // - char형 변수에 자신의 이름 첫 글자를 저장하고, 문자와 해당 ASCII 코드를 함께 출력
  char name = 'P';
  printf("%c %d \n", name, name);
  // - sizeof를 사용해 세 변수의 메모리 크기를 각각 출력
  printf("int : %lu \n", sizeof(age));
  printf("double : %lu \n", sizeof(PI));
  printf("name : %lu \n", sizeof(name));


  //   2. 정수형 오버플로와 2의 보수 탐구

  // - 정수형 데이터형의 표현 범위와 음수의 내부 표현 방식을 직접 확인하는 프로그램을 작성하세요.
  // - unsigned char 변수에 255를 저장한 후, 1을 더했을 때 어떤 값이 되는지 출력 (오버플로 관찰)
  // unsigned char type1 = 255;
  // printf("%c %d \n", type1, type1);
  // printf("%c %d \n", type1 + 1, type1 + 1);

  unsigned char type1 = 255;

  printf("더하기 전: %d\n", type1);

  type1 = type1 + 1;

  printf("더하기 후: %d\n", type1);


  // - signed char 변수에 127을 저장한 후, 1을 더했을 때 어떤 값이 되는지 출력
  signed char type2 = 127;
  printf("더하기 전 : %c %d \n", type2, type2);
  type2++;
  printf("더하기 후 : %c %d \n", type2, type2);
  // - int형 변수에 -1을 저장하고 %X 서식으로 16진수 출력 (2의 보수 확인)
  int val = -1;
  printf("%X\n", val);

  // - 위 세 가지 결과가 왜 그렇게 나오는지 주석으로 설명을 달아보세요.

  //   3. 구조체와 열거형을 활용한 학생 성적 관리

  // - 구조체, 열거형, typedef를 모두 활용하여 학생 2명의 정보를 저장하고 출력하는 프로그램을 작성하세요.
  
  // - enum Grade로 학점을 정의 (A=4, B=3, C=2, D=1, F=0)
  enum Grade {A = 4, B = 3, C = 2, D = 1, F = 0};
  printf("%d %d %d %d %d \n", A, B, C, D, F);
  
  // - typedef로 unsigned int를 uint로, struct Student를 Student로 별칭 정의
  typedef unsigned int uint;

  typedef struct
  {
    int age;
    char gender;
  } Student;

  Student student;
  student.age = 100;
  student.gender = 'M';
  
  printf("%d %c \n", student.age, student.gender);
  
  // - 구조체에 이름(char[20]), 학번(uint), 평점(double), 학점(enum Grade) 포함
  // - 두 학생 중 평점이 더 높은 학생의 이름과 학점을 출력

  typedef struct{
    char name[20];
    uint studentId;
    double avg;
    enum Grade grade;
  } Students;
  
  Students students01;
  strcpy(students01.name, "홍길동");
  students01.studentId = 50;
  students01.avg = 50.11;
  students01.grade = A;

  Students students02;
  strcpy(students02.name, "홍길동2");
  students02.studentId = 51;
  students02.avg = 50.22;
  students02.grade = A;

  if(students01.avg > students02.avg){
    printf("평점이 더 높은 학생의 이름은 : %s 입나다. \n", students01.name);
  }else{
    printf("평점이 더 높은 학생의 이름은 : %s 입니다. \n", students02.name);
  }

  return 0;
}