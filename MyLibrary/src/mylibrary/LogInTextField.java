package mylibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class LogInTextField extends JTextField {

    private final Animator animator;
    private boolean animateHintText = true;
    private boolean mouseOver;
    private Color GoogleColor = new Color(204, 255, 255);
    private String Hint = "Something here";
    private boolean showHint;
    private float location;

    public LogInTextField() {
        setBorder(new EmptyBorder(20, 3, 10, 3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                repaint();
            }
        });
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                showing(false);
            }

            @Override
            public void focusLost(FocusEvent e) {
                showing(true);
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                animateHintText = getText().equals("");
            }

            @Override
            public void timingEvent(float fraction) {
                location = fraction;
                repaint();
            }

        };
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }

    private void showing(boolean b) {
        if (animator.isRunning()) {
            animator.stop();
        } else {
            location = 1;
        }
        animator.setStartFraction(1f - location);
        showHint = b;
        animator.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        if (mouseOver) {
            g2.setColor(new Color(204, 255, 255));
        } else {
            g2.setColor(Color.BLACK);
        }

        g2.fillRect(2, height - 2, width - 4, 2);
        createHintText(g2);
        createLineStyle(g2);
        g2.dispose();
    }

    public void createHintText(Graphics2D g2) {
        Insets inset = getInsets();
        g2.setColor(new Color(150, 150, 150));
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(Hint, g2);
        double height = getHeight() - inset.top - inset.bottom;
        double textY = (height - r2.getHeight()) / 2;
        double size;
        if (animateHintText) {
            if (showHint) {
                size = 18 * (1 - location);
            } else {
                size = 18 * location;
            }
        } else {
            size = 18;
        }
        g2.drawString(Hint, inset.right, (int) (inset.top + textY + ft.getAscent() - size));

    }

    public void createLineStyle(Graphics2D g2) {
        if (isFocusOwner()) {
            double width = getWidth() - 4;
            int height = getHeight();
            g2.setColor(new Color(4, 145, 210));
            double size;
            if (showHint) {
                size = width * (1 - location);
            } else {
                size = width * location;
            }
            double x = (width - size) / 2;
            g2.fillRect((int) x, height - 2, (int) size, 2);
        }

    }

    @Override
    public void setText(String t) {
        if (getText().equals(t)) {
            showing(t.equals(""));
        }
        super.setText(t);
    }

    public Color getGoogleColor() {
        return GoogleColor;
    }

    public void setGoogleColor(Color GoogleColor) {
        this.GoogleColor = GoogleColor;
    }

    public String getHint() {
        return Hint;
    }

    public void setHint(String Hint) {
        this.Hint = Hint;
    }

}
