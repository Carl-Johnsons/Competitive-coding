// https://open.kattis.com/problems/timeloop
#include <stdio.h>

int main()
{
    int number;
    scanf("%d", &number);
    fflush(stdin);
    char str[20] = "Abracadabra";
    for (int i = 1; i <= number; i++)
    {
        printf("%d %s", i, str);
        if (i <= number - 1)
        {
            printf("\n");
        }
    }
}