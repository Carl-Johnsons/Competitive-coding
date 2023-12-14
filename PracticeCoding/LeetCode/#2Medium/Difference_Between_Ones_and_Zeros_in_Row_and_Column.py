class Solution:
    def onesMinusZeros(self, grid: list[list[int]]) -> list[list[int]]:
        rows, cols = grid.__len__(), grid[0].__len__()

        oneRows = [0 for _ in range(rows)]
        oneCols = [0 for _ in range(cols)]
        zeroRows = [0 for _ in range(rows)]
        zeroCols = [0 for _ in range(cols)]
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    oneRows[i] += 1
                    oneCols[j] += 1
                else:
                    zeroRows[i] += 1
                    zeroCols[j] += 1
        for i in range(rows):
            for j in range(cols):
                grid[i][j] = oneRows[i] + oneCols[j] - zeroRows[i] - zeroCols[j]
        return grid


sol = Solution()
grid = [[1, 1, 1], [1, 1, 1]]
print(sol.onesMinusZeros(grid))
