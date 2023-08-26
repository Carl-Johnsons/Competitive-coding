class Solution:
    def addDigits(self, num: int) -> int:
        if num < 10:
            return num
        return ((num - 10) % 9) + 1


sol = Solution()
num = 38

for i in range(1000):
    print(i, " -> ", sol.addDigits(i), sep="")
print(((784 - 10) % 9) + 1)
