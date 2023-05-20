import java.util.ArrayList;
import java.util.List;

public class Symmetric_Tree {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 10000, 3, 10000, 3 };
        TreeNode head = new TreeNode(arr[0]);

        head.left = new TreeNode(arr[1]);
        head.right = new TreeNode(arr[2]);

        head.left.left = new TreeNode(arr[3]);
        // head.left.right = new TreeNode(arr[4]);

        // head.right.left = new TreeNode(arr[5]);
        head.right.right = new TreeNode(arr[6]);

        System.out.println(isSymmetric(head));
    }

    public static boolean isSymmetric(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        bfs(list, root, 0);
        System.out.println(list);
        int a, b;
        for (int i = 0; i < list.size(); i++) {
            a = 0;
            b = list.get(i).size() - 1;
            while (a < b) {
                if (list.get(i).get(a) != list.get(i).get(b)) {
                    return false;
                }
                a++;
                b--;
            }
        }
        return true;
    }

    public static void bfs(
            List<List<Integer>> list,
            TreeNode node,
            int level) {
        if (list.size() < level + 1) {
            list.add(new ArrayList<>());
        }
        if (node == null) {
            list.get(level).add(null);
            return;
        }

        list.get(level).add(node.val);

        bfs(list, node.left, level + 1);
        bfs(list, node.right, level + 1);
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
