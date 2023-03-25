// https://codeforces.com/problemset/problem/281/A
#include <stdio.h>

int main()
{
    char str[10000];
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    if (str[0] >= 'a' && str[0] <= 'z')
        str[0] -= 32;
    printf("%s", str);
}