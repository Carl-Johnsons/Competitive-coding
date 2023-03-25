// https://open.kattis.com/problems/acm
#include <stdio.h>
#include <string.h>

int main()
{
    int time[1000] = {0};
    int wrong = 0;
    int thoat;
    int j = 0;
    int h = 0;
    char answer[1000][5], contestant[1000], already_sum[1000];
    int total_right = 0, total_time = 0;
    while (1)
    {
        scanf("%d", &time[j]);
        if (time[j] == -1)
        {
            j--;
            break;
        }
        scanf(" %c", &contestant[j]);
        scanf(" %s", answer[j]);
        j++;
    }
    already_sum[0] = contestant[0];
    for (int i = 0; i <= j; i++)
    {
        wrong = 0;
        if (strncmp(answer[i], "right", 5) == 0)
            total_right++;
        thoat = 0;

        for (int a = 0; a < h; a++)
        {
            if (already_sum[a] == contestant[i])
            {
                thoat = 1;
                break;
            }
                }
        if (thoat == 1)
            continue;
        for (int k = 0; k <= j; k++)
        {

            if ((contestant[i] == contestant[k]) && strncmp(answer[k], "right", 5) == 0)
            {
                already_sum[h] = contestant[i];
                total_time += time[k];
                if (wrong > 0)
                    total_time += (20 * wrong);
                h++;
                break;
            }
            else if ((contestant[i] == contestant[k]) && strncmp(answer[k], "wrong", 5) == 0)
                wrong++;
        }
    }
    printf("%d %d", total_right, total_time);
}