// https://codeforces.com/problemset/problem/1409/A
#include <stdio.h>

long long absolute(long long x);

int main()
{
    int testcase;
    scanf("%d", &testcase);
    for (int i = 0; i < testcase; i++)
    {
        long long move = 0;
        long long a, b, diffab;
        scanf("%lld %lld", &a, &b);
        diffab = absolute(a - b);
        move = diffab / 10;
        diffab %= 10;
        if (diffab != 0)
            move++;
        printf("%lld", move);
        if (i < testcase - 1)
            printf("\n");
    }
}

long long absolute(long long x)
{
    if (x < 0)
        return -x;
    else
        return x;
}