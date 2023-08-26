// https://codeforces.com/problemset/problem/581/A
#include <stdio.h>

int absolute(int x)
{
    if (x < 0)
        return -x;
    else
        return x;
}

int main()
{
    int red, blue, min = 0, same_socks = 0;
    scanf("%d %d", &red, &blue);
    min = red;
    if (min > blue)
        min = blue;
    same_socks = absolute(red - blue) / 2;
    printf("%d %d", min, same_socks);
}