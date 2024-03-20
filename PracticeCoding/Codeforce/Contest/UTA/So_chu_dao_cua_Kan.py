inp_str = input().split()
_from = int(inp_str[0])
_to = int(inp_str[1])
x = 0
y = 0
res = 0
counter = 0
while True:
    res = pow(2, x) * pow(3, y)
    if _from <= res and res <= _to:
        counter += 1
    x += 1
    if res > _to:
        x = 0
        y += 1
        res = pow(2, x) * pow(3, y)
        if res > _to:
            break

print(counter)
