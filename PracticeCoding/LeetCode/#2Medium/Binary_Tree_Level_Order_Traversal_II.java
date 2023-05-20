import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_II {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(15);
        TreeNode root1 = new TreeNode(7);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20, root, root1);
        TreeNode root4 = new TreeNode(3, root2, root3);

        System.out.println(levelOrderBottom(root4));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        bfs(root, list, 0);
        Collections.reverse(list);
        return list;
    }

    public static void bfs(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() < level + 1) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        
        bfs(node.left, list, level + 1);
        bfs(node.right, list, level + 1);
        

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
