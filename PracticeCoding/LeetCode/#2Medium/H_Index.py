class Solution:
    def hIndex(self, citations: list[int]) -> int:
        citations = sorted(citations, reverse=True)
        h = 0
        for i in range(citations.__len__()):
            if citations[i] >= i + 1:
                h = i + 1
            else:
                break
        return h


sol = Solution()
citations = [3, 1, 1]
print(sol.hIndex(citations))
