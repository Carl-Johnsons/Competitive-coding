def solve():
    n = int(input())
    alphabet = [0 for _ in range(26)]
    counter = 0
    log = input()
    for i in range(n):
        alphabet[ord(log[i]) - 65] += 1
    for i in range(26):
        if alphabet[i] >= i + 1:
            counter += 1
    print(counter)


tc = int(input())
while tc != 0:
    tc -= 1
    solve()
