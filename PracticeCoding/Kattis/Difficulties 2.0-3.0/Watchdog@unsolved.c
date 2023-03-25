// https://open.kattis.com/problems/watchdog
/*3
10 2
6 6
5 4
*/
#include <stdio.h>
#include <math.h>
int power(int x, int y);

int main()
{
    int m = 0;
    int test_case, side_of_the_square_roof, number_of_hatches;
    double khoang_cach_1, khoang_cach_2, x_min = 0, y_min = 0;
    scanf("%d", &test_case);
    while (test_case)
    {
        m = 0;
        khoang_cach_1 = 0;
        khoang_cach_2 = 0;
        test_case--;
        scanf("%d %d", &side_of_the_square_roof, &number_of_hatches);
        int coordinate_of_hatch[number_of_hatches][2];
        int coordinate_of_leash[100][2];
        for (int i = 0; i < number_of_hatches; i++)
        {
            for (int j = 0; j < 2; j++)
                scanf("%d", &coordinate_of_hatch[i][j]);
        }
        for (int k = 0; k < number_of_hatches; k++)
        {
            x_min = 0;
            y_min = 0;
            for (int i = 1; i < side_of_the_square_roof; i++)
            {
                for (int j = 1; j < side_of_the_square_roof; j++)
                {
                    if (k < number_of_hatches - 1)
                    {
                        khoang_cach_1 = sqrt(power(coordinate_of_hatch[k][0] - j, 2) + power(coordinate_of_hatch[k][1] - i, 2));
                        khoang_cach_2 = sqrt(power(coordinate_of_hatch[k + 1][0] - j, 2) + power(coordinate_of_hatch[k + 1][1] - i, 2));

                        if (round(khoang_cach_1) == round(khoang_cach_2))
                        {
                            if (j < x_min && i < y_min)
                            {
                                x_min = j;
                                y_min = i;
                            }
                            // Lay khoang cach tu leash den n hatches nho nhat
                            if (x_min < y_min)
                                y_min = x_min;
                            else if (y_min == 0)
                                y_min = x_min;
                        }
                    }
                }
            }
            coordinate_of_leash[m][0] = x_min;
            coordinate_of_leash[m][1] = y_min;
            m++;
        }
    PRINTT:
        for (int i = 0; i < m; i++)
            printf("\n%d %d\n", coordinate_of_leash[i][0], coordinate_of_leash[i][1]);
    }
}

int power(int x, int y)
{
    if (y == 0)
        return 1;
    else
        return power(x, y - 1) * x;
}