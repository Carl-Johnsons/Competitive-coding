package bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author CE170499 Nguyen Le Tai Duc
 */
public class BSTree {

    private BSTNode root;
    private String result;

    private ArrayList<BSTNode> path = new ArrayList<>();

    /*=============for balacing tree=============*/
    private ArrayList<NodeData> treeData = new ArrayList<>();

    /*=============for balancing tree=============*/

 /*=============for drawing=============*/
    int screenWidth;
    int yMin;

    /*=============for drawing=============*/
    /**
     * Default Constructor
     */
    public BSTree() {
        root = null;
        this.screenWidth = 0;
        this.yMin = 0;
    }

    /**
     * Declare a BST tree with screenWidth and y Min for drawing purpose
     *
     * @param screenWidth
     * @param yMin
     */
    public BSTree(int screenWidth, int yMin) {
        root = null;
        this.screenWidth = screenWidth;
        this.yMin = yMin;
    }

    /**
     * Add node to the tree (Normal insert)
     *
     * @param data
     */
    public void addNode(int data) {
        if (root == null) {
            root = new BSTNode(data, yMin, screenWidth);
            return;
        }

        boolean isAdded = false;
        BSTNode node = root;

        while (!isAdded) {
            if (data < node.getData()) {
                if (node.hasLeftChild()) {
                    node = node.getLeftChild();
                } else {
                    node.setLeftChild(new BSTNode(data));
                    isAdded = true;
                }
            } else if (data > node.getData()) {
                if (node.hasRightChild()) {
                    node = node.getRightChild();
                } else {
                    node.setRightChild(new BSTNode(data));
                    isAdded = true;
                }
            } else {
                node.setCount(node.getCount() + 1);
                isAdded = true;
            }
        }

    }

    /**
     * Add node to the tree, but only when balancing tree (Special Insert)
     *
     * @param data
     * @param count
     */
    public void addNode(int data, int count) {
        if (root == null) {
            root = new BSTNode(data, yMin, screenWidth);
            return;
        }

        boolean isAdded = false;
        BSTNode node = root;

        while (!isAdded) {
            if (data < node.getData()) {
                if (node.hasLeftChild()) {
                    node = node.getLeftChild();
                } else {
                    node.setLeftChild(new BSTNode(data, count));
                    isAdded = true;
                }
            } else if (data > node.getData()) {
                if (node.hasRightChild()) {
                    node = node.getRightChild();
                } else {
                    node.setRightChild(new BSTNode(data, count));
                    isAdded = true;
                }
            } else {
                node.setCount(node.getCount() + 1);
                isAdded = true;
            }
        }

    }

    /**
     * Search Node using recursive algorithm
     *
     * @param data
     * @return
     */
    public BSTNode search(int data) {
        if (root == null) {
            return null;
        }
        clearPath();
        BSTNode searchNode = search(root, data);

        // If the data don't exist
        if (path.get(path.size() - 1).getData() != data) {
            clearPath();
            searchNode = null;
        }
        return searchNode;
    }

    private BSTNode search(BSTNode node, int data) {
        if (node == null) {
            return null;
        }
        path.add(node);
        if (data == node.getData()) {
            return node;
        }

        if (data > node.getData()) {
            return search(node.getRightChild(), data);
        } else {
            return search(node.getLeftChild(), data);
        }
    }

    /**
     * Clear the path
     */
    public void clearPath() {
        if (!path.isEmpty()) {
            path.clear();
        }
    }

    /**
     * Pre-Order algorithm
     */
    public void preOrder() {
        result = "";
        preOrder(root);
    }

    private void preOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < node.getCount(); i++) {
            result += (node.getData() + ", ");
            System.out.print(node.getData() + ", ");
        }
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    /**
     * In-Order algorithm
     */
    public void inOrder() {
        result = "";
        inOrder(root);
    }

    private void inOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        for (int i = 0; i < node.getCount(); i++) {
            result += (node.getData() + ", ");
            System.out.print(node.getData() + ", ");
        }
        inOrder(node.getRightChild());
    }

    /**
     * Post-Order algorithm
     */
    public void postOrder() {
        result = "";
        postOrder(root);
    }

    private void postOrder(BSTNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        for (int i = 0; i < node.getCount(); i++) {
            result += (node.getData() + ", ");
            System.out.print(node.getData() + ", ");
        }
    }

    /**
     * SImply return the root of the tree
     *
     * @return
     */
    public BSTNode getRoot() {
        return this.root;
    }

    /**
     * get Result Traversal
     *
     * @return
     */
    public String getResult() {
        return result;
    }

    /**
     * get the Path when done traversal
     *
     * @return
     */
    public ArrayList<BSTNode> getPath() {
        return path;
    }

    /**
     * set the path
     *
     * @param path
     */
    public void setPath(ArrayList<BSTNode> path) {
        this.path = path;
    }

    /**
     * Remove node using recursive algorithm
     *
     * @param data
     * @return
     */
    public boolean removeNode(int data) {
        BSTNode current = search(data);
        return removeNode(current);
    }

    private boolean removeNode(BSTNode node) {
        if (node == null) {
            return false;
        }
        node.setCount(node.getCount() - 1);
        if (node.getCount() == 0) {
            if (node.isLeaf()) {
                node.getParent().removeLeafChild(node);
                return true;
            } else {
                BSTNode incomer;
                // Tim nut thay the ben tay trai
                if (node.hasLeftChild()) {
                    incomer = node.getLeftChild().findMaxNode();
                } else {
                    incomer = node.getRightChild().findMinNode();
                }
                //swap giua incomer va node
                node.setData(incomer.getData());
                node.setCount(incomer.getCount());

                //De de quy can set count thanh 1
                incomer.setCount(1);
                return removeNode(incomer);
            }
        }
        return false;
    }

    /**
     * This function will iterate ArrayList Path and return a String with
     * traversal result. Between the elements will have " -> ".
     *
     * @return
     */
    public String getTraversalResult() {
        String traversalResult = "";
        Iterator<BSTNode> iterator = path.iterator();
        while (iterator.hasNext()) {
            BSTNode next = iterator.next();
            for (int i = 0; i < next.getCount(); i++) {
                if (i > 0) {
                    traversalResult += " -> ";
                }
                traversalResult += next.getData() + "";

            }
            if (iterator.hasNext()) {
                traversalResult += " -> ";
            } else {
                traversalResult += ".";
            }
        }
        return traversalResult;
    }

    /**
     * Clear the tree by recursively taking the leaf child one by one.
     */
    public void clearTree() {
        clearPath();
        clearTree(this.root);
        this.root = null;
    }

    private void clearTree(BSTNode node) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            node.getParent().removeLeafChild(node);
        } else {
            clearTree(node.getLeftChild());
            clearTree(node.getRightChild());
        }
    }

    /**
     * BFS using Queue
     */
    public void BFS() {
        clearPath();

        Queue<BSTNode> q = new LinkedList<>();

        q.add(root);
        BSTNode current;
        while (!q.isEmpty()) {
            current = q.poll();
            if (current != null) {
                path.add(current);
                q.add(current.getRightChild());
                q.add(current.getLeftChild());
            }
        }
    }

    /**
     * DFS using Stack
     */
    public void DFS() {
        clearPath();
        Stack<BSTNode> s = new Stack<>();

        s.add(root);
        BSTNode current;
        while (!s.isEmpty()) {
            current = s.pop();
            if (current != null) {
                path.add(current);
                s.add(current.getRightChild());
                s.add(current.getLeftChild());
            }
        }
    }

    private void toArray(BSTNode node) {
        if (node == null) {
            return;
        }
        toArray(node.getLeftChild());
        treeData.add(new NodeData(node.getData(), node.getCount()));
        toArray(node.getRightChild());
    }

    /**
     * Balancing the tree using queue and add the middle of the range one by one
     * to the tree
     */
    public void Balacing() {
        treeData.clear();

        toArray(this.root);//Copy all node data before clearTree
        this.clearTree();//Remove all current node!

        Queue<BSTRange> q = new LinkedList<>();
        q.add(new BSTRange(0, treeData.size() - 1));

        BSTRange range;
        NodeData nodeData;
        int middleIndex, leftIndex, rightIndex;
        while (!q.isEmpty()) {
            range = q.poll();
            leftIndex = range.getLeftIndex();
            rightIndex = range.getRightIndex();

            if (leftIndex <= rightIndex) {
                middleIndex = (leftIndex + rightIndex) / 2;
                nodeData = treeData.get(middleIndex);
                this.addNode(nodeData.getData(), nodeData.getCount());
                q.add(new BSTRange(leftIndex, middleIndex - 1));
                q.add(new BSTRange(middleIndex + 1, rightIndex));
            }

        }

    }
}
