import java.util.LinkedList;
import java.util.List;

public class N_ary_Tree_Postorder_Traversal {
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        List<Node> childNode = new LinkedList<>();
        childNode.add(new Node(3));
        childNode.add(new Node(2));
        childNode.add(new Node(4));
        Node root = new Node(1, childNode);
        List<Node> childNode2 = new LinkedList<>();
        childNode2.add(new Node(5));
        childNode2.add(new Node(6));
        root.children.get(0).children = childNode2;
        System.out.println(postorder(root));
    }

    public static List<Integer> postorder(Node root) {
        PO(root);
        return list;
    }

    public static void PO(Node root) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            int len = root.children.size();
            for (int i = 0; i < len; i++) {
                PO(root.children.get(i));
            }
        }
        list.add(root.val);
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
