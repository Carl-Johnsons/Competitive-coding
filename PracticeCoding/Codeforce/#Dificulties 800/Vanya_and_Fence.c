// https://codeforces.com/problemset/problem/677/A
#include <stdio.h>

int main()
{
    int n, h, width = 0;
    scanf("%d %d", &n, &h);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < n; i++)
    {
        if (arr[i] <= h)
            width += 1;
        else
            width += 2;
    }
    printf("%d", width);
}