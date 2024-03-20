def findClosest(array, target):
    n = len(array)
    if target <= array[0]:
        return 0
    if target >= array[n - 1]:
        return n - 1
    low = 0
    high = n
    mid = 0
    while low < high:
        mid = int((low + high) / 2)
        if array[mid] == target:
            return mid
        if target < array[mid]:
            if mid > 0 and target > array[mid - 1]:
                return mid
            high = mid
        else:
            if mid < n - 1 and target < array[mid + 1]:
                return mid + 1
            low = mid + 1
    return mid


n = int(input())
inp_str = input().split()
ho_so = list(map(int, inp_str))
m = int(input())
inp_str = input().split()
ho_so_can_tim = list(map(int, inp_str))
for i in range(1, n):
    ho_so[i] = ho_so[i - 1] + ho_so[i]
for i in range(m):
    index = findClosest(ho_so, ho_so_can_tim[i])
    print(index + 1)
