#include <stdio.h>
#include <stdlib.h>

void set_nums(int** score, int n){
  *score = malloc(sizeof(int) * n);
  if(*score == NULL){
    printf("메모리 할당 실패!!!");
    exit(0);
  }
  for(int i = 0; i < n; i++){
    printf("%d번째 성적을 입력해주세요: ", i + 1);
    scanf("%d", &(*score)[i]);
  }
}

void create_calloc(int** arr2, int n){
  *arr2 = (int*)calloc(n, sizeof(int));
  if(*arr2 == NULL){
    printf("메모리 할당 실패!!!");
    exit(0);
  }
}

int main(void){
  int n;
  int sum = 0;
  double avg = 0.0;
  printf("정수값을 입력해주세요: ");
  scanf("%d", &n);

  int* score;
  set_nums(&score, n);

  for (int i = 0; i < n; i++) {
    printf("%d번째 성적: %d\n", i + 1, score[i]);
    sum += score[i];
  }

  printf("총점: %d, 평균: %.2f \n", sum, (double)sum / n);

  int* arr2 = NULL;
  create_calloc(&arr2, n);

  for (int i = 0; i < n; i++) {
    printf("[%d] arr2: %d\n", i + 1, arr2[i]);
  }

  free(score);
  free(arr2);

  return 0;
}