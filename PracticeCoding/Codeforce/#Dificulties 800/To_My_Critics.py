def solve():
    max1 = -1
    max2 = -1
    input_string = input().split()
    list_number = [int(num) for num in input_string]
    for i in range(0, 3):
        if list_number[i] > max1:
            max2 = max1
            max1 = list_number[i]
        elif list_number[i] > max2:
            max2 = list_number[i]
    if max1 + max2 >= 10:
        print("YES")
    else:
        print("NO")


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
