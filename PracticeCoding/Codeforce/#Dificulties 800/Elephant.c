// https://codeforces.com/problemset/problem/617/A
#include <stdio.h>

int digits(int x);

int main()
{
    int number, count = 0;
    scanf("%d", &number);
    if (number <= 5)
        printf("1");
    else
    {
        count = (number - (number % 5)) / 5;
        if (number % 5 != 0)
            count++;
        printf("%d", count);
    }
}

int digits(int x)
{
    int count = 0;
    while (x)
    {
        x /= 10;
        count++;
    }
    return count;
}