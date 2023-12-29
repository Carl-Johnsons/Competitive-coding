class Solution:
    # Brute force
    # Time complexity: O(2^n) Because each iterate with len of n, recursive 2 time
    # Space complexity: O(n) maximum recursive depth is n
    def numTrees(self, n: int) -> int:
        def dp(n):
            if n <= 1:  # Case 0 still return 1
                return 1
            unique_way = 0
            for i in range(n):
                left = dp(i)
                right = dp(n - 1 - i)
                unique_way += left * right
            return unique_way

        return dp(n)

    # Memoization method
    # Time complexity: O(n^2) Recursive call in the loop
    # Space complexity: O(n) maximum recursive depth is n
    def numTrees(self, n: int) -> int:
        def dp(n, memo=dict()):
            self.counter += 1
            if n in memo:
                return memo[n]
            if n <= 1:  # Case 0 still return 1
                return 1
            unique_way = 0
            for i in range(n):
                left = dp(i, memo)
                right = dp(n - 1 - i, memo)
                unique_way += left * right
            memo[n] = unique_way
            return unique_way

        return dp(n)

    # DP Tabulation method
    # Time complexity:  O(n^2) Nested loop
    # Space complexity: O(n) array 'tabulation' take n space
    def numTrees(self, n: int) -> int:
        tabulation = [0 for _ in range(n + 1)]
        tabulation[0] = 1  # Base case
        tabulation[1] = 1
        for i in range(2, n + 1):
            for j in range(i):
                left = tabulation[j]
                right = tabulation[i - 1 - j]
                tabulation[i] += left * right
        return tabulation[n]

    # Memoization method optimize remove redudant call recursive method call
    # Time complexity: O(n^2) Recursive call in the loop
    # Space complexity: O(n) maximum recursive depth is n

    def numTrees(self, n: int) -> int:
        def dp(n, memo=dict()):
            if n in memo:
                return memo[n]
            if n <= 1:  # Case 0 still return 1
                return 1
            unique_way = 0
            loop = int(n / 2)
            for i in range(loop):
                left = dp(i, memo)
                right = dp(n - 1 - i, memo)
                unique_way += 2 * left * right
            if n % 2 == 1:
                unique_way += dp(int(n / 2), memo) ** 2
            memo[n] = unique_way
            return unique_way

        return dp(n)


sol = Solution()
tests = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
for test in tests:
    print(test, ":", sol.numTrees(test))
