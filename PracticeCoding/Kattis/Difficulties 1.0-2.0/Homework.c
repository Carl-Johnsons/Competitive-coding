// https://open.kattis.com/problems/heimavinna
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int count = 0;
    int h = 0, k = 0, i, j;
    char range_1[100] = {0}, range_2[100] = {0};
    char str[10000] = {0};
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    for (i = 0; i < strlen(str); i++)
    {
        h = 0;
        k = 0;
        if (str[i] == '-')
        {
            while (1)
            {
                i--;
                if (str[i] == ';' || i == 0)
                {
                    for (j = 0; j < strlen(range_2); j++)
                    {
                        range_1[j] = 0;
                        range_2[j] = 0;
                    }
                    break;
                }
            }
            while (1)
            {
                if (str[i] != '-' && str[i] != ';')
                {
                    range_1[h] = str[i];
                    h++;
                }
                else if (str[i] == '-')
                    break;
                i++;
            }
            while (1)
            {
                if (str[i] != '-' && str[i] != '\0' && str[i] != ';')
                {
                    range_2[k] = str[i];
                    k++;
                }
                else if (str[i] == ';' || str[i] == '\0')
                    break;
                i++;
            }
            for (int a = atoi(range_1); a <= atoi(range_2); a++)
                count++;
        }
        else if (str[i] == ';' || i == strlen(str) - 1)
            count++;
    }
    printf("%d", count);
    return 0;
}