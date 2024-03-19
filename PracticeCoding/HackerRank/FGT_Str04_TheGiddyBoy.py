inp = input()
_len = len(inp)
dict = dict()
dict["N"] = 1
dict["E"] = 1
dict["S"] = -1
dict["W"] = -1
x, y = 0, 0
for i in range(_len):
    if inp[i] in ["N", "S"]:
        y += dict.get(inp[i])
    if inp[i] in ["E", "W"]:
        x += dict.get(inp[i])
print(f"{x} {y}")
