// https://codeforces.com/problemset/problem/282/A
#include <stdio.h>

int main()
{
    int number, count;
    scanf("%d", &number);
    while ((getchar()) != '\n')
        ;
    char str[number][3];
    for (int i = 0; i < number; i++)
    {
        scanf("%[^\n]", str[i]);
        while ((getchar()) != '\n')
            ;
    }
    for (int i = 0; i < number; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (str[i][j] == '+')
            {
                count++;
                break;
            }
            else if (str[i][j] == '-')
            {
                count--;
                break;
            }
        }
    }
    printf("%d", count);
}