import re


def solve():
    inp_str = input()
    n = len(inp_str)
    is_lucky = False
    left = ""
    right = ""
    for i in range(1, n):
        if inp_str[i] == "0":
            continue
        left = int(inp_str[0:i])
        right = int(inp_str[i:])
        if right > left:
            is_lucky = True
            break
    if not is_lucky:
        print(-1)
    else:
        print(f"{left} {right}")


testcase = int(input())
while testcase != 0:
    testcase -= 1
    solve()
