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
int n, m;
int arr[25];
bool bought[25];
int _count = 0;
int _max_buy = -1;
// string s;

void backTracking(int current, int remainMoney, int productBought)
{
    if (remainMoney < 0)
    {
        return;
    }
    _count++;
    _max_buy = max(_max_buy, productBought);

    fto(i, current, n - 1)
    {
        if (bought[i] || remainMoney - arr[i] < 0)
        {
            continue;
        }
        // s.append(to_string(arr[i]));
        bought[i] = true;
        backTracking(i + 1, remainMoney - arr[i], productBought + 1);
        // s.pop_back();
        bought[i] = false;
    }
}

void solve()
{
    cin >> n >> m;
    fto(i, 0, n - 1) cin >> arr[i];
    fto(i, 0, n - 1) bought[i] = false;
    backTracking(0, m, 0);
    cout << _count << " " << _max_buy;
}

int main()
{
    FAST;
    solve();
    // TIME;
    return 0;
}