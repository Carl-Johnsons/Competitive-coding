// https://codeforces.com/problemset/problem/339/A
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int inverse(int x);

int main()
{
    int temp;
    char str[1000] = {0};
    int arr[1000], digit = 0;
    int sum = 0, n = 1, j = 0;
    scanf("%[^\n]", str);
    memset(arr, 0, sizeof(arr));
    for (int i = 0; i < strlen(str); i++)
    {
        if (str[i] != '+' && i != strlen(str) - 1)
        {
            digit = i;
        }
        else if (str[i] == '+' || i == strlen(str) - 1)
        {
            if (i == strlen(str) - 1)
            {
                digit = strlen(str);
            }
            while (1)
            {
                if (str[digit] != '+' && str[digit] != '\0')
                {
                    sum += ((str[digit] - 48) * n);
                    n *= 10;
                }
                if (digit == 0 || str[digit - 1] == '+')
                    break;
                digit--;
            }
            arr[j] = sum;
            sum = 0;
            digit = 0;
            n = 1;
            j++;
        }
    }
    for (int i = 0; i < j; i++)
    {
        for (int h = i + 1; h < j; h++)
        {
            if (arr[i] > arr[h])
            {
                temp = arr[i];
                arr[i] = arr[h];
                arr[h] = temp;
            }
        }
    }
    for (int i = 0; i < j; i++)
    {
        printf("%d", arr[i]);
        if (i < j - 1)
            printf("+");
    }
}
