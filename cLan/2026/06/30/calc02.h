#ifndef CACL02_H
#define CACL02_H

typedef struct 
  {
    char name[20];
    int score[3];
  } Student;

void set_score(int [], int, char [][20]);
void set_student(int [], char [][20], Student[], int length);
void print_student(Student student[], int length);

#endif