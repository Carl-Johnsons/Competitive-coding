// https://codeforces.com/problemset/problem/151/A
#include <stdio.h>

int min(int a, int b, int c);

int main()
{
    int n, k, l, c, d, p, nl, np, overall_ml, limes, salt;
    scanf("%d %d %d %d %d %d %d %d", &n, &k, &l, &c, &d, &p, &nl, &np);
    overall_ml = (k * l) / nl;
    limes = c * d;
    salt = p / np;
    printf("%d", (min(overall_ml, limes, salt) / n));
}

int min(int a, int b, int c)
{
    int min = a;
    if (min > b)
        min = b;
    if (min > c)
        min = c;
    return min;
}