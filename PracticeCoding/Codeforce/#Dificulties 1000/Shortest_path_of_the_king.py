start_point = input()
start_row, start_col = int(start_point[1]), start_point[0]
end_point = input()
end_row, end_col = int(end_point[1]), end_point[0]

paths = []
while start_row != end_row or start_col != end_col:
    step = ""
    if ord(start_col) < ord(end_col):
        start_col = chr(ord(start_col) + 1)
        step += "R"
    elif ord(start_col) > ord(end_col):
        start_col = chr(ord(start_col) - 1)
        step += "L"

    if start_row < end_row:
        start_row += 1
        step += "U"
    elif start_row > end_row:
        start_row -= 1
        step += "D"
    paths.append(step)
print(len(paths))
for i in range(len(paths)):
    print(paths[i])
