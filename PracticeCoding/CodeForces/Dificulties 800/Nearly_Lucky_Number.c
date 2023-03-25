// https://codeforces.com/problemset/problem/110/A
#include <stdio.h>

int main()
{
    unsigned long long number, temp, count_lucky = 0;
    scanf("%lld", &number);
    while (number)
    {

        temp = number % 10;
        if (temp == 4 || temp == 7)
            count_lucky++;
        number /= 10;
    }
    if (count_lucky == 4 || count_lucky == 7)
        printf("YES");
    else
        printf("NO");
}