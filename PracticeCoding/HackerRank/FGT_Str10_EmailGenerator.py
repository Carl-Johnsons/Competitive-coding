import json
import re

inp = input()
jsonObject = json.loads(inp)

fullname = jsonObject["fullname"]
fullnames = re.split(" ", fullname)

_len = len(fullnames)
id = jsonObject["id"]
email = fullnames[_len - 1].lower()
for i in range(_len - 1):
    email += fullnames[i][0].lower()
email += id.lower() + "@fpt.edu.vn"
print(email)
