#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

static int led1_on = 0;
static int led2_on = 0;

static const char* get_led_text(int state) {
    return state ? "ON" : "OFF";
}

int main(void) {
    char line[64];

    // 프로그램 시작 시 한 번만 난수 초기화
    srand((unsigned int)time(NULL));

    // Spring Boot가 명령을 보낼 때까지 계속 기다림
    while (fgets(line, sizeof(line), stdin) != NULL) {

        // fgets가 입력받은 줄바꿈 문자 제거
        line[strcspn(line, "\r\n")] = '\0';

        if (strcmp(line, "SENSOR") == 0) {
            int sensor_value = rand() % 256;

            printf("SENSOR_VALUE=%d\n", sensor_value);
        }
        else if (strcmp(line, "BTN1") == 0) {
            led1_on = !led1_on;

            printf("LED1=%s\n", get_led_text(led1_on));
        }
        else if (strcmp(line, "BTN2") == 0) {
            led2_on = !led2_on;

            printf("LED2=%s\n", get_led_text(led2_on));
        }
        else if (strcmp(line, "POWER") == 0) {

            // 둘 다 켜져 있으면 둘 다 끔
            if (led1_on && led2_on) {
                led1_on = 0;
                led2_on = 0;
            }
            // 하나라도 꺼져 있으면 둘 다 켬
            else {
                led1_on = 1;
                led2_on = 1;
            }

            // Java가 한 번에 읽을 수 있도록 한 줄로 출력
            printf(
                "LED1=%s;LED2=%s\n",
                get_led_text(led1_on),
                get_led_text(led2_on)
            );
        }
        else {
            printf("ERROR=UNKNOWN_COMMAND\n");
        }

        // 출력 버퍼에 보관하지 않고 즉시 Spring Boot로 전달
        fflush(stdout);
    }

    return 0;
}