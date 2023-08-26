// https://codeforces.com/problemset/problem/116/A
#include <stdio.h>

int main()
{
    int testcase, max = 0, sum = 0;
    scanf("%d", &testcase);
    int a[testcase], b[testcase];
    for (int i = 0; i < testcase; i++)
    {
        scanf("%d %d", &a[i], &b[i]);
    }
    for (int i = 0; i < testcase; i++)
    {
        sum += (b[i] - a[i]);
        if (max < sum)
            max = sum;
    }
    printf("%d", max);
}