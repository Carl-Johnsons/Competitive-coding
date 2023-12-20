def solve():
    inp = input().split()
    n, k = int(inp[0]), int(inp[1])
    b = 1
    a = n
    for _ in range(k - 1):
        a -= 1
        b += 1
        if a <= 0:
            a = n
        if b > n:
            b = 1
        if b == a:
            b += 1
            if b > n:
                b = 1
    print(b)


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
