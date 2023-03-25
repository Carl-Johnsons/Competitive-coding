// https://open.kattis.com/problems/ofugsnuid
#include <stdio.h>

int main()
{
    int N;
    scanf("%d", &N);
    int arr[N];
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = N - 1; i >= 0; i--)
    {
        printf("%d\n", arr[i]);
    }
}