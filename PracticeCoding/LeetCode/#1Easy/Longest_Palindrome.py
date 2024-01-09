class Solution:
    def longestPalindrome(self, s: str) -> int:
        d = dict()
        for char in s:
            d[char] = d.get(char, 0) + 1
        oneFrequency = 0
        counter = 0
        for key, value in d.items():
            remain = value - value % 2
            if value > 1:
                counter += remain
            if value % 2 == 1:
                oneFrequency = 1
        return counter + oneFrequency


sol = Solution()
print(sol.longestPalindrome(s="abccccdd"))
print(sol.longestPalindrome(s="a"))
