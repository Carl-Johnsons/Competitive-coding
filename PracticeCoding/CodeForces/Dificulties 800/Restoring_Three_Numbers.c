// https://codeforces.com/problemset/problem/1154/A
#include <stdio.h>

int main()
{
    unsigned long long arr[4], sumabc, max, result[3], j = 0;
    for (int i = 0; i < 4; i++)
    {
        scanf("%lld", &arr[i]);
    }
    max = arr[0];
    for (int i = 0; i < 4; i++)
    {
        if (max < arr[i])
            max = arr[i];
    }
    sumabc = max;
    for (int i = 0; i < 4; i++)
    {
        if (arr[i] == max)
            continue;
        else
        {
            result[j] = sumabc - arr[i];
            j++;
        }
    }
    printf("%d %d %d", result[0], result[1], result[2]);
}