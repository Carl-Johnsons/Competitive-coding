// https://open.kattis.com/problems/smil
#include <stdio.h>
#include <string.h>

int main()
{
    char str[10000];
    int location[10000];
    int j = 0;
    int count = 0;
    int i = 0;
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    for (i = 0; i < strlen(str); i++)
    {
        if (str[i] == ':' || str[i] == ';')
        {
            i++;
            if (str[i] == '-')
            {
                i++;
                if (str[i] == ')')
                {
                    location[j] = (i - 2);
                    j++;
                }
                else
                    i--;
            }
            else if (str[i] == ')')
            {
                location[j] = (i - 1);
                j++;
                    }
            else
                i--;
        }
    }
    for (int a = 0; a < j; a++)
    {
        printf("%d", location[a]);
        if (a < j - 1)
        {
            printf("\n");
        }
    }
    return 0;
}