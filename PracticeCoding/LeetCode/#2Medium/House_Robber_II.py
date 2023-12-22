class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        # Special case:
        if n == 1:
            return nums[0]
        if n == 2:
            return max(nums[0], nums[1])
        return max(self.rob_from(0, nums), self.rob_from(1, nums))

    def rob_from(self, index: int, nums: list[int]):
        n = len(nums)
        tabulation = [None for _ in range(n)]
        for i in range(index, n):
            if tabulation[i] is None:
                tabulation[i] = nums[i] if i != 0 else -nums[i]
            if i + 2 < n:
                self.helper(tabulation, nums, i, i + 2, n)
            if i + 3 < n:
                self.helper(tabulation, nums, i, i + 3, n)
        max_value = max(abs(tabulation[n - 1]), abs(tabulation[n - 2]))
        # The tabulation[0] can be None if start from index 1
        if tabulation[n - 3] is not None:
            max_value = max(abs(tabulation[n - 3]), max_value)
        return max_value

    def helper(self, tabulation: list[int], nums: list[int], index, next_index, n):
        sum_so_far = (abs(tabulation[index]) + nums[next_index]) * (
            -1 if tabulation[index] < 0 else 1
        )
        if tabulation[next_index] is None:
            if next_index == n - 1 and sum_so_far < 0:
                return
            tabulation[next_index] = sum_so_far
            return

        larger_abs_value = sum_so_far
        # if there 2 value are equal, prefer the positive one
        if abs(sum_so_far) < abs(tabulation[next_index]):
            larger_abs_value = tabulation[next_index]
        if next_index == n - 1 and larger_abs_value < 0:
            return
        tabulation[next_index] = larger_abs_value


# nums = [[1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3]]
nums = [[200, 3, 140, 20, 10]]
# nums = [[2, 3, 2], [1, 2, 3, 1], [1, 2, 3], [1, 2, 4, 5, 1, 1]]
sol = Solution()
for num in nums:
    print(sol.rob(num))
