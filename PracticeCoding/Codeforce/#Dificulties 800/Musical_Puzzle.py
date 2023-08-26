# https://codeforces.com/problemset/problem/1833/A


def solve():
    length = int(input())
    input_string = input()
    set_string = set()
    for i in range(0, length - 1):
        set_string.add(input_string[i : i + 2])

    print(len(set_string))


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
