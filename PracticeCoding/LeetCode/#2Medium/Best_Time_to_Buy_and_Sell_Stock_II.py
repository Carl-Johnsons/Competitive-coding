from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        i = 0
        n = len(prices)
        profit = 0
        while i < n:
            j = i + 1
            buy = prices[i]
            if j < n and prices[j] <= prices[i]:
                i += 1
                continue
            while j < n:
                if buy < prices[j]:
                    break
                j += 1
            if j < n:
                profit += max(prices[j] - buy, 0)
                i = j
            else:
                i += 1
        return profit


sol = Solution()
# print(sol.maxProfit(prices=[7, 1, 5, 3, 6, 4]))
# print(sol.maxProfit(prices=[1, 2, 3, 4, 5]))
# print(sol.maxProfit(prices=[7, 6, 4, 3, 3, 6]))
print(sol.maxProfit(prices=[8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6]))
