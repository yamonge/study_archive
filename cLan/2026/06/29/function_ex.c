#include <stdio.h>
#include "calc.h"

int main(void){

  int kor, eng, math, science, total;
  double avg;
  char grade;
  // 국어, 영어, 수학, 과학 성적을 입력 받는 함수 생성
  get_score(&kor, &eng, &math, &science);
  // 평균을 구하는 함수 생성
  get_avg(kor, eng, math, science, &avg);
  // 총점을 구하는 함수 생성
  get_total(kor, eng, math, science, &total);
  // 등급을 구하는 함수 생성 (90점 이상 A, 80점 이상 B, 70이상 이면 C, 60이상이면 D, 나머지는 F)
  get_grade(avg, &grade);
  // 결과를 출력 하는 함수 생성
  print_rst(avg, total, grade);
  // 선언부는 헤더파일로 관리

  // 1. 평균, 총점, 등급은 반환값으로 메인에 전달하고 이를 매개변수로 전달 해 출력 하기
  // 2. Call by Reference 방식으로 변경하고 이를 매개변수로 전달해 출력 하기
}
