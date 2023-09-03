# https://codeforces.com/problemset/problem/1859/A
import sys

MAX_INT = sys.maxsize
MIN_INT = -sys.maxsize - 1


#   Array C only need max number, because bigger number can't
# be the divisor of the smaller number
def solve():
    # INPUT
    length = int(input())
    input_string = (input()).split()
    arrayA = [int(num) for num in input_string]

    # SOLVING
    min = MAX_INT
    max = MIN_INT
    maxIndex = -1
    minIndex = -1

    for i in range(0, length):
        if min > arrayA[i]:
            min = arrayA[i]
            minIndex = i
        if max < arrayA[i]:
            max = arrayA[i]
            maxIndex = i

    # OUTPUT

    # only happen when the array only have identical number
    # Ex: 2 2 2 => min max equal
    # Ex: 1 => max and min index are equal
    if min == max or maxIndex == minIndex:
        print(-1)
        return

    countMax = 0
    for i in range(0, length):
        if arrayA[i] == max:
            countMax += 1

    print(length - countMax, countMax)
    for i in range(0, length):
        if arrayA[i] != max:
            print(arrayA[i], end=" ")
    print()
    for i in range(0, countMax):
        print(max, end=" ")
    print()


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
