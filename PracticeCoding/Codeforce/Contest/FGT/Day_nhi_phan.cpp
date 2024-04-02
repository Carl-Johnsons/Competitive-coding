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
#define maxn (int)()

using namespace std;

int n, k;
char str[32767 + 5];
int _count = 0;
void backTracking(int current)
{
    if (_count > k)
    {
        return;
    }
    if (current >= n)
    {
        _count++;
        if (_count == 1)
            return;
        fto(i, 0, n - 1)
        {
            cout << str[i];
        }
        cout << "\n";
        return;
    }
    fto(i, 0, 1)
    {
        str[current] = i + '0';
        backTracking(current + 1);
    }
}

void solve()
{
    cin >> n >> k;
    backTracking(0);
};

int main()
{
    FAST;
    solve();
    // TIME;
    return 0;
}