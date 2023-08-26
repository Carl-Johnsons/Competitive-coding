# https://codeforces.com/problemset/problem/1850/B
def solve():
    len = int(input())
    max_quality = -1
    max_pos = -1
    for i in range(1, len + 1):
        input_string = input().split()
        ele = [int(num) for num in input_string]
        if ele[0] > 10:
            continue
        if ele[1] > max_quality:
            max_quality = ele[1]
            max_pos = i

    print(max_pos)


tescase = int(input())
while tescase != 0:
    solve()
    tescase -= 1
