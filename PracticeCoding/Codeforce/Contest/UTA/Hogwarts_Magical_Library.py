def solve():
    n = int(input())
    arr = list(map(int, input().split()))
    sumOdd = 0
    for i in range(2 * n):
        sumOdd += 1 if arr[i] % 2 == 0 else -1
    if sumOdd == 0:
        print("Yes")
    else:
        print("No")


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
