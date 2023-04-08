import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal {
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
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
