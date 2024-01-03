from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        dictionary = dict()
        nums = sorted(nums)
        for i in range(n):
            dictionary[nums[i]] = i
        result = []
        i = -1
        while i + 1 < n:
            i += 1
            target = 0
            fixed = nums[i]
            target -= fixed
            j = i
            while j + 1 < n:
                j += 1
                index = dictionary.get(target - nums[j], -1)
                if index == -1 or index <= j or index <= i:
                    continue
                result.append([fixed, nums[j], nums[index]])
                # Go to last occurence to skip duplicate number
                j = dictionary[nums[j]]
            # Same as i
            i = dictionary[nums[i]]
        return result


sol = Solution()
# print(sol.threeSum(nums=[-1, 0, 1, 2, -1, -4]))
# print(sol.threeSum(nums=[0, 1, 1]))
# print(sol.threeSum(nums=[0, 0, 0]))
# print(sol.threeSum(nums=[-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4]))
# [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
print(sol.threeSum(nums=[-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]))
