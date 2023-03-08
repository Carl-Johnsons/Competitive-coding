package bst;

import java.util.ArrayList;

/**
 *
 * @author CE170499 Nguyen Le Tai Duc
 */
public class BSTDemo_CE170499 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.addNode(15);
        tree.addNode(12);
        tree.addNode(27);
        tree.addNode(5);
        tree.addNode(13);
        tree.addNode(19);
        tree.addNode(36);
        tree.addNode(11);
        tree.addNode(14);
        tree.addNode(22);
        tree.addNode(33);
        tree.addNode(48);
        tree.addNode(48);
        tree.addNode(25);
        tree.addNode(28);
        System.out.println("Search");
        tree.search(48);
        ArrayList<BSTNode> path = tree.getPath();
        for (BSTNode node : path) {
            System.out.print("-> " + node.getData());
        }
    }

}
