// https://open.kattis.com/problems/areal
#include <stdio.h>
#include <math.h>

int main()
{
    unsigned long long area;
    long double total_length;
    scanf("%lld", &area);
    total_length = sqrt(area) * 4;
    printf("%.20LF", total_length);
}