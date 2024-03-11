def solve():
    testcase = int(input())
    while testcase != 0:
        testcase -= 1
        isConsistence = True
        n = int(input())
        phoneArray = list()
        for _ in range(n):
            phoneArray.append(input())
        phoneArray.sort()
        for i in range(1, n):
            isConsistence = not phoneArray[i].startswith(phoneArray[i - 1])
            if not isConsistence:
                break
        if isConsistence:
            print("YES")
        else:
            print("NO")

solve()
