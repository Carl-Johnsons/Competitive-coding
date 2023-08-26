// https://codeforces.com/problemset/problem/41/A
#include <stdio.h>
#include <string.h>

int main()
{
    char str[1000] = {0}, inverse[1000] = {0}, count = 0;
    int j = 0;
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    scanf("%[^\n]", inverse);
    while ((getchar()) != '\n')
        ;
    for (int i = strlen(str) - 1; i >= 0; i--)
    {
        if (inverse[j] != str[i])
        {
            count = 1;
            break;
        }
        j++;
    }
    if (count == 1)
        printf("NO");
    else
        printf("YES");
}