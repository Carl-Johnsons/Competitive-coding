package lab3src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class GUI {

    private JFrame mainframe;
    private JButton MenuButton[] = new JButton[3];
    private JPanel MenupJPanel;
    private JButton ReturnButton;
    private JButton Clear;

    private JPanel AddPanel;
    private JTextArea AddTextArea[] = new JTextArea[12];
    private JButton AddButton;
    private JPanel AddGUI;

    private JPanel ListPanel;
    private JTextArea ListArea;
    private JTextArea SearchArea;
    private JScrollPane scrollList;
    private JButton ShowListButton;
    private JButton SearchAuthourButton;
    private JButton SearchNameButton;

    private JTextArea header;
    private JTextArea notify;
    private JTextArea Coordinate;
    private Font NormalTRMFont = new Font("TimeRomans", Font.PLAIN, 20);

    private ImageIcon WarningIcon = new ImageIcon("C:\\Users\\Acer\\OneDrive\\Desktop\\FA22\\PRO\\Lab\\Lab3src\\src\\lab3src\\Pic\\Warning_icon.svg.png");
    private ImageIcon CheckIcon = new ImageIcon("C:\\Users\\Acer\\OneDrive\\Desktop\\FA22\\PRO\\Lab\\Lab3src\\src\\lab3src\\Pic\\sign-check-icon_large.png");

    private ArrayList<EBook> MyBook = new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public GUI() {
        prepareGUI();
    }

    public void prepareGUI() {
        //mainframe
        mainframe = new JFrame("EBook Management!!!");
        mainframe.setResizable(false);
        mainframe.setLocationRelativeTo(null);
        mainframe.setLocation(320, 180);
        mainframe.setLayout(null);
        mainframe.setSize(1280, 720);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Icon
        Image tempImg = WarningIcon.getImage();
        Image newIcon = tempImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        WarningIcon.setImage(newIcon);

        tempImg = CheckIcon.getImage();
        newIcon = tempImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        CheckIcon.setImage(newIcon);
        //header
        header = new JTextArea("Welcome to EBook Management!!");
        header.setFont(new Font("TimeRomans", Font.BOLD, 50));
        header.setBounds(150, 100, 1000, 150);
        header.setEditable(false);
        header.setLineWrap(true);
        header.setWrapStyleWord(true);
        header.setMargin(new Insets(0, 100, 50, 0));
        header.setBackground(mainframe.getBackground());

        //Coordinate
        Coordinate = new JTextArea("");
        Coordinate.setBounds(100, 300, 200, 100);
        Coordinate.setFont(NormalTRMFont);
        Coordinate.setEditable(false);
        Coordinate.setBackground(mainframe.getBackground());

        //Return to menu
        ReturnButton = new JButton("Return to menu");
        ReturnButton.setBounds(50, 50, 200, 50);
        ReturnButton.setFont(NormalTRMFont);
        ReturnButton.setVisible(false);

        //Menu
        MenupJPanel = new JPanel();
        MenupJPanel.setLayout(null);
        MenupJPanel.setSize(1280, 720);

        int x = 470;
        int y = 270;
        for (int i = 0; i < 3; i++) {
            MenuButton[i] = new JButton("");
            MenuButton[i].setBounds(x, y, 300, 100);
            MenuButton[i].setFont(NormalTRMFont);
            y += 130;
            MenupJPanel.add(MenuButton[i]);
        }
        MenuButton[0].setText("Add new ebook");
        MenuButton[1].setText("Show all ebook");
        MenuButton[2].setText("Quit");
        MenupJPanel.add(header);
        //Add Panel
        AddPanel = new JPanel();
        AddPanel.setVisible(false);
        AddPanel.setLayout(null);
        AddPanel.setSize(1280, 720);

        AddGUI = new JPanel();
        AddGUI.setSize(300, 200);
        AddGUI.setLocation(520, 320);
        AddGUI.setFont(NormalTRMFont);
        AddGUI.setLayout(null);

        AddButton = new JButton("Add new Ebook");
        AddButton.setBounds(500, 610, 300, 50);
        AddButton.setFont(NormalTRMFont);
        AddPanel.add(AddButton);
        AddButton.setVisible(true);

        x = 350;
        y = 50;

        for (int i = 0; i < 12; i++) {
            AddTextArea[i] = new JTextArea("");
            AddTextArea[i].setBounds(i % 2 == 0 ? x : x + 200, y, i % 2 == 0 ? 200 : 500, 70);
            AddTextArea[i].setEditable(i % 2 == 0 ? false : true);
            AddTextArea[i].setBackground(i % 2 == 0 ? mainframe.getBackground() : Color.WHITE);
            AddTextArea[i].setFont(i % 2 == 0 ? new Font("Impact", Font.PLAIN, 30) : NormalTRMFont);
            AddTextArea[i].setMargin(i % 2 == 0 ? new Insets(20, 0, 0, 0) : new Insets(0, 0, 0, 0));
            AddTextArea[i].setLineWrap(true);
            AddTextArea[i].setWrapStyleWord(true);
            AddPanel.add(AddTextArea[i]);
            y = i % 2 == 0 ? y : y + 80;
        }
        AddTextArea[0].setText("ID: ");
        AddTextArea[2].setText("Name: ");
        AddTextArea[4].setText("Year:");
        AddTextArea[6].setText("Author");
        AddTextArea[8].setText("URL: ");
        AddTextArea[10].setText("Size (kilobyte): ");

        //List Panel
        ListPanel = new JPanel();
        ListPanel.setSize(1280, 720);
        ListPanel.setVisible(false);
        ListPanel.setLayout(null);

        ListArea = new JTextArea("");
        ListArea.setFont(NormalTRMFont);
        ListArea.setEditable(false);
        ListArea.setLineWrap(true);
        ListArea.setWrapStyleWord(true);
        ListArea.setMargin(new Insets(0, 30, 0, 0));

        ShowListButton = new JButton("Show All");
        ShowListButton.setBounds(530, 620, 200, 50);
        SearchAuthourButton = new JButton("Search Author");
        SearchAuthourButton.setBounds(870, 100, 150, 50);
        SearchNameButton = new JButton("Search Title");
        SearchNameButton.setBounds(870, 150, 150, 50);

        scrollList = new JScrollPane(ListArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollList.setBounds(370, 210, 650, 400);

        SearchArea = new JTextArea("");
        SearchArea.setFont(NormalTRMFont);
        SearchArea.setLineWrap(true);
        SearchArea.setWrapStyleWord(true);
        SearchArea.setBounds(370, 100, 500, 100);

        ListPanel.add(scrollList);
        ListPanel.add(SearchArea);
        ListPanel.add(SearchAuthourButton);
        ListPanel.add(SearchNameButton);
        ListPanel.add(ShowListButton);

        //Clear
        Clear = new JButton("Clear");
        Clear.setBounds(850, 610, 100, 50);
        Clear.setFont(NormalTRMFont);
        AddPanel.add(Clear);

        mainframe.add(ReturnButton);
        mainframe.add(Coordinate);
        mainframe.add(AddPanel);
        mainframe.add(ListPanel);
        mainframe.add(MenupJPanel);

        try {
            Read();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void RunSystem() {
        MenuButton[0].addActionListener((e) -> {
            MenupJPanel.setVisible(false);
            AddPanel.setVisible(true);
            ReturnButton.setVisible(true);
        });

        MenuButton[1].addActionListener((e) -> {
            MenupJPanel.setVisible(false);
            ListPanel.setVisible(true);
            ReturnButton.setVisible(true);
        });

        MenuButton[2].addActionListener((e) -> {
            System.exit(0);
        });
        ReturnButton.addActionListener((e) -> {
            MenupJPanel.setVisible(true);
            AddPanel.setVisible(false);
            ListPanel.setVisible(false);
            ReturnButton.setVisible(false);
        });
        AddButton.addActionListener((e) -> {
            boolean Error = false;
            for (int i = 1; i < 12; i += 2) {
                if (!IsOccupied(AddTextArea[i])) {
                    Error = true;
                    AddTextArea[i].setText("Input Required!");
                }
            }
            if (!Error) {
                EBook temp = new EBook();
                temp.setID(AddTextArea[1].getText());
                temp.setName(AddTextArea[3].getText());
                temp.setYear(Integer.parseInt(AddTextArea[5].getText()));
                temp.setAuthor(AddTextArea[7].getText());
                temp.SetURL(AddTextArea[9].getText());
                temp.SetSize(Integer.parseInt(AddTextArea[11].getText()));
                MyBook.add(temp);
                JTextArea allInfo = new JTextArea(PrintAllAtr(temp));
                allInfo.setBackground(mainframe.getBackground());
                allInfo.setFont(NormalTRMFont);
                int output = JOptionPane.showConfirmDialog(AddGUI, allInfo, "Check the Information !!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, WarningIcon);
                if (output == JOptionPane.YES_OPTION) {
                    try {
                        Save();
                    } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(AddGUI, "Save Successfully", "Notification", JOptionPane.OK_OPTION, CheckIcon);
                }
                for (int i = 1; i < 12; i += 2) {
                    AddTextArea[i].setText("");
                }
            }
        });
        ShowListButton.addActionListener((e) -> {
            ListArea.setText("");
            boolean Empty = true;
            for (int i = 0; i < MyBook.size(); i++) {
                ListArea.append(MyBook.get(i).Output() + "\n");
                Empty = false;
            }
            if (Empty) {
                ListArea.setText("The List is empty!! Why don't you add something?");
            }

        });
        SearchAuthourButton.addActionListener((e) -> {
            ListArea.setText("");
            if (IsOccupied(SearchArea)) {
                boolean NoResult = true;
                for (int i = 0; i < MyBook.size(); i++) {
                    String AuString = MyBook.get(i).getAuthor();
                    String temp = SearchArea.getText();
                    if (AuString.substring(0, temp.length()).toLowerCase().equals(temp.toLowerCase())) {
                        ListArea.append(MyBook.get(i).Output() + "\n");
                        NoResult = false;
                    }
                }
                if (NoResult) {
                    ListArea.setText("There is no item match your search!");
                }
            } else {
                ListArea.setText("Don't leave the Search Field empty!");
            }
        });
        SearchNameButton.addActionListener((e) -> {
            ListArea.setText("");
            if (IsOccupied(SearchArea)) {
                boolean NoResult = true;
                for (int i = 0; i < MyBook.size(); i++) {
                    String AuString = MyBook.get(i).getName();
                    String temp = SearchArea.getText();
                    if (AuString.substring(0, temp.length()).toLowerCase().equals(temp.toLowerCase())) {
                        ListArea.append(MyBook.get(i).Output() + "\n");
                        NoResult = false;
                    }
                }
                if (NoResult) {
                    ListArea.setText("There is no item match your search!");
                }
            } else {
                ListArea.setText("Don't leave the Search Field empty!");
            }
        });
        Clear.addActionListener((e) -> {
            for (int i = 1; i < 12; i += 2) {
                AddTextArea[i].setText("");
            }
        });
        /*mainframe.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Coordinate.setText("X = " + e.getX() + "\nY = " + e.getY());
            }
        });*/
        mainframe.setVisible(true);
    }

    private boolean IsOccupied(JTextArea a) {
        return !a.getText().equals("");
    }

    public void Save() throws IOException {
        try (FileWriter fw = new FileWriter("C:\\Users\\Acer\\OneDrive\\Desktop\\FA22\\PRO\\Lab\\Lab3src\\src\\lab3src\\cache.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw)) {
            for (int i = 0; i < MyBook.size(); i++) {
                pw.print(AllAtr(MyBook.get(i)));
            }
        } catch (FileNotFoundException e) {

        }
    }

    public void Read() throws FileNotFoundException {
        Scanner read = new Scanner(new File("C:\\Users\\Acer\\OneDrive\\Desktop\\FA22\\PRO\\Lab\\Lab3src\\src\\lab3src\\cache.txt"));
        while (read.hasNextLine()) {
            EBook t = new EBook();
            t.setID(read.nextLine());
            t.setName(read.nextLine());
            t.setYear(Integer.parseInt(read.nextLine()));
            t.setAuthor(read.nextLine());
            t.SetURL(read.nextLine());
            t.SetSize(Integer.parseInt(read.nextLine()));
            MyBook.add(t);
        }
    }

    public String AllAtr(EBook i) {
        return i.getID() + "\n" + i.getName() + "\n" + i.getYear() + "\n" + i.getAuthor() + "\n" + i.getURL() + "\n" + i.getSize() + "\n";
    }

    public String PrintAllAtr(EBook i) {
        return "ID    : " + i.getID() + "\n"
                + "Name  : " + i.getName() + "\n"
                + "Year  : " + i.getYear() + "\n"
                + "Author: " + i.getAuthor() + "\n"
                + "URL   : " + i.getURL() + "\n"
                + "Size  : " + i.getSize() + "\n";
    }
}
