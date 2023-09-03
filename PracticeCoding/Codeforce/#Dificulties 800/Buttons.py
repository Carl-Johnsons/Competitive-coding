# https://codeforces.com/problemset/problem/1858/A


def solve():
    # INPUT
    input_string = (input()).split()
    [Anna, Katie, EitherOfThem] = [int(num) for num in input_string]
    # SOLVING
    result = ""
    if Anna == Katie:
        if EitherOfThem % 2 == 1:
            result = "First"
        else:
            result = "Second"
    else:
        if Anna > Katie:
            result = "First"
        else:
            result = "Second"
    # OUTPUT
    print(result)


testcase = int(input())

while testcase != 0:
    solve()
    testcase -= 1
