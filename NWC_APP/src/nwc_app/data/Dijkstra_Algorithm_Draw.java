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
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */
public class Dijkstra_Algorithm_Draw extends JPanel {
    
    private ArrayList<Point> points = new ArrayList<>();
    
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
    
    public Dijkstra_Algorithm_Draw() {
        Problem = new ShortestPathProblem();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("TimesRoman", Font.BOLD, 15));
        Color oldColor = g2.getColor();
        Stroke oldStroke = g2.getStroke();

        //DRAW LINE BETWEEN POINT
        int tempData[][] = Problem.ReadData();
        g2.setStroke(new BasicStroke(5));
        for (int i = 0; i < points.size(); i++) {
            for (int k = i + 1; k < points.size(); k++) {
                if (tempData[i][k] != 0) {
                    int x1 = (int) points.get(i).getX();
                    int y1 = (int) points.get(i).getY();
                    int x2 = (int) points.get(k).getX();
                    int y2 = (int) points.get(k).getY();
                    g2.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
                    g2.drawLine(x1, y1, x2, y2);
                }
            }
        }
        
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
                g2.drawString(j + "", x1 - 5, y1 - 7);
            } else if (MODE == ALPHABET) {
                g2.drawString((char) ('A' + j - 1) + "", x1 - 5, y1 - 7);
            }
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
        points.add(new Point(450, 100));
        
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
                    points.add(new Point(NewXPos, NewYPos));
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
}
