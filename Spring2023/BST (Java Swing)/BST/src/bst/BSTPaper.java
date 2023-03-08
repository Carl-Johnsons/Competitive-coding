/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 *
 * @author CE170499 Nguyen Le Tai Duc
 */
public class BSTPaper extends JPanel {

    /**
     * Declaring NODE_RADIUS in order to change the radius of the node in the
     * tree when drawing
     */
    public static int NODE_RADIUS = 20;

    BSTree tree;
    int screenWidth;
    int yMin;

    Graphics2D g;

    /**
     *
     * @param tree
     * @param screenWidth
     * @param yMin
     */
    public BSTPaper(BSTree tree, int screenWidth, int yMin) {
        this.tree = tree;
        this.screenWidth = screenWidth;
        this.yMin = yMin;
    }

    @Override
    public void paint(Graphics graph) {
        super.paint(graph);
        this.g = (Graphics2D) graph;
        drawLevel();
        drawNode(this.tree.getRoot());
        drawPath(this.tree.getPath());
    }

    /**
     * This function will add the node to this tree
     *
     * @param data
     */
    public void addNode(int data) {
        this.tree.addNode(data);
        repaint();
    }

    /**
     * Drawing the node, only when this tree add node
     *
     * @param node
     */
    public void drawNode(BSTNode node) {
        if (node == null) {
            return;
        }
        int x = node.getX();
        int y = node.getY();

        g.setColor(Color.BLACK);

        g.setStroke(new BasicStroke(4));
        //Drawing left child
        if (node.hasLeftChild()) {
            g.drawLine(x, y, node.getLeftChild().getX(), node.getLeftChild().getY());
        }
        //Drawing right child
        if (node.hasRightChild()) {
            g.drawLine(x, y, node.getRightChild().getX(), node.getRightChild().getY());
        }
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(10));
        //Drawing a node
        g.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        g.setColor(Color.WHITE);
        g.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        g.setColor(Color.BLACK);

        drawCenteredString(g, node.getData() + "", new Rectangle(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2), new Font("Arial", Font.PLAIN, 20));

        if (node.getCount() != 1) {
            g.drawString("c = " + node.getCount(), x - NODE_RADIUS, y + NODE_RADIUS * 2);
        }

        g.setStroke(oldStroke);
        drawNode(node.getLeftChild());
        drawNode(node.getRightChild());

    }

    /**
     * Drawing the path, only when the Path is not empty
     *
     * @param pathway
     */
    public void drawPath(ArrayList<BSTNode> pathway) {
        if (pathway.isEmpty()) {
            return;
        }
        Stroke old = new BasicStroke();
        g.setColor(Color.ORANGE);

        g.setStroke(new BasicStroke(4));
        for (BSTNode node : pathway) {
            if (node.getParent() != null) {
                g.drawLine(node.getX(), node.getY(), node.getParent().getX(), node.getParent().getY());
            };
        }
        g.setStroke(new BasicStroke(10));

        Iterator<BSTNode> iteration = pathway.iterator();
        while (iteration.hasNext()) {
            BSTNode node = iteration.next();
            System.out.print("->" + node.getData());
            int x = node.getX();
            int y = node.getY();
            g.setColor(Color.red);

            if (!iteration.hasNext()) {
                g.setColor(Color.green);
            }

            g.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
            g.setColor(Color.white);
            g.fillOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
            g.setColor(Color.black);
            drawCenteredString(g, node.getData() + "", new Rectangle(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2), new Font("Arial", Font.PLAIN, 20));

        }
        g.setStroke(old);

    }

    /**
     * Drawing the level of the tree, as you can see in the screen when first
     * initiate the screen (The dashed line)
     */
    public void drawLevel() {
        int x = 1800;
        int y = 0;
        Stroke old = new BasicStroke();
        for (y = yMin; y < 800; y += yMin) {
            drawDashedLine(g, x, y, x - 1800, y);
        }
        g.setStroke(old);

        g.drawLine(x, 30, x, y - yMin - 50);
    }

    /**
     * This function will delete the node of this tree
     *
     * @param data
     */
    public void deleteNode(int data) {
        this.tree.removeNode(data);
        this.tree.clearPath();
        repaint();
    }

    /**
     * This function will delete ALL the nodes of this tree
     */
    public void clear() {
        this.tree.clearTree();
        repaint();
    }

    /**
     * This function will balance this tree
     */
    public void balancing() {
        this.tree.Balacing();
        repaint();
    }

    // ================ Function from Stack OverFlow ================
    /**
     * Drawing center string
     *
     * @param g
     * @param text
     * @param rect
     * @param font
     */
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }

    /**
     * Drawing dashed Line
     *
     * @param g
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g;
        //float dash[] = {10.0f};
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(x1, y1, x2, y2);
    }

    // ================ Function from Stack OverFlow ================
    // ================ Getters and Setters Section ================
    /**
     *
     * @return
     */
    public BSTree getTree() {
        return tree;
    }

    /**
     *
     * @param tree
     */
    public void setTree(BSTree tree) {
        this.tree = tree;
    }

    /**
     *
     * @return
     */
    public int getScreenWidth() {
        return screenWidth;
    }

    /**
     *
     * @param screenWidth
     */
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }
    // ================ Getters and Setters Section ================

}
