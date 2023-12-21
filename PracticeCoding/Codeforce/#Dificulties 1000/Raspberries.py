# https://codeforces.com/problemset/problem/1883/C
import sys

MAX_VALUE = sys.maxsize


def solve():
    # Using tabulation method
    inp = input().split()
    n, k = int(inp[0]), int(inp[1])
    arr = list(map(int, input().split()))
    min_value = MAX_VALUE
    # k = 4 has 2 case: min_value is 0 or remainder has 2 number 2 because 2 * 2 = 4 which is divisible by 4
    # This counter only for 4 divisor
    count_even = 0
    for i in range(n):
        # count even number in the original array
        count_even += 1 if arr[i] % 2 == 0 else 0
        modulo_remainder = k - (arr[i] % k)
        arr[i] = modulo_remainder if modulo_remainder != k else 0
        if arr[i] < min_value:
            min_value = arr[i]
    # Let's notice that if k=2,3,5
    # , since these are prime numbers, the product of the numbers will be divisible by k
    #  if any number in the array is divisible by k
    # . From this, we can conclude that it is advantageous to perform operations only on one number.

    # If k=4
    # , we have several cases, and we need to take the minimum among them. Again, we can perform operations on one number and make it divisible by 4
    # , or we need to perform operations such that there are two even numbers in the array (there is a special case when n=1
    # ). To have two even numbers, let's count the number of even numbers in the original array as cnt
    # , and if 2≤n
    # , we can say that the answer is max(0,2−cnt)
    # .
    if k == 4 and 2 <= n:
        print(min(min_value, max(0, 2 - count_even)))
    else:
        print(min_value)


tc = int(input())
while tc != 0:
    solve()
    tc -= 1
