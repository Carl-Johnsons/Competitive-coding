def solve():
    inp_str = input().split()
    m = int(inp_str[0])
    n = int(inp_str[1])
    arr = []
    for _ in range(m):
        inp_str = input().split()
        l = list(map(int, inp_str))
        arr.append(l)
    if (m + n - 1) % 2 == 1:
        print("NO")
        return
    tabulation = [[set() for x in range(n)] for y in range(m)]
    tabulation[0][0].add(arr[0][0])
    for i in range(m):
        for j in range(n):
            for value in tabulation[i][j]:
                if i + 1 < m:
                    tabulation[i + 1][j].add(value + arr[i + 1][j])
                if j + 1 < n:
                    tabulation[i][j + 1].add(value + arr[i][j + 1])
                if 0 in tabulation[m - 1][n - 1]:
                    print("YES")
                    return
    print("NO")


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
