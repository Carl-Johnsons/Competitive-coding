def solve():
    pos = input()
    row, col = int(pos[1]), pos[0]
    for i in range(8):
        char = chr(97 + i)
        if char != col:
            print(char, row, sep="")
        if i + 1 != row:
            print(col, i + 1, sep="")


t = int(input())
while t != 0:
    solve()
    t -= 1
