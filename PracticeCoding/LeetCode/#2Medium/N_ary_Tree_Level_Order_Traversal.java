import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;

public class N_ary_Tree_Level_Order_Traversal {
    public static void main(String[] args) {
        Node root = new Node(1);

        List<Node> child = new LinkedList<>();
        child.add(new Node(2));
        child.add(new Node(3));
        child.add(new Node(4));
        child.add(new Node(5));

        root.children = new LinkedList<>(child);

        child.clear();

        child.add(new Node(6));
        child.add(new Node(7));

        root.children.get(1).children = new LinkedList<>(child);

        child.clear();
        child.add(new Node(8));
        root.children.get(2).children = new LinkedList<>(child);

        child.clear();
        child.add(new Node(9));
        child.add(new Node(10));
        root.children.get(3).children = new LinkedList<>(child);

        child.clear();
        child.add(new Node(11));
        root.children.get(1).children.get(1).children = new LinkedList<>(child);

        child.clear();
        child.add(new Node(12));
        root.children.get(2).children.get(0).children = new LinkedList<>(child);

        child.clear();
        child.add(new Node(13));
        root.children.get(3).children.get(0).children = new LinkedList<>(child);

        child.clear();
        child.add(new Node(14));
        root.children.get(1).children.get(1).children.get(0).children = new LinkedList<>(child);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        // Using BFS
        if (root == null)
            return list;

        Queue<Node> q = new LinkedList<>();
        Queue<Integer> NumberOfChild = new LinkedList<>();

        Node cur;
        q.add(root);
        NumberOfChild.add(1);// 1 means the root

        int count = 0;
        int numsChild = 0;
        List<Integer> tempList = new ArrayList<>();

        while (!q.isEmpty()) {
            cur = q.poll();
            count++;
            if (cur.children != null) {
                Iterator<Node> iterator = cur.children.iterator();
                while (iterator.hasNext()) {
                    q.add(iterator.next());
                    numsChild++;
                }
            }

            tempList.add(cur.val);

            if (count == NumberOfChild.peek()) {
                NumberOfChild.add(numsChild);

                count = 0;
                numsChild = 0;
                NumberOfChild.poll();

                list.add(new LinkedList<>(tempList));
                tempList.clear();
            }
        }

        return list;
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
