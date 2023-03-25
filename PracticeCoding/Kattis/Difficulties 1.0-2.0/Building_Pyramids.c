// https://open.kattis.com/problems/pyramids
#include <stdio.h>
int power(int x, int y);

int main()
{
    int blocks;
    int height = 0;
    scanf("%d", &blocks);
    for (int i = 1; i <= 100000; i += 2)
    {
        if (blocks >= power(i, 2))
        {
            blocks -= power(i, 2);
            height++;
        }
        else
            break;
    }
    printf("%d", height);
}

int power(int x, int y)
{
    if (y == 0)
        return 1;
    else
        return power(x, y - 1) * x;
}