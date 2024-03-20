def solve():
    n = int(input())
    _dict = dict()
    inp_str = input().split()
    array1 = list(map(int, inp_str))
    inp_str = input().split()
    array2 = list(map(int, inp_str))
    combination = 1
    _dict = dict()
    for i in range(n):
        _min_value = min(_dict.get(array1[i], -1), _dict.get(array2[i], -1))
        _max_value = max(_dict.get(array1[i], -1), _dict.get(array2[i], -1))
        if _min_value == 0:
            print(0)
            return
        if _min_value == -1:
            if array1[i] == array2[i]:
                combination *= n
            else:
                if _max_value != -1:
                    combination *= _max_value
                else:
                    combination *= 2
            _dict[array1[i]] = _dict.get(array1[i], 2) - 1
            _dict[array2[i]] = _dict.get(array2[i], 2) - 1
        else:
            combination *= _min_value
    print(combination % 998244353)


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
