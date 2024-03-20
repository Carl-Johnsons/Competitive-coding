import math


def solve():
    _len = int(input())
    if _len % 4 != 0:
        print("NO")
        return
    middle = math.ceil((_len + 1) / 2)
    print("YES")
    for i in range(2, _len + 1, 2):
        print(i, end=" ")
    for i in range(1, _len + 2, 2):
        if i == middle:
            continue
        print(i, end=" ")
    print()


testcase = int(input())
while testcase != 0:
    testcase -= 1
    solve()
