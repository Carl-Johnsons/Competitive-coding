// https://open.kattis.com/problems/abc
#include <stdio.h>

int main()
{
    int max, min, mid;
    int array[3];
    int str[3];
    for (int i = 0; i < 3; i++)
    {
        scanf("%d", &array[i]);
    }
    fget(str, sizeof(str), stdin);
    str[3] = '\0';
    max = min = mid = array[0];
    for (int i = 0; i < 3; i++)
    {
        if (max < array[i])
            max = array[i];
        if (min > array[i])
            min = array[i];
        if (max != array[i] || min != array[i])
            mid = array[i];
    }
    for (int i = 0; i < 3; i++)
    {
        if (str[i] == 'A')
            printf("%d", max);
        else if (str[i] == 'B')
            printf("%d", mid);
        else if (str[i] == 'C')
            printf("%d", min);
        if (i < 2)
            printf(" ");
    }
    return 0;
}