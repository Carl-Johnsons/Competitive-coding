def solve():
    n = int(input())
    arr = list(map(int, input().split()))
    min = arr[0]
    for i in range(n - 1):
        if arr[i + 1] < min:
            min = arr[i + 1]
    counter = 0
    for i in range(n):
        counter += arr[i] - min
    print(counter)


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
