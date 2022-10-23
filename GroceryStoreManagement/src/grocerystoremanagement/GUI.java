package grocerystoremanagement;

import grocerystoremanagement.Custom.CustomJFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;

import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;

public class GUI {

    private CustomJFrame mainFrame;
    private JTextArea header;
    private JLabel StartJLabel;

    //Login Panel
    //Menu Panel
    private Timer timer = null;
    private Timer Flash = null;

    private int INCREMENT = 10;
    private JPanel MenuPanel;
    private JButton[] MenuButtons = new JButton[3];
    private JLabel[] MenuButtonLabel = new JLabel[MenuButtons.length];
    private JButton ExitButton;
    private JLabel ExitLabel;
    private int DelayTimer[] = new int[MenuButtons.length];
    private int ExitTime = (MenuButtons.length - 1) * 10;

    //Other
    File[] allFile = new File("src\\grocerystoremanagement\\res").listFiles();
    BufferedImage allImg[] = new BufferedImage[allFile.length];
    private JTextArea CoordinateArea;

    public GUI() throws IOException, FontFormatException {
        prepareGUI();
    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new GUI().ProgramStart();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void prepareGUI() throws IOException, FontFormatException {
        //MAIN FRAME
        mainFrame = new CustomJFrame();

        StartJLabel = new JLabel("CLICK ANYWHERE TO CONTINUE");
        StartJLabel.setFont(GetFuronsFont(60));
        StartJLabel.setForeground(new Color(50, 200, 200));
        StartJLabel.setBounds(300, 500, 750, 60);

        Flash = FlashLabel(StartJLabel, 100, 100);
        Flash.start();

        StartButtonEffect();
        //OTHER STUFF

        for (int i = 0; i < allFile.length; i++) {
            allImg[i] = ImageIO.read(allFile[i]);
        }
        ExitButton = new JButton();
        ExitButton.setBounds(1055, 871, 190, 65);
        ExitButton.setBorder(null);
        ExitButton.setOpaque(false);
        ExitButton.setContentAreaFilled(false);

        ExitLabel = new JLabel("DBSADHASKDJS");
        ExitLabel.setIcon(new ImageIcon(allImg[6].getScaledInstance(200, 160, Image.SCALE_SMOOTH)));
        ExitLabel.setBounds(1050, 800, 200, 160);

        CoordinateArea = new JTextArea();
        CoordinateArea.setBounds(10, 10, 100, 100);
        CoordinateArea.setEditable(false);
        CoordinateArea.setFont(GetFuronsFont(30));
        CoordinateArea.setOpaque(false);
        CoordinateArea.setForeground(Color.GREEN);

        //                  MENU PANEL
        MenuPanel = new JPanel();
        MenuPanel.setSize(mainFrame.getSize());
        MenuPanel.setOpaque(false);
        MenuPanel.setLayout(null);

        for (int i = 0; i < MenuButtons.length; i++) {
            MenuButtons[i] = new JButton();
            MenuButtons[i].setBounds(1280, 150 + (i % MenuButtons.length) * 150, 200, 70);
            MenuButtons[i].setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
            MenuButtons[i].setContentAreaFilled(false);
            MenuButtons[i].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK));

            ButtonEffect(i);
            DelayTimer[i] = 0 + (i % MenuButtons.length) * 10;

            MenuButtonLabel[i] = new JLabel();
            MenuButtonLabel[i].setBounds(MenuButtons[i].getBounds());
            MenuButtonLabel[i].setText("START");
            MenuButtonLabel[i].setFont(GetFuronsFont(40));
            MenuButtonLabel[i].setHorizontalAlignment(JLabel.CENTER);
            MenuButtonLabel[i].setForeground(new Color(160, 200, 210));
        }
        //                  MENU PANEL ADD ELEMENTS
        for (int i = 0; i < MenuButtons.length; i++) {
            MenuPanel.add(MenuButtonLabel[i]);
            MenuPanel.add(MenuButtons[i]);
        }
        //                  MAIN FRAME ADD ELEMENTS
        mainFrame.add(CoordinateArea);
        mainFrame.add(ExitButton);
        mainFrame.add(ExitLabel);
        mainFrame.add(MenuPanel);
        mainFrame.add(StartJLabel);
        mainFrame.add(mainFrame.BackgroundDecorate01);
        mainFrame.add(mainFrame.BackgroundContainer);
        mainFrame.add(mainFrame.StartButton);
    }

    public void ProgramStart() {

        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < MenuButtons.length; i++) {
                    moveButton(i);
                    timer.setDelay(5);
                }
                if (ExitTime < 0 && ExitLabel.getY() > 500) {
                    ExitLabel.setLocation(ExitLabel.getX(), ExitLabel.getY() - 5);
                    ExitButton.setLocation(ExitButton.getX(), ExitButton.getY() - 5);
                } else {
                    ExitTime--;
                }
            }
        });
        mainFrame.StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.StartButton.setVisible(false);
                Flash.stop();
                StartJLabel.setVisible(false);
                timer.start();
            }
        });
        mainFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                CoordinateArea.setText("X = " + e.getX() + "\nY = " + e.getY());
            }
        });
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    public void ButtonEffect(int i) {
        MenuButtons[i].addMouseListener(new MouseAdapter() {
            @Override
            //70, 150, 90
            public void mouseEntered(MouseEvent e) {
                MenuButtons[i].setBorder(new CompoundBorder(
                        BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
                        BorderFactory.createMatteBorder(0, 0, 6, 4, Color.BLACK)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MenuButtons[i].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                MenuButtons[i].setIcon(new ImageIcon(allImg[5].getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
                MenuButtons[i].setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
                MenuButtonLabel[i].setForeground(new Color(200, 60, 60));
                try {
                    MenuButtonLabel[i].setFont(GetFuronsFont(55));
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MenuButtons[i].setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
                MenuButtons[i].setBorder(new CompoundBorder(
                        BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
                        BorderFactory.createMatteBorder(0, 0, 6, 4, Color.BLACK)));
                MenuButtonLabel[i].setForeground(new Color(160, 200, 210));
                try {
                    MenuButtonLabel[i].setFont(GetFuronsFont(45));
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public void StartButtonEffect() {
        mainFrame.StartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.StartButton.setBorder(BorderFactory.createLineBorder(new Color(70, 150, 90), 3));
                Flash.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.StartButton.setBorder(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mainFrame.StartButton.setIcon(new ImageIcon(allImg[5].getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
                mainFrame.StartButton.setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
                StartJLabel.setForeground(new Color(200, 60, 60));
                try {
                    Flash.stop();
                    StartJLabel.setVisible(true);
                    StartJLabel.setFont(GetFuronsFont(55));
                    StartJLabel.setLocation(StartJLabel.getX() + 20, StartJLabel.getY());

                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mainFrame.StartButton.setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
                mainFrame.StartButton.setBorder(BorderFactory.createLineBorder(new Color(70, 150, 90), 3));
                StartJLabel.setForeground(new Color(50, 200, 210));
                try {
                    StartJLabel.setFont(GetFuronsFont(60));
                    StartJLabel.setLocation(StartJLabel.getX() - 20, StartJLabel.getY());
                    Flash.stop();
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void moveButton(int i) {
        if (MenuButtons[i].getX() > 540) {
            if (DelayTimer[i] <= 0) {
                MenuButtons[i].setLocation(MenuButtons[i].getX() - INCREMENT, MenuButtons[i].getY());
                MenuButtonLabel[i].setBounds(MenuButtons[i].getBounds());
            } else {
                DelayTimer[i]--;
            }
        }
    }

    public Timer FlashLabel(JLabel label, int speed, int delay) {

        Timer labelTimer;

        labelTimer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setVisible(!label.isVisible());
            }
        });
        labelTimer.setInitialDelay(delay);
        labelTimer.setDelay(speed * 5);
        return labelTimer;
    }

    public Font GetFuronsFont(int Size) throws FontFormatException, IOException {
        File font_file = new File("src\\grocerystoremanagement\\futronsFont\\FutronsDemo.ttf");
        Font FutronsFont = Font.createFont(Font.TRUETYPE_FONT, font_file);
        Font sizedFont = FutronsFont.deriveFont((float) Size);
        return sizedFont;
    }
}
