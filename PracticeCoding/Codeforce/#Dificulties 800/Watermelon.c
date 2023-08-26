// https://codeforces.com/problemset/problem/4/A
#include <stdio.h>

int main()
{
    int w;  
    scanf("%d", &w);
    if (w % 2 == 0)
    {
        if (w > 2)
            printf("YES");
        else
            printf("NO");
    }
    else
        printf("NO");
}