def solve():
    rowLeft = 8
    columnContainWord = -1
    done = False
    resultString = ""
    while rowLeft != 0:
        rowLeft -= 1
        input_string = input()
        # If there are no other continous character
        if done:
            continue
        length = len(input_string)

        # Find the the column that has the word
        if columnContainWord == -1:
            for i in range(0, length):
                if input_string[i] >= "a" and input_string[i] <= "z":
                    columnContainWord = i
                    break
        # if there are no character skip
        if columnContainWord == -1:
            continue
        if input_string[columnContainWord] == ".":
            done = True
            continue
        resultString += input_string[columnContainWord]

    print(resultString)


testcase = int(input())
while testcase != 0:
    solve()
    testcase -= 1
