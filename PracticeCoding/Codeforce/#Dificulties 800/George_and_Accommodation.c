// https://codeforces.com/problemset/problem/467/A
#include <stdio.h>

int main()
{
    int rooms, free_rooms = 0;
    scanf("%d", &rooms);
    int p[rooms], q[rooms];
    for (int i = 0; i < rooms; i++)
    {
        scanf("%d %d", &p[i], &q[i]);
    }
    for (int i = 0; i < rooms; i++)
    {
        if (q[i] - p[i] >= 2)
            free_rooms++;
    }
    printf("%d", free_rooms);
}