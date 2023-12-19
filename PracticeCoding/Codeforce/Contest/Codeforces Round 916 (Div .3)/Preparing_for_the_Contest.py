def solve():
    string = input().split()
    n, k = int(string[0]), int(string[1])
    for i in range(n):
        if k > 0:
            print(i + 1, end=" ")
        else:
            num = n
            while i < n:
                print(num, end=" ")
                num -= 1
                i += 1
            break
        k -= 1
    print()


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
