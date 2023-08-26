// https://codeforces.com/problemset/problem/1512/A
#include <stdio.h>

int main()
{
    int testcase;
    scanf("%d", &testcase);
    for (int i = 0; i < testcase; i++)
    {
        int location;
        int n;
        scanf("%d", &n);
        int arr[n];
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &arr[i]);
        }
        if ((arr[0] > arr[1] || arr[0] < arr[1]) && arr[1] == arr[2])
            location = 0;
        else
        {
            for (int i = 0; i < n; i++)
            {
                if ((arr[i] < arr[i + 1] || arr[i] > arr[i + 1]) && i < n - 1)
                {
                    location = i + 1;
                    break;
                }
            }
        }
        printf("%d", location + 1);
        if (i < testcase - 1)
            printf("\n");
    }
}