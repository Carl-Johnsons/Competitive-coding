#include <iostream>
using namespace std;

long long memo[1000005];
int mod = 1e9 + 7;
long long fib(int n)
{
    if (n == 1 || n == 2)
        return 1;
    if (memo[n] == 0)
        memo[n] = (fib(n - 1) + fib(n - 2)) % mod;
    return memo[n];
}
int main()
{
    int testcase;
    int n;
    cin >> testcase;
    int first = 0;
    int second = 1;
    memo[1] = 1;
    for (int i = 2; i < 1000005; i++)
    {
        memo[i] = (first + second) % mod;
        first = second;
        second = memo[i];
    }
    for (int i = 0; i < testcase; i++)
    {
        cin >> n;
        cout << memo[n] << endl;
    }
}