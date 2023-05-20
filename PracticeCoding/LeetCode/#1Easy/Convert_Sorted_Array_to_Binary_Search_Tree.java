import java.util.LinkedList;
import java.util.List;

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    static List<Integer> Traversal = new LinkedList<>();
    static TreeNode balanceTreeRoot;

    public static void main(String[] args) {
        int nums[] = { 3, 1 };
        TreeNode test = sortedArrayToBST(nums);
        inOrder(test);
        System.out.println(Traversal);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        balanceTreeRoot = null;
        balanceTree(nums, 0, nums.length - 1);
        System.gc();
        return balanceTreeRoot;
    }

    public static void balanceTree(int[] nums, int low, int high) {
        if (low > high)
            return;
        int mid = (low + high) / 2;
        addNode(balanceTreeRoot, nums[mid]);

        balanceTree(nums, low, mid - 1);
        balanceTree(nums, mid + 1, high);
    }

    public static void addNode(TreeNode root, int value) {
        if (balanceTreeRoot == null) {
            balanceTreeRoot = new TreeNode(value);
            return;
        }
        TreeNode cur = root, prev = null;

        while (cur != null) {
            prev = cur;
            if (value < cur.val)
                cur = cur.left;
            else if (value > cur.val)
                cur = cur.right;
            else {
                return;
            }
        }
        if (value < prev.val)
            prev.left = new TreeNode(value);
        else if (value > prev.val)
            prev.right = new TreeNode(value);
    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        Traversal.add(root.val);
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