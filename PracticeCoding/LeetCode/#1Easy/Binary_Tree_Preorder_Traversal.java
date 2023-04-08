import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Preorder_Traversal {
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
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
