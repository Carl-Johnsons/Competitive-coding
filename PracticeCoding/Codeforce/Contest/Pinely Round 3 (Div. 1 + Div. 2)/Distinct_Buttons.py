import sys

MAX_VALUE = sys.maxsize
MIN_VALUE = -MAX_VALUE - 1


def solve():
    n = int(input())
    s = set()
    canTravel = True
    max_x = 0
    min_x = 0
    max_y = 0
    min_y = 0

    for _ in range(n):
        arr = list(map(int, input().split()))

        if not canTravel:
            continue

        if arr[0] > max_x:
            max_x = arr[0]
            s.add("U")
        if arr[0] < min_x:
            s.add("D")
            min_x = arr[0]
        if arr[1] > max_y:
            s.add("L")
            max_y = arr[1]
        if arr[1] < min_y:
            s.add("R")
            min_y = arr[1]
            
        if len(s) == 4:
            canTravel = False
    print("YES" if canTravel else "NO")


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
