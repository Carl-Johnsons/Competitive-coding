def solve():
    inp = input().split()
    a, b = int(inp[0]), int(inp[1])
    if a > b:
        print(a - b, 0 if a - b != 1 else 1)
    else:
        print(0, b - a + 1)


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
