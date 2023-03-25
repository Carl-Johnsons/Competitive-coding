// https://open.kattis.com/problems/3dprinter
#include <stdio.h>

int main()
{
    int so_tuong_can_in;
    int so_ngay_toi_thieu = 0;
    int mayin = 1;
    scanf("%d", &so_tuong_can_in);
    if (so_tuong_can_in != 1)
    {
        while (1)
        {
            if (so_tuong_can_in - mayin > mayin)
            {
                mayin *= 2;
                so_ngay_toi_thieu++;
            }
            else
            {
                so_ngay_toi_thieu++;
                so_ngay_toi_thieu++;
                break;
            }
        }
    }
    else
        so_ngay_toi_thieu++;
    printf("%d", so_ngay_toi_thieu);
}