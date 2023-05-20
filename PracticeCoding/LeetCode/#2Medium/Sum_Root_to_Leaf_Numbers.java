public class Sum_Root_to_Leaf_Numbers {
    public static void main(String[] args) {
        Integer[] input = {1,2,3 };
        TreeNode root = new TreeNode(input[0]);
        InputTestCase(root, 0, input);

        System.out.println(sumNumbers(root));
    }

    public static void InputTestCase(TreeNode node, int order, Integer[] input) {
        int leftChildOrder = 2 * order + 1, rightChildOrder = leftChildOrder + 1;

        if (leftChildOrder < input.length && input[leftChildOrder] != null) {
            node.left = new TreeNode(input[leftChildOrder]);
            InputTestCase(node.left, leftChildOrder, input);
        }
        if (rightChildOrder < input.length && input[leftChildOrder] != null) {
            node.right = new TreeNode(input[rightChildOrder]);
            InputTestCase(node.right, rightChildOrder, input);
        }
    }

    static int totalSum = 0;

    public static int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root, root.val);
        return totalSum;
    }

    public static void dfs(TreeNode node, int curSum) {
        if (node.left == null && node.right == null) {
            totalSum += curSum;
            return;
        }
        if (node.left != null) {
            dfs(node.left, curSum * 10 + node.left.val);
        }
        if (node.right != null) {
            dfs(node.right, curSum * 10 + node.right.val);
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
