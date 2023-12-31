print(sol.calculate(s="3+2*2"))  # 7
print(sol.calculate(s=" 3/2 "))  # 1
print(sol.calculate(s=" 3+5 / 2 "))  # 5
print(sol.calculate(s=" 33+5 / 2 +2+1*3"))  # 40
print(sol.calculate(s=" 33+5 / 2 +2+1*3*4 +1"))  # 50
print(sol.calculate(s=" 12-2+3-4"))  # 9
print(sol.calculate(s=" 12345"))  # 12345