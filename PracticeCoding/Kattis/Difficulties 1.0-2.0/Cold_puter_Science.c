// https://open.kattis.com/problems/cold
#include <stdio.h>

int main()
{
    int number, count = 0;
    scanf("%d", &number);
    int array[number];
    for (int i = 0; i < number; i++)
        scanf("%d", &array[i]);
    for (int i = 0; i < number; i++)
    {
        if (array[i] < 0)
            count++;
    }
    printf("%d",count);
}