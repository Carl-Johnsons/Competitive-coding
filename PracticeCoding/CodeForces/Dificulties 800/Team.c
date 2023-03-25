// https://codeforces.com/problemset/problem/231/A
#include <stdio.h>

int main()
{
    int problem, solution_count = 0, have_solution = 0;
    scanf("%d", &problem);
    while ((getchar()) != '\n')
        ;
    int arr[problem][3];
    for (int i = 0; i < problem; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            scanf("%d", &arr[i][j]);
        }
    }
    for (int i = 0; i < problem; i++)
    {
        have_solution = 0;
        for (int j = 0; j < 3; j++)
        {
            if (arr[i][j] == 1)
                have_solution++;
            if (have_solution > 1)
            {
                solution_count++;
                break;
            }
        }
    }
    printf("%d", solution_count);
}