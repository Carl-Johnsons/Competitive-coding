class Solution:
    def destCity(self, paths: list[list[str]]) -> str:
        keySet = set([])
        valueSet = set([])
        rows = len(paths)
        for i in range(rows):
            keySet.add(paths[i][0])
            valueSet.add(paths[i][1])
        for item in valueSet.difference(keySet):
            return item


sol = Solution()
paths = [
    ["jMgaf WaWA", "iinynVdmBz"],
    [" QCrEFBcAw", "wRPRHznLWS"],
    ["iinynVdmBz", "OoLjlLFzjz"],
    ["OoLjlLFzjz", " QCrEFBcAw"],
    ["IhxjNbDeXk", "jMgaf WaWA"],
    ["jmuAYy vgz", "IhxjNbDeXk"],
]
print(sol.destCity(paths))
