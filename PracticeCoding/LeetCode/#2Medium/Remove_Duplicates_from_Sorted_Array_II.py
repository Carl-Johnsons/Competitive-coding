class Solution:
    def removeDuplicates(self, nums: list[int]) -> int:
        i = 1
        n = len(nums)
        prev = nums[0]
        counter = 1
        while i < n:
            curr = nums[i]
            if prev != curr:
                prev = curr
                counter = 1
            else:
                if counter == 2:
                    nums.pop(i)
                    nums.append(curr)
                    n -= 1
                    continue
                counter += 1
            i += 1
        return n


sol = Solution()
print(sol.removeDuplicates(nums=[1, 1, 1, 2, 2, 3]))
print(sol.removeDuplicates(nums=[0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3]))
print(sol.removeDuplicates(nums=[0, 1, 2, 3, 4, 5]))
print(sol.removeDuplicates(nums=[1]))
