// https://open.kattis.com/problems/bela
#include <stdio.h>

int main()
{
    int number, sum = 0;
    char B;
    scanf("%d %c", &number, &B);
    while ((getchar() != '\n'))
        ;
    char str[number * 4], suit[number * 4];
    for (int i = 0; i < number * 4; i++)
    {
        scanf("%c%c", &str[i], &suit[i]);
        while ((getchar() != '\n'))
            ;
    }
    for (int i = 0; i < number * 4; i++)
    {
        if (str[i] == 'A')
            sum += 11;
        else if (str[i] == 'K')
            sum += 4;
        else if (str[i] == 'Q')
            sum += 3;
        else if (str[i] == 'J')
        {
            if (suit[i] == B)
                sum += 20;
            else
                sum += 2;
        }
        else if (str[i] == 'T')
            sum += 10;
        else if (str[i] == '9')
        {
            if (B == suit[i])
                sum += 14;
        }
    }
    printf("%d", sum);
}