// https://codeforces.com/problemset/problem/427/A
#include <stdio.h>

int main()
{
    int police = 0, crime = 0, event, untreated = 0;
    scanf("%d", &event);
    int arr[event];
    for (int i = 0; i < event; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < event; i++)
    {
        if (arr[i] > 0)
            police += arr[i];
        else if (arr[i] < 0)
            crime -= arr[i];
        if (crime > 0)
        {
            if (police > 0)
            {
                crime--;
                police--;
            }
            else
            {
                untreated++;
                crime--;
            }
        }
    }
    printf("%d", untreated);
}