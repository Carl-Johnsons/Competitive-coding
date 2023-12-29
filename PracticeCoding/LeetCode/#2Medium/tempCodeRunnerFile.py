    # def numTrees(self, n: int) -> int:
    #     self.counter = 0

    #     def dp(n, memo=dict()):
    #         self.counter += 1
    #         if n in memo:
    #             return memo[n]
    #         if n <= 1:  # Case 0 still return 1
    #             return 1
    #         unique_way = 0
    #         loop = int(n / 2)
    #         for i in range(loop):
    #             left = dp(i, memo)
    #             right = dp(n - 1 - i, memo)
    #             unique_way += 2 * left * right
    #         if n % 2 == 1:
    #             unique_way += dp(int(n / 2), memo) ** 2
    #         memo[n] = unique_way
    #         return unique_way

    #     result = dp(n)
    #     print(self.counter)
    #     return result