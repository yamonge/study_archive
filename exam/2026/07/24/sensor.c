#include <stdio.h>
#include <stdlib.h>
#include "sensor.h"

float simulate_distance(void)
{
    return (float)(rand() % 5000) / 100.0f;
}

int calc_led_level(float distance)
{
    if (distance < 0.0f)
    {
        return -1;
    }

    if (distance < 10.0f)
    {
        return 4;
    }
    else if (distance < 20.0f)
    {
        return 3;
    }
    else if (distance < 30.0f)
    {
        return 2;
    }
    else if (distance < 40.0f)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void print_led_bar(int level)
{
    if (level < 0 || level > 4)
    {
        printf("[잘못된 LED 단계]");
        return;
    }

    printf("[");

    for (int i = 0; i < 4; i++)
    {
        if (i < level)
        {
            printf("■");
        }
        else
        {
            printf("□");
        }
    }

    printf("]");
}