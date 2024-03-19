import sys

MIN_INT = -sys.maxsize - 1

inp = input()
_len = len(inp)
dict = dict()
dict["N"] = 1
dict["E"] = 1
dict["S"] = -1
dict["W"] = -1
x, y = 0, 0
step = MIN_INT
for i in range(_len):
    if inp[i].isnumeric():
        step = int(inp[i])
    if inp[i] in ["N", "S"]:
        y += dict.get(inp[i]) * max(1, step)
        step = MIN_INT
    if inp[i] in ["E", "W"]:
        x += dict.get(inp[i]) * max(1, step)
        step = MIN_INT
print(f"{x} {y}")
