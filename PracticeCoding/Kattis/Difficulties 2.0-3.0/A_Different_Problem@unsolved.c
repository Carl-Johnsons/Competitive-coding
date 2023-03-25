// https://open.kattis.com/problems/different
#include <stdio.h>
int main()
{
    unsigned long long diff, num1, num2;
    char ch;
    FILE *fp;
    fp = fopen("std1.txt", "w");               // open the file in write mode
    while ((fscanf(fp, "%lld", &num1)) != EOF) // reading char by char until it equals to EOF  i.e. when u press ctrlZ the while loop terminates
    {
        putc(ch, fp);
    }
    fclose(fp);
    fp = fopen("std1.txt", "r");
    printf("text on the file:\n");
    while ((ch = getc(fp)) != EOF) // reading the character from file until fp equals to EOF{
        putchar(ch);

    fclose(fp);
    return 0;
}