// https://codeforces.com/problemset/problem/705/A
#include <stdio.h>
#include <string.h>

int main()
{
    int n;
    scanf("%d", &n);
    char str1[] = "I hate ";
    char str2[] = "I love ";
    char str3[] = "it";
    char str4[] = "that";
    for (int i = 1; i <= n; i++)
    {
        if (i % 2 == 1)
            printf("%s", str1);
        else
            printf("%s", str2);
        if (i <= n - 1)
            printf("%s", str4);
        else
            printf("%s", str3);
        if (i <= n - 1)
            printf(" ");
    }
}
