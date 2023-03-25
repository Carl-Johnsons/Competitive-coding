// https://open.kattis.com/problems/oddecho
#include <stdio.h>

int main()
{
    int number;
    scanf("%d", &number);
    while ((getchar()) != '\n')
        ;
    char str[number][100];
    for (int i = 0; i < number; i++)
    {
        scanf("%s", str[i]);
        while ((getchar()) != '\n')
            ;
    }
    for (int i = 0; i < number; i++)
    {
        if (i % 2 == 0)
            printf("%s", str[i]);
        if (i < number - 1)
            printf("\n");
    }
}