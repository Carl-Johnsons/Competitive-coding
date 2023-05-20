public class Insert_into_a_Binary_Search_Tree {
    public static void main(String[] args) {

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        TreeNode currentNode = null, next = root;
        while (next != null) {
            currentNode = next;
            next = (val < next.val ? next.left : next.right);
        }
        if (val < currentNode.val)
            currentNode.left = new TreeNode(val);
        else
            currentNode.right = new TreeNode(val);
        return root;
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
