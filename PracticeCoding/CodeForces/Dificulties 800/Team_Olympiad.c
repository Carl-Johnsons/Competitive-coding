// https://codeforces.com/problemset/problem/490/A
#include <stdio.h>

int main()
{
    int number, team = 0;
    scanf("%d", &number);
    int arr[number], location[number], team3[3] = {1, 2, 3}, k = 0, j = 0;
    for (int i = 0; i < number; i++)
    {
        scanf("%d", &arr[i]);
    }
    for (int c = 0; c <= 1; c++)
    {
        for (int i = 0; i < number; i++)
        {
            if (team3[k] == arr[i])
            {
                k++;
                location[j] = i;
                j++;
                arr[i] = 0;
                i = 0;
                if (k == 3)
                {
                    team++;
                    k = 0;
                }
            }
        }
    }
    if (team > 0)
    {
        printf("%d\n", team);
        for (int i = 0; i < team * 3; i++)
        {
            printf("%d", location[i] + 1);
            if ((i + 1) % 3 == 0 && i < (team * 3) - 1)
                printf("\n");
            else if ((i + 1) % 3 < 3)
                printf(" ");
        }
    }
    else
        printf("0");
    return 0;
}