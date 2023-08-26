// https://codeforces.com/problemset/problem/734/A
#include <stdio.h>

int main()
{
    int length, countA = 0, countD = 0;
    scanf("%d", &length);
    while ((getchar()) != '\n')
        ;
    char str[length];
    scanf("%[^\n]", str);
    while ((getchar()) != '\n')
        ;
    for (int i = 0; i < length; i++)
    {
        if (str[i] == 'A')
            countA++;
        else if (str[i] == 'D')
            countD++;
    }
    if (countA > countD)
        printf("Anton");
    else if (countA < countD)
        printf("Danik");
    else
        printf("Friendship");
}