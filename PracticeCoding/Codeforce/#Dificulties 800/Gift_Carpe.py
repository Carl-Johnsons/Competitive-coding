def solve():
    name = "vika"
    current_index = 0
    inp = input().split()
    n, m = int(inp[0]), int(inp[1])
    arr = []
    for i in range(n):
        arr.append(input())
    for i in range(m):
        for j in range(n):
            if arr[j][i] == name[current_index]:
                current_index += 1
                break
        if current_index == 4:
            break
    print("YES" if current_index == 4 else "NO")


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
