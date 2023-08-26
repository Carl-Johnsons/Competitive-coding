// https://codeforces.com/problemset/problem/432/A
#include <stdio.h>

int main()
{
    int n, k, team = 0, people;
    scanf("%d %d", &n, &k);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < n; i++)
    {
        people = 3;
        for (int j = i; j < n; j++)
        {
            if (5 - arr[j] >= k)
            {
                people--;
            }
            if (people == 0)
            {
                team ++;
                i = j;
                break;
            }
        }
    }
    printf("%d", team);
}