#include <stdio.h>
#include "calc02.h"
#include <string.h>

void set_score(int score[], int length, char names[][20]){
  for(int i = 0; i < length; i++){
    printf("%s의 점수를 입력해주세요: ", names[i]);
    scanf("%d", &score[i]);
  }
}

void set_student(int score[], char names[][20], Student student[], int length){
  for(int i = 0; i < length; i++){
    strcpy(student[i].name, names[i]);
    student[i].score = score[i];
  }
}

void print_student(Student student[], int length){
  for(int i = 0; i < length; i++){
    printf("%s 학생의 점수는 : %d 점 입니다. \n", student[i].name, student[i].score);
    if(student[i].score < 40){
      printf("%s 학생은 보충 수업 대상입니다. \n", student[i].name);
      student[i].score = 40;
    }
  }
}