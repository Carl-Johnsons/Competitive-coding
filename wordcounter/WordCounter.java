package wordcounter;

import java.awt.Insets;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class WordCounter {

    private JTextArea notify;
    private JTextArea header;
    private JFrame mainframe;
    private JPanel controlPanel;
    private final JTextArea Test = new JTextArea();
    private Font font;
    private int WordCounter = 0;
    private int CharCounter = 0;
    private int PapagraphCounter = 0;

    public WordCounter() {
        prepareGUI();
    }

    private void prepareGUI() {
        font = new Font("TimesRoman", Font.PLAIN, 20);
        mainframe = new JFrame("TEST!");
        mainframe.setSize(1280, 720);
        //mainframe.setResizable(false);
        //mainframe.setLayout(new GridLayout(3, 1));
        //mainframe.setLayout(new SpringLayout());
        mainframe.addWindowListener(new WindowAdapter() {
            public void WindowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        //Exit through the X button
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainframe.add(controlPanel);
         */

        header = new JTextArea();
        header.setEditable(false);
        header.setFont(font);
        header.setBounds(390, 20, 500, 50);
        header.setMargin(new Insets(0, 200, 0, 0));
        header.setBackground(mainframe.getBackground());

        notify = new JTextArea();
        notify.setEditable(false);
        notify.setFont(font);
        notify.setBounds(100, 580, 440, 100);
        notify.setBackground(mainframe.getBackground());
        notify.setMargin(new Insets(0, 130, 0, 0));

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        //header.setHorizontalAlignment(JLabel.CENTER);
        //header.setAlignmentY(200);
        //notify.setAlignmentX(1000);
        //JPanel panel = new JPanel();
        //SpringLayout layout = new SpringLayout();

        Test.setBounds(100, 80, 1000, 500);
        Test.setFont(font);
        mainframe.setLayout(null);
        mainframe.add(header);
        mainframe.add(notify);
        //mainframe.add(controlPanel);

        mainframe.add(Test);
        //mainframe.setVisible(true);
        //layout.putConstraint(SpringLayout.NORTH, header, 5, SpringLayout.NORTH, panel);
    }

    public void ShowText() {

        header.setText("Begin the test!!");

        JButton WordCountButton = new JButton("Word Counter");

        WordCountButton.setBounds(540, 600, 150, 50);

        WordCountButton.addActionListener((ActionEvent e) -> {
            int Start = 0;
            int End = 0;
            boolean hasStart = false;
            boolean hasEnd = false;
            WordCounter = 0;
            CharCounter = 0;
            PapagraphCounter = 1;
            String temp;
            temp = Test.getText();

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) != ' ' && !hasStart) {
                    Start = i;
                    hasStart = true;
                }
                if ((temp.charAt(i) == ' ' || i == temp.length() - 1) && !hasEnd && hasStart) {
                    End = i;
                    if (i == temp.length() - 1) {
                        End = i + 1;
                    }
                    hasEnd = true;
                }
                if (temp.charAt(i) == '\n') {
                    PapagraphCounter++;
                }
                if (hasEnd && hasStart) {
                    WordCounter++;
                    String t = temp.substring(Start, End);
                    CharCounter += (t.length());
                    hasStart = false;
                    hasEnd = false;
                }
            }
            notify.setText("Word Found: " + WordCounter + "\nCharacter Found: " + CharCounter + "\nPapagraph found: " + PapagraphCounter);
        });
        mainframe.add(header);
        mainframe.add(notify);

        mainframe.add(WordCountButton);
        mainframe.setVisible(true);
    }
}
