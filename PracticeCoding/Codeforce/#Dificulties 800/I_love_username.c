// https://codeforces.com/problemset/problem/155/A
#include <stdio.h>

int main()
{
    int min, max, testcase, count = 0;
    scanf("%d", &testcase);
    int arr[testcase];
    for (int i = 0; i < testcase; i++)
    {
        scanf("%d", &arr[i]);
    }
    min = max = arr[0];
    for (int i = 0; i < testcase; i++)
    {
        if (min > arr[i])
        {
            min = arr[i];
            count++;
        }
        if (max < arr[i])
        {
            max = arr[i];
            count++;
        }
    }
    printf("%d", count);
}