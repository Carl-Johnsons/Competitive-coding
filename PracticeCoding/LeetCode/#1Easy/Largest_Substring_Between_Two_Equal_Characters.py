class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        first = dict()
        last = dict()
        n = len(s)
        for i in range(n):
            if s[i] not in first:
                first[s[i]] = i
            else:
                last[s[i]] = i
        max = -1
        for key, value in last.items():
            test = value - first[key] - 1
            if test > max:
                max = test
        return max


sol = Solution()
print(sol.maxLengthBetweenEqualCharacters(s="aa"))
print(sol.maxLengthBetweenEqualCharacters(s="abca"))
print(sol.maxLengthBetweenEqualCharacters(s="cbzxy"))
