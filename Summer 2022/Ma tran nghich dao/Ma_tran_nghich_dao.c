#include <stdio.h>
#include <conio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

long double matrixA[3][3], detA, adjA[3][3], inverse_matrix[3][3], inverse;
int goctraitren = 218, gocphaiduoi = 217, gocphaitren = 191, goctraiduoi = 192, ngang = 196, doc = 179;
int thoat = 0;
void ma_tran_2x2();
void ma_tran_3x3();
int power(int x, int y);
int isInt(long double sothuc);
void phan_so_toi_gian(long double tu, long double mau);
int UCLN(int a, int b);
void upper_box(int *a, int *b, char str[]);
void lower_box(int *a, int *b, char str[]);
void box(int *a, int *b, char str[]);
void phanso(long double sothuc);
long double customround(long double x, int a);

int main()
{
START:
    int x, y;
    char str[1000];
    thoat = 0;
    char option = (char)0;
    int ascii_value;
    do
    {
        system("cls");
        strcpy(str, " ESC");
        x = 4;
        y = 3;
        box(&x, &y, str);
        printf("\t\t\t\tThe program is made by someone...\n");
        printf("\t\t\t\tDo you want to invert the matrix?(y/n)\n\n");
        if (!(option == 'Y' || option == 'y' || option == 'n' || option == 'N' || option == (char)27 || option == (char)0))
        {
            printf("\t\t\t\t C'mon man, you just inputted '%c', Not y or n!! Try again\n", option);
        }
        option = getch(); 

    } while (!(option == 'Y' || option == 'y' || option == 'n' || option == 'N' || option == (char)27));
    if (option == 'Y' || option == 'y')
    {
    SIZE:
        fflush(stdin);
        system("cls");
        printf("%c%c%c%c%c\n", goctraitren, ngang, ngang, ngang, gocphaitren);
        printf("%cEsc%c\n", doc, doc);
        printf("%c%c%c%c%c\n", goctraiduoi, ngang, ngang, ngang, gocphaiduoi);
        printf("\t\t\t\t");
        printf("\n\t\t\t\tOkay then, welcome to the inverted matrix!!\n");
        printf("\t\t\t\tDid you decide the size of the matrix?\n");
        printf("\n");
        int i, j, hang, cot;
        char chu_so;
        int h = 2;
        // Lam moi ma tran
        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 3; j++)
            {
                matrixA[i][j] = 0;
                adjA[i][j] = 0;
                inverse_matrix[i][j] = 0;
            }
        }
        printf("\t\tSize of the matrix: ");
        // Nhap size cua ma tran

        while (h--)
        {
            chu_so = getch();
            ascii_value = chu_so;
            if (!(ascii_value >= 48 && ascii_value <= 57 || chu_so == (char)27 || chu_so == (char)8))
            {
                h++;
                continue;
            }
            if (chu_so == (char)27)
            {
                thoat = 1;
                goto THOAT;
            }
            else if (chu_so == (char)8)
            {
                system("cls");
                goto SIZE;
            }
            printf("%c", chu_so);
            if (h == 1)
            {
                hang = ascii_value - 48;
                printf(" x ");
            }
            else
                cot = ascii_value - 48;
        }
        printf("\n");
        if (hang == cot)
        {
            if (hang == 2)
            {
                ma_tran_2x2();
            }
            else if (hang == 3)
            {
                printf("Sorry mate, someone didn't code it :v!");
            }
        }
        else
            printf("The matrix is not invertible!");
    THOAT:
        goto START;
    }
    else
        system("cls");
        printf("\t\t\t\t\tCatch you later then!!");
    return 0;
}

void ma_tran_2x2()
{
    char array[1000] = {0};
    char chuso;
    int ascii;
    int i, j, k = 0, l = 0, count = 0, digit = 0;
    long double sum = 0;
ELEMENT:
     system("cls");
    printf("|Esc|");
    printf("\t\t\t\t\tOkay, the size of the matrix is 2x2\n ");
    printf("\t\t\t\t\tNow input element of the matrix:\n");
    printf("\t\t\t\t\t\t");
    fflush(stdin);
    int n;
    for (i = 0; i < 2; i++)
    {
        for (j = 0; j < 2; j++)
        {
            sum = 0;
            k = 0;
            l = 0;
            do
            {
                chuso = getch();
                ascii = chuso;
                if (!((chuso >= '0' && chuso <= '9') || chuso == '.' || chuso == '-' || chuso == ' ' || chuso == (char)27 || chuso == (char)8))
                {
                    continue;
                }
                if (chuso == (char)27)
                {
                    thoat = 1;
                    goto EXIT;
                }
                else if (chuso == (char)8)
                {
                    printf("\b \b");
                    if (k > 0)
                    {
                        array[k] = '0';
                        k--;
                    }
                    continue;
                }
                printf("%c", chuso);
                array[k] = chuso;
                k++;

            } while (chuso != ' ');
            // Tu dong xuong hang
            if (j == 1)
                printf("\n\t\t\t\t\t\t");
            k--;
            // Detect dau cham trong so vua nhap
            for (int b = 0; b < k; b++)
            {
                if (array[b] == '.')
                {
                    k--;
                    break;
                }
            }
            // Detect dau tru trong so vua nhap
            for (int b = 0; b < k; b++)
            {
                if (array[b] == '-')
                {
                    k--;
                    break;
                }
            }
            // Lay chu so cua so vua nhap
            digit = k;
            count = 0;
            while (k)
            {
                // so nguyen duong
                if (array[l] != '.')
                {
                    if (array[0] != '-')
                        sum += ((int)array[l] - 48) * pow(10, k - 1);
                    else if (array[l] == '-')
                    {
                        k++;
                        goto CONT;
                    }
                    // So nguyen am
                    if (array[0] == '-')
                    {
                        if (array[l] != '.')
                            sum -= ((int)array[l] - 48) * pow(10, k - 1);
                        else
                        {
                            k++;
                        }
                    }
                }
                else
                {
                    k++;
                }
                // Dem bao nhieu chu so ben trai dau cham
                if (array[l] == '.')
                {
                    for (int a = 0; a < 1000; a++)
                    {
                        if (array[a] == '.')
                        {
                            break;
                        }
                        else if (array[a] == '-')
                        {
                            count--;
                        }
                        count++;
                    }
                }
            CONT:
                k--;
                l++;
            }
            if (count > 0)
                sum = sum / (pow(10, digit - count));
            matrixA[i][j] = sum;
        }
    }
    printf("\n\n");
    // Tinh dinh thuc
    detA = matrixA[0][0] * matrixA[1][1] - (matrixA[0][1] * matrixA[1][0]);
    if (detA != 0)
    {
        // Ma tran lien hop
        adjA[0][0] = matrixA[1][1];
        adjA[1][1] = matrixA[0][0];
        adjA[1][0] = -matrixA[1][0];
        adjA[0][1] = -matrixA[0][1];
        printf("\t\t\tThe inverse matrix of A is\n");
        if (detA >= 1 || detA <= -1)
            printf("\tA^(-1) = 1/%.0Lf *  |(%-10.4Lf)(%10.4Lf)| = ", detA, adjA[0][0], adjA[0][1]);
        else
            printf("\tA^(-1) = 1/%.2Lf *  |(%-10.4Lf)(%10.4Lf)| = ", detA, adjA[0][0], adjA[0][1]);
        for (i = 0; i < 2; i++)
        {
            for (j = 0; j < 2; j++)
            {
                // Comg thuc ma tran nghich dao
                inverse_matrix[i][j] = adjA[i][j] / detA;
                inverse = inverse_matrix[i][j];
                // Cach deu nhung phan tu trong ma tran
                if (inverse > 0)
                    printf("   ");
                else
                    printf("  ");
                if (isInt(customround(inverse, 6)))
                    printf("%d", (int)inverse);
                else if (!(inverse <= 1 && inverse >= -1))
                    phan_so_toi_gian(adjA[i][j], detA);
                else
                    phanso(customround(inverse,8));
            }
            if (i == 0)
            {
                printf("\n");
                printf("\t\t\t   |(%-10.4Lf)(%10.4Lf)|\t", adjA[1][0], adjA[1][1]);
            }
        }
    }
    else
        printf("\t\t\t\tThe matrix is not invertible because det(A) = 0!\n\n\n");
EXIT:
    printf("\n");
    system("pause");
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

void box(int *a, int *b, char str[])
{
    *a *= 2;
    int i = 0;
    for (int y = 0; y < *b; y++)
    {
        for (int x = 0; x < *a; x++)
        {
            if (y == 0 && x == 0)
                printf("%c", goctraitren);
            else if (y == 0 && x == *a - 1)
                printf("%c", gocphaitren);
            else if (y == *b - 1 && x == 0)
                printf("%c", goctraiduoi);
            else if (y == *b - 1 && x == *a - 1)
                printf("%c", gocphaiduoi);
            else if ((y == 0 || y == *b - 1) && (x > 0 && x < *a - 1))
                printf("%c", ngang);
            else if ((y >= ((*b % 3)) && y <= (*b - ((*b % 3) + 1))) && (x >= ((*a % 3)) && x <= (*a - ((*a % 3) + 1))) && str[i] != '\0')
            {
                printf("%c", str[i]);
                i++;
            }
            else if ((x == 0 || x == *a - 1) && (y > 0 && y < *b - 1))
                printf("%c", doc);
            else if (!((y >= ((*b % 3)) && y <= (*b - ((*b % 3) + 1)))))
                printf(" ");
            else if (((x >= ((*a % 3)) && x <= (*a - ((*a % 3) + 1)))))
                printf(" ");
        }
        printf("\n");
    }
}

void upper_box(int *a, int *b, char str[])
{
    *a *= 2;
    int i = 0;
    for (int y = 0; y < *b; y++)
    {
        for (int x = 0; x < *a; x++)
        {
            if (y == 0 && x == 0)
                printf("%c", goctraitren);
            else if (y == 0 && x == *a - 1)
                printf("%c", gocphaitren);
            else if ((y == 0) && (x > 0 && x < *a - 1))
                printf("%c", ngang);
            else if ((y >= ((*b % 3)) && y <= (*b - ((*b % 3) + 1))) && (x >= ((*a % 3)) && x <= (*a - ((*a % 3) + 1))) && str[i] != '\0')
            {
                printf("%c", str[i]);
                i++;
            }
            else if ((x == 0 || x == *a - 1) && (y > 0 && y < *b - 1))
                printf("%c", doc);
            else if (!((y >= ((*b % 3)) && y <= (*b - ((*b % 3) + 1)))))
                printf(" ");
            else if (((x >= ((*a % 3)) && x <= (*a - ((*a % 3) + 1)))))
                printf(" ");
        }
        printf("\n");
    }
}

void lower_box(int *a, int *b, char str[])
{
    *a *= 2;
    int i = 0;
    for (int y = 0; y < *b; y++)
    {
        for (int x = 0; x < *a; x++)
        {
            if (y == *b - 1 && x == 0)
                printf("%c", goctraiduoi);
            else if (y == *b - 1 && x == *a - 1)
                printf("%c", gocphaiduoi);
            else if ((y == 0 || y == *b - 1) && (x > 0 && x < *a - 1))
                printf("%c", ngang);
            else if ((y >= ((*b % 3)) && y <= (*b - ((*b % 3) + 1))) && (x >= ((*a % 3)) && x <= (*a - ((*a % 3) + 1))) && str[i] != '\0')
            {
                printf("%c", str[i]);
                i++;
            }
            else if ((x == 0 || x == *a - 1) && (y > 0 && y < *b - 1))
                printf("%c", doc);
            else if (!((y >= ((*b % 3)) && y <= (*b - ((*b % 3) + 1)))))
                printf(" ");
            else if (((x >= ((*a % 3)) && x <= (*a - ((*a % 3) + 1)))))
                printf(" ");
        }
        printf("\n");
    }
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

long double customround(long double x, int a)
{
    long double dec = roundl(x * power(10, a)) / power(10, a);
    long double nxdecplace = roundl(x * power(10, a + 1)) / power(10, a + 1);
    long double temp = ((int)(nxdecplace * power(10, a + 1)) % 10);
    if (temp >= 6 && x > 0)
        dec = dec + power(1 / 10, a);
    return dec;
}
