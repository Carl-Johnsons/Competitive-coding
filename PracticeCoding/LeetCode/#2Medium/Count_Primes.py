import math
import time


class Solution:
    # Sieve of Eratosthenes METHOD take test case (n=5000000|result=348513) 0.4824340343475342 ms
    def countPrimes(self, n: int) -> int:
        if n <= 2:
            return 0
        prime = [True] * n
        prime[0] = prime[1] = False

        for i in range(2, int(math.ceil(math.sqrt(n)))):
            if not prime[i]:
                continue
            for j in range(i * i, n, i):
                prime[j] = False
        return sum(prime)

    # BRUTE FORCE METHOD take  test case (n = 5000000|result=348513) 20.379216194152832 ms

    # def countPrimes(self, n: int) -> int:
    #     if n <= 2:
    #         return 0
    #     prime = []
    #     count = 0
    #     for i in range(0, n + 1):
    #         prime.append(True)

    #     for i in range(2, n):
    #         if not prime[i]:
    #             continue
    #         if self.isPrime(i):
    #             j = i * 2
    #             while j < n:
    #                 prime[j] = False
    #                 j += i
    #     for i in range(2, n):
    #         if prime[i]:
    #             count += 1
    #     return count

    # def isPrime(self, number: int) -> bool:
    #     if number < 2:
    #         return False
    #     for i in range(2, int(math.sqrt(number)) + 1):
    #         if number % i == 0:
    #             return False
    #     return True


sol = Solution()
n = 5000000
# for i in range(1, n):
#     print(i, " | ", sol.countPrimes(i), end="")
#     print()

start = time.time()
result = sol.countPrimes(n)
end = time.time()
print(n, " | ", result, end="")
print()
print(end - start, "ms", end="")
