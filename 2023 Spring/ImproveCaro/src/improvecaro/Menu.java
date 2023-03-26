/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvecaro;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Timer;
import javax.swing.JFrame;

/**
 *
 * @author Acer
 */
public class Menu extends JPanel {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    public static final String BACKGROUND = "bg";

    //Sub Frame
    private AboutUs frameAU = new AboutUs();
    private Guide frameG = new Guide();
    //Img
    public static final String TYPE[] = {"play", "guide", "about", "exit"};
    public static final String MODE = "mode";
    public static final String PAUSE = "pause";
    public static final String RETURN = "return";
    public static final ImageIcon gameStart = new ImageIcon(ImproveCaro.class.getClass().getResource("/img/Menu/gameStart.png"));
    public static final ImageIcon gameMode = new ImageIcon(ImproveCaro.class.getClass().getResource("/img/Menu/gameMode.png"));

    //State of the button
    public static final String ACTIVE = "active";
    public static final String HOVER = "hover";
    public static final String NORMAL = "";
    public static final String SELECT = "select";

    private JLabel lblsMenu[];
    private JLabel lblsMenuSelect[];
    private JLabel lblReturn;
    private JLabel bgMenu;

    private JLabel MenuTitle;

    //Sub-Panel
    private JPanel pnlModeSelect;
    private JPanel pnlMainMenu;
    private ImproveCaro parent;

    //Animation entity
    public static final String CloudName = "cloud";
    public static final String BikerName = "biker";
    public static final String ReversedSuffix = "-reversed";
    private JLabel Cloud[];
    private JLabel Biker[];

    public Menu(ImproveCaro parent) {
        this.parent = parent;
        init();
    }

    private void init() {
        frameAU.setVisible(false);
        frameG.setVisible(false);

        initThisPanel();
        initMenuBtns();

        Event();
//        JLabel lbl = new JLabel();
//        lbl.setBounds(200, 200, 200, 200);
//        lbl.setBackground(Color.red);
//        lbl.setOpaque(true);
//        lbl.setVisible(true);
//        this.add(lbl);
//        Lpane.add(lbl, 0);
        add(pnlModeSelect);
        add(MenuTitle);
        add(pnlMainMenu);
        add(bgMenu);

    }

    private void initThisPanel() {
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.yellow));

        initMainMenu();
        initAnimationEntity();
        initOther();

        int x = pnlMainMenu.getX() + (pnlMainMenu.getWidth() - 1100) / 2;

        MenuTitle = new JLabel();
        MenuTitle.setIcon(gameStart);
//        MenuTitle.setBorder(BorderFactory.createLineBorder(Color.yellow));
        MenuTitle.setBounds(x, 400, 1100, 100);
    }

    private void initMainMenu() {
        pnlMainMenu = new JPanel();
        pnlMainMenu.setBounds(250, 167, 1420, 675);
        pnlMainMenu.setLayout(null);
        pnlMainMenu.setOpaque(false);
    }

    private void initAnimationEntity() {
        initCloudEntity();
        Biker = new JLabel[2];
        for (int i = 0; i < Biker.length; i++) {
            Biker[i] = new JLabel();
            Biker[i].setSize(150, 150);
            Biker[i].setIcon(resizeImgIcon(getAnimationEntity(BikerName + ReversedSuffix), Biker[i].getWidth(), Biker[i].getHeight()));
            this.add(Biker[i]);
        }
        int gap = 70;
        Biker[0].setLocation(100, this.getHeight() - Biker[0].getHeight() - gap);
        Biker[1].setLocation(500, this.getHeight() - Biker[0].getHeight() - gap);

        //Make the cloud moving
        Timer timer = new Timer();
        timer.schedule(parent.moveComponentLeftToRightRepeat(Cloud[0], 1920, 1), 0, 30);
        timer.schedule(parent.moveComponentLeftToRightRepeat(Cloud[1], 1920, 1), 0, 40);
        timer.schedule(parent.moveComponentLeftToRightRepeat(Cloud[2], 1920, 1), 0, 50);
        timer.schedule(parent.moveComponentLeftToRightRepeat(Cloud[3], 1920, 1), 0, 30);
        timer.schedule(parent.moveComponentLeftToRightRepeat(Cloud[4], 1920, 1), 0, 40);

        timer.schedule(parent.moveComponentLeftToRightUpRepeat(Biker[0], 1920, 2), 0, 10);
        timer.schedule(parent.moveComponentLeftToRightRepeat(Biker[1], 1920, 1), 0, 10);
        parent.repaint();
    }

    private void initCloudEntity() {
        Cloud = new JLabel[5];

        int min = 200;
        int max = 400;
        Random rand = new Random();
        int value;

        for (int i = 0; i < Cloud.length; i++) {
            value = (rand.nextInt(max - min)) + min;
            Cloud[i] = new JLabel();
            Cloud[i].setSize(value, value / 3);
            Cloud[i].setIcon(resizeImgIcon(getAnimationEntity(CloudName), Cloud[i].getWidth(), Cloud[i].getHeight()));
            this.add(Cloud[i]);
        }
        Cloud[0].setLocation(1400, 30);
        Cloud[1].setLocation(1000, 150);
        Cloud[2].setLocation(200, 230);
        Cloud[3].setLocation(1920, 200);
        Cloud[4].setLocation(100, 10);
    }

    private void initOther() {
        int x, y, width, height;
        x = pnlMainMenu.getX();
        y = pnlMainMenu.getY();
        width = pnlMainMenu.getWidth();
        height = pnlMainMenu.getHeight();

        bgMenu = new JLabel();
        bgMenu.setBounds(0, 0, WIDTH, HEIGHT - 70);
        bgMenu.setIcon(autoResize(BACKGROUND, NORMAL, WIDTH, HEIGHT - 70));

        pnlModeSelect = new JPanel();
        pnlModeSelect.setBounds(x, y, width, height);
        pnlModeSelect.setLayout(null);
//        pnlModeSelect.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.yellow));
        pnlModeSelect.setOpaque(false);
        pnlModeSelect.setVisible(false);

        lblReturn = new JLabel();

        lblReturn.setBounds(10, 10, 70, 70);

        lblReturn.setIcon(autoResize(RETURN, NORMAL, 70, 70));
        lblReturn.setBorder(BorderFactory.createLineBorder(Color.black));

        lblReturn.setVisible(false);
        
        this.add(lblReturn);

    }

    private void initMenuBtns() {
        lblsMenu = new JLabel[4];
        for (int i = 0; i < lblsMenu.length; i++) {
            lblsMenu[i] = new JLabel();
            lblsMenu[i].setBounds(200 + (300 * i), 500, 200, 80);
            lblsMenu[i].setIcon(autoResize(TYPE[i], NORMAL, 200, 80));
            LabelEffect(lblsMenu[i], TYPE[i], 200, 80);
            pnlMainMenu.add(lblsMenu[i]);
        }

        lblsMenuSelect = new JLabel[10];
        for (int i = 0; i < lblsMenuSelect.length; i++) {
            lblsMenuSelect[i] = new JLabel();
            //lblsMenuSelect[i].setBorder(BorderFactory.createLineBorder(Color.yellow));

            if (i >= 4) {
                if (i < 8) {
                    lblsMenuSelect[i].setIcon(autoResize(1 + "", SELECT, 100, 100));
                } else {
                    lblsMenuSelect[i].setIcon(autoResize(2 + "", SELECT, 100, 100));
                }
                lblsMenuSelect[i].setVisible(false);
            }

            pnlModeSelect.add(lblsMenuSelect[i]);
            pnlModeSelect.setComponentZOrder(lblsMenuSelect[i], 0);
        }

        int x, y, width, height;
        x = lblsMenuSelect[1].getX();
        y = lblsMenuSelect[1].getY();
        int gap = 20;
        width = 100;

//        lblsMenuSelect[0].setBounds(480, 300, 600, 80);
        lblsMenuSelect[1].setBounds(600, 500, 300, 80);
        lblsMenuSelect[0].setIcon(autoResize(1 + "-" + MODE, NORMAL, 600, 80));
        lblsMenuSelect[1].setIcon(autoResize(2 + "-" + MODE, NORMAL, 300, 80));

        x = lblsMenuSelect[1].getX() - 20;
        y = lblsMenuSelect[1].getY() - 300;
        width = 400;
        height = 80;
        lblsMenuSelect[2].setIcon(autoResize(3 + "-" + MODE, NORMAL, width, height));
        lblsMenuSelect[3].setIcon(autoResize(4 + "-" + MODE, NORMAL, width, height));
        lblsMenuSelect[2].setBounds(x, y, width, height);
        lblsMenuSelect[3].setBounds(x, y + height * 2, width, height);

        LabelModeEffect(lblsMenuSelect[0], 1 + "-" + MODE, 600, 80);
        LabelModeEffect(lblsMenuSelect[1], 2 + "-" + MODE, 300, 80);
        LabelModeEffect(lblsMenuSelect[2], 3 + "-" + MODE, 400, 80);
        LabelModeEffect(lblsMenuSelect[3], 4 + "-" + MODE, 400, 80);

        width = 100;
        lblsMenuSelect[4].setBounds(lblsMenuSelect[2].getX() - width - gap, lblsMenuSelect[2].getY() - 10, width, width);
        lblsMenuSelect[5].setBounds(lblsMenuSelect[2].getX() + gap + 400, lblsMenuSelect[2].getY() - 10, width, width);
        lblsMenuSelect[6].setBounds(lblsMenuSelect[3].getX() - width - gap, lblsMenuSelect[3].getY() - 10, width, width);
        lblsMenuSelect[7].setBounds(lblsMenuSelect[3].getX() + gap + 400, lblsMenuSelect[3].getY() - 10, width, width);
        lblsMenuSelect[8].setBounds(lblsMenuSelect[1].getX() - width - gap, lblsMenuSelect[1].getY() - 10, width, width);
        lblsMenuSelect[9].setBounds(lblsMenuSelect[1].getX() + gap + 300, lblsMenuSelect[1].getY() - 10, width, width);

    }

    private void Event() {

        lblsMenu[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblReturn.setVisible(true);

                pnlModeSelect.setVisible(true);
                pnlMainMenu.setVisible(false);
                switchTitle("gameMode");
            }
        });
        lblsMenu[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frameG.setVisible(true);
            }
        });
        lblsMenu[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frameAU.setVisible(true);
            }
        });
        lblsMenu[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.dispose();
                System.gc();
                System.exit(0);
            }
        });

        lblReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchTitle("gameStart");
                enableMenuMode();
            }
        });

        lblsMenuSelect[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblsMenuSelect[8].setVisible(true);
                lblsMenuSelect[9].setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblsMenuSelect[8].setVisible(false);
                lblsMenuSelect[9].setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                enableRPGMode();
            }
        });
        lblsMenuSelect[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblsMenuSelect[4].setVisible(true);
                lblsMenuSelect[5].setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblsMenuSelect[4].setVisible(false);
                lblsMenuSelect[5].setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                parent.getPnlNormalMode().setMapType(NormalCaro.THREE_THREE);
                enableNormalMode();
            }
        });
        lblsMenuSelect[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblsMenuSelect[6].setVisible(true);
                lblsMenuSelect[7].setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblsMenuSelect[6].setVisible(false);
                lblsMenuSelect[7].setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                parent.getPnlNormalMode().setMapType(NormalCaro.FIVE_FIVE);
                enableNormalMode();
            }
        });

    }

    public void switchTitle(String value) {
        int x = pnlMainMenu.getX() + (pnlMainMenu.getWidth() - 1100) / 2;
        if (value.equals("gameStart")) {
            MenuTitle.setIcon(gameStart);
            MenuTitle.setBounds(x, 400, 1100, 100);
        } else if (value.equals("gameMode")) {
            MenuTitle.setIcon(gameMode);
            MenuTitle.setBounds(x + 50, 200, 1100, 100);
        }
    }

    public void enableNormalMode() {
        setVisible(false);
        parent.setNormal(true);
        parent.setRPG(false);

        parent.getPnlNormalMode().generateBoard();
        parent.getPnlNormalMode().setVisible(true);

        parent.repaint();
    }

    public void enableRPGMode() {
        setVisible(false);
        parent.setNormal(false);
        parent.setRPG(true);

        parent.generateBoard();
        parent.getPnlRPGMode().setVisible(true);

        parent.repaint();
    }

    public void enableMenuMode() {
        lblReturn.setVisible(false);

        pnlModeSelect.setVisible(false);
        parent.getPnlRPGMode().setVisible(false);
        parent.getPnlNormalMode().setVisible(false);

        parent.setNormal(false);
        parent.setRPG(false);

        pnlMainMenu.setVisible(true);
        setVisible(true);
    }

    public void LabelEffect(JLabel lbl, String name, int width, int height) {
        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbl.setIcon(autoResize(name, HOVER, width, height));
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl.setIcon(autoResize(name, NORMAL, width, height));
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbl.setIcon(autoResize(name, ACTIVE, width, height));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbl.setIcon(autoResize(name, HOVER, width, height));
            }
        });
    }

    private void LabelModeEffect(JLabel lbl, String name, int width, int height) {
        lbl.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e) {
                lbl.setIcon(autoResize(name, NORMAL, width, height));
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                lbl.setIcon(autoResize(name, ACTIVE, width, height));
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lbl.setIcon(autoResize(name, NORMAL, width, height));
            }

        });
    }

    public ImageIcon autoResize(String name, String suffix, int width, int height) {
        return resizeImgIcon(getMenuBtns(name, suffix), width, height);
    }

    private ImageIcon getMenuBtns(String name, String suffix) {
        return new ImageIcon(getClass().getResource("/img/Menu/" + name + (suffix.equals("") ? "" : "-" + suffix) + ".png"));
    }

    private ImageIcon getAnimationEntity(String value) {
        return new ImageIcon(getClass().getResource("/img/Menu/" + value + "-entity.png"));
    }

    private ImageIcon resizeImgIcon(ImageIcon oldImg, int width, int height) {
        return new ImageIcon(oldImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

}
