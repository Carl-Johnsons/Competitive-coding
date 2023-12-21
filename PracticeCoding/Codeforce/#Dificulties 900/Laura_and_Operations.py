def solve():
    arr = list(map(int, input().split()))
    remainder = 0
    for i in range(3):
        arr[i] = arr[i] % 2
        remainder += arr[i]
    if remainder == 3 or remainder == 1:
        for i in range(3):
            print(arr[i], end=" ")
    else:
        for i in range(3):
            print(1 - arr[i], end=" ")
    print()
    pass


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
