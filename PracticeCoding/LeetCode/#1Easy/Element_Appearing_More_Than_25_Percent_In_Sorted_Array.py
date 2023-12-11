# https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/?envType=daily-question&envId=2023-12-11


class Solution:
    def findSpecialInteger(self, arr: list[int]) -> int:
        limited = int(arr.__len__() / 100 * 25)
        specialInt = arr[0]
        counter = 1
        for i in range(1, arr.__len__()):
            if arr[i] == specialInt:
                counter += 1
                if counter > limited:
                    return specialInt
            else:
                specialInt = arr[i]
                counter = 1
        return specialInt


arr = [1, 1]
sol = Solution()
print(sol.findSpecialInteger(arr))
