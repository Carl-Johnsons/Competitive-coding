// https://codeforces.com/problemset/problem/71/A
#include <stdio.h>
#include <string.h>

int main()
{
    int test_case, count;
    scanf("%d", &test_case);
    while ((getchar()) != '\n')
        ;
    char str[test_case][1000];
    for (int i = 0; i < test_case; i++)
    {
        scanf("%[^\n]", &str[i]);
        while ((getchar()) != '\n')
            ;
    }
    for (int i = 0; i < test_case; i++)
    {
        count = 0;
        if (strlen(str[i]) > 10)
        {
            count = (strlen(str[i]) - 2);
            printf("%c%d%c", str[i][0], count, str[i][strlen(str[i]) - 1]);
        }
        else
            printf("%s", str[i]);
        if (i < test_case - 1)
            printf("\n");
    }
}