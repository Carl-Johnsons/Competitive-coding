// https://codeforces.com/problemset/problem/1343/B
#include <stdio.h>
#include <string.h>

int main()
{
    long long testcase, i, j, k, temp, sumchan, sumle, sum;
    scanf("%lld", &testcase);
    long long arr[testcase];
    for (i = 0; i < testcase; i++)
    {
        scanf("%lld", &arr[i]);
        k = 0;
        sumchan = 0;
        sumle = 0;
        if (arr[i] % 4 >= 1)
            printf("NO");
        else
        {
            temp = 2;
            printf("YES\n");
            for (j = 0; j < (arr[i] / 2); j++)
            {
                printf("%d ", temp);
                temp += 2;
            }
            sumchan = ((temp) * (temp - 2) / 2) / 2;
            temp = 1;
            for (j = 0; j < (arr[i] / 2); j++)
            {
                if (sumle < sumchan && j < (arr[i] / 2) - 1)
                {
                    printf("%d ", temp);
                    sumle += temp;
                    temp += 2;
                }
                sum = sumle + temp;
                if (sum != sumchan && j == (arr[i] / 2) - 1)
                {
                    sum = sumle + temp;
                    j--;
                    temp += 2;
                }
                else if (sum == sumchan)
                {
                    printf("%d", temp);
                    break;
                }
            }
        }
        if (i < testcase - 1)
            printf("\n");
    }
}