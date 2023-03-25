// https://open.kattis.com/problems/pot
#include <stdio.h>

int power(int x, int y);
int main()
{
    int number, result = 0, don_vi;
    scanf("%d", &number);
    int array[number];
    for (int i = 0; i < number; i++)
    {
        scanf("%d", &array[i]);
    }
    for (int i = 0; i < number; i++)
    {
        don_vi = array[i] % 10;
        array[i] /= 10;
        result += (power(array[i], don_vi));
    }
    printf("%d", result);
}

int power(int x, int y)
{
    if (y == 0)
        return 1;
    else
        return power(x, y - 1) * x;
}