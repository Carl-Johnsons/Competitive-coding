class Solution:
    # Using tabulation method
    def maxJumps(self, arr: list[int], d: int) -> int:
        n = len(arr)
        tabulation = [0] * n

        pass


sol = Solution()
print(sol.maxJumps(arr=[6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12], d=2))
#                      [1, 2, 2 , 3, 3, 3 , 2, 3, 0 , 0, 0 ]
# max = 3
# step = 1
# next = 2
# current = max
print(sol.maxJumps(arr=[3, 3, 3, 3, 3], d=3))
print(sol.maxJumps(arr=[7, 6, 5, 4, 3, 2, 1], d=1))
