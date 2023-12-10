# https://codeforces.com/problemset/problem/1855/A
import math


def solve():
    # INPUT
    length = int(input())
    input_string = (input()).split()
    num_array = [int(num) for num in input_string]
    # SOLVING
    # After review some testcase, the answer is count how many Number is in the position
    # Example:
    #   1 2 3
    # There are 3 number are in their position:
    #   1 in position 1
    #   2 in position 2
    #   3 in position 3
    # NOTE:postion start from 1 and index start from 0
    # The number of swapping need is roundUp(count/2)
    countNumberEqualPosition = 0
    for i in range(0, length):
        if (i + 1) == num_array[i]:
            countNumberEqualPosition += 1
    # OUTPUT
    print(math.ceil(countNumberEqualPosition / 2))


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
