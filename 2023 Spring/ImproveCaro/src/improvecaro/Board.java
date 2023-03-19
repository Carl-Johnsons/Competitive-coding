/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvecaro;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */
public class Board extends JPanel {

    private ImproveCaro parent;
    private Graphics2D g;

    public Board(ImproveCaro parent, int width, int height) {
        this.parent = parent;
        setBounds(0, 0, width, height);
        setLayout(null);
        setOpaque(false);//Make the panel transparent but can still be drawn on it
        setBorder(BorderFactory.createLineBorder(Color.yellow));

    }

    @Override
    public void paint(Graphics graph) {
        super.paint(graph); //To change body of generated methods, choose Tools | Templates.
        g = (Graphics2D) graph;
        drawWinningLine(parent.getStart(), parent.getEnd());
    }

    /**
     * This function will draw the winning line if you setStart or setEnd, it
     * will drawn for you Don't forget to use repaint
     *
     * @param Start
     * @param End
     */
    private void drawWinningLine(Cell Start, Cell End) {
        if (Start == null || End == null) {
            return;
        }
        int x1, y1, x2, y2;
        int halfWidth = Start.getWidth() / 2;
        x1 = Start.getX() + halfWidth;
        y1 = Start.getY() + halfWidth;
        x2 = End.getX() + halfWidth;
        y2 = End.getY() + halfWidth;

        Stroke old = g.getStroke();
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(20));

        g.drawLine(x1, y1, x2, y2);

        g.setStroke(old);
        parent.clearStartEnd();
    }

}
