package mylibrary;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawGraph extends JPanel {

    private static final int BORDER_GAP = 60;

    private ArrayList<Integer> In = new ArrayList<>();
    private ArrayList<Date> DateIn = new ArrayList<>();
    private int GraphType;
    private int maxIn = 0;
    private int maxOut = 0;

    public final int GRAPH_180_DEGREE = 0;
    public final int GRAPH_90_DEGREE = 1;

    private static final int Y_HATCH = 10;

    private static final int GRAPH_POINT_WIDTH = 12;

    //Size of the graph
    private static final int PREF_WIDTH = 600;
    private static final int PREF_HEIGHT = 450;

    public DrawGraph(ArrayList<Integer> MoneyArray, ArrayList<Date> DateArray) {
        GraphType = GRAPH_180_DEGREE;
        for (Integer i : MoneyArray) {
            In.add(i);
        }
        for (Date d : DateArray) {
            DateIn.add(d);
        }
    }

    public DrawGraph(ArrayList<Integer> MoneyArray, ArrayList<Date> DateArray, int GraphType) {
        if (GraphType == GRAPH_180_DEGREE || GraphType == GRAPH_90_DEGREE) {
            this.GraphType = GraphType;
        } else {
            this.GraphType = GRAPH_180_DEGREE;
        }
        for (Integer i : MoneyArray) {
            In.add(i);
        }
        for (Date d : DateArray) {
            DateIn.add(d);
        }
    }

    public void setList(ArrayList<Integer> MoneyArray, ArrayList<Date> DateArray) {
        In.clear();
        DateIn.clear();

        for (Integer i : MoneyArray) {
            In.add(i);
        }
        for (Date d : DateArray) {
            DateIn.add(d);
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
        if (GraphType == GRAPH_180_DEGREE) {
            for (int i = 0; i < In.size(); i++) {
                int x1 = (int) (i * xScale + BORDER_GAP);
                int y1 = (int) (((maxIn - In.get(i)) * yScale + BORDER_GAP * 2) / 2);
                graphPoints.add(new Point(x1, y1));
            }
        }

        //Tao truc x va truc y
        g2.drawLine(BORDER_GAP, getHeight(), BORDER_GAP, 0);
        if (GraphType == GRAPH_180_DEGREE) {
            g2.drawLine(BORDER_GAP, (getHeight()) / 2, getWidth() - BORDER_GAP, (getHeight()) / 2);
        } else if (GraphType == GRAPH_90_DEGREE) {
            g2.drawLine(BORDER_GAP, getHeight() - 1, getWidth() - BORDER_GAP, getHeight() - 1);
        }

        Stroke oldStroke = g2.getStroke();

        //Y hatch
        int lastPoint = 0;
        int e = 0;
        for (int i = 0; i < Y_HATCH; i++) {
            int x0 = BORDER_GAP;
            int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
            int y0 = 0;
            int y1 = 0;
            if (GraphType == GRAPH_180_DEGREE) {
                if (i < Y_HATCH / 2) {
                    y0 = getHeight() / 2 - (((i + 1) * getHeight()) / Y_HATCH);
                    y1 = y0;
                } else {
                    y0 = getHeight() - ((i + 1) * getHeight()) / Y_HATCH + getHeight() / 2;
                    y1 = y0;
                }
            } else if (GraphType == GRAPH_90_DEGREE) {
                y0 = getHeight() - (((i + 1) * getHeight()) / Y_HATCH);
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

    public static void main(String[] args) {
        ArrayList<Integer> m = new ArrayList<>();
        ArrayList<Date> d = new ArrayList<>();
        JFrame fr = new JFrame();
        DrawGraph dr = new DrawGraph(m, d, 0);

        dr.setBounds(100, 100, 600, 400);
        fr.add(dr);
        fr.setBounds(320, 180, 1280, 720);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
