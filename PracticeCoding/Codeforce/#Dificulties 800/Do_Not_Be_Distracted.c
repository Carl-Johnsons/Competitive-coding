// https://codeforces.com/problemset/problem/1520/A
#include <stdio.h>

int main()
{
    int testcase;
    scanf("%d", &testcase);
    for (int i = 0; i < testcase; i++)
    {
        int n, a = 0, suspicious = 0, thoat = 0;
        scanf("%d", &n);
        while ((getchar()) != '\n')
            ;
        char str[n + 1];
        scanf("%[^\n]", str);
        while ((getchar()) != '\n')
            ;
        char already_done[n + 1];
        for (int j = 0; j < n; j++)
        {
            already_done[a] = str[j];
            if (already_done[a] == already_done[a - 1] && a > 0)
                continue;
            for (int h = 0; h < a; h++)
            {
                if (already_done[a] == already_done[h])
                {
                    thoat = 1;
                    suspicious = 1;
                    break;
                }
            }
            if (thoat)
                break;
            a++;
        }
        if (suspicious)
            printf("NO");
        else
            printf("YES");
        if (i < testcase - 1)
            printf("\n");
    }
}