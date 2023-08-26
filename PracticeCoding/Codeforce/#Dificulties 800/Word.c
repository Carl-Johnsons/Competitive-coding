// https://codeforces.com/problemset/problem/59/A
#include <stdio.h>
#include <string.h>

int main()
{
    int count_uppercase = 0, lower = 0, lowercase = 32;
    char str[10000] = {0};
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    for (int i = 0; i < strlen(str); i++)
    {
        if (str[i] >= 'A' && str[i] <= 'Z')
            count_uppercase++;
    }
    if (strlen(str) - count_uppercase >= count_uppercase)
        lower = 32;
    else
        lower = -32;
    if (lower == -32)
        lowercase = 0;
    for (int i = 0; i < strlen(str); i++)
    {
        if (str[i] >= 'A' + (32 - lowercase) && str[i] <= 'Z' + (32 - lowercase))
            str[i] += lower;
    }
    printf("%s", str);
}