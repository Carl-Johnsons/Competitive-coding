    # Hash map method
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        self.counter = 0

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

        dfs(root, 0, targetSum)
        return self.counter