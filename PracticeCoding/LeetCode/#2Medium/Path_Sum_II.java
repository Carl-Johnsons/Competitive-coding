import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Path_Sum_II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new LinkedList<>();
        backTrackingDFS(list, new ArrayList<>(), root, targetSum, 0);
        return list;
    }

    public static void backTrackingDFS(
            List<List<Integer>> list,
            List<Integer> tempList,
            TreeNode node,
            int targerSum,
            int curSum) {
        if (node == null)
            return;

        tempList.add(node.val);
        curSum += node.val;
        if (curSum == targerSum && node.left == null && node.right == null) {
            list.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }

        if (node.left != null) {
            backTrackingDFS(list, tempList, node.left, targerSum, curSum);
        }
        if (node.right != null) {
            backTrackingDFS(list, tempList, node.right, targerSum, curSum);
        }

        curSum -= node.val;
        tempList.remove(tempList.size() - 1);
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