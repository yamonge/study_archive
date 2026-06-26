#include <stdio.h>

int main(void){
  // ## 목적
  // - 목적에 맞는 데이터형으로 변수를 만든다.
  // - 값이 변경되지 않는 데이터형에 대한 상수로 선언 한다.
  // - 연산자, 조건문, 반복문 등을 활용하여 회원정보를 입력 받아 출력하는 예제를 학습 한다.
  // - 포함된 내용 중 배열에 대한 내용은 배열 파트에서 자세히 다룬다.

  // ## 조건

  // - 이름은 char 배열을 입력 받는다.
  // - 나이는 정수형으로 입력 받는다.
  // - 성별은 문자로 입력 받는다. 남성이면 ‘M’, ‘m’ 여성이면 ‘F’, ‘f’ char형으로 입력 받고 출력은 배열을 이용해 문자열로 출력 한다. (”남성”, “여성”)
  // - 직업을 입력 받는다. 1번이면 학생, 2번이면 회사원, 3번이면 주부, 4번 무직으로 입력 받으며, 출력은 배열을 이용해 문자열로 출력 한다.
  // - 나이는 1 ~ 199살 까지만 정상적인 입력으로 판단하고 범위를 벗어나면 다시 입력 하도록 한다.
  // - 성별은 ‘M’, ‘m’, ‘F’, ‘f’ 이외의 문자가 입력되면 다시 입력 하도록 한다.
  // - 직업은 정수로 입력받고 1 ~ 4 이외의 숫자가 입력되면 다시 입력 받는다.

  enum Gender {M = 'M', m = 'm', W = 'W', w = 'w'};
  enum Job {student = 1, company = 2, house = 3, no_job = 4};
  typedef struct 
  {
    char name[20];
    int age;
    enum Gender gender;
    enum Job job;
  } Member;

  Member member;
  int result;
  printf("이름을 입력해주세요: ");
  scanf("%s", member.name);
  while(1){
    printf("나이를 입력해주세요: ");
    scanf("%d", &member.age);

    if(member.age < 0 || member.age > 199){
      printf("잘못된 입력입니다.\n");
      continue;
    }
    break;
  }
  getchar();
  while(1){
    char genders;
    printf("성별을 입력해주세요: ");
    result = scanf("%s", &genders);
    if(result != 1){
        printf("잘못된 입력입니다. 숫자로 입력해주세요.\n");
        continue;
    }
    if(genders == 'm' || genders == 'M' || genders == 'W' || genders == 'w'){
      switch (genders)
      {
      case 'm':
        member.gender = m;
        break;
      case 'M':
        member.gender = M;
        break;
      case 'W':
        member.gender = W;
        break;
      case 'w':
        member.gender = w;
        break;
      default:
        break;
      }
      break;
    }

    printf("잘못된 입력입니다.\n");
  }
  while(1){
    int jobs;
    printf("직업을 입력해주세요: ");
    result = scanf("%d", &jobs);
    if(result != 1){
      printf("잘못된 입력입니다. 숫자로 입력해주세요.\n");

      while (getchar() != '\n') {

      }
      
      continue;
    }
    if(jobs == 1 || jobs == 2 || jobs == 3 || jobs == 4){
      switch (jobs)
      {
      case 1:
        member.job = student;
        break;
      case 2:
        member.job = company;
        break;
      case 3:
        member.job = house;
        break;                
      default:
        member.job = no_job;
        break;
      }
      break;
    }

    printf("잘못된 입력입니다. \n");
  }
  
  printf("%s %d %c %d \n", member.name, member.age, member.gender, member.job);
}