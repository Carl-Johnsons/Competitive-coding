// https://codeforces.com/problemset/problem/344/A
#include <stdio.h>

int main()
{
    int number, count = 0, j = 0;
    scanf("%d", &number);
    int arr[number];
    for (int i = 0; i < number; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < number; i++)
    {
        if (j < number)
        {
            j = i + 1;
        }
        if (arr[i] != arr[j])
            count++;
    }
    printf("%d", count);
}