# https://codeforces.com/problemset/problem/1857/A
def solve():
    len = int(input())
    list_number = []

    # These lines used to take input "3 2 2 1 2" into the array
    number_string = input().split()
    list_number = [int(num) for num in number_string]
    sum = 0

    for i in range(0, len):
        sum += list_number[i]
    if sum % 2 == 0:
        print("YES")
    else:
        print("NO")


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
