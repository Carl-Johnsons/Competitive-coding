import re

str = input().strip()
strs = re.split("[ ]+", str)
_len = len(strs)
for i in range(_len):
    strs[i] = strs[i].capitalize()

print(" ".join(strs))
