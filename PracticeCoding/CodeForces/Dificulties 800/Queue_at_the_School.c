// https://codeforces.com/problemset/problem/266/B
#include <stdio.h>

int main()
{
    int queue, time;
    scanf("%d %d", &queue, &time);
    while ((getchar()) != '\n')
        ;
    char str[queue];
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    for (int i = 0; i < time; i++)
    {
        for (int j = 0; j < queue; j++)
        {
            if (str[j] == 'B' && str[j + 1] == 'G' && j < queue - 1)
            {
                str[j] = 'G';
                str[j + 1] = 'B';
                j++;
            }
        }
    }
    printf("%s", str);
}