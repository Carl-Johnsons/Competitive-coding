// https://codeforces.com/problemset/problem/785/A
#include <stdio.h>
#include <string.h>

int main()
{
    int testcase, count = 0;
    scanf("%d", &testcase);
    while ((getchar()) != '\n')
        ;
    char str[testcase][30];
    for (int i = 0; i < testcase; i++)
    {
        scanf("%[^\n]", str[i]);
        while ((getchar()) != '\n')
            ;
    }
    for (int i = 0; i < testcase; i++)
    {
        if (strncmp(str[i], "Tetrahedron", 11) == 0)
            count += 4;
        else if (strncmp(str[i], "Cube", 4) == 0)
            count += 6;
        else if (strncmp(str[i], "Octahedron", 10) == 0)
            count += 8;
        else if (strncmp(str[i], "Dodecahedron", 12) == 0)
            count += 12;
        else if (strncmp(str[i], "Icosahedron", 11) == 0)
            count += 20;
    }
    printf("%d", count);
}