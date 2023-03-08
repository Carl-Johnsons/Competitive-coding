package nwc_app.data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JPanel;

public class Dijkstra_Edit_Path_Draw extends JPanel {
    
    private ArrayList<Point> points = new ArrayList<>();
    private char Selected_Point = 'A';
    
    private int Panel_x = 0;
    private int Panel_y = 0;
    
    private int BORDER_GAP = 30;
    
    private boolean Select_Index = false;

    //SIZE OF THE PANEL
    private int PREF_WIDTH = 800;
    private int PREF_HEIGHT = 300;
    //MODE
    private int MODE = 1;
    public final int NUMBER = 0;
    public final int ALPHABET = 1;
    //DATA
    private ShortestPathProblem Problem;
    
    public Dijkstra_Edit_Path_Draw() {
        Problem = new ShortestPathProblem();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        int data[][] = Problem.ReadData();
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int j = 0;
        for (Point i : points) {
            int x1 = (int) i.getX();
            int y1 = (int) i.getY();
            int x2 = 10;
            int y2 = 10;
            j++;
            g2.setColor(Color.red);
            g2.fillOval(x1 - 5, y1 - 5, x2, y2);
            g2.setColor(Color.BLACK);
            if (MODE == NUMBER) {
                g2.drawString((j - 1) + "", x1 - 5, y1 - 7);
            } else if (MODE == ALPHABET) {
                g2.drawString((char) ('A' + j - 1) + "", x1 - 5, y1 - 7);
            }
            
        }
        int temp = Selected_Point;
        if (MODE == ALPHABET) {
            temp -= 'A';
        } else if (MODE == NUMBER) {
            temp -= '0';
        }
        for (int i = 0; i < points.size(); i++) {
            if (i != temp && data[temp][i] != 0) {
                int x1 = 0;
                int y1 = 0;
                int x2 = 0;
                int y2 = 0;
                
                x1 = (int) points.get(temp).getX();
                y1 = (int) points.get(temp).getY();
                x2 = (int) points.get(i).getX();
                y2 = (int) points.get(i).getY();
                g2.drawLine(x1, y1, x2, y2);
            }
        }
    }
    
    public void setNumberOfPoint(int num) {
        points.clear();
        int dis_between_point = (getWidth() - (BORDER_GAP * 2)) / (num);
        if (MODE == ALPHABET) {
            char temp = Selected_Point;
            for (int i = 0; i < num; i++) {
                if ((char) (i + 'A') == temp) {
                    points.add(new Point(getWidth() / 2, 30));
                } else {
                    points.add(new Point(BORDER_GAP + dis_between_point * (i % num), 100));
                }
            }
        } else if (MODE == NUMBER) {
            int temp = Integer.parseInt(Selected_Point + "");
            for (int i = 0; i < num; i++) {
                if (i == temp) {
                    points.add(new Point(getWidth() / 2, 30));
                } else {
                    points.add(new Point(BORDER_GAP + dis_between_point * (i % num), 100));
                }
            }
        }
        if (!Select_Index) {
            int temp[][] = new int[getNumberOfPoint()][getNumberOfPoint()];
            Problem.SaveData(temp);
        } else {
            Select_Index = false;
        }
    }
    
    public int getNumberOfPoint() {
        return points.size();
    }
    
    public char getSelected_Point() {
        return Selected_Point;
    }
    
    public void setSelected_Point(char Selected_Point) {
        this.Selected_Point = Selected_Point;
        Select_Index = true;
        setNumberOfPoint(points.size());
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
    
}
