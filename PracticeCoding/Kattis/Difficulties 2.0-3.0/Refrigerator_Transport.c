// https://open.kattis.com/problems/refrigerator
#include <stdio.h>

int main()
{
    int costA, capacityA, costB, capacityB, fridges, temp;
    scanf("%d %d %d %d %d", &costA, &capacityA, &costB, &capacityB, &fridges);
    while ((getchar()) != '\n')
        ;
    int min_total_cost, tripA, tripB;
    min_total_cost = costA * ((fridges / capacityA) + 1) + costB * ((fridges / capacityB) + 1);
    for (int i = 0; i < fridges; i++)
    {
        for (int j = 0; j < fridges; j++)
        {
            if (i * capacityA + j * capacityB >= fridges)
            {
                temp = costA * i + costB * j;
                if (min_total_cost > temp)
                {
                    tripA = i;
                    tripB = j;
                    min_total_cost = temp;
                }
            }
        }
    }
    printf("%d %d %d", tripA, tripB, min_total_cost);
}