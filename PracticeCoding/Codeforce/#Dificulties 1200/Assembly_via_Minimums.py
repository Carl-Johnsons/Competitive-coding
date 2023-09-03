# https://codeforces.com/problemset/problem/1857/C


def solve():
    # INPUT
    lengthOfArrayA = int(input())
    input_string = (input()).split()
    arrayB = [int(num) for num in input_string]
    # SOLVING
    # For example:
    #   Testcase:
    #       7 5 3 5 3 3
    #   After sorted the array will look like this:
    #       3 3 3 5 5 7
    #   Appearance of each number:
    #       3: 3 times
    #       5: 2 times
    #       7: 1 times
    #   => The initial Array will look like this: 3 5 7 and number equal or bigger than 7
    #   Result will be: 3 5 7 7 or 3 5 7 8 ....
    arrayB = sorted(arrayB)
    step = lengthOfArrayA - 1
    lengthOfArrayB = len(arrayB)
    i = 0
    # OUTPUT
    while i < lengthOfArrayB:
        print(arrayB[i], end=" ")
        i += step
        step -= 1
    # print the final number equal or bigger than the last number
    print(arrayB[lengthOfArrayB - 1])


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
