#include <iostream>
using namespace std;

int row, col, n, i, j, k, one_counter;
int graph[20][20];
bool is_weak_vertices[20];

void solve()
{
    while (true)
    {
        cin >> n;
        if (n == -1)
        {
            return;
        }
        // setup
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                cin >> graph[i][j];
            }
            is_weak_vertices[i] = true;
        }
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
            {
                if (!is_weak_vertices[i]) // if exist strong vertices break
                {
                    break;
                }
                if (graph[i][j])
                {
                    for (k = j + 1; k < n; k++)
                    {
                        is_weak_vertices[i] = !(graph[i][k] && graph[j][k]);
                        if (!is_weak_vertices[i]) // if exist strong vertices break
                        {
                            break;
                        }
                    }
                }
            }
        }
        for (i = 0; i < n; i++)
        {
            if (is_weak_vertices[i])
            {
                cout << i << " ";
            }
        }
        cout << endl;
    }
}

int main()
{
    solve();
}
