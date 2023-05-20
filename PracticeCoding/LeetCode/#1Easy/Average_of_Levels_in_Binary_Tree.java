import java.util.ArrayList;
import java.util.List;

public class Average_of_Levels_in_Binary_Tree {
    public static void main(String[] args) {

    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        bfs(root, list, number, 0);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) / number.get(i));
        }

        return list;
    }

    public static void bfs(TreeNode node, List<Double> list, List<Integer> number, int level) {
        if (node == null)
            return;
        if (list.size() < level + 1) {
            list.add(0.0);
            number.add(0);
        }
        list.set(level, node.val + list.get(level));
        number.set(level, number.get(level) + 1);
        bfs(node.left, list, number, level + 1);
        bfs(node.right, list, number, level + 1);
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
