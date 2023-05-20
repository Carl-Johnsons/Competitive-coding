#include <iostream>
#include <vector>
#include <time.h>
#include <bits/stdc++.h>
#include <chrono>

using namespace std;

class Solution
{
public:
    bool checkXMatrix(vector<vector<int>> &grid)
    {
        for (int i = 0; i < grid.size(); i++)
        {
            if (grid[i][i] == 0 || grid[i][grid.size() - 1 - i] == 0)
                return false;
            for (int j = 0; j < grid.size(); j++)
            {
                if (i != j && i + j != grid.size() - 1 && grid[i][j] != 0)
                    return false;
            }
        }

        return true;
    }
};
int getRandom(int min, int max)
{
    return (rand() % (max - min + 1)) + min;
}

void generateXMatrix(vector<vector<int>> &grid, int len, int isXMatrix)
{
    for (int i = 0; i < len; i++)
    {
        vector<int> temp;
        grid.push_back(temp);
        for (int j = 0; j < len; j++)
        {
            if ((i == j || i + j == len - 1))
            {
                if (isXMatrix)
                    grid[i].push_back(getRandom(1, 9));
                else
                    grid[i].push_back(getRandom(0, 9));
            }
            else
            {
                if (isXMatrix)
                    grid[i].push_back(0);
                else
                    grid[i].push_back(getRandom(0, 9));
            }
        }
    }
}

int main()
{
    srand(time(0));
    Solution s;
    vector<vector<int>> grid;
    generateXMatrix(grid, 100, 1);

    auto start = chrono::high_resolution_clock::now();

    // unsync the I/O of C and C++.
    // ios_base::sync_with_stdio(false);

    int a = s.checkXMatrix(grid);
    auto end = chrono::high_resolution_clock::now();

    // Calculating total time taken by the program.
    double time_taken =
        chrono::duration_cast<chrono::nanoseconds>(end - start).count();

    time_taken *= 1e-9;

    // Recording the end clock tick.

    cout << "[\n";
    for (int i = 0; i < grid.size(); i++)
    {
        cout << "\t[";
        for (int j = 0; j < grid.size(); j++)
        {
            cout << grid[i][j];
            if (j < grid.size() - 1)
            {
                cout << ", ";
            }
            else
            {
                cout << " ";
            }
        }
        cout << "]\n";
    }
    cout << "]\n";

    cout << (a ? "true" : "false") << "\n";
    cout << "Time run: " << fixed << time_taken << setprecision(5) << "sec";
}
