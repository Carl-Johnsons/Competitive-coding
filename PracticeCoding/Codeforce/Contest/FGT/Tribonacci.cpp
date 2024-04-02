#include <bits/stdc++.h>

#define fto(i, a, b) for (int i = (int)a; i <= (int)b; ++i)
#define fdto(i, a, b) for (int i = (int)a; i >= (int)b; --i)

#define TEST     \
    int TEST;    \
    cin >> TEST; \
    while (TEST--)
#define FAST ios::sync_with_stdio(false), cin.tie(nullptr);
#define TIME cerr << "time: " << (float)clock() / CLOCKS_PER_SEC << " secs \n"

#define ff first
#define ss second
#define pb push_back

#define ll long long

#define maxm (int)()
#define maxn (int)(1e6 + 5)

using namespace std;

int n;
int mod = 1e9 + 7;
ll memo[1000005];

int tribo(int n)
{
    if (n == 1)
        return 1;
    if (n == 2)
        return 2;
    if (n == 3)
        return 3;
    if (memo[n] == -1)
    {
        memo[n] = ((tribo(n - 1) + tribo(n - 2)) % mod + tribo(n - 3)) % mod;
    }
    return memo[n];
}

void solve()
{
    cin >> n;
    cout << tribo(n) << "\n";
}

int main()
{
    int i;
    FAST;
    int testcase;
    cin >> testcase;
    fto(i, 1, 1000000)
    {
        memo[i] = -1;
    }
    // tribo(1000000);
    fto(i, 1, testcase) solve();
    // TIME;
    return 0;
}