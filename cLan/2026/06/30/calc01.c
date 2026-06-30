#include <stdio.h>
#include "calc01.h"

void set_sum(int arr[], int length, int *total, double *avg){
  *total = 0;
  *total = 0.0;

  for(int i = 0; i < length; i++){
    *total += arr[i];
  }

  *avg = (double)*total / length;
}

void set_max_min(int arr[],  int length, int *max, int *min){
  *max = arr[0];
  *min = arr[0];

  for(int i = 0; i < length; i++){
    if (arr[i] > *max) {
        *max = arr[i];
    }

    if (arr[i] < *min) {
        *min = arr[i];
    }
  }
}

void set_arr(int arr[], int length){
  for(int i=0; i < length; i++){
    printf("%d 번째 정수를 입력해주세요: ", i + 1);
    scanf("%d", &arr[i]);
  }
}

void set_cnt(int arr[], int length, int *even_cnt, int *odd_cnt){
  *even_cnt = 0;
  *odd_cnt = 0;
  for(int i=0; i < length; i++){
    if(arr[i] % 2 == 0){
      (*even_cnt)++;
    }else{
      (*odd_cnt)++;
    }
  }
}

void set_eo_arr(int arr[], int length, int even_arr[], int odd_arr[]){
  int even_index = 0;
  int odd_index = 0;
  for(int i = 0; i < length; i++){
    if(arr[i] % 2 == 0){
      even_arr[even_index] = arr[i];
      even_index++;
    }else{
      odd_arr[odd_index] = arr[i];
      odd_index++;
    }
  }
}

void print_arr(int arr[], int arr_length, int even_arr[], int even_cnt, int odd_arr[], int odd_cnt){
  printf("입력 배열 : ");
  for(int i = 0; i < arr_length; i++){
    printf("%d ", arr[i]);
  }
  printf("\n");
  printf("짝수 배열 : ");
  for(int i = 0; i < even_cnt; i++){
    printf("%d ", even_arr[i]);
  }
  printf("\n");
  printf("짝수 배열 : ");
  for(int i = 0; i < odd_cnt; i++){
    printf("%d ", odd_arr[i]);
  }
  printf("\n");
}