// https://codeforces.com/problemset/problem/263/A
#include <stdio.h>
#define mid 2

int absolute(int x);

int main()
{
    int arr[5][5], thoat = 0, hang, cot;
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            scanf("%d", &arr[i][j]);
        }
    }
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            if (arr[i][j] == 1)
            {
                hang = i;
                cot = j;
                thoat = 1;
                break;
            }
        }
        if (thoat == 1)
            break;
    }
    printf("%d", absolute(hang - mid) + absolute(cot - mid));
}

int absolute(int x)
{
    if (x < 0)
        return -x;
    else
        return x;
}