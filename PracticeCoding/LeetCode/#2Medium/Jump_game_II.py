class Solution:
    # Using tabulation method
    # Call len of nums is m
    # Call the value in the nums is n
    #       Time complexity: O(m * n)
    #       Space complexity: O(m)

    # def jump(self, nums: list[int]) -> int:
    #     n = len(nums)
    #     tabulation = [0 for _ in range(n)]
    #     for i in range(n):
    #         value = nums[i]
    #         for j in range(i + 1, i + 1 + value):
    #             if j >= n:
    #                 break
    #             if tabulation[j] == 0:
    #                 tabulation[j] = tabulation[i] + 1
    #                 continue
    #             tabulation[j] = min(tabulation[i] + 1, tabulation[j])
    #     return tabulation[n - 1]

    # Optimize the algorithm
    #       Optimize by skipping the index
    #       Time complexity: O(m * n)
    #       Space complexity: O(1)
    def jump(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        max_reach = 0
        jump_counter = 0
        i = 0
        while i < n:
            max_reach = nums[i]
            start = i + 1
            end = i + 1 + max_reach if i + 1 + max_reach <= n else n
            max_jump = -1
            max_jump_index = 0
            diff_max_reach = 0
            for j in reversed(range(start, end)):
                if j == n - 1:
                    return jump_counter + 1
                if max_jump < nums[j] - diff_max_reach:
                    max_jump = nums[j] - diff_max_reach
                    max_jump_index = j
                diff_max_reach += 1
            jump_counter += 1
            i = max_jump_index
        return jump_counter


sol = Solution()
print(sol.jump(nums=[2, 3, 1, 1, 4]))  # 2
print(sol.jump(nums=[2, 3, 0, 1, 4]))  # 2
print(sol.jump(nums=[1, 2, 1, 1, 1]))  # 3
