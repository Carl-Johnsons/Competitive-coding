import math
import sys


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxLevelSum(self, root: TreeNode) -> int:
        sumArr = []
        max = -sys.maxsize - 1
        maxIndex = -1
        self.maxSum(root, 0, sumArr)
        for i in range(len(sumArr)):
            if max < sumArr[i]:
                max = sumArr[i]
                maxIndex = i
        return maxIndex + 1

    def maxSum(self, root: TreeNode, order, sumArr):
        if root is None:
            return 0
        level = int(math.log(order + 1, 2))
        if level > len(sumArr) - 1:
            sumArr.append(0)
        sumArr[level] += root.val
        if root.left is not None:
            self.maxSum(root.left, 2 * order + 1, sumArr)
        if root.right is not None:
            self.maxSum(root.right, 2 * order + 2, sumArr)


def inputTestCase(node: TreeNode, order, arr) -> None:
    LeftNodeOrder = 2 * order + 1
    if LeftNodeOrder < len(arr) and arr[LeftNodeOrder] is not None:
        node.left = TreeNode(arr[LeftNodeOrder])
        inputTestCase(node.left, LeftNodeOrder, arr)
    RightNodeOrder = LeftNodeOrder + 1
    if RightNodeOrder < len(arr) and arr[RightNodeOrder] is not None:
        node.right = TreeNode(arr[RightNodeOrder])
        inputTestCase(node.right, RightNodeOrder, arr)


def InOrderTraversal(node: TreeNode) -> None:
    if node is None:
        return
    InOrderTraversal(node.left)
    print(" -> ", node.val, end="")
    InOrderTraversal(node.right)


testcase = [1, 7, 0, 7, -8, None, None]
root = TreeNode(testcase[0])
inputTestCase(root, 0, testcase)
InOrderTraversal(root)
sol = Solution()
print()
print(sol.maxLevelSum(root))
