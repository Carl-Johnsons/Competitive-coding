// https://codeforces.com/problemset/problem/732/A
#include <stdio.h>

int main()
{
    int k, r, shovel = 1, price;
    scanf("%d %d", &k, &r);
    while (1)
    {
        price = shovel * k;
        if (price % 10 == r)
            break;
        else if (price % 10 == 0)
            break;

        shovel++;
    }
    printf("%d", shovel);
}