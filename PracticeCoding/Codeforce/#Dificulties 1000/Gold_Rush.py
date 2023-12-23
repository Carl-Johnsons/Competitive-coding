# https://codeforces.com/problemset/problem/1829/D
def solve():
    inp = list(map(int, input().split()))
    n, m = inp[0], inp[1]

    # Using memoization
    memo = dict()

    def helper(n, m, memo=dict()):
        if memo.get(n) is not None:
            return memo[n]

        if n == m:
            memo[n] = True
            return True
        if n % 3 != 0:
            memo[n] = False
            return False
        oneThird = int(n / 3)
        twoThird = n - oneThird
        memo[n] = helper(oneThird, m, memo) or helper(twoThird, m, memo)
        return memo[n]

    print("YES" if helper(n, m, memo) else "NO")


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
