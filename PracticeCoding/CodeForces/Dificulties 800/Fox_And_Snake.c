// https://codeforces.com/problemset/problem/510/A
#include <stdio.h>

int main()
{
    int row, column, left = 0, right = 1;
    scanf("%d %d", &row, &column);
    for (int i = 0; i < row; i++)
    {
        if (i % 2 == 0)
            for (int j = 0; j < column; j++)
                printf("#");
        else
        {
            if (left)
            {
                for (int j = 0; j < column; j++)
                {
                    if (j == 0)
                        printf("#");
                    else
                        printf(".");
                }
            }
            else if (right)
            {
                for (int j = 0; j < column; j++)
                {
                    if (j < column - 1)
                        printf(".");
                    else
                        printf("#");
                }
            }
            if (left)
            {
                right = 1;
                left = 0;
            }
            else if (right)
            {
                right = 0;
                left = 1;
            }
        }
        if (i < row - 1)
            printf("\n");
    }
}