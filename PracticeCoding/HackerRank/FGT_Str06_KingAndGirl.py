req = int(input())
str = input()
pattern = input()
_matches = 0

lastOccurences = [-1] * 26
_lenstr = len(str)
_lenpattern = len(pattern)

for i in range(_lenpattern):
    lastOccurences[ord(pattern[i]) - 65] = i

i = _lenpattern - 1
j = _lenpattern - 1
while i < _lenstr:
    if str[i] == pattern[j]:
        if j == 0:
            _matches += 1
            # Reset
            i = i + _lenpattern
            j = _lenpattern - 1
        else:
            i -= 1
            j -= 1
    else:
        skip = lastOccurences[ord(str[i]) - 65]
        i = i + _lenpattern - min(j, 1 + skip)
        j = _lenpattern - 1
print("Y" if _matches >= req else "N")
