#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "sensor.h"

int main(void)
{
    srand((unsigned int)time(NULL));

    float test_distances[] = {
        0.0f,
        9.9f,
        10.0f,
        19.9f,
        20.0f,
        29.9f,
        30.0f,
        39.9f,
        40.0f,
        49.9f
    };

    int test_count =
        (int)(sizeof(test_distances) / sizeof(test_distances[0]));

    printf("===== 거리 경계값 테스트 =====\n");

    for (int i = 0; i < test_count; i++)
    {
        float distance = test_distances[i];
        int led_level = calc_led_level(distance);

        printf(
            "distance=%5.1f cm, led_level=%d ",
            distance,
            led_level
        );

        print_led_bar(led_level);
        printf("\n");
    }

    printf("\n===== 임의 거리값 시뮬레이션 =====\n");

    for (int i = 0; i < 10; i++)
    {
        float distance = simulate_distance();
        int led_level = calc_led_level(distance);

        printf(
            "%2d회 | distance=%5.2f cm, led_level=%d ",
            i + 1,
            distance,
            led_level
        );

        print_led_bar(led_level);
        printf("\n");
    }

    return 0;
}