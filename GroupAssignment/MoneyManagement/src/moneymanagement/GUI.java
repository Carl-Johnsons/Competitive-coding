package moneymanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public final class GUI {

    //<editor-fold defaultstate="collapsed" desc="Declaration">
    private JFrame mainframe;
    private JLabel header;
    private JTextArea notify;

    //
    private final JButton SortMenu[] = new JButton[4];
    private final boolean IsSortMenuClicked[] = new boolean[4];
    private JButton ReturnButton;
    private JButton GenerateEvent;
    private JButton Save;

    //
    private JPanel StatisticJPanel;
    private DrawGraph graphIn;
    private MoneyManagement SumMoneyPerDay = new MoneyManagement();
    private JTextArea GraphHoldingArea;
    private JTextArea StatisticNotifyArea;

    //
    private JPanel UpdateJPanel;
    private JTextArea UpdateSearchListArea;
    private JScrollPane UpdateSearchListJScrollPane;
    private JTextArea UpdateSearchInputArea;
    private JTextArea SearchByTextArea;
    private JTextArea UpdatenotifyArea;
    private final JButton SearchByAtrButton[] = new JButton[4];
    private JButton UpdateAddButton;
    private JButton UpdateDeleteButton;
    private final JTextField InputField[] = new JTextField[3];
    private JComponent[] UpdateAddInputComponents;
    private JComponent[] UpdateDeleteElementComponents;

    //
    private JPanel MenuJPanel;
    private JTextArea MenuArea;
    private JScrollPane MenuScrollPane;
    private JTextArea CoordinateArea;
    private final JButton InteractiveMenuButton[] = new JButton[3];

    private final Font NormalFont = new Font("TimesRoman", Font.PLAIN, 30);

    private final MoneyManagement ME;
    //Image
    private final File[] allFile = new File("src\\res").listFiles();
    private final BufferedImage allImg[] = new BufferedImage[allFile.length];
    //Image

    //Not important
    private String temp;
    private final Random rand = new Random();
    private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private final Border BlackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    private final Border BlackBorderWidth3 = BorderFactory.createLineBorder(Color.BLACK, 3);
    //</editor-fold>

    public GUI() throws FileNotFoundException, ParseException, IOException {
        //Read a file
        ME = new MoneyManagement();
        ME.Read();
        SortDateIncreasing();
        prepareGUI();

    }

    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new GUI().Start();
                } catch (ParseException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void prepareGUI() throws IOException {
        //<editor-fold defaultstate="collapsed" desc="Initialize the frame">
        //Mainframe
        mainframe = new JFrame("Money Management");
        mainframe.setSize(1280, 720);
        mainframe.setResizable(false);
        mainframe.setLocation(320, 180);
        mainframe.setLocationRelativeTo(null);
        mainframe.setLayout(null);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Icon
        for (int i = 0; i < allFile.length; i++) {
            allImg[i] = ImageIO.read(allFile[i]);
        }

        //Coordinate
        CoordinateArea = new JTextArea("");
        CoordinateArea.setBounds(500, 20, 100, 80);
        CoordinateArea.setFont(NormalFont);
        CoordinateArea.setEditable(false);
        CoordinateArea.setBackground(mainframe.getBackground());
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Menu Panel">
        //                               Menu PANEL
        MenuArea = new JTextArea("");
        MenuArea.setEditable(false);
        MenuArea.setMargin(new Insets(20, 30, 0, 0));
        MenuArea.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        MenuArea.setText(PrintList());
        MenuScrollPane = new JScrollPane(MenuArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        MenuScrollPane.setBounds(150, 100, 830, 450);

        temp = "<html><center>" + "<font color=#505050>S</font><font color=#506450>t</font><font color=#507850>a</font>"
                + "<font color=#508C50>t</font><font color=#50A050>i</font><font color=#50B450>s</font>"
                + "<font color=#50C850>t</font><font color=#50DC50>i</font><font color=#50F050>c</font>"
                + "&ensp;<img src=" + getClass().getResource("/res/_1_Statistic_Icon.png") + " width = " + 40 + " height = " + 40 + " />" + "</center></html>";
        InteractiveMenuButton[0] = new JButton(temp);
        InteractiveMenuButton[0].setBounds(0, 600, 300, 80);

        temp = "<html><center>Update your "
                + "<font color=#009600>In</font>/<font color=#C83C3C>Out  &ensp; </font>" + "<img src=" + getClass().getResource("/res/_0_Update_Icon.png") + " height = " + 40 + " width = " + 40 + " /> " + "</html>";
        InteractiveMenuButton[1] = new JButton(temp);
        InteractiveMenuButton[1].setBounds(300, 600, 680, 80);

        temp = "<html><center>" + "<font color=#AA2D2D>E</font>"
                + "<font color=#732D2D>x</font>"
                + "<font color=#3C2D2D>i</font>"
                + "<font color=#0A2D2D>t</font> &ensp;" + "<img src=" + getClass().getResource("/res/_2_Exit_Icon.png") + " width=" + 40 + " height=" + 40 + " />" + "</center></html>";
        InteractiveMenuButton[2] = new JButton(temp);
        InteractiveMenuButton[2].setBounds(980, 600, 300, 80);

        for (int i = 0; i < 4; i++) {
            SortMenu[i] = new JButton("");
            SortMenu[i].setFont(new Font("TimesRoman", Font.PLAIN, 20));
            SortMenu[i].setMargin(new Insets(0, 0, 0, 0));
            SortMenu[i].setBorderPainted(false);
            SortMenu[i].setForeground(Color.GRAY);
            SortMenu[i].setOpaque(false);
            SortMenu[i].setBackground(new Color(240, 240, 240));

            IsSortMenuClicked[i] = false;
        }
        SortMenu[0].setBounds(150, 80, 190, 20);
        SortMenu[1].setBounds(340, 80, 140, 20);
        SortMenu[2].setBounds(480, 80, 100, 20);
        SortMenu[3].setBounds(580, 80, 400, 20);
        SortMenu[0].setText("Date");
        SortMenu[1].setText("Money");
        SortMenu[2].setText("In/Out");
        SortMenu[3].setText("Reason");

        IsSortMenuClicked[0] = true;

        MenuJPanel = new JPanel();
        MenuJPanel.setSize(1280, 720);
        MenuJPanel.setVisible(true);
        MenuJPanel.setLayout(null);

        //<editor-fold defaultstate="collapsed" desc="Other Button">
        //                               Other button
        GenerateEvent = new JButton();
        GenerateEvent.setText("<html><center>" + "Generating" + "<br>" + "random event" + "</center></html>");
        GenerateEvent.setBounds(980, 100, 250, 100);
        GenerateEvent.setFont(new Font("Impact", Font.PLAIN, 25));

        Save = new JButton("Save");
        Save.setBounds(980, 200, 250, 100);
        Save.setFont(new Font("Impact", Font.PLAIN, 25));

        ReturnButton = new JButton(new ImageIcon(allImg[3].getScaledInstance(50, 50, 100)));
        ReturnButton.setContentAreaFilled(false);
        ReturnButton.setBorderPainted(false);
        ReturnButton.setBounds(50, 20, 50, 50);
        ReturnButton.setVisible(false);
        //</editor-fold>

        //                               MENU PANEL ADD ELEMENTS
        MenuJPanel.add(MenuScrollPane);
        MenuJPanel.add(GenerateEvent);
        MenuJPanel.add(Save);
        for (int i = 0; i < 3; i++) {
            InteractiveMenuButton[i].setFont(new Font("Impact", Font.PLAIN, 40));
            MenuJPanel.add(InteractiveMenuButton[i]);
        }
        for (int i = 0; i < 4; i++) {
            MenuJPanel.add(SortMenu[i]);
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Update Panel">
        //                               UPDATE PANEL
        UpdateJPanel = new JPanel();
        UpdateJPanel.setSize(1280, 720);
        UpdateJPanel.setLayout(null);
        UpdateJPanel.setVisible(false);

        UpdateSearchInputArea = new JTextArea("");
        UpdateSearchInputArea.setBounds(150, 130, 800, 60);
        UpdateSearchInputArea.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        UpdateSearchListArea = new JTextArea("");
        UpdateSearchListArea.setEditable(false);
        UpdateSearchListArea.setFont(new Font("TimesRoman", Font.PLAIN, 30));

        UpdateSearchListJScrollPane = new JScrollPane(UpdateSearchListArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        UpdateSearchListJScrollPane.setBounds(150, 200, 800, 400);

        SearchByTextArea = new JTextArea("Search \n   by");
        SearchByTextArea.setFont(new Font("TimesRoman", Font.BOLD, 20));
        SearchByTextArea.setForeground(new Color(200, 200, 200));
        SearchByTextArea.setMargin(new Insets(0, 100, 0, 0));
        SearchByTextArea.setBounds(950, 50, 280, 60);
        SearchByTextArea.setEditable(false);
        SearchByTextArea.setBackground(mainframe.getBackground());

        for (int i = 0; i < 4; i++) {
            SearchByAtrButton[i] = new JButton("");
            SearchByAtrButton[i].setBounds(i % 2 == 0 ? 960 : 1100, i < 2 ? 130 : 160, 100, 30);
        }
        SearchByAtrButton[0].setText("Date");
        SearchByAtrButton[1].setText("Money");
        SearchByAtrButton[2].setText("In/Out");
        SearchByAtrButton[3].setText("Reason");

        UpdatenotifyArea = new JTextArea("");
        UpdatenotifyArea.setBounds(960, 200, 240, 190);
        UpdatenotifyArea.setEditable(false);
        UpdatenotifyArea.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        UpdatenotifyArea.setLineWrap(true);
        UpdatenotifyArea.setWrapStyleWord(true);

        UpdateAddButton = new JButton("Add");
        UpdateAddButton.setBounds(960, 400, 240, 50);
        UpdateAddButton.setFont(new Font("Impact", Font.PLAIN, 30));

        UpdateDeleteButton = new JButton("Delete");
        UpdateDeleteButton.setBounds(960, 450, 240, 50);
        UpdateDeleteButton.setFont(new Font("Impact", Font.PLAIN, 30));
        for (int i = 0; i < 3; i++) {
            InputField[i] = new JTextField("");
            InputField[i].setBorder(BlackBorder);
        }
        UpdateAddInputComponents = new JComponent[]{
            new JLabel("Date"),
            InputField[0],
            new JLabel("Money"),
            InputField[1],
            new JLabel("Reason"),
            InputField[2]
        };
        UpdateDeleteElementComponents = new JComponent[]{
            new JLabel("Input the date you want to delete"),
            InputField[0]
        };

        //                               UPDATE PANEL ADD ELEMENT
        UpdateJPanel.add(UpdateSearchInputArea);
        UpdateJPanel.add(UpdateSearchListJScrollPane);
        UpdateJPanel.add(SearchByTextArea);
        UpdateJPanel.add(UpdatenotifyArea);
        UpdateJPanel.add(UpdateAddButton);
        UpdateJPanel.add(UpdateDeleteButton);

        for (int i = 0; i < 4; i++) {
            UpdateJPanel.add(SearchByAtrButton[i]);
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Statistic panel">
        //                               STATISTIC PANEL
        StatisticJPanel = new JPanel();
        StatisticJPanel.setSize(1280, 720);
        StatisticJPanel.setLayout(null);
        StatisticJPanel.setVisible(false);

        graphIn = new DrawGraph(SumMoneyPerDay);
        graphIn.setBounds(240, 100, 800, 440);
        graphIn.setOpaque(false);

        GraphHoldingArea = new JTextArea("");
        GraphHoldingArea.setEditable(false);
        GraphHoldingArea.setBounds(graphIn.getBounds());
        GraphHoldingArea.setBorder(BlackBorderWidth3);

        StatisticNotifyArea = new JTextArea("");
        StatisticNotifyArea.setBounds(240, 550, 800, 30);
        StatisticNotifyArea.setFont(new Font("TimesRoman", Font.BOLD, 20));
        StatisticNotifyArea.setMargin(new Insets(0, 240, 0, 0));
        StatisticNotifyArea.setBackground(mainframe.getBackground());
        StatisticNotifyArea.setEditable(false);

        //                               STATISTIC PANEL ADD ELEMENTS
        StatisticJPanel.add(graphIn);
        StatisticJPanel.add(GraphHoldingArea);
        StatisticJPanel.add(StatisticNotifyArea);
        //</editor-fold>

        //                               MAIN FRAME ADD ELEMENTS
        mainframe.add(ReturnButton);
        mainframe.add(UpdateJPanel);
        mainframe.add(StatisticJPanel);
        mainframe.add(MenuJPanel);
        mainframe.add(CoordinateArea);
    }

    public void Start() {
        mainframe.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                CoordinateArea.setText("X: " + e.getX() + "\nY: " + e.getY());
            }
        });

        SortMenu[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IsSortMenuClicked[0]) {
                    SortDateDecreasing();
                } else {
                    SortDateIncreasing();
                }
                IsSortMenuClicked[0] = !IsSortMenuClicked[0];
                MenuArea.setText(PrintList());
            }
        });
        SortMenu[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IsSortMenuClicked[1]) {
                    SortMoneyDecreasing();
                } else {
                    SortMoneyIncreasing();
                }
                IsSortMenuClicked[1] = !IsSortMenuClicked[1];
                MenuArea.setText(PrintList());
            }
        });
        SortMenu[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IsSortMenuClicked[2]) {
                    SortInOutDecreasing();
                } else {
                    SortInOutIncreasing();
                }
                IsSortMenuClicked[2] = !IsSortMenuClicked[2];
                MenuArea.setText(PrintList());
            }
        });
        SortMenu[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (IsSortMenuClicked[3]) {
                    SortReasonDecreasing();
                } else {
                    SortReasonIncreasing();
                }
                IsSortMenuClicked[3] = !IsSortMenuClicked[3];
                MenuArea.setText(PrintList());
            }
        });
        //Menu Panel Button
        InteractiveMenuButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SumMoneyPerDay.getList().clear();
                    SortDateIncreasing();
                    ME.Read();

                    YearMonth yearMonth = YearMonth.of(ME.getList().get(ME.getList().size() - 1).getCurrentDate().getYear() + 1900, ME.getList().get(ME.getList().size() - 1).getCurrentDate().getMonth() + 1);
                    LocalDate fistofMonth = yearMonth.atDay(1);
                    LocalDate lastofMonth = yearMonth.atEndOfMonth();
                    Date firstDate = Date.from(fistofMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Date lastDate = Date.from(lastofMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    StatisticNotifyArea.setText("Graph of my spending of " + new SimpleDateFormat("MM/yyyy").format(firstDate));
                    for (int i = 0; i < ME.getList().size(); i++) {
                        int sum = 0;
                        MoneyManagement sumthuchi = new MoneyManagement();
                        Date oldDay = ME.getList().get(i).getCurrentDate();
                        if (oldDay.after(firstDate) || oldDay.equals(firstDate) || oldDay.equals(lastDate)) {
                            sumthuchi.setCurrentDate(oldDay);
                            while (i < ME.getList().size() && oldDay.compareTo(ME.getList().get(i).getCurrentDate()) == 0) {
                                sum += ME.getList().get(i).getThuChi();
                                i++;
                            }
                            sumthuchi.setThuChi(sum);
                            i--;
                            SumMoneyPerDay.getList().add(sumthuchi);
                        }
                    }
                    graphIn.setList(SumMoneyPerDay);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DateTimeException ex) {
                }

                MenuJPanel.setVisible(false);
                StatisticJPanel.setVisible(true);
                ReturnButton.setVisible(true);
            }

        });
        InteractiveMenuButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuJPanel.setVisible(false);
                UpdateJPanel.setVisible(true);
                ReturnButton.setVisible(true);
            }
        });
        InteractiveMenuButton[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //Add Panel Button
        SearchByAtrButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateSearchListArea.setText("");
                if (IsOccupied(UpdateSearchInputArea.getText())) {
                    Date t;
                    try {
                        t = dateFormat.parse(UpdateSearchInputArea.getText());
                        UpdatenotifyArea.setText("");
                        for (int i = 0; i < ME.getList().size(); i++) {
                            if (t.equals(ME.getList().get(i).getCurrentDate())) {
                                Date temp = ME.getList().get(0).getCurrentDate();
                                if (i > 0 && temp.compareTo(ME.getList().get(i).getCurrentDate()) == 0) {
                                    UpdateSearchListArea.append("\t " + Math.abs(ME.getList().get(i).getThuChi()) + " ---- " + (ME.getList().get(i).isIn() ? "In   " : "Out") + " ---- " + ME.getList().get(i).getReason() + "\n");
                                } else {
                                    temp = ME.getList().get(i).getCurrentDate();
                                    UpdateSearchListArea.append(ME.PrintAllAtr(i) + "\n");
                                }
                            }
                        }
                    } catch (ParseException ex) {
                        UpdatenotifyArea.setText("Date format error: \nTry again with Format:\n(dd-mm-yyyy)");
                    }

                } else {
                    UpdatenotifyArea.setText("\n\n          Input Required");
                }
            }
        });
        SearchByAtrButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateSearchListArea.setText("");
                boolean hasMoney = false;
                if (IsOccupied(UpdateSearchInputArea.getText())) {
                    try {
                        for (int i = 0; i < ME.getList().size(); i++) {
                            int temp = Integer.parseInt(UpdateSearchInputArea.getText());
                            if (ME.getList().get(i).getThuChi() == temp) {
                                hasMoney = true;
                                UpdateSearchListArea.append(ME.PrintAllAtr(i) + "\n");
                            }
                        }
                        if (!hasMoney) {
                            UpdatenotifyArea.setText("\n            This money\n             not found");
                        }
                    } catch (NumberFormatException ex) {
                        UpdatenotifyArea.setText("\n      Money can't \n       be a text!");
                    }
                } else {
                    UpdatenotifyArea.setText("\n\n          Input Required");
                }
            }
        });
        SearchByAtrButton[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateSearchListArea.setText("");
                boolean hasIn = false;
                if (IsOccupied(UpdateSearchInputArea.getText())) {
                    if ("In".equalsIgnoreCase(UpdateSearchInputArea.getText()) || UpdateSearchInputArea.getText().equalsIgnoreCase("Out")) {
                        for (int i = 0; i < ME.getList().size(); i++) {
                            try {
                                String temp = UpdateSearchInputArea.getText();
                                String InString = ME.getList().get(i).isIn() ? "In" : "Out";
                                if (InString.equalsIgnoreCase(temp)) {
                                    hasIn = true;
                                    UpdateSearchListArea.append(ME.PrintAllAtr(i) + "\n");
                                }
                            } catch (InputMismatchException ex) {
                                UpdatenotifyArea.setText("Please input 'In' or 'Out'!");
                            }
                        }
                        if (!hasIn) {
                            UpdatenotifyArea.setText("\n            This " + UpdateSearchInputArea.getText() + "\n             not found");
                        } else {
                            UpdatenotifyArea.setText("");
                        }
                    } else {
                        UpdatenotifyArea.setText("Please input 'In' or 'Out'!");
                    }

                } else {
                    UpdatenotifyArea.setText("\n\n          Input Required");
                }
            }
        });
        SearchByAtrButton[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateSearchListArea.setText("");
                boolean hasReason = false;
                if (IsOccupied(UpdateSearchInputArea.getText())) {
                    for (int i = 0; i < ME.getList().size(); i++) {
                        String temp = UpdateSearchInputArea.getText();
                        if (ME.getList().get(i).getReason().substring(0, temp.length()).equalsIgnoreCase(temp)) {
                            hasReason = true;
                            UpdateSearchListArea.append(ME.PrintAllAtr(i) + "\n");
                        }
                    }
                    if (!hasReason) {
                        UpdatenotifyArea.setText(" This \"" + UpdateSearchInputArea.getText() + "\" not found");
                    } else {
                        UpdatenotifyArea.setText("");
                    }

                } else {
                    UpdatenotifyArea.setText("\n\n          Input Required");
                }
            }
        });
        UpdateAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean InputError = false;
                boolean LeaveEmpty = false;

                do {
                    int result = JOptionPane.showConfirmDialog(null, UpdateAddInputComponents, "Add", JOptionPane.OK_CANCEL_OPTION);
                    InputError = false;
                    LeaveEmpty = false;
                    for (int i = 0; i < 3; i++) {
                        if (!IsOccupied(InputField[i].getText())) {
                            LeaveEmpty = true;
                            InputField[i].setText("Input required");

                        }
                    }
                    if (!LeaveEmpty) {
                        if (result == JOptionPane.OK_OPTION) {
                            try {
                                MoneyManagement tManagement = new MoneyManagement();
                                tManagement.setCurrentDate(dateFormat.parse(InputField[0].getText()));
                                try {
                                    tManagement.setThuChi(Integer.parseInt(InputField[1].getText()));
                                    tManagement.setReason(InputField[2].getText());
                                    for (int i = 0; i < 3; i++) {
                                        InputField[i].setBackground(mainframe.getBackground());
                                        InputField[i].setEditable(false);
                                        InputField[i].setBorder(null);
                                    }
                                    result = JOptionPane.showConfirmDialog(null, UpdateAddInputComponents, "Check", JOptionPane.OK_CANCEL_OPTION);
                                    if (result == JOptionPane.OK_OPTION) {
                                        JOptionPane.showConfirmDialog(null, "Save successfully", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                        ME.getList().add(tManagement);
                                        try {
                                            ME.Save();
                                        } catch (IOException ex) {
                                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        for (int i = 0; i < 3; i++) {
                                            InputField[i].setBackground(Color.WHITE);
                                            InputField[i].setBorder(BlackBorder);
                                            InputField[i].setEditable(true);
                                        }
                                        break;
                                    }
                                    for (int i = 0; i < 3; i++) {
                                        InputField[i].setBackground(Color.WHITE);
                                        InputField[i].setBorder(BlackBorder);
                                        InputField[i].setEditable(true);
                                    }
                                } catch (NumberFormatException ex) {
                                    InputError = true;
                                    JOptionPane.showConfirmDialog(null, "Money can't not be a text", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (ParseException ex) {
                                InputError = true;
                                JOptionPane.showConfirmDialog(null, "Please input right date format (dd-mm-yyyy)", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        InputError = true;
                        JOptionPane.showConfirmDialog(null, "Please input all required information", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                } while (InputError);
                for (int i = 0; i < 3; i++) {
                    InputField[i].setBackground(Color.WHITE);
                }
            }

        });
        UpdateDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean InputError = false;
                boolean LeaveEmpty = false;
                boolean hasDate = false;

                do {
                    int result = JOptionPane.showConfirmDialog(null, UpdateDeleteElementComponents, "Delete", JOptionPane.OK_CANCEL_OPTION);
                    InputError = false;
                    LeaveEmpty = false;
                    hasDate = false;
                    if (!IsOccupied(InputField[0].getText())) {
                        LeaveEmpty = true;
                        InputField[0].setText("Input required");
                    }

                    if (!LeaveEmpty) {
                        if (result == JOptionPane.OK_OPTION) {
                            try {

                                InputField[0].setBackground(mainframe.getBackground());
                                InputField[0].setEditable(false);
                                InputField[0].setBorder(null);
                                result = JOptionPane.showConfirmDialog(null, UpdateDeleteElementComponents, "Check", JOptionPane.OK_CANCEL_OPTION);
                                if (result == JOptionPane.OK_OPTION) {

                                    //DELETE
                                    MoneyManagement tManagement = new MoneyManagement();
                                    tManagement.setCurrentDate(dateFormat.parse(InputField[0].getText()));
                                    SortDateIncreasing();
                                    for (int i = 0; i < ME.getList().size(); i++) {
                                        if (tManagement.getCurrentDate().equals(ME.getList().get(i).getCurrentDate())) {
                                            hasDate = true;
                                            ME.getList().remove(i);
                                            i--;
                                        }
                                    }

                                    InputField[0].setBackground(Color.WHITE);
                                    InputField[0].setBorder(BlackBorder);
                                    InputField[0].setEditable(true);
                                    if (!hasDate) {
                                        JOptionPane.showConfirmDialog(null, "Date not found!", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        JOptionPane.showConfirmDialog(null, "Delete successfully", "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                    }
                                    try {
                                        ME.Save();
                                    } catch (IOException ex) {
                                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    InputField[0].setBackground(Color.WHITE);
                                    InputField[0].setBorder(BlackBorder);
                                    InputField[0].setEditable(true);
                                    break;
                                }
                            } catch (ParseException ex) {
                                InputField[0].setBackground(Color.WHITE);
                                InputField[0].setBorder(BlackBorder);
                                InputField[0].setEditable(true);
                                InputError = true;
                                JOptionPane.showConfirmDialog(null, "Please input right date format (dd-mm-yyyy)", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        InputField[0].setBackground(Color.WHITE);
                        InputField[0].setBorder(BlackBorder);
                        InputField[0].setEditable(true);
                        InputError = true;
                        JOptionPane.showConfirmDialog(null, "Please input all required information", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                } while (InputError);
                InputField[0].setBackground(Color.WHITE);
            }

        });
        //Other Button
        GenerateEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RandomEvent();
                    MenuArea.setText(PrintList());
                } catch (ParseException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ME.Save();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        ReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ME.Read();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                MenuArea.setText(PrintList());
                MenuJPanel.setVisible(true);
                UpdateJPanel.setVisible(false);
                StatisticJPanel.setVisible(false);
                ReturnButton.setVisible(false);
            }
        });

        mainframe.setVisible(true);
    }

    public boolean IsOccupied(String text) {
        return !text.equals("");
    }

    public void RandomEvent() throws ParseException {

        int number_of_event = rand.nextInt(10);
        MoneyManagement temp[] = new MoneyManagement[number_of_event];
        for (int i = 0; i < number_of_event; i++) {
            temp[i] = new MoneyManagement();
        }
        Calendar c = Calendar.getInstance();
        StringBuffer event = new StringBuffer();
        if (ME.getList().size() == 0) {
            Date t = dateFormat.parse("1-1-2019");
            for (int i = 0; i < number_of_event; i++) {
                temp[i].setCurrentDate(t);
            }
        } else {
            //Add 1 days
            c.setTime(ME.getList().get(ME.getList().size() - 1).getCurrentDate());
            c.add(Calendar.DATE, 1);
            for (int i = 0; i < number_of_event; i++) {
                temp[i].setCurrentDate(c.getTime());
            }
        }

        int option;
        for (int i = 0; i < number_of_event; i++) {
            option = rand.nextInt(10);
            switch (option) {
                case 0:
                    temp[i].setReason("Pick up some money!");
                    break;
                case 1:
                    temp[i].setReason("Sell a product");
                    break;
                case 2:
                    temp[i].setReason("My Parent give me some money!");
                    break;
                case 3:
                    temp[i].setReason("Pickpocket someone in the street!");
                    break;
                case 4:
                    temp[i].setReason("Rob someone's purse");
                    break;
                case 5:
                    temp[i].setReason("Drop my wallet");
                    break;
                case 6:
                    temp[i].setReason("Buy some new cloth");
                    break;
                case 7:
                    temp[i].setReason("Not passed an exam!");
                    break;
                case 8:
                    temp[i].setReason("Get caught cause of riding over 100km/h");
                    break;
                case 9:
                    temp[i].setReason("Buy some new food!");
                    break;
                default:
                    break;
            }
            if (option < 5) {
                option = rand.nextInt(80);
                temp[i].setThuChi(100000 - option * 1000);
            } else {
                option = rand.nextInt(80);
                temp[i].setThuChi(-100000 + option * 1000);
            }
            ME.getList().add(temp[i]);
        }
    }

    public String PrintList() {
        StringBuffer sb = new StringBuffer("");
        if (ME.getList().size() > 0) {
            Date temp = ME.getList().get(0).getCurrentDate();
            for (int i = 0; i < ME.getList().size(); i++) {
                if (i > 0 && temp.compareTo(ME.getList().get(i).getCurrentDate()) == 0) {
                    sb.append("\t " + Math.abs(ME.getList().get(i).getThuChi()) + " ---- " + (ME.getList().get(i).isIn() ? "In   " : "Out") + " ---- " + ME.getList().get(i).getReason() + "\n");
                } else {
                    temp = ME.getList().get(i).getCurrentDate();
                    sb.append(ME.PrintAllAtr(i) + "\n");
                }
            }
        }
        return sb.toString();
    }

    //<editor-fold defaultstate="collapsed" desc="Sort By attribute">
    public void SortDateIncreasing() {
        Collections.sort(ME.getList(), (MoneyManagement o1, MoneyManagement o2) -> {
            if (o1.getDate().compareTo(o2.getDate()) > 0) {
                return 1;
            } else if (o1.getDate().compareTo(o2.getDate()) == 0) {
                return 0;
            } else {
                return -1;
            }
        });
    }

    public void SortDateDecreasing() {
        Collections.sort(ME.getList(), (MoneyManagement o1, MoneyManagement o2) -> {
            if (o1.getDate().compareTo(o2.getDate()) < 0) {
                return 1;
            } else if (o1.getDate().compareTo(o2.getDate()) == 0) {
                return 0;
            } else {
                return -1;
            }
        });
    }

    public void SortMoneyIncreasing() {
        Collections.sort(ME.getList(), (MoneyManagement o1, MoneyManagement o2) -> {
            if (Math.abs(o1.getThuChi()) > Math.abs(o2.getThuChi())) {
                return 1;
            } else if (Math.abs(o1.getThuChi()) == Math.abs(o2.getThuChi())) {
                return 0;
            } else {
                return -1;
            }
        });
    }

    public void SortMoneyDecreasing() {
        Collections.sort(ME.getList(), (MoneyManagement o1, MoneyManagement o2) -> {
            if (Math.abs(o1.getThuChi()) < Math.abs(o2.getThuChi())) {
                return 1;
            } else if (Math.abs(o1.getThuChi()) == Math.abs(o2.getThuChi())) {
                return 0;
            } else {
                return -1;
            }
        });
    }

    public void SortInOutIncreasing() {
        Collections.sort(ME.getList(), (MoneyManagement o1, MoneyManagement o2) -> {
            return Boolean.compare(o1.isIn(), o2.isIn());
        });
    }

    public void SortInOutDecreasing() {
        Collections.sort(ME.getList(), (MoneyManagement o1, MoneyManagement o2) -> {
            return Boolean.compare(o2.isIn(), o1.isIn());
        });
    }

    public void SortReasonIncreasing() {
        Collections.sort(ME.getList(), (MoneyManagement o1, MoneyManagement o2) -> {
            if (o1.getReason().compareTo(o2.getReason()) > 0) {
                return 1;
            } else if (o1.getReason().compareTo(o2.getReason()) == 0) {
                return 0;
            } else {
                return -1;
            }
        });
    }

    public void SortReasonDecreasing() {
        Collections.sort(ME.getList(), (MoneyManagement o1, MoneyManagement o2) -> {
            if (o1.getReason().compareTo(o2.getReason()) < 0) {
                return 1;
            } else if (o1.getReason().compareTo(o2.getReason()) == 0) {
                return 0;
            } else {
                return -1;
            }
        });
    }
    //</editor-fold>
}
