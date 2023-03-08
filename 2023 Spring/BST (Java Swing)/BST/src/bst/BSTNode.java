package bst;

/**
 *
 * @author CE170499 Nguyen Le Tai Duc
 */
public class BSTNode {

    // Requirement for the tree to be existed
    private int data;
    private BSTNode leftChild;
    private BSTNode rightChild;

    // This variable will make iteration through the tree easier
    private BSTNode parent;

    /**
     * Declare a list in order to code easier
     */
    public enum NodeType {
        LEFT_CHILD,
        RIGHT_CHILD
    }

    // Other variable in order to draw or used in different function
    private int count;
    private int level;
    private int order;

    // And for Drawing in the Java Swing
    /* =========== drawing ============= */
    /**
     * A distance of each level
     */
    public static int LEVEL_DISTANCE = 60;
    private int x;
    private int y;
    private int width; // From x-canvas-left to x-node

    /* =========== drawing ============= */
    /**
     * Declaring the node with data
     *
     * @param data
     */
    public BSTNode(int data) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;

        this.level = 0;
        this.order = 0;

        // For Drawing
        this.width = this.x = this.y = 0;
    }

    /**
     * Declaring the node with data and count. Only when balancing the tree,
     * this function is used
     *
     * @param data
     * @param count
     */
    public BSTNode(int data, int count) {// For balacing tree
        this.data = data;
        this.count = count;
        this.leftChild = this.rightChild = this.parent = null;

        this.level = 0;
        this.order = 0;

        // For Drawing
        this.width = this.x = this.y = 0;
    }

    /**
     * Only use this constructor when declaring the root
     *
     * @param data
     * @param y
     * @param widthScreen
     */
    public BSTNode(int data, int y, int widthScreen) {
        this.data = data;
        this.count = 1;
        this.leftChild = this.rightChild = this.parent = null;

        this.level = 0;
        this.order = 0;

        // For Drawing
        this.x = this.width = widthScreen / 2;
        this.y = y;
    }

    /* ===============VALIDATE===============*/
    /**
     * Check if the node has child or not
     *
     * @return
     */
    public boolean hasChild() {
        return !isLeaf();
    }

    /**
     * Check if the node has left child or not
     *
     * @return
     */
    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    /**
     * Check if the node has right child or not
     *
     * @return
     */
    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    /**
     * Check if the node is root or not
     *
     * @return
     */
    public boolean isRoot() {
        return this.parent == null;
    }

    /**
     * Check if the node is leaf or not
     *
     * @return
     */
    public boolean isLeaf() {
        return this.leftChild == null && this.rightChild == null;
    }

    /**
     * Check if the node is not root and not leaf
     *
     * @return
     */
    public boolean isInside() {
        return !isLeaf() && !isRoot();
    }

    /* ===============VALIDATE===============*/
    /**
     * Finding max node starting from this node. Or Finding rightmost node
     * starting from this node.
     *
     * @return
     */
    public BSTNode findMaxNode() {
        // Tim max cua 1 nhanh cay nao do, co nghia la bat dau tu 1 node bat ki khong nhat thiet la root
        BSTNode node = this;
        while (node.hasRightChild()) {
            node = node.getRightChild();
        }
        return node;
    }

    /**
     * Finding min node starting from this node. Or Finding leftmost node
     * starting from this node.
     *
     * @return
     */
    public BSTNode findMinNode() {
        // Tim max cua 1 nhanh cay nao do, co nghia la bat dau tu 1 node bat ki khong nhat thiet la root
        BSTNode node = this;
        while (node.hasLeftChild()) {
            node = node.getLeftChild();
        }
        return node;
    }

    /**
     * remove the leaf child ( easiest condition when removing a node)
     *
     * @param ChildNode
     * @return
     */
    public boolean removeLeafChild(BSTNode ChildNode) {
        if (ChildNode == null) {
            return false;
        }
        if (ChildNode.isLeaf()) {
            if (this.hasLeftChild()) {
                if (this.getLeftChild().getData() == ChildNode.getData()) {
                    this.setLeftChild(null); //remove left child
                    return true;
                }
            }
            if (this.hasRightChild()) {
                if (this.getRightChild().getData() == ChildNode.getData()) {
                    this.setRightChild(null); //remove right child
                    return true;
                }
            }
        }
        return false;
    }

    /*==========GETTERS AND SETTERS ==========*/
 /* There are 3 modified function in the getters and setters function */
    /**
     * Change the parent of the current node
     *
     * @param parent
     * @param type
     */
    public void setParent(BSTNode parent, NodeType type) {
        this.parent = parent;

        this.level = parent.getLevel() + 1;
        // The left child order is 2n+1, otherwise is 2n+2
        this.order = parent.getOrder() * 2 + ((type == NodeType.LEFT_CHILD) ? 1 : 2);

        // For Drawing
        this.width = parent.getWidth() / 2;
        this.x = parent.getX() + ((type == NodeType.LEFT_CHILD) ? -this.width : this.width);
        this.y = parent.getY() + LEVEL_DISTANCE;
    }

    /**
     * Set the left child of this node and set parent of that left child node
     * back to this node (2 direction).
     *
     * @param leftChild
     */
    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
        if (leftChild != null) {
            this.leftChild.setParent(this, NodeType.LEFT_CHILD);
        }
    }

    /**
     * Set the right child of this node and set parent of that right child node
     * back to this node (2 direction).
     *
     * @param rightChild
     */
    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
        if (rightChild != null) {
            this.rightChild.setParent(this, NodeType.RIGHT_CHILD);
        }

    }

    /*================================================*/
    /**
     *
     * @return
     */
    public int getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public BSTNode getLeftChild() {
        return leftChild;
    }

    /**
     *
     * @return
     */
    public BSTNode getRightChild() {
        return rightChild;
    }

    /**
     *
     * @return
     */
    public BSTNode getParent() {
        return parent;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     *
     * @return
     */
    public int getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     *
     * @return
     */
    public static int getLEVEL_DISTANCE() {
        return LEVEL_DISTANCE;
    }

    /**
     *
     * @param LEVEL_DISTANCE
     */
    public static void setLEVEL_DISTANCE(int LEVEL_DISTANCE) {
        BSTNode.LEVEL_DISTANCE = LEVEL_DISTANCE;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /*==========GETTERS AND SETTERS ==========*/

}
