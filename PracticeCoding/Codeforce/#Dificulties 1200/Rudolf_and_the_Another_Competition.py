# https://codeforces.com/problemset/problem/1846/C
def solve():
    inp = list(map(int, input().split()))
    n, m, h = inp[0], inp[1], inp[2]
    rank = 1
    Rudolf_penalty = 0
    Rudolf_point = 0
    for i in range(n):
        times = sorted(list(map(int, input().split())))
        current_time = times[0]
        current_penalty = times[0]
        # overtime
        if current_time > h:
            continue

        current_point = 1
        for j in range(1, m):
            current_time += times[j]
            if current_time > h:
                break
            current_penalty += current_time
            current_point += 1
        if i == 0:
            Rudolf_penalty = current_penalty
            Rudolf_point = current_point
        elif current_point > Rudolf_point or (
            current_point == Rudolf_point and current_penalty < Rudolf_penalty
        ):
            rank += 1
    print(rank)


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
