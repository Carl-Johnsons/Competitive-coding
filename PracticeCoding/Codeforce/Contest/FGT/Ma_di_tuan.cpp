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
#define ull long long

#define maxm (int)(1e3 + 2)
#define maxn (int)(1e3 + 2)

#define println(value) cout << value << "\n"
#define printok(_isOk) cout << ((bool)_isOk ? "YES" : "NO") \
                            << "\n"
using namespace std;

int n, m, q;

bool isOk = false;
bool block_cell[maxn][maxm];
bool visited_cell[maxn][maxm];
int di[] = {-2, -2, -1, -1, 1, 1, 2, 2};
int dj[] = {-1, 1, 2, -2, 2, -2, 1, -1};

void canGo(int row, int col)
{
    visited_cell[row][col] = true;
    fto(i, 0, 7)
    {
        int u, v;
        u = row + di[i];
        v = col + dj[i];
        if (u >= 1 && v >= 1 && u <= n && v <= m && !block_cell[u][v] && !visited_cell[u][v])
            canGo(u, v);
    }
}

void solve()
{
    cin >> n >> m;
    cin >> q;
    int row, col;
    fto(i, 0, q - 1)
    {
        cin >> row >> col;
        block_cell[row][col] = true;
    }
    canGo(1, 1);
    printok(visited_cell[n][m]);
}

int main()
{
    FAST;
    solve();
    // TIME;
    return 0;
}