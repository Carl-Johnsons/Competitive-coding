class Solution:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        def helper(s, wordDict):
            n = len(s)
            tabulation = [False for _ in range(n + 1)]
            tabulation[0] = True
            for i in range(n + 1):
                if not tabulation[i]:
                    continue
                for word in wordDict:
                    try:
                        test = s[i : (i + len(word))]
                        if i + len(word) <= len(s) and test.index(word) == 0:
                            tabulation[i + len(word)] = True
                    except ValueError:
                        pass
            return tabulation[len(s)]

        return helper(s, wordDict)


sol = Solution()
print(sol.wordBreak(s="leetcode", wordDict=["leet", "code"]))
print(sol.wordBreak(s="applepenapple", wordDict=["apple", "pen"]))
print(sol.wordBreak(s="catsandog", wordDict=["cats", "dog", "sand", "and", "cat"]))
