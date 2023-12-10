# https://codeforces.com/problemset/problem/1853/B

# Generating Function Theory
# https://math.libretexts.org/Bookshelves/Combinatorics_and_Discrete_Mathematics/Combinatorics_(Morris)/02%3A_Enumeration/08%3A_Generating_Functions_and_Recursion/8.03%3A_Using_Generating_Functions_to_Solve_Recursively-Defined_Sequences


def fibSeq(F0, F1, length):
    array = [F0, F1]

    for i in range(0, length - 2):
        array.append(array[i] + array[i + 1])
    print("F0 = ", F0, " F1 = ", F1, end="")
    print()
    print(array)


fibSeq(0, 1, 10)
fibSeq(6, 8, 10)
