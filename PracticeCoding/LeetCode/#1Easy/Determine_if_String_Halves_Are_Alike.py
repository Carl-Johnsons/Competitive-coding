class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        n = len(s)
        low = 0
        high = n - 1
        left = 0
        right = 0
        vowel = {"a", "e", "o", "u", "i", "A", "E", "O", "U", "I"}
        while low < high:
            if s[low] in vowel:
                left += 1
            if s[high] in vowel:
                right += 1
            low += 1
            high -= 1
        return left == right


sol = Solution()
print(sol.halvesAreAlike(s="book"))
print(sol.halvesAreAlike(s="textbook"))
