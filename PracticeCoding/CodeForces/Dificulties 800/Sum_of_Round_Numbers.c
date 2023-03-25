// https://codeforces.com/problemset/problem/1352/A
#include <stdio.h>
#include <string.h>
#include <math.h>

int digits(int x);
int power(int x, int y);

int main()
{
    int testcase;
    scanf("%d", &testcase);
    int arr[testcase], k = 0, round_[1000], chuso = 0;
    for (int i = 0; i < testcase; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < testcase; i++)
    {
        k = 0;
        memset(round_, 0, sizeof(round_));
        chuso = power(10, digits(arr[i]));
        while (arr[i])
        {
            round_[k] = round(arr[i] / chuso) * chuso;
            arr[i] %= chuso;
            k++;
            if (arr[i] == 0)
                break;
            chuso = power(10, digits(arr[i]));
        }
        printf("%d\n", k);
        for (int a = 0; a < k; a++)
        {
            printf("%d", round_[a]);
            if (a < k - 1)
                printf(" ");
        }
        if (i < testcase - 1)
            printf("\n");
    }
}

int digits(int x)
{
    int count = 0;
    while (x)
    {
        x /= 10;
        count++;
    }
    count--;
    return count;
}

int power(int x, int y)
{
    if (y == 0)
        return 1;
    else
        return power(x, y - 1) * x;
}