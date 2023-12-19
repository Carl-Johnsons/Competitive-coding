def solve():
    inp = input().split()
    n, k = int(inp[0]), int(inp[1])
    arr = []
    inp = input().split()
    arr.append(list(map(int, inp)))
    inp = input().split()
    arr.append(list(map(int, inp)))
    experience = 0
    max_repeated_quest_exp = -1
    m = -1
    for i in range(n):
        if k == 0:
            break
        experience += arr[0][i]
        if max_repeated_quest_exp < arr[1][i]:
            max_repeated_quest_exp = arr[1][i]
        test = experience + max_repeated_quest_exp * (k - 1)
        if test > m:
            m = test
        k -= 1
    print(m)


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
