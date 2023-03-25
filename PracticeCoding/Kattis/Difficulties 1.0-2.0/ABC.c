// https://open.kattis.com/problems/abc
#include <stdio.h>
// Bai nay su dung fgets kattis dell nhan, scanf("%s") thi nhan
int main()
{
    int temp;
    int array[100];
    char str[100];
    for (int i = 0; i < 3; i++)
    {
        scanf("%d", &array[i]);
    }
    scanf("%s", str);
    for (int i = 0; i < 3; i++)
    {
        for (int j = i + 1; j < 3; j++)
            if (array[i] > array[j])
            {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
    }
    for (int i = 0; i < 3; i++)
    {
        if (*(str + i) == 'C')
            printf("%d", array[2]);
        else if (*(str + i) == 'B')
            printf("%d", array[1]);
        else if (*(str + i) == 'A')
            printf("%d", array[0]);
        if (i < 2)
            printf(" ");
    }
    return 0;
}