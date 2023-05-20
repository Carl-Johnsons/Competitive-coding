public class Sum_of_Left_Leaves {
    public static void main(String[] args) {
        Integer arr[] = { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = new TreeNode(0);
        bfsTestCase(root, arr, 0);
        System.out.println(bfs(root, false));
    }

    public static void bfsTestCase(TreeNode root, Integer[] testcase, int current) {
        if (current >= testcase.length || testcase[current] == null)
            return;

        root.val = testcase[current];
        if (current * 2 + 1 < testcase.length && testcase[current * 2 + 1] != null)
            root.left = new TreeNode();
        if (current * 2 + 2 < testcase.length && testcase[current * 2 + 2] != null)
            root.right = new TreeNode();
        bfsTestCase(root.left, testcase, current * 2 + 1);
        bfsTestCase(root.right, testcase, current * 2 + 2);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return bfs(root, false);
    }

    public static int bfs(TreeNode node, boolean isLeftChild) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null && isLeftChild) {
            return node.val;
        }

        return bfs(node.left, true) + bfs(node.right, false);
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
