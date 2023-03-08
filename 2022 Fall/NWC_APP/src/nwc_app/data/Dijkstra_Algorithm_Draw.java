/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwc_app.data;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.util.ArrayList;
import java.util.Random;
import static javafx.scene.transform.Transform.translate;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */
public class Dijkstra_Algorithm_Draw extends JPanel {

    private ArrayList<DraggablePoint> points = new ArrayList<>();

    private int PATH_LENGHT = 500;
    private int Panel_x = 0;
    private int Panel_y = 0;

    private int BORDER_GAP = 30;

    //SIZE OF THE PANEL
    private int PREF_WIDTH = 800;
    private int PREF_HEIGHT = 300;
    //MODE
    private int MODE = 1;
    public final int NUMBER = 0;
    public final int ALPHABET = 1;
    //DATA
    private ShortestPathProblem Problem;
    private char Selected_Point = 'A';
    private char End_Point = 'A';
    private int tx = 0;
    private int ty = 0;
    private Point mousePt;

    public Dijkstra_Algorithm_Draw() {
        Problem = new ShortestPathProblem();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePt = e.getPoint();
                for (DraggablePoint i : points) {
                    i.select(mousePt.x, mousePt.y); //check to see if selected--Houe will know
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (DraggablePoint i : points) {
                    i.unselect(); //button up--nobody should move any more
                }
                repaint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mousePt = e.getPoint();
                for (DraggablePoint i : points) {
                    i.move(mousePt.x, mousePt.y); //tell Houses to move--they will know if they should
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        FontRenderContext frc = g2.getFontRenderContext();
        Color oldColor = g2.getColor();
        Stroke oldStroke = g2.getStroke();

        int tempData[][] = Problem.ReadData();
        BasicStroke lineStroke = new BasicStroke(5);
        BasicStroke distanceStroke = new BasicStroke(3);
        for (int i = 0; i < points.size(); i++) {
            for (int k = i + 1; k < points.size(); k++) {
                if (tempData[i][k] != 0) {
                    int x1 = (int) points.get(i).getX();
                    int y1 = (int) points.get(i).getY();
                    int x2 = (int) points.get(k).getX();
                    int y2 = (int) points.get(k).getY();

                    //DRAW LINE BETWEEN POINT
                    g2.setColor(Color.BLACK);
                    g2.setStroke(lineStroke);
                    g2.drawLine(x1, y1, x2, y2);

                    //DRAW TOTAL DISTANCE
                    int realX = (x1 + x2) / 2;
                    int realY = ((y1 + y2) / 2) - 4;
                    g2.translate(realX, realY);
                    TextLayout tl = new TextLayout(tempData[i][k] + "", g.getFont().deriveFont(15F), frc);
                    Shape shape = tl.getOutline(null);
                    g2.setStroke(distanceStroke);
                    g2.draw(shape);
                    g2.setColor(Color.white);
                    g2.fill(shape);

                    g2.translate(-realX, -realY);
                }
            }
        }
        g2.setStroke(lineStroke);
        g2.setColor(Color.red);
        int s_index = Selected_Point;
        int e_index = End_Point;
        if (MODE == ALPHABET) {
            s_index -= 'A';
            e_index -= 'A';
        } else if (MODE == NUMBER) {
            s_index -= '0';
            e_index -= '0';
        }
        int t[][] = Problem.dijkstra(Problem.ReadData(), s_index);
        int dis = (t[e_index][1] == Integer.MAX_VALUE ? 0 : t[e_index][1]);

        if (dis > 0 && !Problem.Path.get(e_index).isEmpty()) {
            System.out.println(Problem.Path.get(e_index));
            ArrayList<Integer> target = new ArrayList<>(Problem.Path.get(e_index));
            for (int a = 0; a < target.size() - 1; a++) {
                int x1 = (int) points.get(target.get(a)).getX();
                int y1 = (int) points.get(target.get(a)).getY();
                int x2 = (int) points.get(target.get(a + 1)).getX();
                int y2 = (int) points.get(target.get(a + 1)).getY();
                g2.drawLine(x1, y1, x2, y2);
            }
        }

        int j = 0;
        for (DraggablePoint i : points) {
            int x1 = (int) i.getX() - 5;
            int y1 = (int) i.getY() - 7;
            int x2 = 10;
            int y2 = 10;
            j++;
            //Fill a circle at point
            g2.setStroke(lineStroke);
            
            g2.setColor(Color.red);
            g2.fillOval(x1, y1 + 2, x2, y2);
            
            g2.setColor(Color.BLACK);

            if (i.isSelected) {
                g2.setStroke(new BasicStroke(1));
                int tx1 = x1 + 5;
                int ty1 = 0;
                int tx2 = x1 + 5;
                int ty2 = getHeight();

                g2.drawLine(tx1, ty1, tx2, ty2);

                tx1 = 0;
                ty1 = y1 + 7;
                tx2 = getWidth();
                ty2 = y1 + 7;
                g2.drawLine(tx1, ty1, tx2, ty2);
            }
            g2.setStroke(lineStroke);
            //Draw vertices's name
            String s = "";
            if (MODE == NUMBER) {
                s = j + "";
            } else if (MODE == ALPHABET) {
                s = (char) ('A' + j - 1) + "";
            }
            g2.translate(x1, y1);
            TextLayout tl = new TextLayout(s, g.getFont().deriveFont(15F), frc);
            Shape shape = tl.getOutline(null);
            g2.setStroke(distanceStroke);
            g2.draw(shape);
            g2.setColor(Color.white);
            g2.fill(shape);

            g2.translate(-x1, -y1);
        }
        g2.setColor(oldColor);
        g2.setStroke(oldStroke);

    }

    public void setNumberOfPoint(int num) {

        //PATH_LENGHT = 500;
        PATH_LENGHT = num * (num <= 10 ? 30 : num <= 20 ? 15 : num <= 50 ? 10 : 7);
        //PATH_LENGHT /= num;
        points.clear();
        double angle = (double) 360 / num;
        double AngleScale = angle;
        points.add(new DraggablePoint(450, 100));

        if (num >= 2) {
            for (int i = 1; i < num; i++) {
                boolean near_Other_point = false;
                int NewXPos = (int) (points.get(i - 1).getX() + (PATH_LENGHT - (num * 5)) * Math.cos(Math.toRadians(angle)));
                int NewYPos = (int) (points.get(i - 1).getY() + (PATH_LENGHT - (num * 5)) * Math.sin(Math.toRadians(angle)));
//                System.out.println(i + ".X: " + NewXPos + "| Y:" + NewYPos);
//                System.out.println("Angle: " + angle);
//                System.out.println("Cos: " + Math.cos(angle));
//                System.out.println("Sin: " + Math.sin(angle));
                for (Point j : points) {
                    if (Math.abs(j.getX() - NewXPos) <= 20 && Math.abs(j.getY() - NewYPos) <= 20) {
                        near_Other_point = true;
                        break;
                    }
                }

                if ((NewXPos <= BORDER_GAP || NewXPos >= getWidth() - BORDER_GAP) || (NewYPos <= BORDER_GAP || NewYPos >= getHeight() - BORDER_GAP) || near_Other_point) {
                    i--;
                    angle++;
                } else {
                    points.add(new DraggablePoint(NewXPos, NewYPos));
                    angle += AngleScale;
                }

            }
        }
        System.gc();

    }

    @Override
    public int getX() {
        return Panel_x; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        return Panel_y; //To change body of generated methods, choose Tools | Templates.
    }

    public void setPanel_x(int Panel_x) {
        this.Panel_x = Panel_x;
    }

    public void setPanel_y(int Panel_y) {
        this.Panel_y = Panel_y;
    }

    public int getMODE() {
        return MODE;
    }

    public void setMODE(int MODE) {
        this.MODE = MODE;
    }

    public ShortestPathProblem getProblem() {
        return Problem;
    }

    public void setProblem(ShortestPathProblem Problem) {
        this.Problem = Problem;
    }

    @Override
    public void setLocation(int x, int y) {
        Panel_x = x;
        Panel_y = y;
        super.setLocation(x, y); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        Panel_x = x;
        Panel_y = y;
        super.setBounds(x, y, width, height); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_WIDTH, PREF_HEIGHT); //To change body of generated methods, choose Tools | Templates.
    }

    public char getSelected_Point() {
        return Selected_Point;
    }

    public void setSelected_Point(char Selected_Point) {
        this.Selected_Point = Selected_Point;
    }

    public char getEnd_Point() {
        return End_Point;
    }

    public void setEnd_Point(char End_Point) {
        this.End_Point = End_Point;
    }

    public ArrayList<DraggablePoint> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<DraggablePoint> points) {
        this.points = points;
    }

}

class DraggablePoint extends Point {

    boolean isSelected;
    int tx = 0;
    int ty = 0;

    public DraggablePoint() {
        super();
        isSelected = false;
    }

    public DraggablePoint(int x, int y) {
        super(x, y);
        isSelected = false;
    }

    public void select(int x, int y) {
        if (Math.abs(x - (this.x - 5)) <= 10 && Math.abs(y - (this.y - 7)) <= 10) {
            isSelected = true;
        }
    }

    public void unselect() {
        isSelected = false;
    }

    @Override
    public void move(int x, int y) {
        if (isSelected) {
            tx = x;
            ty = y;
            translate(tx - this.x, ty - this.y);
            this.x = tx;
            this.y = ty;
        }
    }
}
