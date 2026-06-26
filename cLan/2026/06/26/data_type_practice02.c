#include <stdio.h>

void sum_of(int num2, int *sum1){
    for(int i = 1; i <= num2; i++){
      *sum1 += i;
    }
}

int main(void){
  
  // 1. 양수·음수·0 판별하기

  // 사용자로부터 정수 하나를 입력받아, 해당 숫자가 양수인지, 음수인지, 0인지 판별하여 출력하는 프로그램을 작성하세요.

  // 조건:

  // 변수는 int num 하나만 사용
  int num;
  printf("정수를 입력해주세요: ");
  scanf("%d", &num);
  // if - else if - else 구조 사용
  // 양수면 "양수입니다" 출력
  // 음수면 "음수입니다" 출력
  // 0이면 "0입니다" 출력
  if(num > 0){
    printf("%d 는 양수 입니다. \n", num);
  }else if(num < 0){
    printf("%d 는 음수 입니다. \n", num);
  }else{
    printf("%d 는 0 입니다. \n", num);
  }
  // 2. 1부터 N까지 합계 계산

  // 정수 N을 입력받아, 1부터 N까지의 합을 for문으로 계산하고 출력하세요.

  // 단, N이 0 이하이면 "올바른 수를 입력하세요"를 출력합니다.

  // 조건:

  // if로 N의 유효성을 먼저 검사
  // for문으로 누적 합산
  // 최종 결과를 "1부터 N까지의 합: XXX" 형식으로 출력

  int num2;
  int sum1;

  printf("정수를 입력해주세요: ");
  scanf("%d", &num2);
  if(num2 < 0 || num2 == 0){
    printf("올바른 수를 입력해주세요.");
  }else{
    sum_of(num2, &sum1);
    printf("1부터 %d 까지의 합 : %d \n", num2, sum1);
  }
  // 3. 간이 계산기 — 반복 연산

  // 두 정수와 연산자 +, -, *, /를 입력받아 결과를 출력하는 계산기를 만드세요.

  // 계산 후 "계속하겠습니까? (y/n)"를 묻고, 'y'이면 반복, 'n'이면 종료합니다.

  // 조건:

  // 연산자 분기는 switch문 사용
  // 반복은 do-while 또는 while 사용
  // 나눗셈 시 분모가 0이면 "0으로 나눌 수 없습니다" 출력
  // 정의되지 않은 연산자 입력 시 "알 수 없는 연산자" 출력
  char sign;
  int num3;
  int num4;
  double rst;
  int cycle = 1;
  char continues;
  while(cycle){
    printf("정수 2개와 연산자를 입력해주세요: ");
    scanf("%d %d %c", &num3, &num4, &sign);

    switch (sign)
    {
    case '+':
      rst = num3 + num4;
      printf("rst : %.lf \n", rst);
      break;
    case '-':
      rst = num3 - num4;
      printf("rst : %.lf \n", rst);
      break;
    case '*':
      rst = num3 * num4;
      printf("rst : %.lf \n", rst);
      break;
    case '/':
      rst = num3 / num4;
      if(num3 == 0 || num4 == 0){
        printf("0으로 나눌수 없습니다. \n");
        break;
      }
      printf("rst : %.lf \n", rst);
      break;
    default:
      printf("잘못된 입력입니다.. \n");
      break;
    }

    getchar();

    while(1){
      printf("계속하시겠습니까?(Y:N) : ");
      scanf("%c", &continues);

      if(continues == 'Y'){
        break;
      }else if(continues == 'N'){
        cycle = 0;
        break;
      }else{
        printf("잘못된 입력입니다. 다시 입력해주세요. \n");
      }
    }

    if(cycle = 0){
      break;
    }
  }
  return 0;
}