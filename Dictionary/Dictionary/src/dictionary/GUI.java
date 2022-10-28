package dictionary;

import com.sun.org.apache.xpath.internal.patterns.NodeTest;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
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
import javax.swing.KeyStroke;

public final class GUI {

    //<editor-fold defaultstate="collapsed" desc="Declaration">
    //Main frame
    private JFrame mainFrame;
    private JTextArea CoordinateArea;
    private JLabel LoadingJLabel;

    //MENU PANEL
    private JPanel MenuPanel;
    private JTextArea MenuSearchArea;
    private JTextArea MenuResultArea;
    private JScrollPane MenuSearchJScrollPane;
    private JScrollPane MenuResultJScrollPane;
    private final JButton SearchButtonJbutton[] = new JButton[4];
    private final ArrayList<Boolean> CheckButton = new ArrayList<>();
    private JButton TestButton;
    private JLabel TestButtonLabel;
    private JTextArea TutorialArea;
    private JButton AddNewWordButton;
    private JLabel AddNewWordLabel;
    private JTextField addField[] = new JTextField[2];
    private JComponent[] AddComponents;

    //TEST PANEL
    private JPanel TestPanel;
    private final JButton QuestionButton[] = new JButton[10];
    private final JLabel QuestionButtonLabel[] = new JLabel[QuestionButton.length];
    private final JLabel QuestionLabel[] = new JLabel[QuestionButton.length];
    private final JTextArea AnswerArea[] = new JTextArea[QuestionButton.length];
    private final boolean QuestionButtonClicked[] = new boolean[QuestionButton.length];
    private ArrayList<String> QuestionBank = new ArrayList<>();
    private JButton FinishButton;
    private JLabel FinishLabel;
    private boolean Right_Ans[] = new boolean[10];
    private int Score;

    //RESULT PANEL
    private JPanel ResultPanel;
    private JTextArea NotifyHeader;
    private JTextArea NotifyArea;
    private JScrollPane NotifyScrollPane;
    private JButton ReturnButton;
    private JLabel ReturnLabel;
    private int next;

    //Other
    private final Dictionary myDictionary = new Dictionary();
    private Action F5Action;
    //Not important

    private final Border GrayBorder = BorderFactory.createLineBorder(new Color(187, 187, 187), 2);
    private final Color GoogleColor = new Color(26, 115, 232);
    private final File[] allFile = new File("src\\dictionary\\res").listFiles();
    private final BufferedImage allImg[] = new BufferedImage[allFile.length];

    //</editor-fold>
    public GUI() throws IOException {
        prepareGUI();
    }

    public static void main(String[] args) throws IOException {
        new GUI().Start();
    }

    public void prepareGUI() throws IOException {

        //<editor-fold defaultstate="collapsed" desc="Main Frame Declaration">
        //Main Frame
        mainFrame = new JFrame("Dictionary");
        mainFrame.setLayout(null);
        mainFrame.setLocation(320, 180);
        mainFrame.setSize(1280, 720);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Coordinate
        CoordinateArea = new JTextArea("");
        CoordinateArea.setBounds(10, 10, 100, 50);
        CoordinateArea.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        CoordinateArea.setBackground(mainFrame.getBackground());
        CoordinateArea.setEditable(false);

        F5Action = new F5ACTION();

        LoadingJLabel = new JLabel("Generating questions ...");
        LoadingJLabel.setBounds(450, 270, 500, 100);
        LoadingJLabel.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        LoadingJLabel.setVisible(false);

        for (int i = 0; i < allFile.length; i++) {
            allImg[i] = ImageIO.read(allFile[i]);
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="MENU PANEL">
        //              MENU PANEL
        MenuPanel = new JPanel();
        MenuPanel.setLayout(null);
        MenuPanel.setSize(1280, 720);

        MenuSearchArea = new HintTextArea("\n                Enter some Text here");
        MenuSearchArea.setBorder(GrayBorder);
        MenuSearchArea.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        MenuSearchArea.setLineWrap(true);
        MenuSearchArea.setWrapStyleWord(true);
        MenuSearchArea.setMargin(new Insets(20, 20, 0, 0));
        MenuSearchJScrollPane = new JScrollPane(MenuSearchArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        MenuSearchJScrollPane.setBounds(100, 200, 540, 370);

        MenuResultArea = new JTextArea();
        MenuResultArea.setEditable(false);
        MenuResultArea.setBorder(GrayBorder);
        MenuResultArea.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        MenuResultJScrollPane = new JScrollPane(MenuResultArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        MenuResultJScrollPane.setBounds(640, 200, 540, 370);

        for (int i = 0; i < 4; i++) {
            SearchButtonJbutton[i] = new JButton("");
            SearchButtonJbutton[i].setBounds((i < 2 ? 100 : 640) + i % 2 * 100, 150, 100, 45);
            SearchButtonJbutton[i].setContentAreaFilled(false);
            SearchButtonJbutton[i].setFont(new Font("TimesRoman", Font.BOLD, 30));
            SearchButtonJbutton[i].setForeground(new Color(187, 187, 187));
            if (i == 0 || i == 3) {
                SearchButtonJbutton[i].setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, GoogleColor));
                SearchButtonJbutton[i].setForeground(GoogleColor);
            } else {
                SearchButtonJbutton[i].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLUE));
            }
        }

        SearchButtonJbutton[0].setText("Viet");
        SearchButtonJbutton[1].setText("Eng");
        SearchButtonJbutton[2].setText("Viet");
        SearchButtonJbutton[3].setText("Eng");
        CheckButton.add(true);
        CheckButton.add(false);
        CheckButton.add(false);
        CheckButton.add(true);

        TestButton = new JButton();
        TestButton.setBounds(540, 580, 200, 70);
        TestButton.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        TestButton.setBorder(null);
        TestButton.setContentAreaFilled(false);
        TestButton.setIcon(new ImageIcon(allImg[4].getScaledInstance(220, 140, Image.SCALE_SMOOTH)));

        TestButtonLabel = new JLabel("TEST YOUR SKILL");
        TestButtonLabel.setForeground(Color.WHITE);
        TestButtonLabel.setHorizontalAlignment(JLabel.CENTER);
        TestButtonLabel.setOpaque(false);
        TestButtonLabel.setBounds(TestButton.getBounds());
        TestButtonLabel.setFont(new Font("TimesRoman", Font.BOLD, 20));

        TutorialArea = new JTextArea("While in the search area. \nPress F5 on your key board to translate!");
        TutorialArea.setBounds(400, 30, 800, 100);
        TutorialArea.setOpaque(false);
        TutorialArea.setBorder(null);
        TutorialArea.setFont(new Font("TimesRoman", Font.BOLD, 30));
        TutorialArea.setEditable(false);

        AddNewWordButton = new JButton();
        AddNewWordButton.setIcon(new ImageIcon(allImg[4].getScaledInstance(220, 140, Image.SCALE_SMOOTH)));
        AddNewWordButton.setBounds(1000, 580, 200, 70);
        AddNewWordButton.setOpaque(false);
        AddNewWordButton.setContentAreaFilled(false);
        AddNewWordButton.setBorder(null);

        AddNewWordLabel = new JLabel();
        AddNewWordLabel.setBounds(AddNewWordButton.getBounds());
        AddNewWordLabel.setText("+");
        AddNewWordLabel.setHorizontalAlignment(JLabel.CENTER);
        AddNewWordLabel.setFont(new Font("Impact", Font.BOLD, 50));
        AddNewWordLabel.setForeground(Color.WHITE);

        for (int i = 0; i < 2; i++) {
            addField[i] = new JTextField();
        }
        AddComponents = new JComponent[]{
            new JLabel("English"),
            addField[0],
            new JLabel("Vietnamese"),
            addField[1]
        };

        //              MENU PANEL ADD ELEMENTS
        MenuPanel.add(AddNewWordLabel);
        MenuPanel.add(AddNewWordButton);
        MenuPanel.add(TutorialArea);
        MenuPanel.add(TestButtonLabel);
        MenuPanel.add(TestButton);
        MenuPanel.add(MenuSearchJScrollPane);
        MenuPanel.add(MenuResultJScrollPane);
        for (int i = 0; i < 4; i++) {
            MenuPanel.add(SearchButtonJbutton[i]);
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="TEST PANEL">
        //              TEST PANEL
        TestPanel = new JPanel();
        TestPanel.setBounds(0, 0, 1280, 720);
        TestPanel.setLayout(null);
        TestPanel.setVisible(false);
        for (int i = 0; i < QuestionButton.length; i++) {
            QuestionButton[i] = new JButton();
            QuestionButton[i].setBounds(270 + (i % QuestionButton.length) * 80, 510, 80, 50);
            QuestionButton[i].setBorder(null);
            QuestionButton[i].setOpaque(false);
            QuestionButton[i].setContentAreaFilled(false);
            QuestionButton[i].setIcon(new ImageIcon(allImg[0].getScaledInstance(80, 50, Image.SCALE_SMOOTH)));

            QuestionButtonLabel[i] = new JLabel("" + (i + 1));
            QuestionButtonLabel[i].setHorizontalAlignment(JLabel.CENTER);
            QuestionButtonLabel[i].setFont(new Font("TimesRoman", Font.PLAIN, 30));
            QuestionButtonLabel[i].setForeground(Color.WHITE);
            QuestionButtonLabel[i].setBounds(QuestionButton[i].getBounds());

            QuestionLabel[i] = new JLabel();
            QuestionLabel[i].setBounds(200, 200, 300 + 70 * 9, 250);
            QuestionLabel[i].setFont(new Font("TimesRoman", Font.BOLD, 100));
            QuestionLabel[i].setVisible(false);

            AnswerArea[i] = new HintTextArea("Input your Answer here");
            AnswerArea[i].setMargin(new Insets(0, 20, 0, 0));
            AnswerArea[i].setBounds(200, 460, 300 + 70 * 9, 40);
            AnswerArea[i].setFont(new Font("TimesRoman", Font.PLAIN, 30));
            AnswerArea[i].setVisible(false);

            QuestionButtonClicked[i] = false;
            ButtonEffect(i);
        }
        FinishButton = new JButton();
        FinishButton.setBounds(TestButton.getBounds());
        FinishButton.setBorder(null);
        FinishButton.setContentAreaFilled(false);
        FinishButton.setIcon(new ImageIcon(allImg[4].getScaledInstance(220, 140, Image.SCALE_SMOOTH)));

        FinishLabel = new JLabel("FINISH");
        FinishLabel.setForeground(Color.WHITE);
        FinishLabel.setHorizontalAlignment(JLabel.CENTER);
        FinishLabel.setOpaque(false);
        FinishLabel.setBounds(TestButton.getBounds());
        FinishLabel.setFont(new Font("TimesRoman", Font.BOLD, 40));

        myDictionary.Read();

        //              TEST PANEL ADD ELEMENTS
        for (int i = 0; i < QuestionButton.length; i++) {
            TestPanel.add(QuestionLabel[i]);
            TestPanel.add(AnswerArea[i]);
            TestPanel.add(QuestionButtonLabel[i]);
            TestPanel.add(QuestionButton[i]);
        }
        TestPanel.add(FinishLabel);
        TestPanel.add(FinishButton);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="RESULT PANEL">
        //              RESULT PANEL
        ResultPanel = new JPanel();
        ResultPanel.setLayout(null);
        ResultPanel.setBounds(MenuPanel.getBounds());
        ResultPanel.setVisible(false);

        NotifyArea = new JTextArea("");
        NotifyArea.setFont(new Font("TimesRoman", Font.BOLD, 30));
        NotifyArea.setBounds(200, 200, 300 + 70 * 9, 300);
        NotifyArea.setEditable(false);
        NotifyArea.setLineWrap(true);
        NotifyArea.setWrapStyleWord(true);

        NotifyHeader = new JTextArea("");
        NotifyHeader.setBorder(null);
        NotifyHeader.setOpaque(false);
        NotifyHeader.setFont(new Font("TimesRoman", Font.BOLD, 50));
        NotifyHeader.setBounds(200, 100, 300 + 70 * 9, 100);
        NotifyHeader.setEditable(false);

        NotifyScrollPane = new JScrollPane(NotifyArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        NotifyScrollPane.setBounds(200, 200, 300 + 70 * 9, 300);

        ReturnButton = new JButton();
        ReturnButton.setBounds(FinishButton.getBounds());
        ReturnButton.setOpaque(false);
        ReturnButton.setBorder(null);
        ReturnButton.setContentAreaFilled(false);
        ReturnButton.setIcon(new ImageIcon(allImg[4].getScaledInstance(220, 140, Image.SCALE_SMOOTH)));

        ReturnLabel = new JLabel("BACK");
        ReturnLabel.setFont(FinishLabel.getFont());
        ReturnLabel.setForeground(Color.WHITE);
        ReturnLabel.setBounds(FinishButton.getBounds());
        ReturnLabel.setHorizontalAlignment(JLabel.CENTER);
        //              RESULT PANEL ADD ELEMENTS
        ResultPanel.add(ReturnLabel);
        ResultPanel.add(ReturnButton);
        ResultPanel.add(NotifyHeader);
        ResultPanel.add(NotifyScrollPane);
        //</editor-fold>

        //              MAIN FRAME ADD ELEMENTS
        mainFrame.add(ResultPanel);
        mainFrame.add(TestPanel);
        mainFrame.add(LoadingJLabel);
        //mainFrame.add(CoordinateArea);
        mainFrame.add(MenuPanel);

    }

    public void Start() {
        mainFrame.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                CoordinateArea.setText("X: " + e.getX() + "\nY: " + e.getY());
            }
        });
        MenuSearchArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "F5action");
        MenuSearchArea.getActionMap().put("F5action", F5Action);
        TestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 10; i++) {
                    QuestionButtonClicked[i] = false;
                    QuestionButton[i].setIcon(new ImageIcon(allImg[0].getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
                    QuestionLabel[i].setVisible(false);
                    AnswerArea[i].setText("");
                }
                MenuPanel.setVisible(false);
                LoadingJLabel.setVisible(true);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        LoadingJLabel.setText(LoadingText(LoadingJLabel.getText()));
                    }
                }, 0, 500);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        LoadingJLabel.setVisible(false);
                        TestPanel.setVisible(true);
                        timer.cancel();
                    }
                }, 3000, 1);
                QuestionBank = RandomWord(myDictionary.myDictionary);
                QuestionLabel[0].setVisible(true);
                AnswerArea[0].setVisible(true);
                QuestionButton[0].setIcon(new ImageIcon(allImg[2].getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
                QuestionButtonClicked[0] = true;
                QuestionLabel[0].setText(QuestionBank.get(0));
            }
        });
        for (int i = 0; i < QuestionButton.length; i++) {
            CreateActionListenerForTestButton(i);
        }
        //Menu Button
        for (int i = 0; i < CheckButton.size(); i++) {
            CreateActionListenerForMenuButton(i);
        }
        ReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultPanel.setVisible(false);
                TestPanel.setVisible(false);
                MenuPanel.setVisible(true);
            }
        });
        FinishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Score = 0;
                boolean All_Answered = true;
                for (int i = 0; i < AnswerArea.length; i++) {
                    if (AnswerArea[i].getText().equals("")) {
                        All_Answered = false;
                        QuestionButton[i].setIcon(new ImageIcon(allImg[5].getScaledInstance(QuestionButton[i].getWidth(), QuestionButton[i].getHeight(), Image.SCALE_SMOOTH)));
                        QuestionButtonClicked[i] = false;
                        ShakeEffect(mainFrame);
                    } else {
                        if (AnswerArea[i].getText().compareToIgnoreCase(myDictionary.myDictionary.get(QuestionBank.get(i))) == 0) {
                            Right_Ans[i] = true;
                            Score++;
                        } else {
                            Right_Ans[i] = false;
                        }
                    }
                }
                if (All_Answered) {
                    NotifyArea.setText("");
                    Random rand = new Random();
                    TestPanel.setVisible(false);
                    ResultPanel.setVisible(true);
                    NotifyHeader.setText("                        You get 0/10");
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            NotifyHeader.setText("                        You get " + rand.nextInt(11) + "/10");
                        }
                    }, 50, 5);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            NotifyHeader.setText("                        You get " + Score + "/10");
                            timer.cancel();
                        }
                    }, 1000, 1);

                    next = 0;

                    Timer timer2 = new Timer();
                    timer2.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (next == 10) {
                                timer2.cancel();
                            } else {
                                NotifyArea.append("#" + (next + 1) + ". " + QuestionBank.get(next) + "    | Your Answer : " + AnswerArea[next].getText()
                                        + "| Correct Answer: " + myDictionary.myDictionary.get(QuestionBank.get(next)) + "\n");
                            }
                            next++;
                        }
                    }, 1500, 50);
                }
            }
        });
        AddNewWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 2; i++) {
                    addField[i].setText("");
                }
                boolean Input_Error = true;
                do {
                    Input_Error = true;
                    int option = JOptionPane.showConfirmDialog(null, AddComponents, "Add new Word", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        boolean isEmpty = false;
                        for (int i = 0; i < 2; i++) {
                            if (addField[i].getText().compareTo("") == 0 || addField[i].getText().compareToIgnoreCase("    Input required!") == 0) {
                                addField[i].setText("    Input required!");
                                isEmpty = true;
                                Input_Error = true;
                            }
                        }
                        if (!isEmpty) {
                            myDictionary.myDictionary.put(addField[0].getText(), addField[1].getText());
                            myDictionary.Save();
                            Input_Error = false;
                        }
                    } else {
                        Input_Error = false;
                    }
                } while (Input_Error);
            }
        });
        mainFrame.setVisible(true);
    }

    private String LoadingText(String LoadingTest) {
        String temp = "";
        switch (LoadingTest.length()) {
            case 22:
                temp = "Generating questions ..";
                break;
            case 23:
                temp = "Generating questions ...";
                break;
            case 24:
                temp = "Generating questions .";
                break;
        }
        return temp;
    }

    private void CreateActionListenerForTestButton(int i) {
        QuestionButton[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int j = 0; j < QuestionButton.length; j++) {
                    QuestionLabel[j].setVisible(false);
                    AnswerArea[j].setVisible(false);
                    if (QuestionButtonClicked[j]) {
                        QuestionButtonClicked[j] = false;
                        QuestionButton[j].setIcon(new ImageIcon(allImg[0].getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
                    }
                }
                QuestionButton[i].setIcon(new ImageIcon(allImg[2].getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
                QuestionLabel[i].setVisible(true);
                QuestionLabel[i].setText(QuestionBank.get(i));
                QuestionButtonClicked[i] = true;
                AnswerArea[i].setVisible(true);
            }
        });
    }

    private void CreateActionListenerForMenuButton(int i) {
        SearchButtonJbutton[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuResultArea.setText("");
                MenuSearchArea.setText("");
                if (!CheckButton.get(i)) {
                    for (int i = 0; i < 4; i++) {
                        boolean temp = !CheckButton.get(i);
                        CheckButton.set(i, temp);
                    }
                    for (int i = 0; i < 4; i++) {
                        if (CheckButton.get(i)) {
                            SearchButtonJbutton[i].setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, GoogleColor));
                            SearchButtonJbutton[i].setForeground(GoogleColor);
                        } else {
                            SearchButtonJbutton[i].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLUE));
                            SearchButtonJbutton[i].setForeground(new Color(187, 187, 187));

                        }
                    }
                }
            }
        });

    }

    private ArrayList<String> RandomWord(Hashtable<String, String> a) {
        ArrayList<String> temp = new ArrayList<>();
        Object[] t = a.keySet().toArray();
        Random rand = new Random();

        while (temp.size() < 10) {
            boolean has_word = false;
            String temporary = t[rand.nextInt(a.size())].toString();
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).compareToIgnoreCase(temporary) == 0) {
                    has_word = true;
                    break;
                }
            }
            if (!has_word) {
                temp.add(temporary);
            }
        }
        return temp;
    }

    private void ButtonEffect(int i) {
        QuestionButton[i].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!QuestionButtonClicked[i]) {
                    QuestionButton[i].setIcon(new ImageIcon(allImg[0].getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (!QuestionButtonClicked[i]) {
                    QuestionButton[i].setIcon(new ImageIcon(allImg[1].getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!QuestionButtonClicked[i]) {
                    QuestionButton[i].setIcon(new ImageIcon(allImg[0].getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
                }
            }
        });
    }

    private void ShakeEffect(Component o) {
        Point curLocation = o.getLocation();
        Point Position1 = new Point(o.getX() + 5, o.getY() + 5);
        Point Position2 = new Point(o.getX() - 10, o.getY() - 10);
        for (int i = 0; i < 100; i++) {
            o.setLocation(Position1);
            o.setLocation(Position2);
        }
        o.setLocation(curLocation);
    }

    private class F5ACTION extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            MenuResultArea.setText("");
            String in = MenuSearchArea.getText().toLowerCase();
            try {

                in = in.substring(0, 1).toUpperCase() + in.substring(1, in.length());
                if (!CheckButton.get(0)) {
                    if (myDictionary.myDictionary.containsKey(in)) {
                        MenuResultArea.setText(myDictionary.myDictionary.get(in));
                    } else {
                        for (String i : myDictionary.myDictionary.keySet()) {
                            if (i.contains(in) || i.contains(in.toLowerCase())) {
                                MenuResultArea.append(i + "\n");
                            }
                        }
                    }
                } else {
                    boolean hasKeyWord = false;
                    for (String i : myDictionary.myDictionary.keySet()) {
                        if (myDictionary.myDictionary.get(i).compareToIgnoreCase(in) == 0) {
                            MenuResultArea.setText(i);
                            hasKeyWord = true;
                        }
                    }
                    if (!hasKeyWord) {
                        for (String i : myDictionary.myDictionary.keySet()) {
                            if (myDictionary.myDictionary.get(i).contains(in) || myDictionary.myDictionary.get(i).contains(in.toLowerCase())) {
                                MenuResultArea.append(myDictionary.myDictionary.get(i) + "\n");
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                MenuResultArea.setText("\n                  ----Input Required----");
            }
        }
    }

    private class HintTextArea extends JTextArea implements FocusListener {

        private String hint;
        private boolean showingHint;

        public HintTextArea(final String hint) {
            super(hint);
            super.setForeground(Color.LIGHT_GRAY);
            this.hint = hint;
            this.showingHint = true;
            super.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText("");
                showingHint = false;
                super.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(hint);
                super.setForeground(Color.LIGHT_GRAY);
                showingHint = true;
            }
        }

        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
        }

        @Override
        public void setText(String text) {
            if (text.equals("")) {
                super.setText(hint);
                super.setForeground(Color.LIGHT_GRAY);
                showingHint = true;
            } else {
                super.setText(text);
            }
        }
    }
}
