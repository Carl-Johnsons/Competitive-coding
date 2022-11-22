package nwc_app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Coordinate_mode extends JPanel {

    private int Mouse_X = 0;
    private int Mouse_Y = 0;
    private int Mouse_last_X = 0;
    private int Mouse_last_y = 0;
    //States of the Cusor
    private Cursor defaultcCursor;
    private Cursor ActiveCursor;

    //CHECK MOUSE DRAGGING
    private boolean isMouseDragging;

    //Size of the MODE
    private static final int PREF_WIDTH = 1280;
    private static final int PREF_HEIGHT = 720;

    public Coordinate_mode() {

        isMouseDragging = false;
        
        defaultcCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        ActiveCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);

        setCursor(ActiveCursor);
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Mouse_X = e.getX();
                Mouse_Y = e.getY();

                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                isMouseDragging = true;

                Mouse_last_X = e.getX();
                Mouse_last_y = e.getY();

                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                isMouseDragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isMouseDragging = false;
                Mouse_X = Mouse_last_X;
                Mouse_Y = Mouse_last_y;
                repaint();
            }

        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        //DELETE PREVIOUS GRAPHIC
        Color oldColor = g.getColor();
        g.setColor(new Color(238, 238, 238));
        g.clearRect(0, 0, getWidth(), getHeight());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(oldColor);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //DRAW NOTIFICATION BOX
        if (!isMouseDragging) {
            //Tao truc X
            g2.drawLine(0, Mouse_Y, getWidth(), Mouse_Y);
            //Tao truc Y
            g2.drawLine(Mouse_X, 0, Mouse_X, getHeight());

            g.setColor(Color.WHITE);
            g.fillRect(Mouse_X + 5, Mouse_Y + 5, 90, 15);
            g.setColor(oldColor);
            g2.drawRect(Mouse_X + 5, Mouse_Y + 5, 90, 15);
            g2.drawString("X: " + Mouse_X + " Y: " + Mouse_Y, Mouse_X + 10, Mouse_Y + 18);
        } else {
            if (Mouse_last_X < Mouse_X) {
                if (Mouse_last_y < Mouse_Y) {
                    g2.drawRect(Mouse_last_X, Mouse_last_y, -Mouse_last_X + Mouse_X, -Mouse_last_y + Mouse_Y);
                } else {
                    g2.drawRect(Mouse_last_X, Mouse_Y, -Mouse_last_X + Mouse_X, Mouse_last_y - Mouse_Y);
                }
            } else {
                if (Mouse_last_y > Mouse_Y) {
                    g2.drawRect(Mouse_X, Mouse_Y, Mouse_last_X - Mouse_X, Mouse_last_y - Mouse_Y);
                } else {
                    g2.drawRect(Mouse_X, Mouse_last_y, Mouse_last_X - Mouse_X, -Mouse_last_y + Mouse_Y);
                }
            }
            g.setColor(Color.WHITE);
            g.fillRect(Mouse_last_X + 5, Mouse_last_y + 5, 90, 15);
            g.setColor(oldColor);

            g2.drawRect(Mouse_last_X + 5, Mouse_last_y + 5, 90, 15);
            g2.drawString("X: " + Mouse_last_X + " Y: " + Mouse_last_y, Mouse_last_X + 10, Mouse_last_y + 18);
        }
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_WIDTH, PREF_HEIGHT); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMouse_X() {
        return Mouse_X;
    }

    public void setMouse_X(int Mouse_X) {
        this.Mouse_X = Mouse_X;
    }

    public int getMouse_Y() {
        return Mouse_Y;
    }

    public void setMouse_Y(int Mouse_Y) {
        this.Mouse_Y = Mouse_Y;
    }

    public int getMouse_last_X() {
        return Mouse_last_X;
    }

    public void setMouse_last_X(int Mouse_last_X) {
        this.Mouse_last_X = Mouse_last_X;
    }

    public int getMouse_last_y() {
        return Mouse_last_y;
    }

    public void setMouse_last_y(int Mouse_last_y) {
        this.Mouse_last_y = Mouse_last_y;
    }

    public void UpdateCoordinate(int x, int y) {
        Mouse_X = x;
        Mouse_Y = y;
    }

    public void UpdateLastCoordinate(int x, int y) {
        Mouse_last_X = x;
        Mouse_last_y = y;
    }

    public boolean isIsMouseDragging() {
        return isMouseDragging;
    }

    public void setIsMouseDragging(boolean isMouseDragging) {
        this.isMouseDragging = isMouseDragging;
    }

    public void setCusorTypeCoordinate() {
        setCursor(ActiveCursor);
    }

    public void setCusorTypeDefault() {
        setCursor(defaultcCursor);
    }

    public Cursor getDefaultcCursor() {
        return defaultcCursor;
    }

    public Cursor getActiveCursor() {
        return ActiveCursor;
    }

    // TEST AREA
//    public static void main(String[] args) {
//        new Coordinate_mode().Start();
//    }
//
//    private void Start() {
//        JFrame temp = new JFrame();
//        JButton t = new JButton("clickme");
//        t.setBounds(600, 50, 200, 40);
//        temp.setBounds(320, 180, 1280, 720);
//        temp.setLayout(null);
//        temp.setResizable(false);
//        temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        temp.setLocationRelativeTo(null);
//
//        Coordinate_mode test = new Coordinate_mode();
//        test.setBounds(0, 0, 1280, 720);
//        test.setLayout(null);
//
//        test.setOpaque(false);
//        temp.add(t);
//        temp.add(test);
//
//        temp.setVisible(true);
//    }
}
