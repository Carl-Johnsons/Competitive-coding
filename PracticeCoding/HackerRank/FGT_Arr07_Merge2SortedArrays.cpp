#include <iostream>
using namespace std;
int m, n, i, j, k;
long arrA[1000000];
long arrB[1000000];
long arrC[2000000];

int main()
{
    cin >> m;

    for (i = 0; i < m; i++)
    {
        cin >> arrA[i];
    }
    cin >> n;
    for (i = 0; i < n; i++)
    {
        cin >> arrB[i];
    }
    i = 0;
    j = 0;
    k = 0; 

    while (i < m && j < n)
    {
        if (arrA[i] <= arrB[j])
        {
            arrC[k] = arrA[i];
            i++;
        }
        else
        {
            arrC[k] = arrB[j];
            j++;
        }
        k++;
    }
    while (i < m)
    {
        arrC[k] = arrA[i];
        k++;
        i++;
    }
    while (j < n)
    {
        arrC[k] = arrB[j];
        k++;
        j++;
    }
    for (k = 0; k < m + n; k++)
    {
        cout << arrC[k] << " ";
    }
}