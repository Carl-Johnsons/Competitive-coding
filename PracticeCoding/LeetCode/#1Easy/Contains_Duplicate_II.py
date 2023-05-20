from collections import OrderedDict


class Solution:
    def containsNearbyDuplicate(self, nums: list[int], k: int) -> bool:
        dic = OrderedDict()
        first_key = 0
        for i in range(len(nums)):
            if i < k + 1:
                if nums[i] in dic:
                    return True
                dic[nums[i]] = i
            else:
                first_key = next(iter(dic.keys()))
                dic.__delitem__(first_key)
                if nums[i] in dic:
                    return True
                dic[nums[i]] = i
                pass
        return False


sol = Solution()
nums = [1, 2, 3, 1, 2, 3]
k = 2
print(sol.containsNearbyDuplicate(nums, k))
