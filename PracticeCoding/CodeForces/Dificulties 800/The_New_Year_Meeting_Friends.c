// https://codeforces.com/problemset/problem/723/A
#include <stdio.h>

int absolute(int x);

int main()
{
    int arr[3], max, min, total_distance = 0, meet_location, mid;
    for (int i = 0; i < 3; i++)
    {
        scanf("%d", &arr[i]);
    }
    max = min = arr[0];
    for (int i = 0; i < 3; i++)
    {
        if (max < arr[i])
            max = arr[i];
        if (min > arr[i])
            min = arr[i];
    }
    for (int i = 0; i < 3; i++)
    {
        if (arr[i] != max && arr[i] != min)
            mid = arr[i];
    }
    for (int i = 0; i < 3; i++)
    {
        total_distance += absolute(mid - arr[i]);
    }
    printf("%d", total_distance);
}

int absolute(int x)
{
    if (x < 0)
        return -x;
    else
        return x;
}