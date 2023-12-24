class Solution:
    def minOperations(self, s: str) -> int:
        start = int(s[0])
        other = 1 - start
        n = len(s)
        diff_start_counter = 0
        diff_other_counter = 1
        for i in range(1, n):
            other = start
            start = 1 - start
            if s[i] != str(start):
                diff_start_counter += 1
            if s[i] != str(other):
                diff_other_counter += 1
        return min(diff_start_counter, diff_other_counter)


sol = Solution()
print(sol.minOperations(s="0100"))
print(sol.minOperations(s="10"))
print(sol.minOperations(s="1111"))
print(sol.minOperations(s="10010100"))
