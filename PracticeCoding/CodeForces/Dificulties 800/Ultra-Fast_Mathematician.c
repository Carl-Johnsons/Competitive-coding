// https://codeforces.com/problemset/problem/61/A
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char str1[1000] = {0}, str2[1000] = {0};
    scanf("%[^\n]", str1);
    while ((getchar()) != '\n')
        ;
    scanf("%[^\n]", str2);
    while ((getchar()) != '\n')
        ;
    for (int i = 0; i < strlen(str1); i++)
    {
        printf("%d", (str1[i] - 48) ^ (str2[i] - 48));
    }
}
