#ifndef SENSOR_H
#define SENSOR_H

float simulate_distance(void);

int calc_led_level(float distance);

void print_led_bar(int level);

#endif