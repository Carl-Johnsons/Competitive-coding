// https://open.kattis.com/problems/betting
#include <stdio.h>

int main()
{
    double option_1_ratio;
    double option_1_win, option_2_win;
    scanf("%lf", &option_1_ratio);
    option_1_win = 100 / option_1_ratio;
    option_2_win = 100 / (100 - option_1_ratio);
    printf("%.10lf\n%.10lf", option_1_win, option_2_win);
}