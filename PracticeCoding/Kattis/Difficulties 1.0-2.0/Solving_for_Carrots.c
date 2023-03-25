// https://open.kattis.com/problems/carrots
// P/S: This problem is a joke
#include <stdio.h>

int main()
{
    int N, P;
    scanf("%d %d", &N, &P);
    char comment[N][1000];
    for (int i = 0; i < N; i++)
    {
        scanf("%[^\n]", comment[i]);
    }
    printf("%d", P);
}