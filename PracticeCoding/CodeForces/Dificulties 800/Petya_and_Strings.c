// https://codeforces.com/problemset/problem/112/A
#include <stdio.h>
#include <string.h>

int main()
{
    char str1[1000] = {0};
    char str2[1000] = {0};
    scanf("%[^\n]", str1);
    while ((getchar()) != '\n')
        ;
    scanf("%[^\n]", str2);
    while ((getchar()) != '\n')
        ;
    for (int i = 0; i < strlen(str1); i++)
    {
        int j = 0;
        if (str1[i] >= 'A' && str1[i] <= 'Z')
            str1[i] += 32;
        if (str2[i] >= 'A' && str2[i] <= 'Z')
            str2[i] += 32;
        j++;
    }
    printf("%d", strcmp(str1, str2));
}