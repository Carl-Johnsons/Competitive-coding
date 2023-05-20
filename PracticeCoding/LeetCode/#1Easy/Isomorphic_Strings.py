from collections import defaultdict


class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        dic = defaultdict(list)
        dic2 = defaultdict(list)
        for i in range(len(s)):
            dic[s[i]].append(i)

        for i in range(len(t)):
            dic2[t[i]].append(i)

        for key, key2 in zip(dic, dic2):
            if dic[key] != dic2[key2]:
                return False
        return True


sol = Solution()
s = "egg"
t = "add"

print(sol.isIsomorphic(s, t))
