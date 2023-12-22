# https://codeforces.com/problemset/problem/1861/B
def solve():
    a, b = input(), input()
    n = len(a)
    # Special case
    if a[0] != b[0] or a[n - 1] != b[n - 1]:
        print("NO")
        return

    # using tabulation method

    tabulation = [False for _ in range(n)]
    tabulation[0] = True

    have_match_0 = a[0] == '0'
    have_match_1 = a[0] == '1'
    for i in range(1, n):
        # Make False value overide
        test = a[i] == b[i]
        tabulation[i] = tabulation[i - 1] and test
        if tabulation[i]:
            if(not have_match_0):
                have_match_0 = a[i] == '0'
            if(not have_match_1):
                have_match_1 = a[i] == '1'
            continue
        if a[i] == '0':
            tabulation[i] = test and have_match_0
        else:
            tabulation[i] = test and have_match_1
    print("YES" if tabulation[n - 1] else "NO")


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
