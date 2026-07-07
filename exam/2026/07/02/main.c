#include <stdio.h>
#include <string.h>

#define MAX_MEMBERS 10
int memberCount = 0;

typedef struct {
    int id;
    char name[30];
    int age;
    char email[50];
} Member;

Member members[MAX_MEMBERS];

void addMember(int id, const char *name, int age, const char *email) {
    if (memberCount >= MAX_MEMBERS) {
        printf("회원이 가득 찼습니다.\n");
        return;
    }

    members[memberCount].id = id;
    strcpy(members[memberCount].name, name);
    members[memberCount].age = age;
    strcpy(members[memberCount].email, email);

    memberCount++;
}

int findMemberByName(const char *name) {
    for (int i = 0; i < memberCount; i++) {
        if (strcmp(members[i].name, name) == 0) {
            return i;
        }
    }

    return -1;
}

void printAllMembers(void) {
    printf("[\n");

    for (int i = 0; i < memberCount; i++) {
        printf("  {\"id\":%d, \"name\":\"%s\", \"age\":%d, \"email\":\"%s\"}",
               members[i].id,
               members[i].name,
               members[i].age,
               members[i].email);

        if (i < memberCount - 1) {
            printf(",");
        }

        printf("\n");
    }

    printf("]\n");
}

int main(void) {
    addMember(1, "홍길동", 25, "hong@test.com");
    addMember(2, "김철수", 30, "kim@test.com");
    addMember(3, "이영희", 28, "lee@test.com");

    int idx = findMemberByName("김철수");

    if (idx != -1) {
        printf("검색 성공: %s\n", members[idx].name);
    } else {
        printf("해당 회원을 찾을 수 없습니다.\n");
    }

    printAllMembers();

    return 0;
}