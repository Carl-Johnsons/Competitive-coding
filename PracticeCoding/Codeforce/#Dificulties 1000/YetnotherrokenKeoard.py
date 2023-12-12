def solve():
    str = list(input())
    n = len(str)
    upper = []
    lower = []
    for i in range(n):
        if(str[i] == 'b'):
            str[i] = ''
            if lower:
                str[lower.pop()] = ''
            continue
        if(str[i] =='B'):
            str[i] = ''
            if upper:
                str[upper.pop()] = ''
            continue
        if(str[i] >= 'a' and str[i] <='z'):
            lower.append(i)
        else:
            upper.append(i)
    print(''.join(str))


t = int(input())
while t != 0:
    t -= 1
    solve()
