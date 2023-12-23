class Solution:
    # Using memozing method
    # def findTargetSumWays(self, nums: list[int], target: int) -> int:
    #     memo = dict()
    #     def helper(nums, target, index, memo=dict()):
    #         if memo.get((index, target)) is not None:
    #             return memo[(index, target)]
    #         if index == -1:
    #             return 1 if target == 0 else 0
    #         memo[(index, target)] = helper(
    #             nums, target - nums[index], index - 1, memo
    #         ) + helper(nums, target + nums[index], index - 1, memo)
    #         return memo[(index, target)]
    #     result = helper(nums, target, len(nums) - 1, memo)
    #     return result

    # Using tabulation method

    def findTargetSumWays(self, nums: list[int], target: int) -> int:
        tabulation = [[0 for _ in range(len(nums))] for _ in range(target)]
        print(tabulation)


sol = Solution()
# nums = [0, 0, 0, 0, 0, 0, 0, 0, 1]
nums = [1, 1, 1, 1, 1]
target = 3
print(sol.findTargetSumWays(nums, target))
