#include <bits/stdc++.h>
#include <string>

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
#define ull long long

#define maxm (int)()
#define maxn (int)()

using namespace std;

ull a, b;
int res;
int mod = 1e9 + 7;
ull temp;
int pow(ull base, ull exp)
{
    if (exp <= 0)
    {
        return 1;
    }
    if (exp & 1)
    {
        temp = pow(base, exp - 1);
        res = (temp * base) % mod;
        return res;
    }
    temp = pow(base, exp / 2);
    res = (int)((temp * temp) % mod);
    return res;
}

void solve()
{
    cin >> a >> b;
    cout << pow(a, b) << "\n";
}

int main()
{
    FAST;
    solve();
    // TIME;
    return 0;
}