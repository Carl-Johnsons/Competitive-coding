// https://codeforces.com/problemset/problem/977/A
#include <stdio.h>

int main()
{
    int number, time;
    scanf("%d %d", &number, &time);
    for (int i = 0; i < time; i++)
    {
        if (number % 10 == 0)
            number /= 10;
        else
            number -= 1;
    }
    printf("%d", number);
}