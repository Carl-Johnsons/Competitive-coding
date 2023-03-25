// https://codeforces.com/problemset/problem/486/A
#include <stdio.h>
#include <math.h>

int power(int x, int y);

int main()
{
    unsigned long long num, sum = 0, chan = 0, le = 0, sum_chan = 0, sum_le = 0, cong_sai = 2, max_chan = 0, max_le = 0;
    scanf("%lld", &num);
    if (num % 2 == 0)
    {
        chan = num / 2;
        le = num / 2;
    }
    else
    {
        chan = num / 2;
        le = num - chan;
    }
    max_chan = 2 + (chan - 1) * cong_sai;
    max_le = 1 + (le - 1) * cong_sai;
    sum_chan = (max_chan * ((max_chan + 2) / 2)) / 2;
    sum_le = ((max_le + 1) * ((max_le + 1) / 2)) / 2;
    sum = sum_chan - sum_le;
    printf("%lld", sum);
}
