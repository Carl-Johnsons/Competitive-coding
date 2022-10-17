/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Acer
 */
public class DrawGraph extends JPanel {

    private static final int BORDER_GAP = 60;

    private ArrayList<Integer> In = new ArrayList<>();
    private ArrayList<Date> DateIn = new ArrayList<>();
    private int maxIn = 0;
    private int maxOut = 0;

    private static final int Y_HATCH = 10;

    private static final int GRAPH_POINT_WIDTH = 12;

    //Size of the graph
    private static final int PREF_WIDTH = 600;
    private static final int PREF_HEIGHT = 450;

    public DrawGraph(MoneyManagement a) {
        for (int i = 0; i < a.getList().size(); i++) {
            int temp = a.getList().get(i).getThuChi();
            In.add(temp);
            DateIn.add(a.getList().get(i).getCurrentDate());
            if (maxIn < temp) {
                maxIn = temp;
            }

        }
    }

    public void setList(MoneyManagement a) {
        In.clear();
        DateIn.clear();
        for (int i = 0; i < a.getList().size(); i++) {
            int temp = a.getList().get(i).getThuChi();
            In.add(temp);
            DateIn.add(a.getList().get(i).getCurrentDate());
            if (maxIn < Math.abs(temp)) {
                maxIn = Math.abs(temp);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (In.size() - 1);
        double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (maxIn - 1);
        
        //Tao cac diem tren do thi
        List<Point> graphPoints = new ArrayList<Point>();
        for (int i = 0; i < In.size(); i++) {
            int x1 = (int) (i * xScale + BORDER_GAP);
            int y1 = (int) (((maxIn - In.get(i)) * yScale + BORDER_GAP * 2) / 2);
            graphPoints.add(new Point(x1, y1));
        }

        //Tao truc x va truc y
        g2.drawLine(BORDER_GAP, getHeight(), BORDER_GAP, 0);
        g2.drawLine(BORDER_GAP, (getHeight()) / 2, getWidth() - BORDER_GAP, (getHeight()) / 2);

        Stroke oldStroke = g2.getStroke();
        
        //Y hatch
        int lastPoint = 0;
        int e = 0;
        for (int i = 0; i < Y_HATCH; i++) {
            int x0 = BORDER_GAP;
            int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
            int y0 = 0;
            int y1 = 0;
            if (i < Y_HATCH / 2) {
                y0 = getHeight() / 2 - (((i + 1) * getHeight()) / Y_HATCH);
                y1 = y0;
            } else {
                y0 = getHeight() - ((i + 1) * getHeight()) / Y_HATCH + getHeight() / 2;
                y1 = y0;
            }
            g2.drawLine(x0, y0, x1, y1);
            char t[] = "".toCharArray();
            if (i < Y_HATCH / 2) {
                e += maxIn / Y_HATCH * 11 / 4;
                t = Integer.toString(e).toCharArray();
                lastPoint = e;
            } else {
                lastPoint -= maxIn / Y_HATCH * 11 / 4;
                t = Integer.toString(-lastPoint).toCharArray();
            }
            g2.drawChars(t, 0, t.length, x0 - 50, y0);

        }
        // X hatch
        for (int i = 0; i < In.size(); i++) {
            try {
                int x0 = (i + 1) * (getWidth() - 2 * BORDER_GAP) / (In.size() - 1) + BORDER_GAP;
                int x1 = x0;
                int y0 = getHeight() / 2;
                int y1 = y0 - GRAPH_POINT_WIDTH;
                g2.drawLine(x0, y0, x1, y1);

                x0 = i * (getWidth() - 2 * BORDER_GAP) / (In.size() - 1) + BORDER_GAP;
                char t[] = new SimpleDateFormat("dd").format(DateIn.get(i)).toCharArray();
                g2.setStroke(new BasicStroke(3f));
                g2.drawChars(t, 0, t.length, x0, y0 + 15);
                g2.setStroke(oldStroke);
            } catch (ArithmeticException ex) {
            }
        }

        //Draw line between point in the graph
        g2.setStroke(new BasicStroke(3f));
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x0 = graphPoints.get(i).x;
            int y0 = graphPoints.get(i).y;
            int x1 = graphPoints.get(i + 1).x;
            int y1 = graphPoints.get(i + 1).y;
            g2.drawLine(x0, y0, x1, y1);
        }

        g2.setStroke(oldStroke);
        g2.setColor(Color.red);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x0 = graphPoints.get(i).x - (GRAPH_POINT_WIDTH / 2 - 4);
            int y0 = graphPoints.get(i).y - (GRAPH_POINT_WIDTH / 2 - 4);

            int OvalW = GRAPH_POINT_WIDTH - 4;
            int OvalH = GRAPH_POINT_WIDTH - 4;
            g2.fillOval(x0, y0, OvalW, OvalH);
        }

        g2.setColor(Color.BLUE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            char[] temp = In.get(i).toString().toCharArray();
            g2.drawChars(temp, 0, temp.length, graphPoints.get(i).x + 5 + temp.length, graphPoints.get(i).y + 5);
        }
        if (In.size() > 0) {
            char[] temp = In.get(In.size() - 1).toString().toCharArray();
            g2.drawChars(temp, 0, temp.length, graphPoints.get(graphPoints.size() - 1).x - 50, graphPoints.get(graphPoints.size() - 1).y - 10);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }
}
