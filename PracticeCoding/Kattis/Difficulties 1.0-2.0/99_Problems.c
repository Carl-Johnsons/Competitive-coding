// https://open.kattis.com/problems/99problems
#include <stdio.h>
#include <math.h>

int main()
{
    int N;
    int hai_so_cuoi;
    int max, min;
    int diffmax, diffmin;
    scanf("%d", &N);
    if (N > 100)
    {
        hai_so_cuoi = N % 100;
        max = (round(N / 100) * 100) + 99;
        min = (round((N - 50) / 100) * 100) + 99;
        diffmax = max - N;
        diffmin = N - min;
        if (diffmax <= diffmin)
            N = max;
        else
            N = min;
    }
    else
        N = 99;
    printf("%d", N);
}