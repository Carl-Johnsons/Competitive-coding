str1 = input()
str2 = input()

diff_counter = 0
len_str1 = len(str1)
lastletter = None
pos = []
for i in range(len_str1):
    if diff_counter >= 2:
        break
    if lastletter is not None and str1[i] == lastletter and pos[len(pos) - 1] - i == 1:
        pos.append(i + 1)
    if i - diff_counter >= len(str2) or str1[i] != str2[i - diff_counter]:
        diff_counter += 1
        lastletter = str1[i]
        pos.append(i + 1)
if diff_counter >= 2:
    print(0)
else:
    print(len(pos))
    for i in range(len(pos)):
        print(pos[i], end=" ")
