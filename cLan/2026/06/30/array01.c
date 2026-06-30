#include <stdio.h>
#include "calc01.h"

int main(void){
  int arr[3] = {100, 99, 88};
  int total, min, max;
  double avg;
  //  배열의 총점과 편균 구하기
  set_sum(arr, sizeof(arr) / sizeof(arr[0]), &total, &avg);
  // 최소 점수와 최대 점수 구하기
  set_max_min(arr, sizeof(arr) / sizeof(arr[0]), &max, &min);

  printf("총점: %d, 평균: %.2f, 최대값: %d, 최소값: %d \n", total, avg, max, min);
}