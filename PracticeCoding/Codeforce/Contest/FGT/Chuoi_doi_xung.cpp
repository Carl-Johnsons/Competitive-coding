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

using namespace std;

string s;

bool isPalindrome(string str, int low, int high)
{
    if (low >= high)
    {
        return true;
    }
    if (str[low] != str[high])
    {
        return false;
    }

    return isPalindrome(str, low + 1, high - 1);
}

void solve()
{
    cin >> s;
    printok(isPalindrome(s, 0, s.length() - 1));
}

int main()
{
    FAST;
    solve();
    // TIME;
    return 0;
}