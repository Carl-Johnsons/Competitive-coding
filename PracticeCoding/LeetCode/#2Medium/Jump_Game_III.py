class Solution:
    # Call len of the array is n
    #       Time complexity: O(n) (for the index operation) + O(n) (for DFS) = O(n)
    #       Space complexity: O(n)
    def canReach(self, arr: list[int], start: int) -> bool:
        try:
            arr.index(0)
        except:
            return False

        def dfs(arr: list[int], start: int) -> bool:
            if start < 0 or start >= len(arr):
                return False
            if arr[start] == 0:
                return True
            value = arr[start]
            # mark as visited
            arr[start] = -arr[start]
            positive_reach = False
            negative_reach = False
            if start + value < len(arr) and arr[start + value] >= 0:
                positive_reach = dfs(arr, start + value)
            if not positive_reach and start - value >= 0 and arr[start - value] >= 0:
                negative_reach = dfs(arr, start - value)
            can_reach_zero = positive_reach or negative_reach
            if can_reach_zero:
                return True
            return False

        return dfs(arr, start)


sol = Solution()
# print(sol.canReach(arr=[4, 2, 3, 0, 3, 1, 2], start=5))
# print(sol.canReach(arr=[4, 2, 3, 0, 3, 1, 2], start=0))
print(sol.canReach(arr=[3, 0, 2, 1, 2], start=2))
