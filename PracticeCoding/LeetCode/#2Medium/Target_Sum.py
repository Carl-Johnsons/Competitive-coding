class Solution:
    def findTargetSumWays(self, nums: list[int], target: int) -> int:
        # Using memozing method
        memo = dict()

        def helper(nums, target, index, memo=dict()):
            if memo.get((index, target)) is not None:
                return memo[(index, target)]

            if index == -1:
                return 1 if target == 0 else 0

            memo[(index, target)] = helper(
                nums, target - nums[index], index - 1, memo
            ) + helper(nums, target + nums[index], index - 1, memo)
            return memo[(index, target)]

        result = helper(nums, target, len(nums) - 1, memo)
        # print(memo)
        return result


sol = Solution()
# nums = [0, 0, 0, 0, 0, 0, 0, 0, 1]
nums = [1, 1, 1, 1, 1]
target = 3
print(sol.findTargetSumWays(nums, target))
