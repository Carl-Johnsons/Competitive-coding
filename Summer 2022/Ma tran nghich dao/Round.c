#include <stdio.h>
#include <math.h>
long double customround(long double x, int a);
long double power(int x, int y);

int main()
{
  long double a;
  int d;
  scanf("%LF %d", &a, &d);
  printf("%.10LF", customround(a, d));
}

long double power(int x, int y)
{
  if (y == 0)
    return 1;
  else
    return power(x, y - 1) * x;
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