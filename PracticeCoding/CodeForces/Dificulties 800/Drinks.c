// https://codeforces.com/problemset/problem/200/B
#include <stdio.h>

int main()
{
    int num;
    double fraction = 0;
    scanf("%d", &num);
    int arr[num];
    for (int i = 0; i < num; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < num; i++)
    {
        fraction += arr[i];
    }
    printf("%.012lf", (fraction) / num);
}