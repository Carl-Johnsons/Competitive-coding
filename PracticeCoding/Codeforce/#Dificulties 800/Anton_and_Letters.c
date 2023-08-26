// https://codeforces.com/problemset/problem/443/A
#include <stdio.h>
#include <string.h>

int main()
{
    char str[1000] = {0}, already_have[30] = {0};
    int j = 0;
    scanf("%[^\n]", str);
    for (int i = 0; i < strlen(str); i++)
    {
        if (str[i] >= 'a' && str[i] <= 'z')
        {
            already_have[j] = str[i];
            for (int h = 0; h < j; h++)
            {
                if (already_have[h] == already_have[j])
                {
                    already_have[j] = (char)0;
                    j--;
                }
            }
            j++;
        }
    }
    printf("%d", j);
}