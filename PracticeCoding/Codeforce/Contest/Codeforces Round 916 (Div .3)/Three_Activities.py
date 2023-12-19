def solve():
    n = int(input())
    arr = []
    arr.append(list(map(int, input().split())))
    arr.append(list(map(int, input().split())))
    arr.append(list(map(int, input().split())))
    print(arr)
    pass


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
