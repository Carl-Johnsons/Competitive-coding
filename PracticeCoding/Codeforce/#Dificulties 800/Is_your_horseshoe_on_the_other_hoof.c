// https://codeforces.com/problemset/problem/228/A
#include <stdio.h>

int main()
{
    int arr[4], count = 0;
    for (int i = 0; i < 4; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < 4; i++)
    {
        for (int j = i + 1; j < 4; j++)
        {
            if (arr[i] == arr[j])
            {
                count++;
                break;
            }
        }
    }
    printf("%d", count);
}