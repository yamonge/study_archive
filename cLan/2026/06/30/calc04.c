#include <stdio.h>
#include "calc04.h"

// 각 학생에 대한 이름 입력 받기
void set_names(char names[][20], int NUMBER){
  for(int i =0; i < NUMBER; i++){
    printf("%d 번 학생 이름을 입력해주세요: ", i + 1);
    scanf("%s", names[i]);
  }
}
// 각 학생에 대한 성적 입력 받기
void set_score(int score[][4], char names[][20], int NUMBER){
  for(int i =0; i < NUMBER; i++){
    for(int j = 0; j < 3; j++){
      printf("%s 학생의 %d 번 성적 : ", names[i], j + 1);
      scanf("%d", &score[i][j]);
    }
    score[i][3] = 0;
  }
}

// 각 학생에 대한 정보 구조체 만들기
void set_student(int score[][4], char names[][20], Student student[], int NUMBER){
  for(int i =0; i < NUMBER; i++){
    strcpy(student[i].name, names[i]);
    student[i].score[3] = 0;
    student[i].avg = 0;
    for(int j = 0; j < 3; j++){
      student[i].score[j] = score[i][j];
      student[i].score[3] += score[i][j];
    }
    student[i].avg = student[i].score[3] / 3;
  }
}

// 각 학생에 대한 정보 출력 하기
void print_student(Student student[], int NUMBER){
  for(int i =0; i < NUMBER; i++){
    printf("=========%s 학생 성적========= \n", student[i].name);
    for(int j = 0; j < 3; j++){
      printf("%s 학생의 %d 번 점수 : %d \n", student[i].name, j + 1, student[i].score[j]);
    }
    printf("%s 학생의 총점 : %d \n", student[i].name, student[i].score[3]);
    printf("%s 학생의 평균 : %.2f \n", student[i].name, student[i].avg);
  }
}