// https://codeforces.com/problemset/problem/520/A
#include <stdio.h>

int main()
{
    int length, j = 0;
    scanf("%d", &length);
    while ((getchar()) != '\n')
        ;
    char str[length + 1], alphabet[27] = {0};
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    for (int i = 0; i < length; i++)
    {
        if (str[i] >= 'A' && str[i] <= 'Z')
            str[i] += 32;
        alphabet[j] = str[i];
        for (int h = 0; h < j; h++)
        {
            if (alphabet[h] == alphabet[j])
            {
                alphabet[j] = (char)0;
                j--;
            }
        }
        j++;
    }
    if (j >= 26)
        printf("YES");
    else
        printf("NO");
}