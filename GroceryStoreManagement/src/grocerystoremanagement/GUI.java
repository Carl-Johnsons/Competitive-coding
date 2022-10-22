package grocerystoremanagement;

import grocerystoremanagement.Custom.CustomJFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
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

public class GUI {

    private CustomJFrame mainFrame;
    private JTextArea header;
    //START PANEL

    //Menu Panel
    private Timer timer = null;
    private int INCREMENT = 10;
    private JPanel MenuPanel;
    private JButton[] MenuButtons = new JButton[3];
    private JLabel[] MenuButtonLabel = new JLabel[MenuButtons.length];
    private int DelayTimer[] = new int[MenuButtons.length];

    //Other
    File[] allFile = new File("src\\grocerystoremanagement\\res").listFiles();
    BufferedImage allImg[] = new BufferedImage[allFile.length];
    private int GUIScale = 0;

    public GUI() throws IOException {
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
                }
            }
        });

    }

    public void prepareGUI() throws IOException {
        //MAIN FRAME
        mainFrame = new CustomJFrame();
        //OTHER STUFF
        MenuPanel = new JPanel();
        MenuPanel.setSize(mainFrame.getSize());
        MenuPanel.setOpaque(false);
        MenuPanel.setLayout(null);

        for (int i = 0; i < allFile.length; i++) {
            allImg[i] = ImageIO.read(allFile[i]);
        }

        //                  MENU PANEL
        for (int i = 0; i < MenuButtons.length; i++) {

            MenuButtons[i] = new JButton();
            MenuButtons[i].setBounds(1280, 150 + (i % MenuButtons.length) * 150, 200, 70);
            MenuButtons[i].setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
            MenuButtons[i].setContentAreaFilled(false);

            MenuButtons[i].setBorder(null);
            ButtonEffect(i);
            DelayTimer[i] = 0 + (i % MenuButtons.length) * 10;

            MenuButtonLabel[i] = new JLabel();
            MenuButtonLabel[i].setBounds(MenuButtons[i].getBounds());
            MenuButtonLabel[i].setText("START");
            MenuButtonLabel[i].setFont(new Font("Sans-serif", Font.BOLD, 40));
            MenuButtonLabel[i].setHorizontalAlignment(JLabel.CENTER);
            MenuButtonLabel[i].setForeground(new Color(160, 200, 210));
        }
        //                  MENU PANEL ADD ELEMENTS
        for (int i = 0; i < MenuButtons.length; i++) {
            MenuPanel.add(MenuButtonLabel[i]);
            MenuPanel.add(MenuButtons[i]);
        }
        //                  MAIN FRAME ADD ELEMENTS
        mainFrame.add(MenuPanel);
        mainFrame.add(mainFrame.BackgroundContainer);
    }

    public void ProgramStart() {

        //<editor-fold defaultstate="collapsed" desc="Resolution">
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < MenuButtons.length; i++) {
                    moveButton(i);
                    timer.setDelay(5);

                }
            }
        });
        mainFrame.StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.StartButton.setVisible(false);
                timer.start();
            }
        });
        mainFrame.ViewItem[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setSize(1280, 720);
                mainFrame.setLocation(320, 180);
                mainFrame.BackgroundContainer.setSize(mainFrame.getSize());
                mainFrame.BackgroundContainer.setIcon(new ImageIcon(allImg[0].getScaledInstance((int) mainFrame.getSize().getWidth(), (int) mainFrame.getSize().getHeight(), Image.SCALE_SMOOTH)));
                ResolutionFixed(mainFrame.getWidth(), mainFrame.getHeight());
            }
        });
        mainFrame.ViewItem[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setSize(1366, 768);
                mainFrame.setLocation(310, 170);
                mainFrame.BackgroundContainer.setSize(mainFrame.getSize());
                mainFrame.BackgroundContainer.setIcon(new ImageIcon(allImg[0].getScaledInstance((int) mainFrame.getSize().getWidth(), (int) mainFrame.getSize().getHeight(), Image.SCALE_SMOOTH)));
                ResolutionFixed(mainFrame.getWidth(), mainFrame.getHeight());
            }
        });
        mainFrame.ViewItem[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setSize(1600, 900);
                mainFrame.setLocation(160, 90);
                mainFrame.BackgroundContainer.setSize(mainFrame.getSize());
                mainFrame.BackgroundContainer.setIcon(new ImageIcon(allImg[0].getScaledInstance((int) mainFrame.getSize().getWidth(), (int) mainFrame.getSize().getHeight(), Image.SCALE_SMOOTH)));
                ResolutionFixed(mainFrame.getWidth(), mainFrame.getHeight());
            }
        });
        mainFrame.ViewItem[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setSize(1920, 1080);
                mainFrame.setLocation(0, 0);
                mainFrame.BackgroundContainer.setSize(mainFrame.getSize());
                mainFrame.BackgroundContainer.setIcon(new ImageIcon(allImg[0].getScaledInstance((int) mainFrame.getSize().getWidth(), (int) mainFrame.getSize().getHeight(), Image.SCALE_SMOOTH)));
                ResolutionFixed(mainFrame.getWidth(), mainFrame.getHeight());
            }
        });
        //</editor-fold>

        mainFrame.setVisible(true);
    }

    public void ButtonEffect(int i) {
        MenuButtons[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                MenuButtons[i].setBorder(BorderFactory.createLineBorder(new Color(70, 150, 90), 3));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MenuButtons[i].setBorder(null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                MenuButtons[i].setIcon(new ImageIcon(allImg[5].getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
                MenuButtons[i].setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
                MenuButtonLabel[i].setFont(new Font("Impact", Font.BOLD, 45));
                MenuButtonLabel[i].setForeground(new Color(200, 60, 60));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MenuButtons[i].setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
                MenuButtons[i].setBorder(BorderFactory.createLineBorder(new Color(70, 150, 90), 3));
                MenuButtonLabel[i].setFont(new Font("Sans-serif", Font.BOLD, 40));
                MenuButtonLabel[i].setForeground(new Color(160, 200, 210));
            }
        });
    }

    public void ResolutionFixed(int WIDTH, int HEIGHT) {
        switch (WIDTH) {
            case 1280:
                GUIScale = 0;
                break;
            case 1366:
                GUIScale = 1;
                break;
            case 1600:
                GUIScale = 2;
                break;
            case 1920:
                GUIScale = 3;
                break;
            default:
                break;
        }
        mainFrame.StartButton.setSize(mainFrame.getSize());
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
}
