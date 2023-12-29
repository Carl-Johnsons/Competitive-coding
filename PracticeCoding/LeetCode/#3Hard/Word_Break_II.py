class Solution:
    # Using tabulation method
    def wordBreak(self, s: str, wordDict: list[str]) -> list[str]:
        n = len(s)
        paths = [[] for _ in range(n + 1)]
        for i in range(n):
            if i != 0 and len(paths[i]) == 0:
                continue
            for word in wordDict:
                next_index = len(word) + i
                if next_index <= n and s[i:next_index] == word:
                    if len(paths[i]) >= 1:
                        for path in paths[i]:
                            prev_word = path.copy()
                            prev_word.append(word)
                            paths[next_index].append(prev_word)
                    else:
                        prev_word = []
                        prev_word.append(word)
                        paths[next_index].append(prev_word)

        for i in range(len(paths[n])):
            paths[n][i] = " ".join(paths[n][i])
        return paths[n]


sol = Solution()
print(sol.wordBreak(s="catsanddog", wordDict=["cat", "cats", "and", "sand", "dog"]))
print(
    sol.wordBreak(
        s="catsanddog",
        wordDict=["cat", "cats", "and", "sand", "dog", "ca", "ts", "c", "t", "a"],
    )
)
print(
    sol.wordBreak(
        s="pineapplepenapple",
        wordDict=["apple", "pen", "applepen", "pine", "pineapple"],
    )
)
print(sol.wordBreak(s="catsandog", wordDict=["cats", "dog", "sand", "and", "cat"]))
