def solve():
    remainder_dict = dict()
    n = int(input())
    inp_str = input().split()
    _list = list(map(int, inp_str))
    for i in range(n):
        remainder_dict[_list[i] % 10] = remainder_dict.get(_list[i] % 10, 0) + 1
    _set_list = list(remainder_dict)
    len_set = len(_set_list)
    is_possible = False
    for i in range(len_set):
        remainder_dict[_set_list[i]] -= 1
        for j in range(i, len_set):
            if remainder_dict[_set_list[j]] <= 0:
                continue
            remainder_dict[_set_list[j]] -= 1

            temp1 = 3 - (_set_list[i] + _set_list[j]) % 10
            temp2 = 13 - (_set_list[i] + _set_list[j]) % 10
            if remainder_dict.get(temp1, -1) > 0:
                # print(f"{_set_list[i]} {_set_list[j]} {temp1}")
                print("YES")
                return

            if remainder_dict.get(temp2, -1) > 0:
                # print(f"{_set_list[i]} {_set_list[j]} {temp2}")
                print("YES")
                return

            remainder_dict[_set_list[j]] += 1
        remainder_dict[_set_list[i]] += 1
    print("NO")


testcase = int(input())
while testcase != 0:
    testcase -= 1
    solve()
