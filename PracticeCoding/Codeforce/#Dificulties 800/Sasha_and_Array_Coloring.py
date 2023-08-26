# https://codeforces.com/problemset/problem/1843/A

def solve():
    length = int(input())
    input_string = input().split()
    list_number = [int(num) for num in input_string]
    list_number = sorted(list_number)
    leftPointer = 0
    rightPointer = length - 1

    sum = 0
    while leftPointer < rightPointer:
        sum += list_number[rightPointer] - list_number[leftPointer]
        leftPointer += 1
        rightPointer -= 1
    print(sum)


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
