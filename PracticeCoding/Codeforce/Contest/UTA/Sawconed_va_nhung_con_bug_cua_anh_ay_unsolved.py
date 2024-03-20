import math


def solve():
    n = int(input())
    inp_str = input().split()
    l = sorted(list(map(int, inp_str)))
    middle_index = math.ceil(n / 2)
    left_sum = sum(l[0:middle_index])
    right_sum = sum(l[middle_index:])

    while left_sum < right_sum and middle_index < n:
        left_sum += l[middle_index]
        right_sum -= l[middle_index]
        middle_index += 1
        print(left_sum + (right_sum - left_sum))


testcase = int(input())
while testcase != 0:
    testcase -= 1
    solve()
