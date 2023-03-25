// https://codeforces.com/problemset/problem/758/A
#include <stdio.h>

int main()
{
    int citizen, max, burles = 0;
    scanf("%d", &citizen);
    int arr[citizen];
    for (int i = 0; i < citizen; i++)
    {
        scanf("%d", &arr[i]);
    }
    max = arr[0];
    for (int i = 0; i < citizen; i++)
    {
        if (max < arr[i])
            max = arr[i];
    }
    for (int i = 0; i < citizen; i++)
    {
        if (arr[i] != max)
        {
            burles += (max - arr[i]);
        }
    }
    printf("%d", burles);
}