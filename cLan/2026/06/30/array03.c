#include <stdio.h>
#include "calc02.h"

int main(void){
  int score[5];
  char names[5][20] = {"원섭", "세희", "상근", "숭", "강수"};
  int score_length = sizeof(score) / sizeof(score[0]);
  
  Student student[5];
  
  set_score(score, score_length, names);
  set_student(score, names, student, score_length);
  print_student(student, score_length);
}