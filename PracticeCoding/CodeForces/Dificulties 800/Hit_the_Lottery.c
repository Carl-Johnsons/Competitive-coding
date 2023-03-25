// https://codeforces.com/problemset/problem/996/A
#include <stdio.h>

int main()
{
    int dollars, count = 0;
    scanf("%d", &dollars);
    if (dollars >= 100)
    {
        count += (dollars / 100);
        dollars %= 100;
    }
    if (dollars >= 20)
    {
        count += (dollars / 20);
        dollars %= 20;
    }
    if (dollars >= 10)
    {
        count += (dollars / 10);
        dollars %= 10;
    }
    if (dollars >= 5)
    {
        count += (dollars / 5);
        dollars %= 5;
    }
    while (dollars)
    {
        if (dollars >= 1)
        {
            dollars -= 1;
            count++;
        }
    }
    printf("%d", count);
}
