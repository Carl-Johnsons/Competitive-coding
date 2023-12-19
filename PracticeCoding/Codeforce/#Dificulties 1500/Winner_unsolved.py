import sys


class TimeScore:
    def __init__(self, score: int, last_index: int):
        self.score = score
        self.last_index = last_index


MIN_INT = -sys.maxsize - 1
currentMax = MIN_INT
fastest_player_last_index = -1
fastest_player = ""
d = dict()
n = int(input())
for i in range(n):
    string = input().split(" ")
    name, score = string[0], int(string[1])
    ts = TimeScore(d.get(name).score + score if d.get(name) is not None else score, i)
    d[name] = ts
print("---------------")
for key, value in d.items():
    print(key,value.score,value.last_index)
    if value.score > currentMax:
        currentMax = value.score
        fastest_player_last_index = value.last_index
        fastest_player = key
        continue
    if value.score == currentMax:
        if value.last_index < fastest_player_last_index:
            fastest_player_last_index = value.last_index
            fastest_player = key

print(fastest_player)
