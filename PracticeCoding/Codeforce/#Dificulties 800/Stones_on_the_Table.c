// https://codeforces.com/problemset/problem/266/A
#include <stdio.h>

int main()
{
    int number, j = 0, i, count = 0;
    scanf("%d", &number);
    while ((getchar()) != '\n')
        ;
    char str[number + 1];
    char temp;
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    for (i = 0; i < number; i++)
    {
        if (str[i] == str[i + 1] && i < number - 1)
        {
            count++;
        }
    }
    printf("%d", count);
}