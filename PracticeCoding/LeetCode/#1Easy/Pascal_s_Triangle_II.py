class Solution:
    # Brute force approach
    def getRow(self, rowIndex: int) -> list[int]:
        arr = [[1], [1, 1]]
        for i in range(2, rowIndex + 1):
            temp_arr = [0 for _ in range(i + 1)]
            temp_arr[-1] = 1
            temp_arr[0] = 1
            for j in range(1, i):
                temp_arr[j] = arr[i - 1][j - 1] + arr[i - 1][j]
            arr.append(temp_arr)
        return arr[rowIndex]

    # Using binomial coefficient (math equation)
    def getRow(self, rowIndex: int) -> list[int]:
        arr = [1]
        prev = 1
        for k in range(1, rowIndex + 1):
            next_val = prev * (rowIndex - k + 1) // k
            arr.append(next_val)
            prev = next_val
        return arr


sol = Solution()
print(sol.getRow(rowIndex=7))
print(sol.getRow(rowIndex=3))
print(sol.getRow(rowIndex=0))
print(sol.getRow(rowIndex=1))
