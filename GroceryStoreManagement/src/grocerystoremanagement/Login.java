package grocerystoremanagement;

import grocerystoremanagement.Custom.LogInPassWordTextField;
import grocerystoremanagement.Custom.LogInTextField;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Login {

    //<editor-fold defaultstate="collapsed" desc="Declaration">
    private JFrame LogInframe;
    private GUI Program;
    //                  LOG IN PANEL
    private JPanel LogInPanel;
    private LogInTextField Username;
    private LogInPassWordTextField Password;
    private JLabel ImageContainer[] = new JLabel[2];
    private JButton LogInButton[] = new JButton[1];
    private JLabel LogInButtonLabel[] = new JLabel[LogInButton.length];
    private JLabel LogInBorder;

    //                  LOG IN SUCCESSFUL PANEL
    private JPanel LoginSuccessfulPanel;
    private JLabel loadingContainer;
    private JLabel CheckContainer;
    private JLabel notifyJLabel;
    private JLabel TitleBackground;
    private JLabel WelcomeLabel[] = new JLabel[30];
    private int RGB[] = new int[3];
    private JButton SettingButton;
    private JLabel SettingLabel;
    private JList SettingList;
    private JButton StartProgramButton;
    private JLabel StartProgramLabel;

    //Not Important
    private File[] allFiles = new File("src\\grocerystoremanagement\\res").listFiles();
    private BufferedImage allImg[] = new BufferedImage[allFiles.length];
    //</editor-fold>

    public Login() throws IOException, FontFormatException {
        createGUI();
    }

    private void createGUI() throws IOException, FontFormatException {
        Program = new GUI();

        LogInframe = new JFrame();
        LogInframe.setLocation(320, 180);
        LogInframe.setLayout(null);
        LogInframe.setSize(1280, 720);
        LogInframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogInframe.setResizable(false);
        LogInframe.setFocusable(true);

        //<editor-fold defaultstate="collapsed" desc="Log In Panel">
        LogInPanel = new JPanel();
        LogInPanel.setBounds(0, 0, 1280, 720);
        LogInPanel.setOpaque(false);
        LogInPanel.setLayout(null);
        LogInPanel.setFocusable(true);

        Username = new LogInTextField();
        Username.setBounds(450, 300, 400, 50);
        Username.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        Username.setHint("Username");

        Password = new LogInPassWordTextField();
        Password.setBounds(Username.getX(), Username.getY() + Username.getHeight() + 40, Username.getWidth(), Username.getHeight());
        Password.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        Password.setHint("Password");

        for (int i = 0; i < allFiles.length; i++) {
            allImg[i] = ImageIO.read(allFiles[i]);
        }

        for (int i = 0; i < ImageContainer.length; i++) {
            ImageContainer[i] = new JLabel();
        }

        for (int i = 0; i < LogInButton.length; i++) {
            LogInButton[i] = new JButton();
            LogInButton[i].setBounds(Password.getX(), Password.getY() + (Password.getHeight() + 40) * ((i + 1) % (LogInButton.length + 1)), Password.getWidth(), Password.getHeight());
            LogInButton[i].setIcon(new ImageIcon(allImg[12].getScaledInstance(LogInButton[i].getWidth() + 10, LogInButton[i].getHeight() + 10, Image.SCALE_SMOOTH)));
            LogInButton[i].setBorder(null);
            LogInButton[i].setContentAreaFilled(false);

            LogInButtonLabel[i] = new JLabel();
            LogInButtonLabel[i].setBounds(LogInButton[i].getBounds());
            LogInButtonLabel[i].setForeground(Color.WHITE);
            LogInButtonLabel[i].setFont(GetFuronsFont(30));
            LogInButtonLabel[i].setHorizontalAlignment(JLabel.CENTER);

            ButtonEffect(LogInButton[i], LogInButtonLabel[i]);
        }
        LogInButtonLabel[0].setText("LOG IN");

        ImageContainer[0].setBounds(30, 550, 300, 100);
        ImageContainer[0].setIcon(new ImageIcon(allImg[11].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));

        ImageContainer[1].setBounds(0, 0, 1280, 720);
        ImageContainer[1].setIcon(new ImageIcon(allImg[10].getScaledInstance(1280, 720, Image.SCALE_SMOOTH)));
        LogInBorder = new JLabel();
        LogInBorder.setBounds(400, 100, 500, 500);
        LogInBorder.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));

        //                  LOG IN PANEL ADD ELEMENTS
        LogInPanel.add(Username);
        LogInPanel.add(Password);
        LogInPanel.add(LogInBorder);

        for (int i = 0; i < LogInButton.length; i++) {
            LogInPanel.add(LogInButtonLabel[i]);
            LogInPanel.add(LogInButton[i]);
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Log In successful panel">
        //                  LOG IN SUCCESSFUL PANEL
        LoginSuccessfulPanel = new JPanel();
        LoginSuccessfulPanel.setBounds(0, 0, 1280, 720);
        LoginSuccessfulPanel.setOpaque(false);
        LoginSuccessfulPanel.setLayout(null);
        LoginSuccessfulPanel.setVisible(false);
        LoginSuccessfulPanel.setFocusable(true);

        loadingContainer = new JLabel(new ImageIcon("src\\grocerystoremanagement\\res\\_015_Loading-icon-unscreen.gif"));
        loadingContainer.setBounds(550, 250, 200, 200);

        CheckContainer = new JLabel(new ImageIcon("src\\grocerystoremanagement\\res\\_016_Check-icon-unscreen.gif"));
        CheckContainer.setBounds(loadingContainer.getBounds());
        CheckContainer.setVisible(false);

        notifyJLabel = new JLabel("Login Successful!");
        notifyJLabel.setBounds(CheckContainer.getX() - 50, CheckContainer.getY() + 130, CheckContainer.getWidth() + 100, CheckContainer.getHeight());
        notifyJLabel.setHorizontalAlignment(JLabel.CENTER);
        notifyJLabel.setForeground(Color.WHITE);
        notifyJLabel.setFont(GetFuronsFont(40));
        notifyJLabel.setVisible(false);

        TitleBackground = new JLabel();
        TitleBackground.setBounds(0, -50, 1280, 50);
        TitleBackground.setIcon(new ImageIcon(allImg[17].getScaledInstance(1280, 50, 0)));

        char[] t = "Welcome user ".toCharArray();
        for (int i = 0; i < WelcomeLabel.length; i++) {
            WelcomeLabel[i] = new JLabel();
            WelcomeLabel[i].setFont(GetFuronsFont(30));
            WelcomeLabel[i].setBounds(25 + (i % WelcomeLabel.length) * 25, -45, 30, 30);
            if (i < t.length) {
                WelcomeLabel[i].setText(t[i] + "");
            }
        }

        for (int i = 0; i < 3; i++) {
            RGB[i] = 0;
        }

        //SETTING
        SettingButton = new JButton();
        SettingButton.setBounds(1140, -50, 70, 50);
        SettingButton.setContentAreaFilled(false);
        SettingButton.setBorder(null);

        SettingLabel = new JLabel();
        SettingLabel.setBounds(1100, -50, 140, 50);
        SettingLabel.setIcon(new ImageIcon(allImg[19].getScaledInstance(150, 100, Image.SCALE_SMOOTH)));

        SettingList = new JList();
        DefaultListModel defaultListModel = new DefaultListModel();
        defaultListModel.add(0, "Log out");
        SettingList.setModel(defaultListModel);
        SettingList.setFont(GetFuronsFont(30));

        SettingList.setBounds(1050, -50, 150, 40 * defaultListModel.size());
        SettingList.setVisible(false);

        StartProgramButton = new JButton();
        StartProgramButton.setSize(LogInButton[0].getWidth(), LogInButton[0].getHeight());
        StartProgramButton.setIcon(LogInButton[0].getIcon());
        StartProgramButton.setLocation(LogInButton[0].getX(), 300);
        StartProgramButton.setContentAreaFilled(false);
        StartProgramButton.setBorder(null);
        StartProgramButton.setVisible(false);

        StartProgramLabel = new JLabel();
        StartProgramLabel.setBounds(StartProgramButton.getBounds());
        StartProgramLabel.setFont(LogInButtonLabel[0].getFont());
        StartProgramLabel.setHorizontalAlignment(JLabel.CENTER);
        StartProgramLabel.setText("START");
        StartProgramLabel.setForeground(Color.WHITE);
        StartProgramLabel.setVisible(false);

        ButtonEffect(StartProgramButton, StartProgramLabel);

        //                  LOG IN SUCCESSFUL PANEL ADD ELEMENTS
        LoginSuccessfulPanel.add(loadingContainer);
        LoginSuccessfulPanel.add(CheckContainer);
        LoginSuccessfulPanel.add(notifyJLabel);

        for (JLabel WelcomeLabel1 : WelcomeLabel) {
            LoginSuccessfulPanel.add(WelcomeLabel1);
        }
        LoginSuccessfulPanel.add(SettingLabel);
        LoginSuccessfulPanel.add(SettingButton);
        LoginSuccessfulPanel.add(TitleBackground);
        LoginSuccessfulPanel.add(SettingList);
        LoginSuccessfulPanel.add(StartProgramLabel);
        LoginSuccessfulPanel.add(StartProgramButton);

        //</editor-fold>
        //                  FRAME ADD ELEMENTS
        LogInframe.add(LogInPanel);
        LogInframe.add(LoginSuccessfulPanel);
        for (int i = 0; i < ImageContainer.length; i++) {
            LogInframe.add(ImageContainer[i]);
        }

    }

    public void Start() {
        Timer AnimationColor = new Timer();
        AnimationColor.schedule(new TimerTask() {
            @Override
            public void run() {
                RGB[0] = (RGB[1] + 5) % 256;
                RGB[1] = (RGB[2] + 2) % 256;
                RGB[2] = (RGB[0] + 1) % 256;

                WelcomeLabel[0].setForeground(new Color(RGB[0], RGB[1], RGB[2]));
                for (int i = 1; i < WelcomeLabel.length; i++) {
                    int RED = (WelcomeLabel[i - 1].getForeground().getRed() + 10) % 255;
                    int GREEN = (WelcomeLabel[i - 1].getForeground().getGreen()) % 255;
                    int BLUE = (WelcomeLabel[i - 1].getForeground().getBlue() + 2) % 255;

                    WelcomeLabel[i].setForeground(new Color(RED, GREEN, BLUE));
                }
            }
        }, 0, 150);

        LogInButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = "Welcome user ".length(); i < WelcomeLabel.length; i++) {
                    char t[] = Username.getText().toCharArray();
                    WelcomeLabel[i].setBounds(25 + (i % WelcomeLabel.length) * 25, -45, 30, 30);
                    int j = i - "Welcome user ".length();
                    if (j < t.length) {
                        WelcomeLabel[i].setText(t[j] + "");
                    } else {
                        WelcomeLabel[i].setText("");
                    }
                }

                Timer timer = new Timer();
                timer.schedule(moveComponentTopToBottom(LogInPanel, 720, 10), 0, 5);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        LoginSuccessfulPanel.setVisible(true);
                    }
                }, 200, 1);

                //LOADING
                Timer LoadingTimer = new Timer();
                LoadingTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        loadingContainer.setVisible(true);
                    }
                }, 200, 1);

                LoadingTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        loadingContainer.setVisible(false);
                        LoadingTimer.cancel();
                    }
                }, 1200, 1);
                //LOADING

                // +1000
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        CheckContainer.setVisible(true);
                        notifyJLabel.setVisible(true);
                    }
                }, 1200, 1);
                timer.schedule(moveComponentTopToBottom(TitleBackground, 0, 1), 2000, 10);
                timer.schedule(moveComponentTopToBottom(SettingButton, 0, 2), 2500, 10);
                timer.schedule(moveComponentTopToBottom(SettingLabel, 0, 2), 2500, 10);
                // +1800
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        CheckContainer.setVisible(false);
                        notifyJLabel.setVisible(false);
                        StartProgramButton.setVisible(true);
                        StartProgramLabel.setVisible(true);
                        timer.cancel();
                    }
                }, 3000, 1);
                int delay = 2300;
                Timer timer2 = new Timer();
                for (int i = 0; i < WelcomeLabel.length; i++) {
                    timer2.schedule(moveComponentTopToBottom(WelcomeLabel[i], 5, 5), delay + (i % WelcomeLabel.length) * 50, 10);
                }
                timer2.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        timer2.cancel();
                    }
                }, 4000, 1);
            }
        });
        LogInPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LogInPanel.grabFocus();
            }

        });

        SettingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (!SettingButton.isFocusOwner()) {
                            SettingLabel.setIcon(new ImageIcon(allImg[19].getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
                            SettingList.setLocation(SettingList.getX(), -50);
                            SettingList.setVisible(false);
                        } else {
                            SettingList.setVisible(true);
                            SettingLabel.setIcon(new ImageIcon("src\\grocerystoremanagement\\res\\_018_Setting_animation.gif"));
                        }
                    }
                }, 0, 100);
                timer.schedule(moveComponentTopToBottom(SettingList, 50, 2), 0, 5);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (SettingButton.isFocusOwner()) {
                            SettingLabel.setIcon(new ImageIcon(allImg[20].getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
                            SettingList.setVisible(true);
                        } else {
                            timer.cancel();
                        }
                    }
                }, 2000, 1);
                if (LoginSuccessfulPanel.isFocusOwner()) {
                    SettingList.setLocation(SettingList.getX(), -50);
                    SettingList.setVisible(false);
                    timer.cancel();
                }
            }
        });
        SettingList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SettingList.getSelectedValue().toString().compareToIgnoreCase("Log out") == 0) {
                    SettingList.setVisible(false);
                    LoginSuccessfulPanel.grabFocus();

                    Username.setText("");
                    Password.setText("");
                    StartProgramButton.setVisible(false);
                    StartProgramLabel.setVisible(false);

                    Timer timer = new Timer();

                    timer.schedule(moveComponentBottomToTop(LogInPanel, 0, 10), 200, 5);

                    timer.schedule(moveComponentBottomToTop(TitleBackground, -50, 1), 700, 5);
                    timer.schedule(moveComponentBottomToTop(SettingButton, -50, 2), 200, 5);
                    timer.schedule(moveComponentBottomToTop(SettingLabel, -50, 2), 200, 5);

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            timer.cancel();
                        }
                    }, 1000, 1);
                    int delay = 0;
                    Timer timer2 = new Timer();
                    for (int i = 0; i < WelcomeLabel.length; i++) {
                        timer2.schedule(moveComponentBottomToTop(WelcomeLabel[i], -45, 5), delay + (i % WelcomeLabel.length) * 50, 10);
                    }
                    timer2.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            timer2.cancel();
                        }
                    }, 2000, 1);
                }
            }

        });
        StartProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(()
                        -> {
                    LogInframe.setVisible(false);
                    Program.ProgramStart();
                });

            }
        });
        LoginSuccessfulPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                SettingLabel.setIcon(new ImageIcon(allImg[19].getScaledInstance(150, 100, Image.SCALE_SMOOTH)));
                SettingList.setLocation(SettingList.getX(), -50);
                SettingList.setVisible(false);
                LoginSuccessfulPanel.grabFocus();
            }

        });
        if (!Program.getMainFrameStatus()) {
            LogInframe.setVisible(true);
        }
        LogInframe.setVisible(true);
    }

    public void ButtonEffect(JButton button, JLabel label) {
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setIcon(new ImageIcon(allImg[14].getScaledInstance(button.getWidth() + 10, button.getHeight() + 10, Image.SCALE_SMOOTH)));
                try {
                    label.setFont(GetFuronsFont(label.getFont().getSize() + 10));
                } catch (FontFormatException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setIcon(new ImageIcon(allImg[13].getScaledInstance(button.getWidth() + 10, button.getHeight() + 10, Image.SCALE_SMOOTH)));
                try {
                    label.setFont(GetFuronsFont(label.getFont().getSize() - 10));
                } catch (FontFormatException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(new ImageIcon(allImg[13].getScaledInstance(button.getWidth() + 10, button.getHeight() + 10, Image.SCALE_SMOOTH)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(new ImageIcon(allImg[12].getScaledInstance(button.getWidth() + 10, button.getHeight() + 10, Image.SCALE_SMOOTH)));
            }
        });
    }

    public Font GetFuronsFont(int Size) throws FontFormatException, IOException {
        File font_file = new File("src\\grocerystoremanagement\\futronsFont\\FutronsDemo.ttf");
        Font FutronsFont = Font.createFont(Font.TRUETYPE_FONT, font_file);
        Font sizedFont = FutronsFont.deriveFont((float) Size);
        return sizedFont;
    }

    //<editor-fold defaultstate="collapsed" desc="Animation">
    public TimerTask moveComponentRightToLeft(Component o, int location, int speed) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (o.getX() > location) {
                    o.setLocation(o.getX() - speed, o.getY());
                }
            }
        };
        return tt;
    }

    public TimerTask moveComponentLeftToRight(Component o, int location, int speed) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (o.getX() < location) {
                    o.setLocation(o.getX() + speed, o.getY());
                }
            }
        };
        return tt;
    }

    public TimerTask moveComponentTopToBottom(Component o, int location, int speed) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (o.getY() < location) {
                    o.setLocation(o.getX(), o.getY() + speed);
                }
            }
        };
        return tt;
    }

    public TimerTask moveComponentBottomToTop(Component o, int location, int speed) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (o.getY() > location) {
                    o.setLocation(o.getX(), o.getY() - speed);
                }
            }
        };
        return tt;
    }
    //</editor-fold>

    public static void main(String[] args) throws IOException, FontFormatException {
        new Login().Start();
    }
}
