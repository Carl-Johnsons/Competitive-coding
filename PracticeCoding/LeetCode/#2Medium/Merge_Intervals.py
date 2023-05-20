from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) == 1:
            return intervals

        newIntervals = []
        i = 1
        j = 0
        while i < len(intervals):
            while i < len(intervals) and intervals[i][0] <= intervals[i - 1][1]:
                i += 1
            newIntervals.append([intervals[j][0], intervals[i - 1][1]])
            j = i
            i += 1
            pass
        if j < len(intervals):
            newIntervals.append((intervals[len(intervals) - 1]))
        return newIntervals


intervals = [[1, 3], [2, 6], [8, 10], [11, 18], [18, 20]]
sol = Solution()
print(sol.merge(intervals))
