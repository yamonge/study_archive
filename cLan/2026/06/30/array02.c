#include <stdio.h>
#include "calc01.h"

int main(void){
  // 7개의 정수를 입력 받는 배열을 생성하고 키보드로 정수값을 입력 받음
  int arr[7];
  set_arr(arr, sizeof(arr) / sizeof(arr[0]));
  // 입력 받은 배열의 값을 홀수 배열과 짝수 배열을 만들어 나누어 담기
  int even_cnt;
  int odd_cnt;
  set_cnt(arr, sizeof(arr) / sizeof(arr[0]), &even_cnt, &odd_cnt);

  int even_arr[even_cnt];
  int odd_arr[odd_cnt];

  set_eo_arr(arr, sizeof(arr) / sizeof(arr[0]), even_arr, odd_arr);
  // 홀수 배열과 짝수 배열의 값 출력 하기
  // 입력배열 : 1 2 3 4 5 6 7
  // 홀수배열 : 1 3 5 7
  // 짝수배열 : 2 4 6
  print_arr(arr, sizeof(arr) / sizeof(arr[0]), even_arr, even_cnt,  odd_arr, odd_cnt);
  // main 함수에서 배열을 선언하고 입력 함수, 홀수와 짝수 나누어 담는 함수, 출력 함수 작성
}