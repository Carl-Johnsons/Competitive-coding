// https://codeforces.com/problemset/problem/1714/C
#include <stdio.h>
#include <string.h>

int main()
{
    int test_case;
    int sum = 0, h = 0, countdown = 9, a = 0;
    scanf("%d", &test_case);
    int arr[test_case], result[10];
    while ((getchar() != '\n'))
        ;
    for (int i = 0; i < test_case; i++)
        scanf("%d", &arr[i]);
    for (int i = 0; i < test_case; i++)
    {
        countdown = 9;
        sum = 0;
        h = 0;
        memset(result, 0, sizeof(result));
        if (arr[i] < 10)
            printf("%d", arr[i]);
        else
        {
            result[0] = countdown;
            h++;
            countdown--;
        LOOP:
            for (int j = 1; j <= countdown; j++)
            {
                a = 0;
                sum = 0;
                result[h] = j;
                while (1)
                {
                    sum += result[a];
                    if (a == h)
                        break;
                    a++;
                }
                if (sum == arr[i] && j != countdown)
                {
                    result[h] = j;
                    h++;
                }
            }
            if (sum < arr[i])
            {
                result[h] = countdown;
                countdown--;
                h++;
                goto LOOP;
            }
            else if (sum == arr[i])
            {
                result[h] = countdown;
                h++;
            }
        }
        for (int b = h - 1; b >= 0; b--)
            printf("%d", result[b]);
        if (i < test_case - 1)
            printf("\n");
    }
}