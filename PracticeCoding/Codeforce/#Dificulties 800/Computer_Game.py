# https://codeforces.com/problemset/problem/1598/A


def bfs(arr: list[str], row: int, col: int, m: int, n: int) -> bool:
    if row < 0 or col < 0 or row >= m or col >= n:
        return False
    if row == m - 1 and col == n - 1:
        return True
    if arr[row][col] == "0":
        arr[row][col] = "1"
        return (
            bfs(arr, row + 1, col, m, n)
            or bfs(arr, row + 1, col + 1, m, n)
            or bfs(arr, row + 1, col - 1, m, n)
            or bfs(arr, row - 1, col, m, n)
            or bfs(arr, row - 1, col + 1, m, n)
            or bfs(arr, row - 1, col - 1, m, n)
            or bfs(arr, row, col + 1, m, n)
            or bfs(arr, row, col - 1, m, n)
        )
    return False


def solve():
    n = int(input())
    arr = []
    for i in range(2):
        arr.append(list(input()))
    row = 0
    col = 0
    print("YES" if (bfs(arr, row, col, 2, n)) else "NO")
    pass


testcase = int(input())
while testcase:
    testcase -= 1
    solve()
