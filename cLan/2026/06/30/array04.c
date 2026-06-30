#include <stdio.h>
#include <string.h> // memcpy를 위해서
#include "calc04.h"
#define NUMBER 5
int main(void){
  int score[NUMBER][4]; // 국어, 영어, 수학, 총점
  char names[NUMBER][20];
  double avg[NUMBER]; // 평균
  Student student[NUMBER];
  // 각 학생에 대한 이름 입력 받기
  set_names(names, NUMBER);
  // 각 학생에 대한 성적 입력 받기
  set_score(score, names, NUMBER);
  
  // 각 학생에 대한 정보 구조체 만들기
  set_student(score, names, student, NUMBER);

  // 각 학생에 대한 정보 출력 하기
  print_student(student, NUMBER);
}