import heapq
from typing import Collection


class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        nums.sort(reverse=True)
        return nums[k - 1]


sol = Solution()
nums = [3, 2, 1, 5, 6, 4]
k = 2
print(sol.findKthLargest(nums, k))
