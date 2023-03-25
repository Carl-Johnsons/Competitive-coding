// https://codeforces.com/problemset/problem/50/A
#include <stdio.h>

int main()
{
    int a, b, S, n = 0;
    scanf("%d %d", &a, &b);
    S = a * b;
    while (1)
    {
        if (S <= 1)
            break;
        n++;
        S -= 2;
    }
    printf("%d", n);
}