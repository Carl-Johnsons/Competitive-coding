public class Maximum_Depth_of_Binary_Tree {
    static int depth = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(15);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20, node, node1);
        TreeNode node4 = new TreeNode(3, node2, node3);

        System.out.println(maxDepth(node4));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        bfs(root, 1);
        return depth;
    }

    public static void bfs(TreeNode node, int level) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            depth = Math.max(depth, level);
            return;
        }
        if (node.left != null)
            bfs(node.left, level + 1);
        if (node.right != null)
            bfs(node.right, level + 1);
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
