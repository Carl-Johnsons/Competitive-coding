inp = input().split()
list = list(map(int, inp))
middle = 0
_max = max(list)
_min = min(list)
for i in range(3):
    if list[i] != _max and list[i] != _min:
        middle = list[i]
print((_max - middle) + (middle - _min))
