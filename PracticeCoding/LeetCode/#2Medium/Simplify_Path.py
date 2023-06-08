class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        directory = path.split("/")
        # print(strs)
        for dir in directory:
            if dir == "." or not dir:
                continue
            if dir == "..":
                if stack:
                    stack.pop()
            else:
                stack.append(dir)
        return "/" + "/".join(stack)


sol = Solution()
path = "/..."
print(sol.simplifyPath(path))
