class Solution:
    def isPathCrossing(self, path: str) -> bool:
        start = [0, 0]
        n = len(path)
        visited_path = dict()
        visited_path[(start[0], start[1])] = True
        for i in range(n):
            if path[i] == "N":
                start[1] += 1
            if path[i] == "S":
                start[1] -= 1
            if path[i] == "E":
                start[0] += 1
            if path[i] == "W":
                start[0] -= 1
            if visited_path.get((start[0], start[1])) is None:
                visited_path[(start[0], start[1])] = True
                continue
            return True
        return False


sol = Solution()
print(sol.isPathCrossing(path="NES"))
print(sol.isPathCrossing(path="NESWW"))
print(sol.isPathCrossing(path="NNSWWEWSSESSWENNW"))
