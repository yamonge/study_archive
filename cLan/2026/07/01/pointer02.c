#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void){
  int arr1[3] = {10, 20 , 30};
  int arr2[3] = {100, 200, 300};
  int arr3[4] = {1000, 2000, 3000};
  int* ptr;

  // arr1의 배열 값 출력
  printf("arr1 배열: %d %d %d\n", arr1[0], arr1[1], arr1[2]);
  // ptr에 arr2의 주소를 대입해 배열의 값을 출력하는데 배열의 인덱스 사용
  ptr = arr2;
  printf("arr2 배열: %d %d %d\n", ptr[0], ptr[1], ptr[2]);
  // ptr에 arr3의 주소를 대입해 배열의 값을 출력하는 포인터 사용.
  ptr = arr3;
  printf("arr3 배열 : %d %d %d\n", *ptr, *(ptr + 1), *(ptr + 2));

  int* pptr[3];

  pptr[0] = arr1;
  pptr[1] = arr2;
  pptr[2] = arr3;

  printf("%p %p %p \n", pptr[0], pptr[1], pptr[2]);
  for(int i = 0; i < 3; i++){
    for(int j = 0; j < 3; j++){
      printf("%d ", pptr[i][j]);
    }
    printf("\n");
  }

  int arr4[3][2] = {{1,2}, {3,4}, {5,6}};
  int (*pptr2)[2] = arr4;

  for(int i = 0; i < 3; i++){
    for(int j = 0; j < 2; j++){
      printf("%d ", pptr2[i][j]);
    }
    printf("\n");
  }

  char* city[5] = {"서울", "부산", "인천", "대구", "광주"}; 

  printf("%s %s %s %s %s \n", city[0], city[1], city[2], city[3], city[4]);

  int arr5[2][5] = {{1,2,3,4,5}, {1,2,3,4,5}};
  int (*numbers)[5] = arr5; 
  printf("%d %d \n", numbers[0][1], numbers[1][1]);

  // 5개의 도시 이름 입력 및 출력
  char* city2[5];
  char temp[100];
  for(int i = 0; i < 5; i++){
    printf("도시 이름 입력: ");
    scanf("%s", temp);

    city2[i] = malloc(strlen(temp) + 1);
    strcpy(city2[i], temp);
  }

  for(int i = 0; i < sizeof(city2) / sizeof(city2[0]); i++){
    printf("%s ", city2[i]);
  }

  printf("\n");
}