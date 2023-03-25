// https://codeforces.com/problemset/problem/469/A
#include <stdio.h>

int main()
{
    int num, X, Y, arr1[1000], arr2[1000], pass[1000], j = 0, temp = 0;
    scanf("%d", &num);
    scanf("%d", &X);
    for (int i = 0; i < X; i++)
    {
        scanf("%d", &arr1[i]);
    }
    scanf("%d", &Y);
    for (int i = 0; i < Y; i++)
    {
        scanf("%d", &arr2[i]);
    }
    for (int a = 0; a < X; a++)
    {
        pass[j] = arr1[a];
        temp = 0;
        while (1)
        {
            if (temp == j)
                break;
            if (pass[j] == pass[temp])
            {
                pass[j] = 0;
                j--;
                break;
            }

            temp++;
        }
        j++;
    }
    for (int a = 0; a < Y; a++)
    {
        pass[j] = arr2[a];
        temp = 0;
        while (1)
        {
            if (temp == j)
                break;
            if (pass[j] == pass[temp])
            {
                pass[j] = 0;
                j--;
                break;
            }

            temp++;
        }
        j++;
    }
    if (j == num)
        printf("I become the guy.");
    else
        printf("Oh, my keyboard!");
}