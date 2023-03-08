#include <stdio.h>
#include <string.h>

int goctraitren = 218, gocphaiduoi = 217, gocphaitren = 191, goctraiduoi = 192, ngang = 196, doc = 179;
void box(int *a, int *b, char str[]);

int main()
{
    char str[100] = {0};
    int a, b;
    scanf("%d %d\n", &a, &b);
    scanf("%[^\n]", str);
    fflush(stdin);
    box(&a, &b, str);
}

void box(int *a, int *b, char str[])
{
    *a *= 2;
    int i = 0;
    int con_lai = 0;
    int lam_roi = 0;
    for (int y = 0; y < *b; y++)
    {
        for (int x = 0; x < *a; x++)
        {
            if (y == 0 && x == 0)
                printf("%c", goctraitren);
            else if (y == 0 && x == *a - 1)
                printf("%c", gocphaitren);
            else if (y == *b - 1 && x == 0)
                printf("%c", goctraiduoi);
            else if (y == *b - 1 && x == *a - 1)
                printf("%c", gocphaiduoi);
            else if ((y == 0 || y == *b - 1) && (x > 0 && x < *a - 1))
                printf("%c", ngang);
            else if ((x == 0 || x == *a - 1) && (y > 0 && y < *b - 1))
                printf("%c", doc);
            else if ((y >= ((*b / 2)) && y <= (*b - ((*b / 2) ))) && (x >= (*a / 4)) && str[i] != '\0')
            {
                printf("%c", str[i]);
                i++;
                if (str[i] == '\0' && lam_roi == 0)
                {
                    con_lai = *a - strlen(str) - (*a / 4);
                    lam_roi = 1;
                    for (int j = 0; j < con_lai - 1; j++)
                        printf(" ");
                }
            }
            else if (!((y >= ((*b / 2)) && y <= (*b - ((*b / 2))))))
                printf(" ");
            else if (!(x >= ((*a / 4))))
                printf(" ");
        }
        printf("\n");
    }
}