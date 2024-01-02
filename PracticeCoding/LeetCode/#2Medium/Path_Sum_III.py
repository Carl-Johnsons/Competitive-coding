from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    # Brute force
    # def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
    #     def dfs(
    #         root: Optional[TreeNode],
    #         currentSum: int,
    #         targetSum: int,
    #         counter: list[int],
    #         visited=set(),
    #     ):
    #         if root is None:
    #             return 0
    #         visited.add(root)
    #         currentSum += root.val
    #         if targetSum == currentSum:
    #             counter[0] += 1
    #         if root.left is not None and root.left not in visited:
    #             dfs(root.left, 0, targetSum, counter)
    #         if root.right is not None and root.right not in visited:
    #             dfs(root.right, 0, targetSum, counter)
    #         dfs(root.left, currentSum, targetSum, counter)
    #         dfs(root.right, currentSum, targetSum, counter)

    #     counter = [0]
    #     dfs(root, 0, targetSum, counter)
    #     return counter[0]

    # Hash map method
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        self.counter = 0
        memo = {0: 1}

        def dfs(root: Optional[TreeNode], currentSum: int, targetSum: int, memo=dict()):
            if root is None:
                return 0
            currentSum += root.val
            oldSum = currentSum - targetSum
            self.counter += memo.get(oldSum, 0)
            memo[currentSum] = memo.get(currentSum, 0) + 1
            dfs(root.left, currentSum, targetSum, memo)
            dfs(root.right, currentSum, targetSum, memo)
            memo[currentSum] -= 1

        dfs(root, 0, targetSum, memo)
        return self.counter


def insertNodeBfs(root: TreeNode, arr: list[int], index: int):
    if index >= len(arr):
        root = None
        return
    root.val = arr[index]
    left_index = index + 1
    right_index = index + 2

    if left_index < len(arr) and arr[left_index] != None:
        root.left = TreeNode()
        insertNodeBfs(root.left, arr, left_index)
    if right_index < len(arr) and arr[right_index] != None:
        root.right = TreeNode()
        insertNodeBfs(root.right, arr, right_index)


# testcase = [10, 5, -3, 3, 2, None, 11, 3, -2, None, 1]
# testcase = [5, 4, 8, 11, None, 13, 4, 7, 2, None, None, 5, 1]
testcase = [1, None, 2, None, 3, None, 4, None, 5]
root = TreeNode()
insertNodeBfs(root, testcase, 0)

sol = Solution()
# print(sol.pathSum(root, targetSum=8))
# print(sol.pathSum(root, targetSum=22))
print(sol.pathSum(root, targetSum=3))
