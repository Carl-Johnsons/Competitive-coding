// https://open.kattis.com/problems/multtable
#include <stdio.h>
#include <math.h>
int main()
{
    long long count = 0;
    unsigned long long N, M, i, j = 0;
    scanf("%lld %lld", &N, &M);
    for (i = 2; i <= (M / 2); i++)
    {
        if (M % i == 0)
        {
            if (M / i > N)
            {
                if (count > 0)
                    count--;
            }
            else if (i <= N)
            {
                printf("%d ",i);
                count++;
            }
        }
    }
    // truong hop giua so M va 1
    if (M <= N)
    {
        count += 2;
    }
    printf("\n%lld", count);
}