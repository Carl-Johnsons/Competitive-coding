def solve():
    n = int(input())
    arr = sorted(list(map(int, input().split())))
    # Using tabulation method
    tabulation = [None for _ in range(n)]
    tabulation[0] = arr[0]
    for i in range(1, n):
        last_value = arr[i - 1]
        last_sum = tabulation[i - 1]
        current_value = arr[i]
        if last_value >= 0 and current_value >= 0:
            tabulation[i] = last_sum + current_value
        else:
            negative_sum = last_sum + current_value
            positive_sum = last_sum - (last_value * 2) - current_value
            if positive_sum < last_sum and i < n - 1:
                tabulation[i] = negative_sum
                continue

            if negative_sum < positive_sum:
                arr[i - 1] = -arr[i - 1]
                arr[i] = -arr[i]
            tabulation[i] = max(negative_sum, positive_sum)
    print(tabulation[n - 1])


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
