def solve():
    length = int(input())
    list_number = []

    for i in range(0, length):
        list_number.append(i + 1)

    # The pattern is the cost only increase when the array is like this
    # 1
    # 10
    # [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    # Current Cost: 285
    # [1, 2, 3, 4, 5, 6, 7, 8, 10, 9]
    # Current Cost: 294
    # [1, 2, 3, 4, 5, 6, 7, 10, 9, 8]
    # Current Cost: 300
    # [1, 2, 3, 4, 5, 6, 10, 9, 8, 7]
    # Current Cost: 303
    # len = 10
    # [1, 2, 3, 4, 5, 6, 10, 9, 8, 7]
    # Max cost: 303

    preCost = -1
    current_cost = costOf(list_number)
    current_pointer = length - 1
    while preCost < current_cost:
        preCost = current_cost
        if current_pointer == 0:
            break
        leftMax = list_number[current_pointer - 1]
        list_number.remove(leftMax)
        list_number.append(leftMax)
        current_cost = costOf(list_number)
        current_pointer -= 1
    print(preCost)

    #  =======  Brute Force ================
    # visited = []
    # permutation = []
    # storePermutation = []
    # for i in range(0, length):
    #     visited.append(False)
    # backTracking(permutation, list_number, visited, 0, length, storePermutation)
    # dummy = []
    # maxCost = -10000
    # for permutation in storePermutation:
    #     cost = costOf(permutation)
    #     if cost > maxCost:
    #         maxCost = cost
    #         dummy = permutation
    #         print(permutation)
    #         print("Current Cost:", cost)
    # print("len =", length)
    # print(dummy)
    # print("Max cost:", maxCost)


def costOf(permutation: list):
    max = -1

    cost = 0
    for i in range(0, len(permutation)):
        value = permutation[i] * (i + 1)
        if value > max:
            max = value
        cost += value
    cost -= max
    return cost


# For brute force
def backTracking(
    permutation: list,
    list_number: list,
    visited: list,
    i,
    length,
    storePermutation: list,
):
    if len(permutation) >= length:
        storePermutation.append(list(permutation))
        return
    for i in range(0, length):
        if visited[i]:
            continue
        visited[i] = True
        permutation.append(list_number[i])
        backTracking(permutation, list_number, visited, i + 1, length, storePermutation)
        visited[i] = False
        permutation.pop()


testcase = int(input())

while testcase != 0:
    solve()
    testcase -= 1
