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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */
public class Menu extends JPanel {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    public static final String BACKGROUND = "bg";

    //Img
    public static final String TYPE[] = {"about", "play", "exit"};
    public static final String MODE = "mode";
    public static final String PAUSE = "pause";
    public static final String RETURN = "return";
    //State of the button
    public static final String ACTIVE = "active";
    public static final String HOVER = "hover";
    public static final String NORMAL = "";
    public static final String SELECT = "select";

    private JLabel lblsMenu[];
    private JLabel lblsMenuSelect[];
    private JLabel lblReturn;
    private JLabel lblGameReturn;
    private JLabel bgMenu;
    private JLabel bgModeSelect;

    //Sub-Panel
    private JPanel pnlModeSelect;
    private ImproveCaro parent;

    public Menu(ImproveCaro parent) {
        this.parent = parent;
        init();
    }

    private void init() {
        initThisPanel();
        initMenuBtns();

        Event();
        add(bgMenu);
    }

    private void initThisPanel() {
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.yellow));

        bgMenu = new JLabel();
        bgMenu.setBounds(0, 0, WIDTH, HEIGHT - 70);
        bgMenu.setIcon(autoResize(BACKGROUND, NORMAL, WIDTH, HEIGHT - 70));

        pnlModeSelect = new JPanel();
        pnlModeSelect.setBounds(0, 0, WIDTH, HEIGHT);
        pnlModeSelect.setLayout(null);

        bgModeSelect = new JLabel();
        bgModeSelect.setBounds(0, 0, WIDTH, HEIGHT - 70);
        bgModeSelect.setIcon(autoResize(BACKGROUND, SELECT, WIDTH, HEIGHT - 70));

        lblReturn = new JLabel();

        lblReturn.setBounds(10, 10, 70, 70);

        lblReturn.setIcon(autoResize(RETURN, NORMAL, 70, 70));
        lblReturn.setBorder(BorderFactory.createLineBorder(Color.black));

        pnlModeSelect.add(bgModeSelect);

        pnlModeSelect.setComponentZOrder(bgModeSelect, 0);
        pnlModeSelect.setVisible(false);
        lblReturn.setVisible(false);

        parent.add(lblReturn);
        parent.add(pnlModeSelect);

//        parent.setComponentZOrder(lblReturn, 0);
    }

    private void initMenuBtns() {
        lblsMenu = new JLabel[3];
        for (int i = 0; i < 3; i++) {
            lblsMenu[i] = new JLabel();
            lblsMenu[i].setBounds(600 + (300 * i), 700, 200, 80);
            lblsMenu[i].setIcon(autoResize(TYPE[i], NORMAL, 200, 80));
            LabelEffect(lblsMenu[i], TYPE[i], 200, 80);
            this.add(lblsMenu[i]);
        }

        lblsMenuSelect = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            lblsMenuSelect[i] = new JLabel();
//            lblsMenuSelect[i].setBorder(BorderFactory.createLineBorder(Color.yellow));

            if (i >= 2) {
                lblsMenuSelect[i].setIcon(autoResize((i / 2) + "", SELECT, 100, 100));
                lblsMenuSelect[i].setVisible(false);
            }

            pnlModeSelect.add(lblsMenuSelect[i]);
            pnlModeSelect.setComponentZOrder(lblsMenuSelect[i], 0);
        }
        lblsMenuSelect[0].setBounds(650, 550, 600, 80);
        lblsMenuSelect[1].setBounds(800, 700, 300, 80);
        lblsMenuSelect[0].setIcon(autoResize(1 + "-" + MODE, NORMAL, 600, 80));
        lblsMenuSelect[1].setIcon(autoResize(2 + "-" + MODE, NORMAL, 300, 80));

        LabelModeEffect(lblsMenuSelect[0], 1 + "-" + MODE, 600, 80);
        LabelModeEffect(lblsMenuSelect[1], 2 + "-" + MODE, 300, 80);

        int gap = 20;
        int width = 100;

        lblsMenuSelect[2].setBounds(650 - width - gap, 540, width, width);
        lblsMenuSelect[3].setBounds(650 + gap + 600, 540, width, width);
        lblsMenuSelect[4].setBounds(800 - width - gap, 700, width, width);
        lblsMenuSelect[5].setBounds(800 + gap + 300, 700, width, width);

    }

    private void Event() {
        lblsMenu[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblReturn.setVisible(true);

                pnlModeSelect.setVisible(true);
                setVisible(false);
            }
        });

        lblReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblReturn.setVisible(false);

                pnlModeSelect.setVisible(false);
                parent.getPnlRPGMode().setVisible(false);
                parent.getPnlNormalMode().setVisible(false);

                parent.setNormal(false);
                parent.setRPG(false);

                setVisible(true);
            }

        });

        lblsMenuSelect[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblsMenuSelect[2].setVisible(true);
                lblsMenuSelect[3].setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblsMenuSelect[2].setVisible(false);
                lblsMenuSelect[3].setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                parent.setNormal(true);
                parent.setRPG(false);

                parent.getPnlNormalMode().generateBoard();
                pnlModeSelect.setVisible(false);
                parent.getPnlNormalMode().setVisible(true);

                parent.repaint();
            }

        });
        lblsMenuSelect[1].addMouseListener(new MouseAdapter() {
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
                parent.setNormal(false);
                parent.setRPG(true);

                parent.generateBoard();
                pnlModeSelect.setVisible(false);
                parent.getPnlRPGMode().setVisible(true);

                parent.repaint();
            }

        });
    }

    private void LabelEffect(JLabel lbl, String name, int width, int height) {
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

    private ImageIcon autoResize(String name, String suffix, int width, int height) {
        return resizeImgIcon(getMenuBtns(name, suffix), width, height);
    }

    private ImageIcon getMenuBtns(String name, String suffix) {
        return new ImageIcon(getClass().getResource("/img/Menu/" + name + (suffix.equals("") ? "" : "-" + suffix) + ".png"));
    }

    private ImageIcon resizeImgIcon(ImageIcon oldImg, int width, int height) {
        return new ImageIcon(oldImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
}
