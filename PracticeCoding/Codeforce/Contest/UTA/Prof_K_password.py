encrypted_code = input()
d = dict()
for i in range(10):
    d[input()] = i
start = 0
end = 10
for i in range(8):
    temp = encrypted_code[start:end]
    start = end
    end = end + 10
    print(d[temp], end="")
print()
