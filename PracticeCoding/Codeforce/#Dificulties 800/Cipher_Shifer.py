def solve():
    length = int(input())
    input_string = input()
    start_char = input_string[0]
    end_char = ""
    decrypt_txt = ""

    i = 1
    
    while i < length:
        end_char = input_string[i]
        i += 1
        if end_char != start_char:
            continue

        decrypt_txt += start_char
        if i < length - 1:
            start_char = input_string[i]
            i += 1
            end_char = ""

    print(decrypt_txt)


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
