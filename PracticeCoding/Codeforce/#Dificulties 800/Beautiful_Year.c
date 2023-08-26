// https://codeforces.com/problemset/problem/271/A
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int years, beautiful_years, arr[20], j = 0, temp, count = 0, thoat = 0, n;
    scanf("%d", &years);
    while (1)
    {
        years++;
        temp = years;
        memset(arr, 0, sizeof(arr));
        count = 0;
        j = 0;
        thoat = 0;
        n = 1000;
        for (int a = 0; a < 4; a++)
        {
            arr[j] = temp / n;
            temp %= n;
            n /= 10;
            j++;
            count = 0;
        }
        for (int i = 0; i < j; i++)
        {
            for (int h = i + 1; h < j; h++)
            {
                if (arr[i] == arr[h] && i < j - 1)
                {
                    count++;
                }
            }
        }
        if (count == 0)
        {
            beautiful_years = years;
            break;
        }
    }
    printf("%d", beautiful_years);
}