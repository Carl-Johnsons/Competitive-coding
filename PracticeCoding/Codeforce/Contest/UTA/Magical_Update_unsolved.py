import math


def solve():
    inp = input().split()
    n, k = int(inp[0]), int(inp[1])
    minNum = math.ceil((-1 + math.sqrt(-7 + 8 * n)) / 2)
    print((-1 + math.sqrt(-7 + 8 * n)) / 2)
    if minNum > k:
        if k != 1:
            minNum = k
            remain = n - int(1 + ((k + 1) * k) / 2)
            print("remain: ", remain)
            print(minNum + math.ceil(remain / k))
        else:
            print(n - k)

    else:
        print(minNum)


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
