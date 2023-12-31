class Solution:
    def calculate(self, s: str) -> int:
        num = 0
        result = 0
        op = "+"
        stack = []
        for ch in s + "+":
            if ch.isdigit():
                num = num * 10 + int(ch)
                continue
            if ch in "+-*/":
                if op == "+":
                    stack.append(num)
                elif op == "-":
                    stack.append(-num)
                elif op == "*":
                    stack.append(stack.pop() * num)
                elif op == "/":
                    stack.append(int(stack.pop() / num))
                op = ch
                num = 0
        for number in stack:
            result += number
        return result


sol = Solution()
print(sol.calculate(s="3+2*2"))  # 7
print(sol.calculate(s=" 3/2 "))  # 1
print(sol.calculate(s=" 3+5 / 2 "))  # 5
print(sol.calculate(s=" 33+5 / 2 +2+1*3"))  # 40
print(sol.calculate(s=" 33+5 / 2 +2+1*3*4 +1"))  # 50
print(sol.calculate(s=" 12-2+3-4"))  # 9
print(sol.calculate(s=" 12345"))  # 12345
print(sol.calculate(s="1*2-3/4+5*6-7*8+9/10"))  # -24
print(sol.calculate(s="876-142-978*2/8+4/2*2+40*2+282/2-137+855"))  # 1433
