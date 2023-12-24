class Solution:
    def minJumps(self, arr: list[int]) -> int:
        n = len(arr)
        index_map = dict()
        for i in reversed(range(n)):
            if index_map.get(arr[i]) is None:
                index_map[arr[i]] = []
            # Skip the index if arr[i] is surround by indetical value
            if (
                (
                    i - 1 >= 0
                    and i + 1 < n
                    and (
                        arr[i - 1] != arr[i + 1]
                        or (
                            arr[i - 1] not in index_map.keys()
                            or arr[i + 1] not in index_map.keys()
                        )
                    )
                )
                or (i == n - 1)
                or len(index_map[arr[i]]) == 0
            ):
                index_map[arr[i]].append(i)


        visited = set()
        queue = []
        # Enqueue index
        queue.append(0)
        visited.add(0)
        level = 0
        while len(queue) > 0:
            queue_len = len(queue)
            for _ in range(queue_len):
                # Dequeue
                index = queue.pop(0)
                value = arr[index]
                if index == n - 1:
                    return level
                array = index_map[value]
                array.append(index + 1)
                array.append(index - 1)
                for i in array:
                    if i >= 0 and i < n and i not in visited:
                        visited.add(i)
                        queue.append(i)
                # IMPORTANT: Solve time limited exceed
                array.clear() # clear the array in the map in order not to re-enqueue
            level += 1
        return level


sol = Solution()
print(sol.minJumps(arr=[100, -23, -23, 404, 100, 23, 23, 23, 3, 404]))  # 3
print(sol.minJumps(arr=[7]))  # 0
print(sol.minJumps(arr=[7, 6, 9, 6, 9, 6, 9, 7]))  # 1
print(sol.minJumps(arr=[7, 7, 2, 1, 7, 7, 7, 3, 4, 1]))  # 3
print(sol.minJumps(arr=[7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 1]))  # 2
print(sol.minJumps(arr=[1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7]))  # 2