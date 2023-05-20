public class Root_Equals_Sum_of_Children {
    public static void main(String[] args) {

    }

    public static boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
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
