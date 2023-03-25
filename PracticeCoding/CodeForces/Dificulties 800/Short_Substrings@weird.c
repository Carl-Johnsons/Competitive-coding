// https://codeforces.com/problemset/problem/1367/A
#include <stdio.h>
#include <string.h>

int main()
{
    char substr1[3], substr2[3];
    int testcase, del;
    scanf("%d", &testcase);
    fflush(stdin);
    char str[testcase][100];
    for (int i = 0; i < testcase; i++)
    {
        scanf("%[^\n]", str[i]);
        while ((getchar()) != '\n')
            ;
        for (int j = 0; j < strlen(str[i]); j++)
        {
            strncpy(substr1, &str[i][j], 2);
            strncpy(substr2, &str[i][j + 2], 2);
            if (substr1[1] == substr2[0])
            {
                del = j + 2;
                for (int a = del + 1; a <= strlen(str[i]); a++)
                {
                    str[i][a - 1] = str[i][a];
                }
                str[i][strlen(str[i])] = '\0';
            }
        }
        printf("%s", str[i]);
        if (i < testcase - 1)
            printf("\n");
    }
}