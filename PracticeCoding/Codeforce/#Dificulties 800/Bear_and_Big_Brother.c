// https://codeforces.com/problemset/problem/791/A
#include <stdio.h>

int main()
{
    int years = 0, a, b;
    scanf("%d %d", &a, &b);
    while (1)
    {
        a *= 3;
        b *= 2;
        years++;
        if (a > b)
            break;
    }
    printf("%d", years);    
}