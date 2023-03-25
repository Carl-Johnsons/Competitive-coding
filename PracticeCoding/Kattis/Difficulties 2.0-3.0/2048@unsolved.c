// https://open.kattis.com/problems/2048
#include <stdio.h>
#define LEFT 0
#define UP 1
#define RIGHT 2
#define DOWN 3
int result[4][4];

void left(int array[4][4]);
void right(int array[4][4]);
void in_matran(int array[4][4]);

int main()
{
    int array[4][4];
    int option;
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            scanf("%d", &array[i][j]);
        }
    }
    fflush(stdin);
    scanf("%d", &option);
    switch (option)
    {
    case 0:
        left(array);
        break;
    case 1:
        break;
    case 2:
        right(array);
        break;
    default:
        break;
    }
}

void left(int array[4][4])
{
    int temp;
    int h = 1;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 3; j >= 0; j--)
            {
                if (array[i][j] != 0 && array[i][j - 1] == 0 && j >= 1)
                {
                    temp = array[i][j];
                    array[i][j] = array[i][j - 1];
                    array[i][j - 1] = temp;
                }
                else if (array[i][j] == array[i][j - 1] && j >= 1)
                {
                    array[i][j - 1] *= 2;
                    h = j;
                    while (1)
                    {
                        if (h <= 2)
                            array[i][h] = array[i][h + 1];
                        else
                            array[i][h] = 0;
                        if (h == 3)
                            break;
                        h++;
                    }
                }
            }
        }
    
    in_matran(array);
}

void right(int array[4][4])
{
    int temp;
    int h = 1;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (array[i][j] != 0 && array[i][j + 1] == 0 && j < 3)
                {
                    temp = array[i][j];
                    array[i][j] = array[i][j + 1];
                    array[i][j + 1] = temp;
                }
                else if ((array[i][j] == array[i][j + 1] || (array[i][j] != 0 && array[i][j + 1] == 0)) && j < 3)
                {
                    array[i][j + 1] += array[i][j];
                    h = j;
                    while (1)
                    {
                        if (h >= 1)
                            array[i][h] = array[i][h - 1];
                        else
                            array[i][h] = 0;
                        if (h == 0)
                            break;
                        h--;
                    }
                }
            }
    }
    in_matran(array);
}

void in_matran(int array[4][4])
{
    for (int i = 0; i < 4; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            printf("%d ", array[i][j]);
        }
        if (i < 3)
        {
            printf("\n");
        }
    }
}