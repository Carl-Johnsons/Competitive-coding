class Solution:
    # Call row is n
    #       Time complexity: O(n^2)
    #       Space complexity: O(1)
    def minimumTotal(self, triangle: list[list[int]]) -> int:
        row = len(triangle)
        for i in range(row - 2, -1, -1):
            for j in range(len(triangle[i])):
                triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1])
        return triangle[0][0]


sol = Solution()
print(sol.minimumTotal(triangle=[[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]))
print(sol.minimumTotal(triangle=[[-10]]))
