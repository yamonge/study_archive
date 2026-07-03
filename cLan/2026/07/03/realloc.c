#include <stdio.h>
#include <stdlib.h>

int main(){
  // 크기  5 짜리 정수 배열을 malloc으로 생성
  int* arr = NULL;
  int size = 5;
  int old_size = 0;
  arr = malloc(sizeof(int) * size);
  // 할당 실패에 대한 처리
  if(arr == NULL){
    printf("메모리 할당 실패!! \n");
    exit(1);
  }
  // 반복문으로 임의의 값 채우기
  for(int i = 0; i < size; i++){
    printf("[%d] arr : ", i + 1);
    scanf("%d", &arr[i]);
  }
  // realloc을 사용해 크기를 10으로 조정
  int* temp = realloc(arr, sizeof(int) * (size + 5));
  // 할당 실패에 대한 처리
  if(temp == NULL){
    printf("메모리 재할당 실패!!! \n");
    free(arr);
    exit(1);
  }

  old_size = size;
  size = size + 5;

  arr = temp;
  // 새로 생긴 공간에 임의의 값 채우기
  for(int i = old_size; i < size; i++){
    printf("[%d] arr : ", i + 1);
    scanf("%d", &arr[i]);
  }
  // 배열의 값을 오름 차순 정렬 (버블 정렬)
  for (int i = 0; i < size - 1; i++) {
      for (int j = 0; j < size - 1 - i; j++) {
          if (arr[j] > arr[j + 1]) {
              int temp = arr[j];
              arr[j] = arr[j + 1];
              arr[j + 1] = temp;
          }
      }
  }

  // 출력

  for(int i = 0; i < size; i ++){
    printf("%d, ", arr[i]);
  }

  printf("\n");

  // 메모리 해제
  free(arr);
}