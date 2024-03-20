def solve():
    str = input()
    _len = len(str)
    zero_occur = 0
    one_occur = 0
    for i in range(_len):
        if str[i] == "1":
            one_occur += 1
        if str[i] == "0":
            zero_occur += 1
    str2 = list(str)
    for i in range(_len):
        if (str[i] == "1") and zero_occur > 0:
            str2[i] = "0"
            zero_occur -= 1
            continue
        if (str[i] == "0") and one_occur > 0:
            str2[i] = "1"
            one_occur -= 1
            continue
    str2 = "".join(str2)
    energy_take = 0
    for i in range(_len):
        if str[i] != str2[i]:
            continue
        energy_take = _len - i
        break
    print(energy_take)


testcase = int(input())
while testcase > 0:
    testcase -= 1
    solve()
