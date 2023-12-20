def solve():
    n = int(input())
    arr = list(map(int, input().split()))
    arr = sorted(arr)
    for i in range(n - 1):
        if arr[i + 1] - arr[i] > 1:
            print("NO")
            return
    print("YES")


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
