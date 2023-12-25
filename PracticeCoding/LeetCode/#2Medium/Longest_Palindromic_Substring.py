class Solution:
    # Call len of s is n
    #       Time complexity:
    #           Outer loop: O(n)
    #           Check left and right from the center with odd and even length: O(2n) -> O(n)
    #           Update the string when it has longer string: O(2n) -> O(n)
    #               Overall: O(n * n * n) -> O(n*3)
    #       Space complexity:
    #           Update the string when it has longer string: O(2n) -> O(n)
    #               Overall: O(n)
    def longestPalindrome(self, s: str) -> str:
        result = ""
        result_len = 0
        n = len(s)
        for i in range(n):
            # odd length
            left, right = i, i
            while left >= 0 and right < n and s[left] == s[right]:
                if right - left + 1 > result_len:
                    result = s[left : right + 1]
                    result_len = len(result)
                left -= 1
                right += 1
            # even length
            left, right = i, i + 1
            while left >= 0 and right < n and s[left] == s[right]:
                if right - left + 1 > result_len:
                    result = s[left : right + 1]
                    result_len = len(result)
                left -= 1
                right += 1
        return result


sol = Solution()
print(sol.longestPalindrome(s="babad"))
print(sol.longestPalindrome(s="cbbd"))
