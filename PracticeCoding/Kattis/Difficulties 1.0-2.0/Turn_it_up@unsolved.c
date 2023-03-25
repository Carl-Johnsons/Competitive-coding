// https://open.kattis.com/problems/skruop
#include <stdio.h>
#include <string.h>

int main()
{
    int volume = 7;
    int N;
    scanf("%d", &N);
    fflush(stdin);
    for (int i = 0; i < N; i++)
    {
        char request[9] = {0};
        scanf("%[^\n]", request);
        fflush(stdin);
        if (strncmp(request, "Skru op!", 8) == 0 && volume < 10)
            volume++;
        else if (strncmp(request, "Skru ned!", 9) == 0 && volume > 0)
            volume--;
    }
    printf("%d", volume);
}