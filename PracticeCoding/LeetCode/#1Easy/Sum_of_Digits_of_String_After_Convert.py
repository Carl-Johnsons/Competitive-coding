class Solution:
    def getLucky(self, s: str, k: int) -> int:
        sum = 0
        string = ""
        listChar = []
        for i in range(len(s)):
            listChar.append(str(ord(s[i]) - 97 + 1))
        string = "".join(listChar)
        for i in range(len(string)):
            sum += int(string[i])
        k -= 1
        while k != 0:
            newSum = 0
            k -= 1
            while sum != 0:
                newSum += sum % 10
                sum = int(sum / 10)
            sum = newSum
        return sum


sol = Solution()
s = "leetcode"
k = 2
print(sol.getLucky(s, k))
