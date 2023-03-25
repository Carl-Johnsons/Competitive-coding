// https://codeforces.com/problemset/problem/141/A
#include <stdio.h>
#include <string.h>

int main()
{
    int j = 0, count[1000], sum = 0, no = 0;
    char str[1000] = {0}, str2[1000] = {0}, alphabet[30] = {0}, alphabet2[30] = {0};
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    scanf("%[^\n]", str2);
    while ((getchar()) != '\n')
        ;
    strcat(str, str2);
    memset(str2, 0, sizeof(str2));
    scanf("%[^\n]", str2);
    while ((getchar()) != '\n')
        ;
    for (int i = 0; i < strlen(str); i++)
    {
        alphabet[j] = str[i];
        for (int a = 0; a < j; a++)
        {
            if (alphabet[a] == str[i])
            {
                alphabet[j] = (char)0;
                j--;
            }
        }
        j++;
    }
    j = 0;
    for (int i = 0; i < strlen(str2); i++)
    {
        alphabet2[j] = str2[i];
        for (int a = 0; a < j; a++)
        {
            if (alphabet2[a] == str2[i])
            {
                alphabet2[j] = (char)0;
                j--;
            }
        }
        j++;
    }
    if (strlen(alphabet2) == strlen(alphabet))
    {
        for (int i = 0; i < strlen(alphabet); i++)
        {
            sum = 0;
            for (int b = 0; b < strlen(str); b++)
            {
                if (alphabet[i] == str[b])
                    sum++;
            }
            count[i] = sum;
        }
        for (int i = 0; i < strlen(alphabet); i++)
        {
            sum = 0;
            for (int b = 0; b < strlen(str2); b++)
            {
                if (alphabet[i] == str2[b])
                    sum++;
            }
            if (count[i] != sum)
            {
                no = 1;
                break;
            }
        }
    }
    else
        no = 1;
    if (no)
        printf("NO");
    else
        printf("YES");
}