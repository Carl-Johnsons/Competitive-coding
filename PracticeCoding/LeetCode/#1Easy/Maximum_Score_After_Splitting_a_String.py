class Solution:
    def maxScore(self, s: str) -> int:
        zero_score = 1 if s[0] == "0" else 0
        one_score = 0
        n = len(s)
        max_score = -1
        for i in range(1, n):
            if s[i] == "1":
                one_score += 1
        max_score = zero_score + one_score
        for i in range(1, n - 1):
            if s[i] == "0":
                zero_score += 1
            else:
                one_score -= 1
            current_sum = zero_score + one_score
            if current_sum > max_score:
                max_score = current_sum
        return max_score


s = "00"
sol = Solution()
print(sol.maxScore(s))
