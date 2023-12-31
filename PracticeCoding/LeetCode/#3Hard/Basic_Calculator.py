class Solution:
    def calculate(self, s: str) -> int:
        return self.calculateInBracket(s, -1)

    def calculateInBracket(self, s: str, index: int) -> int:
        result = 0
        num = 0
        op = "+"
        stack = []
        if s[-1] != "+":
            s = s + "+"
        i = index
        while i + 1 < len(s):
            i += 1
            if s[i] == "(":
                arr = self.calculateInBracket(s, i)
                num, i = arr[0], arr[1]
                continue

            if s[i].isdigit():
                num = num * 10 + int(s[i])
            if s[i] in "+-*/)":
                if op == "+":
                    stack.append(num)
                if op == "-":
                    stack.append(-num)
                if op == "*":
                    stack.append(stack.pop() * num)
                if op == "/":
                    stack.append(int(stack.pop() / num))
                num = 0
                op = s[i]
                if s[i] == ")":
                    for num in stack:
                        result += num
                    return [result, i]
        for num in stack:
            result += num
        return result


sol = Solution()
print(sol.calculate(s="1 + 1"))  # 2
print(sol.calculate(s=" 2-1 + 2 "))  # 3
print(sol.calculate(s="(1+(4+5+2)-3)+(6+8)"))  # 23
print(sol.calculate(s="1"))  # 1
print(sol.calculate(s="-1-2"))  # -3
print(sol.calculate(s="-(1-2)"))  # 1
print(sol.calculate(s="(1+(41+5*2)*23)-(6+8)"))  # 29
