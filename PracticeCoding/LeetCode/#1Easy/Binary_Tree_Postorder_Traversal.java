import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Postorder_Traversal {
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return list;
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
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
