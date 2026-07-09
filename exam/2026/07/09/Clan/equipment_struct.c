#include <stdio.h>
#include <string.h>

typedef struct {
    char id[10];
    char state[10];
    int errorCount;
} Equipment;

void checkStatus(Equipment* eq) {
    if (strcmp(eq->state, "RUN") == 0) {
        printf("[%s] 정상 가동중\n", eq->id);
        eq->errorCount = 0;
    } else if (strcmp(eq->state, "STOP") == 0) {
        printf("[%s] 설비 정지\n", eq->id);
        eq->errorCount = 0;
    } else if (strcmp(eq->state, "ERROR") == 0) {
        printf("[%s] 이상 발생\n", eq->id);
        eq->errorCount++;

        if (eq->errorCount >= 3) {
            printf("[%s] 긴급 점검 필요 (연속 %d회)\n", eq->id, eq->errorCount);
        }
    } else {
        printf("[%s] 알 수 없는 상태값입니다\n", eq->id);
        eq->errorCount = 0;
    }
}

int main(void) {
    Equipment eq = {"EQ-01", "", 0};

    for (int i = 0; i < 5; i++) {
        printf("설비 상태 입력(RUN/STOP/ERROR): ");
        scanf("%9s", eq.state);

        checkStatus(&eq);
    }

    return 0;
}