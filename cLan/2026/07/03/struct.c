#include <stdio.h>
#include <stdlib.h>

typedef struct 
{
  char name[20];
  int age;
  int birth;
  double weight;
  double height;
  int score_count;
  int* score;
} Member;

void print_member_json(Member m) {
    printf("{\n");
    printf("  \"name\": \"%s\",\n", m.name);
    printf("  \"age\": %d,\n", m.age);
    printf("  \"birth\": %d,\n", m.birth);
    printf("  \"weight\": %.1f,\n", m.weight);
    printf("  \"height\": %.1f\n", m.height);
    for(int i = 0; i < m.score_count; i++){
      printf("\"[%d] score\": %d\n", i+1, m.score[i]);
    }
    printf("}\n");
}


int main(void) {
    Member m;

    for (int i = 0; i < 6; i++) {
        printf("[%d] : ", i + 1);

        if (i == 0) {
            printf("이름 입력: ");
            scanf("%s", m.name);
        }
        else if (i == 1) {
            printf("나이 입력: ");
            scanf("%d", &m.age);
        }
        else if (i == 2) {
            printf("생년 입력: ");
            scanf("%d", &m.birth);
        }
        else if (i == 3) {
            printf("몸무게 입력: ");
            scanf("%lf", &m.weight);
        }
        else if (i == 4) {
            printf("키 입력: ");
            scanf("%lf", &m.height);
        }
        else if (i == 5) {
            printf("점수 개수 입력: ");
            scanf("%d", &m.score_count);
            m.score = malloc(sizeof(int) * m.score_count);
        }
    }

    if(m.score_count <= 0){
      printf("점수 개수가 존재하지 않습니다.");
    }else{
      for(int i = 0; i < m.score_count; i++){
        printf("[%d] 성적: ", i+1);
        scanf("%d", &m.score[i]);
      }
    }

    print_member_json(m);

    return 0;
}