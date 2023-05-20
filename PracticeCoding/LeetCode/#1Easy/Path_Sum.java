public class Path_Sum {
    static boolean isValid = false;

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(5);
        // root.left = new TreeNode(4);
        // root.left.left = new TreeNode(11);
        // root.left.left.left = new TreeNode(7);
        // root.left.left.right = new TreeNode(2);
        // root.right = new TreeNode(8);
        // root.right.left = new TreeNode(13);
        // root.right.right = new TreeNode(4);
        // root.right.right.right = new TreeNode(1);
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);

        System.out.println(hasPathSum(root, -5));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return isValid;
    }

    public static void dfs(TreeNode root, int targetSum, int curSum) {
        if (root == null || isValid) {
            return;
        }
        curSum += root.val;
        if (curSum == targetSum && root.left == null && root.right == null) {
            isValid = true;
            return;
        }

        if (root.left != null) {
            dfs(root.left, targetSum, curSum);
        }
        if (root.right != null) {
            dfs(root.right, targetSum, curSum);
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}