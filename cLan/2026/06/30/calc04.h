#ifndef CALC04_H
#define CALC04_H
#include <string.h>
typedef struct 
{
  char name[20];
  int score[4];
  double avg;
} Student;

// 각 학생에 대한 이름 입력 받기
void set_names(char names[][20], int NUMBER);
// 각 학생에 대한 성적 입력 받기
void set_score(int score[][4], char names[][20], int NUMBER);

// 각 학생에 대한 정보 구조체 만들기
void set_student(int score[][4], char names[][20], Student student[], int NUMBER);

// 각 학생에 대한 정보 출력 하기
void print_student(Student student[], int NUMBER);

#endif