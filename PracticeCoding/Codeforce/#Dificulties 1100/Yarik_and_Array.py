# https://codeforces.com/problemset/problem/1899/C
import sys


def solve():
    # Using tabulation method (dp)
    n = int(input())
    arr = list(map(int, input().split()))
    tabulation = [0 for _ in range(n)]
    tabulation[0] = arr[0]
    m = arr[0]
    for i in range(1, n):
        # parity check
        if arr[i - 1] % 2 == arr[i] % 2:
            tabulation[i] = arr[i]
            if tabulation[i] > m:
                m = tabulation[i]
            continue
        # sum normal
        sum_so_far = tabulation[i - 1] + arr[i]
        if sum_so_far < arr[i]:
            sum_so_far = arr[i]
        tabulation[i] = sum_so_far
        if tabulation[i] > m:
            m = sum_so_far
    print(m)


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
