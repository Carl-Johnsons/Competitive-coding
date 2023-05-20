class Solution:
    def summaryRanges(self, nums: list[int]) -> list[str]:
        arr = []
        if len(nums) == 0:
            return arr

        prev = cur = nums[0]
        i = 1
        for i in range(1, len(nums)):
            if nums[i] - nums[i - 1] == 1:
                cur = nums[i]
                continue

            if cur == prev:
                arr.append(str(cur))
            else:
                arr.append(str(prev) + "->" + str(cur))
            prev = cur = nums[i]
        # handle last pos
        if cur == prev:
            arr.append(str(cur))
        else:
            arr.append(str(prev) + "->" + str(cur))
        return arr


sol = Solution()
nums = [0, 1, 2, 4, 5, 6]
print(sol.summaryRanges(nums))
