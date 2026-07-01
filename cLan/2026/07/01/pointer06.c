#include <stdio.h>
#include <stdlib.h>

void my_strlen(char*, int*);
void set_to_b(int**, int*);
void alloc_array(int**, int);
int** create_matrix(int, int);

int main(void){
  // int num = 50;
  // int* p = &num;
  // printf("%d %p %d \n", num, &num, *p);
  // char word[5] = "Hello";
  // int length = 0;
  // my_strlen(word, &length);
  // int a = 10, b = 20;
  // int *ptr = &a;

  // printf("변경 전: %d\n", *ptr); // 10
  // set_to_b(&ptr, &b);
  // printf("변경 후: %d\n", *ptr); // 20
  // int *arr = NULL;
  // alloc_array(&arr, 5);

  // for (int i = 0; i < 5; i++) {
  //     printf("%d ", arr[i]); // 1 2 3 4 5
  // }
  // printf("\n");

  int **m = create_matrix(3, 4);

  for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
          printf("%3d", m[i][j]);
      }
      printf("\n");
  }
}

int** create_matrix(int a, int b){
  int matrix[a][b];
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
          matrix[i][j] = i * (j + 1) ;
      }
  }

  return &matrix;
}

void alloc_array(int** arr, int size){
  *arr = malloc(sizeof(int) * size);
  for(int i = 0; i < size; i++){
    (*arr)[i] = i + 1;
  }
}

void set_to_b(int** ptr, int* b){
  *ptr = b;
}

void my_strlen(char* word, int* length){
  int count = 0;
  while(word[count] != '\0'){
    count++;
  }
  *length = count;
  printf("count: %d \n", count);
}