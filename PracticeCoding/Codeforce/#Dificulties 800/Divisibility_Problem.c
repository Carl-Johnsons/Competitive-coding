// https://codeforces.com/problemset/problem/1328/A
#include <stdio.h>

int main()
{
    int testcase, b;
    scanf("%d", &testcase);
    for (int i = 0; i < testcase; i++)
    {
        int m, n;
        scanf("%d %d", &m, &n);
        if (m >= n)
        {
            b = (((m / n) + 1) * n - m);
            if (b != n)
                printf("%d", b);
            else
                printf("%d", m % n);
        }
        else
            printf("%d", n - m);
        if (i < testcase - 1)
            printf("\n");
    }
}