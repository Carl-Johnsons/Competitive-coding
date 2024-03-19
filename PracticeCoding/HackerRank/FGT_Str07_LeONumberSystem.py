_dict = dict()
_dict["L"] = "1"
_dict["O"] = "0"

reverse_dict = dict()
reverse_dict["1"] = "L"
reverse_dict["0"] = "O"

start1 = input()
start2 = input()

temp = ""
for i in range(len(start1)):
    temp += _dict[start1[i]]
start1 = int(temp, 2)
temp = ""
for i in range(len(start2)):
    temp += _dict[start2[i]]
start2 = int(temp, 2)

iter = int(input())
memo = [-1] * (iter + 1)
memo[0] = start1
memo[1] = start2


def fib(n):
    if n == 0 or n == 1:
        return memo[n]
    if memo[n] == -1:
        memo[n] = fib(n - 1) + fib(n - 2)
    return memo[n]


res = fib(iter - 1)
b = bin(res)[2:]
_len = len(b)
for i in range(_len):
    print(reverse_dict[b[i]], end="")
print()
