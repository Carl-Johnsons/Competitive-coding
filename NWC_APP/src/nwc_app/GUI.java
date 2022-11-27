package nwc_app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.io.File;
import java.io.IOException;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.EventObject;

import javax.imageio.ImageIO;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import nwc_app.data.*;

public final class GUI {

    //<editor-fold defaultstate="collapsed" desc="ATTRIBUTE Declaration">
    private JFrame mainFrame;

    //MENU PANEL
    private JPanel MenuPanel;
    private FilterSearchTextField TypeFilter;
    private JButton FrameBorderButton[] = new JButton[2];
    private boolean isFrameBorderButtonClicked[] = new boolean[FrameBorderButton.length];
    private JButton TypeMenuButton[] = new JButton[1];
    //Answer Panel
    private JPanel[] AnswerPanels = new JPanel[1];
    private JTextField[] AnswerTextField = new JTextField[1];
    private JButton[] AnswerButton = new JButton[2];
    private JComboBox<String> AnswerComboBox[] = new JComboBox[5];
    private JLabel AnswerLabel[] = new JLabel[5];
    private JTextArea DrawingArea[] = new JTextArea[2];
    private JTable AnswerEditPath;
    private JScrollPane AnswerEditScrollPane;
    private JTextArea AnswerFromLabel[] = new JTextArea[2];
    private JTextArea Result;

    private Dijkstra_Algorithm_Draw Dijkstra;
    private Dijkstra_Edit_Path_Draw Dijkstra_Edit;

    //Ohter
    private Coordinate_mode coordinate_mode;
    private MouseAdapter Coordinate_Event;
    private MouseAdapter Coordinate_Drag_Event;
    private JPanel border;
    //Res
    private File[] allFiles = new File("src\\nwc_app\\res").listFiles();
    private BufferedImage allImg[] = new BufferedImage[allFiles.length];
    //DATA

    //</editor-fold>
    public GUI() throws IOException {
        prepareGUI();
    }

    public static void main(String[] args) throws IOException {
        new GUI().Start();
    }

    private void prepareGUI() throws IOException {

        //<editor-fold defaultstate="collapsed" desc="MAIN FRAME DECLARATION">
        mainFrame = new JFrame();
        mainFrame.setBounds(320, 180, 1280, 720);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);

        //Update data
        for (int i = 0; i < allFiles.length; i++) {
            allImg[i] = ImageIO.read(allFiles[i]);
        }

        //OTHER
        coordinate_mode = new Coordinate_mode();
        coordinate_mode.setBounds(0, 0, 1280, 720);
        coordinate_mode.setOpaque(false);
        coordinate_mode.setVisible(false);

        Coordinate_Event = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                coordinate_mode.setIsMouseDragging(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                coordinate_mode.setIsMouseDragging(false);
                coordinate_mode.UpdateCoordinate(coordinate_mode.getMouse_last_X(), coordinate_mode.getMouse_last_y());
                coordinate_mode.repaint();
            }

        };
        Coordinate_Drag_Event = new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                if (isFrameBorderButtonClicked[1]) {
                    coordinate_mode.setVisible(true);
                    coordinate_mode.UpdateCoordinate(e.getX(), e.getY());
                } else {
                    coordinate_mode.setVisible(false);
                }
                coordinate_mode.repaint();

            }

            @Override
            public void mouseDragged(MouseEvent e) {

                coordinate_mode.setIsMouseDragging(true);
                coordinate_mode.UpdateLastCoordinate(e.getX(), e.getY());
                coordinate_mode.repaint();
            }
        };

        border = new FrameBorder();
        border.setBounds(0, 0, 1280, 720);
        border.setOpaque(false);

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="MENU PANEL">
        //                              MENU PANEL DECLARATION
        MenuPanel = new JPanel();
        MenuPanel.setBounds(0, 0, 200, 720);
        MenuPanel.setLayout(null);
        MenuPanel.setOpaque(false);
        MenuPanel.setFocusable(true);

        TypeFilter = new FilterSearchTextField("Add new Type");
        TypeFilter.setBounds(25, 30, 150, 30);
        TypeFilter.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        TypeFilter.setHint("Input Type here");
        TypeFilter.myList.setFont(TypeFilter.getFont());
        TypeFilter.myList.setVisible(false);

        for (int i = 0; i < FrameBorderButton.length; i++) {
            FrameBorderButton[i] = new JButton();
            FrameBorderButton[i].setSize(20, 20);
            FrameBorderButton[i].setLocation(2, 30 + (i % FrameBorderButton.length) * 25);
            FrameBorderButton[i].setContentAreaFilled(false);
            FrameBorderButton[i].setBorder(null);

            isFrameBorderButtonClicked[i] = false;
        }
        isFrameBorderButtonClicked[0] = true;
        FrameBorderButton[0].setIcon(new ImageIcon(allImg[0].getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        FrameBorderButton[1].setIcon(new ImageIcon(allImg[1].getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

        for (int i = 0; i < TypeMenuButton.length; i++) {
            TypeMenuButton[i] = new JButton();
            TypeMenuButton[i].setBounds(TypeFilter.getX(), TypeFilter.getY() + TypeFilter.getHeight() + 10 + (i % TypeMenuButton.length) * 40, 150, 40);
            TypeMenuButton[i].setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.yellow));
            TypeMenuButton[i].setBackground(new Color(100, 100, 100));
            TypeMenuButton[i].setFont(new Font("TimesRoman", Font.PLAIN, 20));
            TypeMenuButton[i].setForeground(new Color(255, 255, 255));
            TypeMenuButton[i].setPressedIcon(new ImageIcon(allImg[2]));

            TypeMenuButtonEffect(TypeMenuButton[i]);
        }
        TypeMenuButton[0].setText("Shortest Path");

        //                              MENU PANEL ADD ELEMENTS
        MenuPanel.add(TypeFilter.myList);
        MenuPanel.add(TypeFilter);

        for (int i = 0; i < FrameBorderButton.length; i++) {
            MenuPanel.add(FrameBorderButton[i]);
        }
        for (int i = 0; i < TypeMenuButton.length; i++) {
            MenuPanel.add(TypeMenuButton[i]);
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="ANSWER PANEL">
        for (int i = 0; i < AnswerPanels.length; i++) {
            AnswerPanels[i] = new JPanel();
            AnswerPanels[i].setBounds(0, 0, 1280, 720);
            AnswerPanels[i].setOpaque(false);
            AnswerPanels[i].setLayout(null);
            AnswerPanels[i].setVisible(false);
            AnswerPanels[i].setFocusable(true);
        }
        AnswerPanels[0].setVisible(true);
        for (int i = 0; i < DrawingArea.length; i++) {
            DrawingArea[i] = new JTextArea();
            DrawingArea[i].setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black));
        }

        DrawingArea[0].setBounds(240, 70, 900, 300);
        DrawingArea[1].setBounds(600, 480, 540, 150);

        for (int i = 0; i < AnswerButton.length; i++) {
            AnswerButton[i] = new JButton();
            AnswerButton[i].setBounds(DrawingArea[0].getX() + DrawingArea[0].getWidth() - (AnswerButton.length) * 55 + (i % AnswerButton.length) * 66, DrawingArea[0].getY() + DrawingArea[0].getHeight() + 5, 50, 25);
        }
        AnswerButton[0].setText("+");
        AnswerButton[1].setText("-");
        for (int i = 0; i < AnswerTextField.length; i++) {
            AnswerTextField[i] = new JTextField();
            AnswerTextField[i].setBounds(AnswerButton[0].getX() - (AnswerTextField.length * 80) + (i % AnswerTextField.length) * 80, AnswerButton[0].getY(), 70, 25);
        }
        AnswerTextField[0].setText("D");

        for (int i = 0; i < AnswerComboBox.length; i++) {
            AnswerComboBox[i] = new JComboBox<>();
            AnswerComboBox[i].setBounds(DrawingArea[0].getX() + 50 + (i % AnswerComboBox.length) * 150, AnswerButton[0].getY(), 100, AnswerButton[0].getHeight());

            AnswerLabel[i] = new JLabel();
            AnswerLabel[i].setFont(new Font("TimesRoman", Font.BOLD, 12));
            AnswerLabel[i].setHorizontalAlignment(JLabel.CENTER);
            AnswerLabel[i].setBounds(AnswerComboBox[i].getX() - 50, AnswerComboBox[i].getY(), 50, AnswerButton[0].getHeight());
        }
        AnswerLabel[0].setText("MODE");
        AnswerLabel[1].setText("TYPE");
        AnswerLabel[2].setText("FROM");
        AnswerLabel[3].setText("TO");
        AnswerLabel[4].setText("EDIT");

        AnswerComboBox[0].addItem("ALPHABET");
        AnswerComboBox[0].addItem("NUMBER");

        AnswerComboBox[1].addItem("INDIRECTED");
        AnswerComboBox[1].addItem("DIRECTED");

        AnswerComboBox[4].setLocation(AnswerComboBox[0].getX(), AnswerComboBox[0].getY() + AnswerComboBox[0].getHeight() + 5);
        AnswerLabel[4].setLocation(AnswerComboBox[4].getX() - 50, AnswerComboBox[4].getY());
        for (char i = 'A'; i < 'E'; i++) {
            AnswerComboBox[2].addItem(i + "");
            AnswerComboBox[3].addItem(i + "");
            AnswerComboBox[4].addItem(i + " ");
        }

        AnswerEditPath = new JTable() {

            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                if (column == 0) {
                    return false;
                }
                return super.editCellAt(row, column, e); //To change body of generated methods, choose Tools | Templates.
            }

        };
        DefaultTableModel AnswerEditPathModel = (DefaultTableModel) AnswerEditPath.getModel();
        AnswerEditPathModel.addColumn("To");
        AnswerEditPathModel.addColumn("Distance");

        //Data
        AnswerEditPathModel.addRow(new Object[]{"B", "0"});
        AnswerEditPathModel.addRow(new Object[]{"C", "0"});
        AnswerEditPathModel.addRow(new Object[]{"D", "0"});

        AnswerEditPath.getTableHeader().setBackground(new Color(100, 100, 100));
        AnswerEditPath.getTableHeader().setForeground(Color.WHITE);
        AnswerEditPath.getTableHeader().setFont(new Font("TimesRoman", Font.BOLD, 15));
        AnswerEditPath.setFont(new Font("TimesRoman", Font.BOLD, 15));

        AnswerEditScrollPane = new JScrollPane();
        AnswerEditScrollPane.setViewportView(AnswerEditPath);
        AnswerEditScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        AnswerEditScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        AnswerEditScrollPane.setBounds(AnswerComboBox[4].getX(), AnswerComboBox[4].getY() + AnswerComboBox[4].getHeight() + 5, 200, 200);
        for (int i = 0; i < 2; i++) {
            AnswerFromLabel[i] = new JTextArea();
            AnswerFromLabel[i].setBounds(AnswerLabel[4].getBounds());
            AnswerFromLabel[i].setLocation(AnswerLabel[4].getX(), AnswerEditScrollPane.getY() + AnswerLabel[4].getHeight() * (i % AnswerFromLabel.length));
            AnswerFromLabel[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            AnswerFromLabel[i].setEditable(false);
            AnswerFromLabel[i].setFont(new Font("TimesRoman", Font.BOLD, 15));
        }
        AnswerFromLabel[1].setSize(AnswerFromLabel[1].getWidth(), 20);
        AnswerFromLabel[0].setBackground(new Color(100, 100, 100));
        AnswerFromLabel[0].setForeground(Color.WHITE);
        AnswerFromLabel[1].setBackground(Color.WHITE);
        AnswerFromLabel[0].setText("From");
        AnswerFromLabel[1].setText("A");

        Result = new JTextArea();
        Result.setText("The shortest path from " + AnswerComboBox[2].getSelectedItem() + " to " + AnswerComboBox[3].getSelectedItem() + "\n");
        Result.append("A\n");
        Result.append("Shortest distance : 0");
        Result.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        Result.setBounds(DrawingArea[1].getX(), DrawingArea[1].getY() - 70, DrawingArea[1].getWidth(), 90);
        Result.setEditable(false);
        Result.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK), BorderFactory.createEmptyBorder(0, 20, 0, 20)));
        Result.setWrapStyleWord(true);
        Result.setLineWrap(true);

        //<editor-fold defaultstate="collapsed" desc="Dijkstra algorithm">
        Dijkstra = new Dijkstra_Algorithm_Draw();
        Dijkstra.setLayout(null);
        Dijkstra.setBounds(DrawingArea[0].getBounds());
        Dijkstra.setLocation(DrawingArea[0].getX(), DrawingArea[0].getY());
        Dijkstra.setOpaque(false);
        Dijkstra.setNumberOfPoint(4);

        Dijkstra_Edit = new Dijkstra_Edit_Path_Draw();
        Dijkstra_Edit.setBounds(DrawingArea[1].getBounds());
        Dijkstra_Edit.setOpaque(false);
        Dijkstra_Edit.setNumberOfPoint(4);

        AnswerPanels[0].add(Dijkstra);
        AnswerPanels[0].add(Dijkstra_Edit);
        for (int i = 0; i < AnswerButton.length; i++) {
            AnswerPanels[0].add(AnswerButton[i]);
        }
        for (int i = 0; i < AnswerComboBox.length; i++) {
            AnswerPanels[0].add(AnswerComboBox[i]);
        }
        for (int i = 0; i < AnswerTextField.length; i++) {
            AnswerPanels[0].add(AnswerTextField[i]);
        }
        for (int i = 0; i < AnswerLabel.length; i++) {
            AnswerPanels[0].add(AnswerLabel[i]);
        }
        for (int i = 0; i < DrawingArea.length; i++) {
            AnswerPanels[0].add(DrawingArea[i]);
        }
        for (int i = 0; i < AnswerFromLabel.length; i++) {
            AnswerPanels[0].add(AnswerFromLabel[i]);
        }
        AnswerPanels[0].add(AnswerEditScrollPane);
        AnswerPanels[0].add(Result);
        //</editor-fold>
        //</editor-fold>
        //                              MAINFRAME ADD ELEMENTS
        mainFrame.add(MenuPanel);
        for (int i = 0; i < AnswerPanels.length; i++) {
            mainFrame.add(AnswerPanels[i]);
        }

        mainFrame.add(border);

        mainFrame.add(coordinate_mode);

    }

    public void Start() {
        MenuPanel.requestFocus();

        TypeFilter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                TypeFilter.myList.setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                TypeFilter.myList.setVisible(false);
            }
        });
        TypeFilter.myList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (TypeFilter.myList.getSelectedValue() == "Dijkstra algorithm") {

                }
            }

        });
        //REQUEST FOCUS
        MenuPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ((e.getX() >= TypeFilter.getX() && e.getX() <= TypeFilter.getX() + TypeFilter.getWidth()) && (e.getY() >= TypeFilter.getY() && e.getY() <= TypeFilter.getY() + TypeFilter.getHeight())) {
                    TypeFilter.myList.setVisible(true);
                } else {
                    TypeFilter.myList.setVisible(false);
                    MenuPanel.requestFocus();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        AnswerPanels[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                AnswerPanels[0].requestFocus();
            }

        });

        //For Coordinate to work
        MenuPanel.addMouseListener(Coordinate_Event);
        MenuPanel.addMouseMotionListener(Coordinate_Drag_Event);
        border.addMouseListener(Coordinate_Event);
        border.addMouseMotionListener(Coordinate_Drag_Event);
        AnswerPanels[0].addMouseListener(Coordinate_Event);
        AnswerPanels[0].addMouseMotionListener(Coordinate_Drag_Event);

        for (int i = 0; i < FrameBorderButton.length; i++) {
            FrameButtonEffect(FrameBorderButton[i]);
        }
        FrameBorderButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < FrameBorderButton.length; i++) {
                    isFrameBorderButtonClicked[i] = false;
                }
                isFrameBorderButtonClicked[0] = true;
                mainFrame.setCursor(Cursor.DEFAULT_CURSOR);
            }
        });
        FrameBorderButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < FrameBorderButton.length; i++) {
                    isFrameBorderButtonClicked[i] = false;
                }
                isFrameBorderButtonClicked[1] = true;
                mainFrame.setCursor(Cursor.CROSSHAIR_CURSOR);
            }
        });

        AnswerButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Dijkstra.getMODE() == Dijkstra.NUMBER) {
                        int temp = Integer.parseInt(AnswerTextField[0].getText());
                        if (temp <= 0) {
                            throw new Exception();
                        } else if (temp <= 99) {
                            AnswerTextField[0].setText((temp + 1) + "");
                            Dijkstra.setNumberOfPoint(temp + 1);
                            Dijkstra_Edit.setNumberOfPoint(temp + 1);

                        }
                    } else if (Dijkstra.getMODE() == Dijkstra.ALPHABET) {
                        char temp = AnswerTextField[0].getText().toUpperCase().toCharArray()[0];
                        if (!(temp >= 'A' && temp <= 'Z')) {
                            throw new Exception();
                        } else if (temp < 'Z') {
                            AnswerTextField[0].setText((char) (temp + 1) + "");
                            Dijkstra.setNumberOfPoint((int) (temp - 'A') + 2);
                            Dijkstra_Edit.setNumberOfPoint((int) (temp - 'A') + 2);

                        }
                    }
                    updateData();
                } catch (Exception ex) {
                    if (Dijkstra.getMODE() == Dijkstra.NUMBER) {
                        AnswerTextField[0].setText("2");
                        Dijkstra_Edit.setSelected_Point('0');
                    } else if (Dijkstra.getMODE() == Dijkstra.ALPHABET) {
                        AnswerTextField[0].setText("B");
                        Dijkstra_Edit.setSelected_Point('A');
                    }
                    Dijkstra.setNumberOfPoint(2);
                    Dijkstra_Edit.setNumberOfPoint(2);
                    updateData();
                }
            }
        });
        AnswerButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (Dijkstra.getMODE() == Dijkstra.NUMBER) {
                        int temp = Integer.parseInt(AnswerTextField[0].getText());
                        if (temp <= 0) {
                            throw new Exception();
                        } else if (temp > 0) {
                            AnswerTextField[0].setText((temp - 1) + "");
                            Dijkstra.setNumberOfPoint(temp - 1);
                            Dijkstra_Edit.setNumberOfPoint(temp - 1);

                        }
                    } else if (Dijkstra.getMODE() == Dijkstra.ALPHABET) {
                        char temp = AnswerTextField[0].getText().toUpperCase().toCharArray()[0];
                        if (!(temp >= 'A' && temp <= 'Z')) {
                            throw new Exception();
                        } else if (temp > 'A') {
                            AnswerTextField[0].setText((char) (temp - 1) + "");
                            Dijkstra.setNumberOfPoint((int) (temp - 'A'));
                            Dijkstra_Edit.setNumberOfPoint((int) (temp - 'A'));
                        }
                        updateData();
                    }

                } catch (Exception ex) {
                    if (Dijkstra.getMODE() == Dijkstra.NUMBER) {
                        AnswerTextField[0].setText("2");
                        Dijkstra_Edit.setSelected_Point('0');
                    } else if (Dijkstra.getMODE() == Dijkstra.ALPHABET) {
                        AnswerTextField[0].setText("B");
                        Dijkstra_Edit.setSelected_Point('A');
                    }
                    Dijkstra.setNumberOfPoint(2);
                    Dijkstra_Edit.setNumberOfPoint(2);
                    updateData();
                }
            }
        });
        AnswerTextField[0].addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        AnswerComboBox[4].removeAllItems();
                        if (Dijkstra.getMODE() == Dijkstra.NUMBER) {
                            int temp = Integer.parseInt(AnswerTextField[0].getText());
                            if (temp <= 0) {
                                throw new Exception();
                            } else if (temp > 0) {
                                AnswerTextField[0].setText(temp + "");
                                Dijkstra.setNumberOfPoint(temp);
                                Dijkstra_Edit.setNumberOfPoint(temp);
                                for (int i = 0; i < temp; i++) {
                                    AnswerComboBox[4].addItem(i + "");
                                }
                            }
                        } else if (Dijkstra.getMODE() == Dijkstra.ALPHABET) {
                            char temp = AnswerTextField[0].getText().toUpperCase().toCharArray()[0];
                            if (!(temp >= 'A' && temp <= 'Z')) {
                                throw new Exception();
                            } else if (temp > 'A') {
                                AnswerTextField[0].setText((char) (temp) + "");
                                Dijkstra.setNumberOfPoint((int) (temp - 'A') + 1);
                                Dijkstra_Edit.setNumberOfPoint((int) (temp - 'A') + 1);
                                for (int i = 0; i < temp; i++) {
                                    AnswerComboBox[4].addItem((char) (i + 'A') + "");
                                }
                            }
                        }
                        Dijkstra.repaint();
                        Dijkstra_Edit.repaint();
                    } catch (Exception ex) {
                        if (Dijkstra.getMODE() == Dijkstra.NUMBER) {
                            AnswerTextField[0].setText("2");

                        } else if (Dijkstra.getMODE() == Dijkstra.ALPHABET) {
                            AnswerTextField[0].setText("B");
                        }
                        Dijkstra.setNumberOfPoint(2);
                        Dijkstra.repaint();
                        Dijkstra_Edit.setNumberOfPoint(2);
                        Dijkstra_Edit.repaint();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if (Dijkstra.getMODE() == Dijkstra.NUMBER) {
                            int temp = Integer.parseInt(AnswerTextField[0].getText());
                            if (temp <= 0) {
                                throw new Exception();
                            } else if (temp > 0) {
                                AnswerTextField[0].setText(temp + "");
                                Dijkstra.setNumberOfPoint(temp);
                                Dijkstra_Edit.setNumberOfPoint(temp);

                            }
                        } else if (Dijkstra.getMODE() == Dijkstra.ALPHABET) {
                            char temp = AnswerTextField[0].getText().toUpperCase().toCharArray()[0];
                            if (!(temp >= 'A' && temp <= 'Z')) {
                                throw new Exception();
                            } else if (temp > 'A') {
                                AnswerTextField[0].setText((char) (temp) + "");
                                Dijkstra.setNumberOfPoint((int) (temp - 'A') + 1);
                                Dijkstra_Edit.setNumberOfPoint((int) (temp - 'A') + 1);

                            }
                        }
                        updateData();
                    } catch (Exception ex) {
                        if (Dijkstra.getMODE() == Dijkstra.NUMBER) {
                            AnswerTextField[0].setText("2");
                            Dijkstra_Edit.setSelected_Point('0');
                        } else if (Dijkstra.getMODE() == Dijkstra.ALPHABET) {
                            AnswerTextField[0].setText("B");
                            Dijkstra_Edit.setSelected_Point('A');
                        }
                        Dijkstra.setNumberOfPoint(2);
                        Dijkstra_Edit.setNumberOfPoint(2);
                        updateData();
                    }
                }
            }
        });
        AnswerComboBox[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AnswerComboBox[0].getSelectedItem().toString().equalsIgnoreCase("ALPHABET")) {
                    Dijkstra.setMODE(Dijkstra.ALPHABET);
                    Dijkstra_Edit.setMODE(Dijkstra_Edit.ALPHABET);
                    AnswerTextField[0].setText("D");
                    Dijkstra_Edit.setSelected_Point('A');

                } else if (AnswerComboBox[0].getSelectedItem().toString().equalsIgnoreCase("NUMBER")) {
                    Dijkstra.setMODE(Dijkstra.NUMBER);
                    Dijkstra_Edit.setMODE(Dijkstra_Edit.NUMBER);
                    AnswerTextField[0].setText("4");
                    Dijkstra_Edit.setSelected_Point('0');
                }

                Dijkstra.setNumberOfPoint(4);
                Dijkstra_Edit.setNumberOfPoint(4);
                updateData();
            }
        });
        AnswerComboBox[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AnswerComboBox[2].getItemCount() == Dijkstra_Edit.getNumberOfPoint()) {
                    updateResult();
                }
            }
        });
        AnswerComboBox[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AnswerComboBox[3].getItemCount() == Dijkstra_Edit.getNumberOfPoint()) {
                    updateResult();
                }
            }
        });
        AnswerComboBox[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AnswerComboBox[4].getItemCount() > 0) {
                    Dijkstra_Edit.setSelected_Point(AnswerComboBox[4].getSelectedItem().toString().toCharArray()[0]);

                    int temp = Dijkstra_Edit.getSelected_Point();
                    if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.ALPHABET) {
                        temp -= 'A';
                    } else if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.NUMBER) {
                        temp -= '0';
                    }

                    DefaultTableModel model = (DefaultTableModel) AnswerEditPath.getModel();

                    int tempD[][] = Dijkstra_Edit.getProblem().ReadData();
                    Dijkstra_Edit.getProblem().SaveData(tempD);
                    System.out.println("Im in");
                    for (int i = 0; i < tempD.length; i++) {
                        for (int j = 0; j < tempD.length; j++) {
                            System.out.print(tempD[i][j] + " ");
                        }
                        System.out.println();
                    }

                    model.setRowCount(0);

                    if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.ALPHABET) {
                        for (int i = 0; i < Dijkstra_Edit.getNumberOfPoint(); i++) {
                            if ((char) (i + 'A') != Dijkstra_Edit.getSelected_Point()) {
                                model.addRow(new Object[]{(char) (i + 'A'), tempD[temp][i]});
                            }
                        }

                    } else if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.NUMBER) {
                        for (int i = 0; i < Dijkstra_Edit.getNumberOfPoint(); i++) {
                            if ((char) (i + '0') != Dijkstra_Edit.getSelected_Point()) {
                                model.addRow(new Object[]{i, tempD[temp][i]});
                            }
                        }
                    }

                    AnswerFromLabel[1].setText(Dijkstra_Edit.getSelected_Point() + "");

                    Dijkstra.repaint();
                    Dijkstra_Edit.repaint();
                }
            }
        });
        AnswerEditPath.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                try {
                    DefaultTableModel model = (DefaultTableModel) AnswerEditPath.getModel();
                    int temp = Dijkstra_Edit.getSelected_Point();
                    if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.ALPHABET) {
                        temp -= 'A';
                    } else if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.NUMBER) {
                        temp -= '0';
                    }

                    int tempData[] = new int[Dijkstra_Edit.getNumberOfPoint()];
                    int cell = 0;
                    for (int i = 0; i < tempData.length; i++) {
                        if (i != temp) {
                            int t = 0;
                            try {
                                t = Integer.parseInt(model.getValueAt(cell, 1).toString());
                                if (t < 0) {
                                    throw new Exception();
                                }
                            } catch (Exception e) {
                                t = 0;
                                model.setValueAt(0, cell, 1);
                            }
                            tempData[i] = t;
                            cell++;
                        }
                    }
                    Dijkstra_Edit.getProblem().EditDataAtLine(temp, tempData);

                    int tempD[][] = Dijkstra_Edit.getProblem().ReadData();

                    for (int i = 0; i < tempD.length; i++) {
                        if (i != temp) {
                            Dijkstra_Edit.getProblem().EditDataAtCell(tempD[temp][i], tempD, i, temp);
                        }
                    }
                    for (int i = 0; i < tempD.length; i++) {
                        for (int j = 0; j < tempD.length; j++) {
                            System.out.print(tempD[i][j] + " ");
                        }
                        System.out.println();
                    }

                    Dijkstra.repaint();
                    Dijkstra_Edit.repaint();
                } catch (Exception ex) {
                    System.out.println("Error has occured");
                }
                updateResult();
            }
        });
       

        mainFrame.setVisible(true);
    }

    private void FrameButtonEffect(JButton b) {
        b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                b.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setBorder(null);
            }
        });
    }

    private void TypeMenuButtonEffect(JButton b) {
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                b.setFont(new Font("TimesRoman", Font.BOLD, 20));
                b.setForeground(Color.BLACK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                b.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                b.setForeground(Color.WHITE);
            }

        });

    }

    private void updateData() {
        AnswerComboBox[2].removeAllItems();
        AnswerComboBox[3].removeAllItems();
        AnswerComboBox[4].removeAllItems();

        DefaultTableModel tempModel = (DefaultTableModel) AnswerEditPath.getModel();

        if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.ALPHABET) {
            clearTable();

            for (int i = 0; i < Dijkstra_Edit.getNumberOfPoint(); i++) {
                String t = (char) (i + 'A') + "";
                System.out.println(AnswerComboBox[2].getItemCount());
                if (AnswerComboBox[2].getItemCount() > Dijkstra_Edit.getNumberOfPoint()) {
                    AnswerComboBox[2].removeAllItems();
                }
                if (AnswerComboBox[3].getItemCount() > Dijkstra_Edit.getNumberOfPoint()) {
                    AnswerComboBox[3].removeAllItems();
                }
                AnswerComboBox[2].addItem(t);
                AnswerComboBox[3].addItem(t);
                AnswerComboBox[4].addItem(t);

                if ((char) (i + 'A') != Dijkstra_Edit.getSelected_Point()) {
                    if (tempModel.getRowCount() > Dijkstra_Edit.getNumberOfPoint() - 2) {
                        clearTable();
                    }
                    tempModel.addRow(new Object[]{(char) (i + 'A'), 0});
                }
            }

        } else if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.NUMBER) {
            for (int i = 0; i < Dijkstra_Edit.getNumberOfPoint(); i++) {
                if (AnswerComboBox[2].getItemCount() > Dijkstra_Edit.getNumberOfPoint()) {
                    AnswerComboBox[2].removeAllItems();
                }
                if (AnswerComboBox[3].getItemCount() > Dijkstra_Edit.getNumberOfPoint()) {
                    AnswerComboBox[3].removeAllItems();
                }
                AnswerComboBox[2].addItem(i + "");
                AnswerComboBox[3].addItem(i + "");
                AnswerComboBox[4].addItem(i + "");

                if ((char) (i + '0') != Dijkstra_Edit.getSelected_Point()) {
                    if (tempModel.getRowCount() > Dijkstra_Edit.getNumberOfPoint() - 2) {
                        clearTable();
                    }
                    tempModel.addRow(new Object[]{i, 0});
                }
            }
        }
        AnswerFromLabel[1].setText(Dijkstra_Edit.getSelected_Point() + "");

        Result.setText("");

        Dijkstra.repaint();
        Dijkstra_Edit.repaint();

        System.gc();
    }

    private void updateResult() {
        int temp = TransformIndex(AnswerComboBox[2].getSelectedItem().toString());

        Result.setText("The shortest path from " + AnswerComboBox[2].getSelectedItem() + " to " + AnswerComboBox[3].getSelectedItem() + "\n");
        int t[][] = Dijkstra_Edit.getProblem().dijkstra(Dijkstra_Edit.getProblem().ReadData(), temp);
        Dijkstra.setProblem(Dijkstra_Edit.getProblem());
        Dijkstra.setSelected_Point(AnswerComboBox[2].getSelectedItem().toString().toCharArray()[0]);
        Dijkstra.setEnd_Point(AnswerComboBox[3].getSelectedItem().toString().toCharArray()[0]);
        Dijkstra.repaint();

        temp = TransformIndex(AnswerComboBox[3].getSelectedItem().toString());
        int dis = (t[temp][1] == Integer.MAX_VALUE ? 0 : t[temp][1]);

        boolean first = true;
        if (dis > 0) {
            Result.append("Path Way:");
            for (Integer i : Dijkstra_Edit.getProblem().Path.get(temp)) {
                if (first) {
                    Result.append(TransformVertex(i) + " ");
                    first = false;
                } else {
                    Result.append(" -> " + TransformVertex(i));
                }
            }
            Result.append("\n");
            Result.append("Total Distance: " + dis);
        } else {
            Result.append("Path not found!");
        }

    }

    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) AnswerEditPath.getModel();
        model.setRowCount(0);
    }

    private int TransformIndex(int index) {
        int temp = index;
        if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.ALPHABET) {
            temp -= 'A';
        }
        return temp;
    }

    private int TransformIndex(String index) {
        int temp = 0;
        if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.ALPHABET) {
            temp = (index.toCharArray()[0]) - 'A';
        } else if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.NUMBER) {
            temp = Integer.parseInt(index);
        }
        return temp;
    }

    private Object TransformVertex(Object o) {
        Object temp = 0;
        if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.ALPHABET) {
            temp = (char) ((int) o + 'A');
        } else if (Dijkstra_Edit.getMODE() == Dijkstra_Edit.NUMBER) {
            temp = Integer.parseInt(o.toString());
        }
        return temp;
    }
}

class FrameBorder extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        //setOpaque(false);

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(100, 100, 100));
        g2.fillRect(25, 0, 150, getHeight());

        g2.setColor(new Color(200, 200, 200));
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(0, getHeight() - 65, getWidth(), getHeight());

    }

}
