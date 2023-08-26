#include <stdio.h>

char strs[500][500];
int m, n, isValid;
int bfs(int i, int j)
{
    if (i < 0 || j < 0 || i >= m || j >= n)
    {
        return 1;
    }
    return strs[i][j] != 'W';
}

int main()
{
    isValid = 1;
    scanf("%d%d", &m, &n);
    getchar();
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%c", &strs[i][j]);
            if (strs[i][j] == '.')
                strs[i][j] = 'D';
        }
        while ((getchar()) != '\n')
            ;
    }
    for (int i = 0; i < m; i++)
    {

        for (int j = 0; j < n; j++)
        {

            if (strs[i][j] == 'S')
            {
                isValid = bfs(i + 1, j) && bfs(i - 1, j) && bfs(i, j + 1) && bfs(i, j - 1);
                break;
            }
        }
        if (!isValid)
            break;
    }

    if (!isValid)
    {
        printf("No\n");
    }
    else
    {
        printf("Yes\n");
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
                printf("%c", strs[i][j]);
            printf("\n");
        }
    }
}