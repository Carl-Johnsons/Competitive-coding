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

#define println(_string) cout << (string)_string << "\n"
#define printok(_isOk) cout << ((bool)_isOk ? "YES" : "NO") \
                            << "\n"
#define printArr(arr, size)    \
    do                         \
    {                          \
        fto(i, 0, size - 1)    \
        {                      \
            cout << arr[i];    \
            if (i != size - 1) \
                cout << " ";   \
        }                      \
        cout << "\n";          \
    } while (0)

using namespace std;
string s;
bool visited[10];
int n;
void backTracking(int current)
{
    if (current == n)
    {
        printArr(s, n);
        return;
    }
    fto(i, 0, n - 1)
    {
        if (visited[i])
        {
            continue;
        }
        s.append(to_string(i + 1));
        visited[i] = true;
        backTracking(current + 1);
        visited[i] = false;
        s.pop_back();
    }
}

void solve()
{
    cin >> n;
    fto(i, 0, n - 1) visited[i] = false;
    backTracking(0);
}

int main()
{
    FAST;
    solve();
    // TIME;
    return 0;
}