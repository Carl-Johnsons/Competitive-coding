class Solution:
    # Call amount is m
    # Call lenght of coin array is n
    #    Time complexity: O(m * n)
    #    Space complexity: O(m)

    def coinChange(self, coins: list[int], amount: int) -> int:
        tabluation = [-1 for _ in range(amount + 1)]
        tabluation[0] = 0
        for i in range(amount + 1):
            for coin in coins:
                if tabluation[i] == -1:
                    continue
                counter = tabluation[i] + 1
                next_index = i + coin
                if next_index > amount:
                    continue

                if tabluation[next_index] == -1 or tabluation[next_index] > counter:
                    tabluation[next_index] = counter
        return tabluation[amount]


sol = Solution()
# print(sol.coinChange(coins=[1, 2, 5], amount=11))
# print(sol.coinChange(coins=[2], amount=3))
# print(sol.coinChange(coins=[1], amount=0))
# print(sol.coinChange(coins=[5, 11], amount=27))
print(sol.coinChange(coins=[186, 419, 83, 408], amount=6249))
