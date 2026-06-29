#include <stdio.h>
#include "calc.h"

void get_score(int *kor, int *eng, int *math, int *science){
  printf("국어 점수 입력: ");
  scanf("%d", kor);

  printf("영어 점수 입력: ");
  scanf("%d", eng);

  printf("수학 점수 입력: ");
  scanf("%d", math);

  printf("과학 점수 입력: ");
  scanf("%d", science);
}

void get_avg(int kor, int eng, int math, int science, double *avg){
  *avg = (kor + eng + math + science) / 4;
}

void get_total(int kor, int eng, int math, int science, int *total){
  *total = kor + eng + math + science;
}

void get_grade(int avg, char *grade){
    if (avg >= 90) {
        *grade = 'A';
    } else if (avg >= 80) {
        *grade = 'B';
    } else if (avg >= 70) {
        *grade = 'C';
    } else if (avg >= 60) {
        *grade = 'D';
    } else {
        *grade = 'F';
    }
}

void print_rst(double avg, int total, char grade){
  printf("사용자의 결과 평균: %.1f 점 총합: %d 점 등급: %c 등급 \n", avg, total, grade);
}