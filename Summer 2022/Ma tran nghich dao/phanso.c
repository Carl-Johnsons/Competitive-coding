#include <stdio.h>

void phanso(long double sothuc);
int power(int x, int y);
int isInt(long double sothuc);
void phan_so_toi_gian(long double tu, long double mau);
int UCLN(int a, int b);

int main()
{
    long double sothuc;
    do
    {
        scanf("%Lf", &sothuc);
        phanso(sothuc);
        printf("\n=============\n");
    } while (sothuc != 0);
    return 0;
}

void phanso(long double sothuc)
{
    long double count = 0;
    long double tuso = sothuc;
    while (isInt(tuso) != 1)
    {
        tuso = sothuc * power(10, count);
        count++;
    }
    if (count > 0)
        count--;
    phan_so_toi_gian(tuso, power(10, count));
}

int isInt(long double sothuc)
{
    int so_nguyen;
    so_nguyen = sothuc;
    if (so_nguyen == sothuc)
        return 1;
    else
        return 0;
}

int UCLN(int a, int b)
{
    if (a == 0)
        return b;
    return UCLN(b % a, a);
}

void phan_so_toi_gian(long double tu, long double mau)
{
    int temp = UCLN(tu, mau);
    tu /= temp;
    mau /= temp;
    printf("%d/%d", (int)tu, (int)mau);
}

int power(int x, int y)
{
    if (y == 0)
        return 1;
    else
        return power(x, y - 1) * x;
}