class Solution:
    def numberOfBeams(self, bank: list[str]) -> int:
        prev = cur = 0
        laserBeams = 0

        for i in range(len(bank)):
            cur = bank[i].count("1")
            if cur:
                laserBeams += cur * prev
                prev = cur
        return laserBeams


sol = Solution()
bank = ["011001", "000000", "010100", "001000"]
print(sol.numberOfBeams(bank))
