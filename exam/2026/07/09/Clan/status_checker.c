#include <stdio.h>
#include <string.h>

int errorCount = 0;

void checkStatus(char* state) {
    if (strcmp(state, "RUN") == 0) {
        printf("정상 가동중\n");
        errorCount = 0;
    } else if (strcmp(state, "STOP") == 0) {
        printf("설비 정지\n");
        errorCount = 0;
    } else if (strcmp(state, "ERROR") == 0) {
        printf("이상 발생\n");
        errorCount++;

        if (errorCount >= 3) {
            printf("긴급 점검 필요 (연속 %d회)\n", errorCount);
        }
    } else {
        printf("알 수 없는 상태값입니다\n");
        errorCount = 0;
    }
}

int main(void) {
    char state[10];

    for (int i = 0; i < 5; i++) {
        printf("설비 상태 입력(RUN/STOP/ERROR): ");
        scanf("%9s", state);

        checkStatus(state);
    }

    return 0;
}