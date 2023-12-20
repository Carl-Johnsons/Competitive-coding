n = int(input())
arr = sorted(list(map(int, input().split())), reverse=True)
num = int("".join(map(str, arr)))
print(num )
if num % 2 == 0 and num % 3 == 0 and num % 5 == 0:
    print(num)
else:
    print(-1)
