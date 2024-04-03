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

#define println(value) cout << value << "\n"
#define printok(_isOk) cout << ((bool)_isOk ? "YES" : "NO") \
                            << "\n"
using namespace std;

int n;
bool vertical[15];
bool horizontal[15];
bool diagonal[30];
bool diagonal2[30];
int _count = 0;
// int board[15][15];

void backTracking(int row)
{
    if (row >= n)
    {
        _count++;
        // fto(i, 1, n)
        // {
        //     fto(j, 1, n)
        //     {
        //         cout << board[i][j] << " ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;
        return;
    }
    fto(j, 0, n - 1)
    {
        int d1 = (row + j) - 1;
        int d2 = (row - j) + n;
        if (horizontal[row] || vertical[j] || diagonal[d1] || diagonal2[d2])
        {
            continue;
        }
        horizontal[row] = true;
        vertical[j] = true;
        diagonal[d1] = true;
        diagonal2[d2] = true;
        // board[row][j] = 1;
        backTracking(row + 1);
        // board[row][j] = 0;
        horizontal[row] = false;
        vertical[j] = false;
        diagonal[d1] = false;
        diagonal2[d2] = false;
    }
}

void solve()
{
    cin >> n;
    fto(i, 0, n - 1)
    {
        vertical[i] = false;
        horizontal[i] = false;
    }
    fto(i, 0, 2 * n - 1)
    {
        diagonal[i] = false;
        diagonal2[i] = false;
    }

    // fto(i, 0, n - 1)
    // {
    //     fto(j, 0, n - 1)
    //     {
    //         board[i][j] = 0;
    //     }
    // }

    backTracking(0);
    println(_count);
}

int main()
{
    FAST;
    solve();
    // TIME;
    return 0;
}