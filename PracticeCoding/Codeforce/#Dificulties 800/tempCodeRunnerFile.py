def solve(str):
    leftL = 0
    leftO = 0
    totalL = 0
    totalO = 0

    for i in range(n):
        if str[i] == "L":
            totalL += 1
        else:
            totalO += 1

    for i in range(n):
        if str[i] == "L":
            leftL += 1
            totalL -= 1
        else:
            leftO += 1
            totalO -= 1
        if leftL != totalL and leftO != totalO:
            return i + 1
    return -1


n = int(input())
str = input()
print(solve(str))
