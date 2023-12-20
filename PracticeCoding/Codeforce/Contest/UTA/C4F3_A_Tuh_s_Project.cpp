#include <iostream>
using namespace std;

int dfs(int **arr, int i, int j, int row, int col, int currentSum)
{

    if (i < 0 or j < 0 or i >= row or j >= col or arr[i][j] <= 0)
        return currentSum;
    currentSum += arr[i][j];
    arr[i][j] = -arr[i][j];
    currentSum = dfs(arr, i + 1, j, row, col, currentSum);
    currentSum = dfs(arr, i, j + 1, row, col, currentSum);
    currentSum = dfs(arr, i - 1, j, row, col, currentSum);
    currentSum = dfs(arr, i, j - 1, row, col, currentSum);
    return currentSum;
}
void solve()
{
    int row, col;
    cin >> row >> col;
    int **arr = new int *[row];
    for (int i = 0; i < row; ++i)
    {
        arr[i] = new int[col];
        for (int j = 0; j < col; ++j)
        {
            cin >> arr[i][j];
        }
    }
    int max_value = 0;
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < col; j++)
        {
            if (arr[i][j] <= 0)
                continue;
            else
            {
                int temp = dfs(arr, i, j, row, col, 0);
                if (temp > max_value)
                    max_value = temp;
            }
        }
    }
    cout << max_value << endl;
}
int main()
{
    int tc;
    cin >> tc;
    while (tc-- != 0)
    {
        solve();
    }
    return 0;
}