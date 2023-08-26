// https://codeforces.com/problemset/problem/236/A
#include <stdio.h>
#include <string.h>

int main()
{
    char str[1000] = {0}, already_have[30] = {0};
    int j = 0;
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    for (int i = 0; i < strlen(str); i++)
    {
        already_have[j] = str[i];
        for (int a = 0; a < j; a++)
        {
            if (already_have[j] == already_have[a])
            {
                already_have[j] = (char)0;
                j--;
                break;
            }
        }
        j++;
    }
    if (j % 2 == 0)
        printf("CHAT WITH HER!");
    else
        printf("IGNORE HIM!");
}