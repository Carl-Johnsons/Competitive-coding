class Solution:
    # Using tabulation method
    # Call length of nums is n
    #       Time complexity: O (n ^ 2)
    #       Space complexity: O (n)
    def lengthOfLIS(self, nums: list[int]) -> int:
        n = len(nums)
        max_value = 1
        tabulation = [1 for _ in range(n)]
        for i in range(n):
            count_so_far = tabulation[i]
            for j in range(i + 1, n):
                if nums[i] < nums[j]:
                    tabulation[j] = max(count_so_far + 1, tabulation[j])
                    max_value = max(tabulation[j], max_value)
        return max_value


sol = Solution()
# print(sol.lengthOfLIS(nums=[10, 9, 2, 5, 3, 7, 101, 18]))
# print(sol.lengthOfLIS(nums=[0, 1, 0, 3, 2, 3]))
# print(sol.lengthOfLIS(nums=[7, 7, 7, 7, 7, 7, 7]))
# print(sol.lengthOfLIS(nums=[1, 3, 6, 7, 9, 4, 10, 5, 6]))
print(sol.lengthOfLIS(nums=[3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12]))
