// https://codeforces.com/problemset/problem/750/A
#include <stdio.h>

int time_to_solve(int x);

int main()
{
    int n, k, time, deadline = 60 * 4;
    scanf("%d %d", &n, &k);
    while (n)
    {
        if (time_to_solve(n) > deadline - k)
            n--;
        else
            break;
    }
    printf("%d", n);
}

int time_to_solve(int x)
{
    if (x == 1)
        return 5;
    else
        return time_to_solve(x - 1) + 5 * x;
}