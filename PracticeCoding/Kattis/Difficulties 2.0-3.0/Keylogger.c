#include <stdio.h>
#include <string.h>

int main()
{
    int number, h = 0, count = 0, upper = 0, caps = 0, shift = 0;
    scanf("%d", &number);
    while ((getchar() != '\n'))
        ;
    char string[number][10], result[1000000];
    for (int i = 0; i < number; i++)
    {
        scanf("%[^\n]", string[i]);
        while ((getchar() != '\n'))
            ;
    }
    for (int i = 0; i < number; i++)
    {
        // delete key
        if (strncmp(string[i], "pop", 3) == 0)
        {
            result[h] = '\0';
            if (h > 0)
                h--;
        }
        // shift holding
        else if (strncmp(string[i], "dink", 4) == 0)
        {
            if (caps == 0)
            {
                shift = 1;
                upper = -32;
            }
            else if (caps == 1 && shift == 1)
            {
                upper = 0;
            }
        }
        // shift release
        else if (strncmp(string[i], "thumb", 5) == 0)
        {
            shift = 0;
            if (caps == 0)
                upper = 0;
            else
                upper = -32;
        }
        // Capslock
        else if (strncmp(string[i], "bump", 4) == 0)
        {
            caps = 1;
            if (count > 0 && caps == 1)
            {
                caps = 0;
                upper = 0;
                count = 0;
            }
            else if (shift == 1 && caps == 1)
            {
                upper = 0;
            }
            else if (count == 0 && caps == 0 && shift == 0)
            {
                upper = -32;
            }
            count++;
        }
        // Spacebar
        else if (strncmp(string[i], "whack", 5) == 0)
        {
            result[h] = ' ';
            h++;
        }
        // A
        else if (strncmp(string[i], "clank", 5) == 0)
        {
            result[h] = 'a' + upper;
            h++;
        }
        else if (strncmp(string[i], "bong", 4) == 0)
        {
            result[h] = 'b' + upper;
            h++;
        }
        else if (strncmp(string[i], "click", 5) == 0)
        {
            result[h] = 'c' + upper;
            h++;
        }
        else if (strncmp(string[i], "tap", 3) == 0)
        {
            result[h] = 'd' + upper;
            h++;
        }
        else if (strncmp(string[i], "poing", 5) == 0)
        {
            result[h] = 'e' + upper;
            h++;
        }
        else if (strncmp(string[i], "clonk", 5) == 0)
        {
            result[h] = 'f' + upper;
            h++;
        }
        else if (strncmp(string[i], "clack", 5) == 0)
        {
            result[h] = 'g' + upper;
            h++;
        }
        else if (strncmp(string[i], "ping", 4) == 0)
        {
            result[h] = 'h' + upper;
            h++;
        }
        else if (strncmp(string[i], "tip", 3) == 0)
        {
            result[h] = 'i' + upper;
            h++;
        }
        else if (strncmp(string[i], "cloing", 6) == 0)
        {
            result[h] = 'j' + upper;
            h++;
        }
        else if (strncmp(string[i], "tic", 3) == 0)
        {
            result[h] = 'k' + upper;
            h++;
        }
        else if (strncmp(string[i], "cling", 5) == 0)
        {
            result[h] = 'l' + upper;
            h++;
        }
        else if (strncmp(string[i], "bing", 4) == 0)
        {
            result[h] = 'm' + upper;
            h++;
        }
        else if (strncmp(string[i], "pong", 4) == 0)
        {
            result[h] = 'n' + upper;
            h++;
        }
        else if (strncmp(string[i], "clang", 5) == 0)
        {
            result[h] = 'o' + upper;
            h++;
        }
        else if (strncmp(string[i], "pang", 4) == 0)
        {
            result[h] = 'p' + upper;
            h++;
        }
        else if (strncmp(string[i], "clong", 5) == 0)
        {
            result[h] = 'q' + upper;
            h++;
        }
        else if (strncmp(string[i], "tac", 3) == 0)
        {
            result[h] = 'r' + upper;
            h++;
        }
        else if (strncmp(string[i], "boing", 5) == 0)
        {
            result[h] = 's' + upper;
            h++;
        }
        else if (strncmp(string[i], "boink", 5) == 0)
        {
            result[h] = 't' + upper;
            h++;
        }
        else if (strncmp(string[i], "cloink", 6) == 0)
        {
            result[h] = 'u' + upper;
            h++;
        }
        else if (strncmp(string[i], "rattle", 6) == 0)
        {
            result[h] = 'v' + upper;
            h++;
        }
        else if (strncmp(string[i], "clock", 5) == 0)
        {
            result[h] = 'w' + upper;
            h++;
        }
        else if (strncmp(string[i], "toc", 3) == 0)
        {
            result[h] = 'x' + upper;
            h++;
        }
        else if (strncmp(string[i], "clink", 5) == 0)
        {
            result[h] = 'y' + upper;
            h++;
        }
        else if (strncmp(string[i], "tuc", 3) == 0)
        {
            result[h] = 'z' + upper;
            h++;
        }
    }
    result[h] = (char)0;
    printf("%s", result);
}
