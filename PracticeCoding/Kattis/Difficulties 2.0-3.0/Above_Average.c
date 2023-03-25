// https://open.kattis.com/problems/aboveaverage
#include <stdio.h>

int main()
{
    int test_case;
    double average;
    double above_average;
    int number_of_students;
    int h;
    scanf("%d", &test_case);
    while (test_case)
    {
        scanf("%d", &number_of_students);
        int mark[number_of_students];
        average = 0;
        above_average = 0;
        for (int i = 0; i < number_of_students; i++)
        {
            scanf("%d", &mark[i]);
            average += mark[i];
        }
        average /= number_of_students;
        for (int i = 0; i < number_of_students; i++)
        {
            if (mark[i] > average)
            {
                above_average++;
            }
        }
        above_average /= number_of_students;
        above_average *= 100;
        printf("%.3lf%%\n", above_average);
        test_case--;
    }
}