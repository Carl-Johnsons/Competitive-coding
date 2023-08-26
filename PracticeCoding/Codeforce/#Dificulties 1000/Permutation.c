// https://codeforces.com/problemset/problem/137/B
#include <stdio.h>

int arr[5001], n, value, duplicate;

int abs(int x)
{
    if (x < 0)
        return -x;
    return x;
}

int solve()
{
    duplicate = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < n; i++)
    {

        if (abs(arr[i]) > n || arr[abs(arr[i]) - 1] < 0)
        {
            duplicate++;
            continue;
        }
        arr[abs(arr[i]) - 1] = -arr[abs(arr[i]) - 1];
    }
    printf("%d", duplicate);
}

int main()
{
    solve();

    return 0;
}
