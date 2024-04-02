#include <iostream>
using namespace std;

long long memo[1000005];
int mod = 1e9 + 7;

int main()
{
    int testcase;
    int n;
    cin >> testcase;
    int first = 1;
    memo[0] = 1;
    memo[1] = 1;
    for (int i = 2; i < 1000005; i++)
    {
        long long res = first * i;
        memo[i] = (res) % mod;
        first = memo[i];
    }
    for (int i = 0; i < testcase; i++)
    {
        cin >> n;
        cout << memo[n] << endl;
    }
}