// https://codeforces.com/problemset/problem/1335/A
#include <stdio.h>

int main()
{
    long long testcase;
    scanf("%lld", &testcase);
    long long arr[testcase];
    for (long long i = 0; i < testcase; i++)
    {
        scanf("%lld", &arr[i]);
    }
    for (long long i = 0; i < testcase; i++)
    {
        if (arr[i] > 2)
            printf("%lld", (arr[i] - 1) / 2);
        else
            printf("0");
        if (i < testcase - 1)
            printf("\n");
    }
}