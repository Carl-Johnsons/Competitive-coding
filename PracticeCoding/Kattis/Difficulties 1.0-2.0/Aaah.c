// https://open.kattis.com/problems/aaah
#include <stdio.h>
#include <string.h>
// scanf("%[^\n]") thi kattis dell nhan? su dung fgets thi okay :)
int main()
{
    char Jon[10000] = {0};
    char Doctor[10000] = {0};
    fgets(Jon, sizeof(Jon), stdin);
    fflush(stdin);
    fgets(Doctor, sizeof(Doctor), stdin);
    fflush(stdin);
    if (strcmp(Jon, Doctor) <= 0)
        printf("go");
    else
        printf("no");
}