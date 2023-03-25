// https://codeforces.com/problemset/problem/546/A
#include <stdio.h>
int absolute(int x);

int main()
{
    int k, n, w, sum = 0;
    scanf("%d %d %d", &k, &n, &w);
    for (int i = 1; i <= w; i++)
    {
        sum += (k * i);
    }
    if (n - sum < 0)
        printf("%d", absolute(n - sum));
    else
        printf("0");
}
int absolute(int x)
{
    if (x < 0)
        return -x;
    else
        return x;
}