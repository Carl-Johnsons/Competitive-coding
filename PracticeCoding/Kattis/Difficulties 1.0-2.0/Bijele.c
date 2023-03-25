// https://open.kattis.com/problems/bijele
#include <stdio.h>
#define king 1
#define queen 1
#define rooks 2
#define bishops 2
#define knights 2
#define pawns 8
int main()
{
    int valid_set[6] = {0};
    int chess_at_the_present[6];
    valid_set[0] = king;
    valid_set[1] = queen;
    valid_set[2] = rooks;
    valid_set[3] = bishops;
    valid_set[4] = knights;
    valid_set[5] = pawns;
    for (int i = 0; i < 6; i++)
    {
        scanf("%d", &chess_at_the_present[i]);
    }
    for (int i = 0; i < 6; i++)
    {
        chess_at_the_present[i] = valid_set[i] - chess_at_the_present[i];
        printf("%d ", chess_at_the_present[i]);
    }
}