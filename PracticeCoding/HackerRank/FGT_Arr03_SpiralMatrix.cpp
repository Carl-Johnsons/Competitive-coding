#include <iostream>
using namespace std;
int n, direction = 0, count = 1, max_value, row = 0, col = 0;
int _top, _right, _down, _left;
int arr[100][100];
int main()
{
    cin >> n;
    row = 0;
    col = 0;
    _top = -1;
    _left = -1;
    _right = n;
    _down = n;

    max_value = n * n;
    while (count <= max_value)
    {
        arr[row][col] = count;
        count++;
        switch (direction)
        {
        case 0:
            col += 1;
            break;
        case 1:
            row += 1;
            break;
        case 2:
            col -= 1;
            break;
        default:
            row -= 1;
            break;
        }
        if (row == _down || col == _right || row == _top || col == _left)
        {
            col = col == _right  ? _right - 1
                  : col == _left ? _left + 1
                                 : col;
            row = row == _down  ? _down - 1
                  : row == _top ? _top + 1
                                : row;
            switch (direction)
            {
            case 0:
                _top += 1;
                row += 1;
                break;
            case 1:
                _right -= 1;
                col -= 1;
                break;
            case 2:
                _down -= 1;
                row -= 1;
                break;
            default:
                _left += 1;
                col += 1;
                break;
            }
            direction = (direction + 1) % 4;
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }
}