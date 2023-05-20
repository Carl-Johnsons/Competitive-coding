class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        strs = s.split(" ")
        if len(strs) != len(pattern):
            return False
        
        charToWord = {}
        wordToChar = {}
        for char, word in zip(pattern, strs):
            if char in charToWord and charToWord[char] != word:
                return False
            if word in wordToChar and wordToChar[word] != char:
                return False

            charToWord[char] = word
            wordToChar[word] = char
        return True


sol = Solution()
pattern = "abc"
s = "dog cat dog"
print(sol.wordPattern(pattern, s))
