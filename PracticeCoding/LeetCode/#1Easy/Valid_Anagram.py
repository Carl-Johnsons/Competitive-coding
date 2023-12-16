# https://leetcode.com/problems/valid-anagram/?envType=daily-question&envId=2023-12-16
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if(len(s) != len(t)):
            return False
        d = dict()
        for i in range(len(s)):
            d[s[i]] = d.get(s[i]) + 1 if d.get(s[i]) is not None else 1      
            d[t[i]] = d.get(t[i]) - 1 if d.get(t[i]) is not None else -1
        for key in d:
            if d[key] != 0:
                return False
        return True


sol = Solution()
s = "anagram"
t = "nagaram"
print(sol.isAnagram(s, t))
