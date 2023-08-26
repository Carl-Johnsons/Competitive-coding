// https://codeforces.com/problemset/problem/1030/A
#include <stdio.h>

int main()
{
    int number, hard = 0;
    scanf("%d", &number);
    int arr[number];
    for (int i = 0; i < number; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int i = 0; i < number; i++)
    {
        if (arr[i] == 1)
        {
            hard = 1;
            break;
        }
    }
    if (hard == 1)
        printf("HARD");
    else
        printf("EASY");
}