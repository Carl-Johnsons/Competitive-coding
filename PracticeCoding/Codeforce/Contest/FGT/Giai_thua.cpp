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
#define ull unsigned long long

#define maxm (int)()
#define maxn (int)(1e6 + 5)

using namespace std;

int n;
ull memo[maxn];
int mod = 1e9 + 7;

ll fact(int n)
{
    if (n == 0 || n == 1)
        return 1;
    if (!memo[n])
    {
        memo[n] = (n * fact(n - 1)) % mod;
    }
    return memo[n];
}

void solve()
{
    cin >> n;
    cout << fact(n) << "\n";
}

int main()
{
    FAST;
    fto(i, 0, maxn - 1) memo[i] = 0;
    int t;
    cin >> t;
    fto(i, 0, t - 1)
        solve();
    // TIME;
    return 0;
}