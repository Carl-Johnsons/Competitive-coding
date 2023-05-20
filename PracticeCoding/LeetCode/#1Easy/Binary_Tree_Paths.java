import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Binary_Tree_Paths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new LinkedList<>();
        BackTrackingDFS(path, new ArrayList<>(), root);
        return path;
    }

    public static void BackTrackingDFS(
            List<String> path,
            List<Integer> tempList,
            TreeNode root) {
        if (root == null)
            return;
        tempList.add(root.val);
        if (root.left == null && root.right == null) {
            path.add(tempList.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("->")));

            tempList.remove(tempList.size() - 1);
            return;
        }
        if (root.left != null)
            BackTrackingDFS(path, tempList, root.left);
        if (root.right != null)
            BackTrackingDFS(path, tempList, root.right);
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
