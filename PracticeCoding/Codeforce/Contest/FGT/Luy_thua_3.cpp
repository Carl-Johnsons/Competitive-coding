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
ull res;
ull mod;
ull temp;

ull mulMod(ull a, ull b)
{
    ull res = 0;
    a = a % mod;
    while (b > 0)
    {
        if (b & 1)
        {
            res = (res + a) % mod;
        }
        a = (a * 2) % mod;
        b /= 2;
    }
    return res;
}

ull powMod(ull base, ull exp)
{
    if (exp <= 0)
    {
        return 1;
    }
    if (exp & 1)
    {
        temp = powMod(base, exp - 1);
        res = mulMod(temp, base);
        return res;
    }
    temp = powMod(base, exp / 2);
    res = mulMod(temp, temp);
    return res;
}

void solve()
{
    cin >> a >> b >> mod;
    cout << powMod(a, b) << "\n";
}

int main()
{
    FAST;
    solve();
    // TIME;
    return 0;
}