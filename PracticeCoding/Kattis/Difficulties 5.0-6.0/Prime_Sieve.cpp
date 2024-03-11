#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int n, q;
// Using sieve algorithm to cross out composite number
void solve()
{
    cin >> n >> q;
    vector<bool> is_prime(n + 1, true); // testcase up 10^8 so normal array won't work
    is_prime[0] = false;
    is_prime[1] = false;
    long prime_counter = n - 1;
    int i = 2, j;
    int m = sqrt(n);
    while (i <= m) // only compare up to sqrt(m)
    {
        if (!is_prime[i])
        {
            i++;
            continue;
        }
        j = i + i;
        while (j <= n)
        {
            if (is_prime[j])
            {
                prime_counter--;
            }
            is_prime[j] = false;
            j += i;
        }
        i++;
    }
    int temp;
    cout << prime_counter << endl;
    for (int k = 0; k < q; k++)
    {
        cin >> temp;
        cout << is_prime[temp] << endl;
    }
};

int main()
{
    solve();
}