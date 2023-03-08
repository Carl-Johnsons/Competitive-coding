package mylibrary;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomJFrame extends JFrame {

    public JLabel BackgroundContainer;
    public JLabel BackgroundDecorate[];
    public JLabel AboutBackground;
    public JButton StartButton;

    public CustomJFrame() throws IOException {
        super("");
        BackgroundDecorate = new JLabel[0];
        initFrame();
    }

    public CustomJFrame(String title) throws IOException {
        super(title);
        BackgroundDecorate = new JLabel[0];
        initFrame();
    }

    public CustomJFrame(String title, int Number_Of_Decoration) throws IOException {
        super(title);
        BackgroundDecorate = new JLabel[Number_Of_Decoration];
        initFrame();
    }

    private void initFrame() throws IOException {
        setBounds(320, 180, 1280, 720);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //          START BUTTON
        StartButton = new JButton();
        StartButton.setBounds(0, 0, 1280, 720);
        StartButton.setBorder(null);
        StartButton.setContentAreaFilled(false);
        StartButton.setBorder(null);

        //          BACK GROUND
        BackgroundContainer = new JLabel();
        BackgroundContainer.setSize(getSize());

        for (int i = 0; i < BackgroundDecorate.length; i++) {
            BackgroundDecorate[i] = new JLabel();
            BackgroundDecorate[i].setBounds(0, 0, 200, 200);
        }
        //                                  MENU BAR
        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        JMenu About = new JMenu("Help");
        JMenuItem AboutItem = new JMenuItem("About us");

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        AboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame dialog = new JFrame("ABOUT US");

                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                dialog.setLocation(560, 240);
                dialog.setSize(800, 600);
                dialog.setResizable(false);
                dialog.setLocationRelativeTo(null);
                dialog.setLayout(null);

                //Back ground
                AboutBackground = new JLabel();
                AboutBackground.setBounds(0, 0, 800, 600);

                JTextArea AboutArea = new JTextArea("Grocery Store manageMent version 0.0\n\n"
                        + "                                                        Group 2:\n"
                        + "             Nguyen Le Tai Duc (Leader) working with GUI\n"
                        + "                 Le Quoc Vuong\n"
                        + "                     Le Ba Thinh\n"
                        + "                         Huynh Duy Khang\n");
                AboutArea.setLineWrap(true);
                AboutArea.setWrapStyleWord(true);
                AboutArea.setFont(new Font("Impact", Font.PLAIN, 30));
                AboutArea.setForeground(new Color(100, 200, 200));

                AboutArea.setEditable(false);
                AboutArea.setOpaque(false);

                JScrollPane AboutJScrollPane = new JScrollPane(AboutArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                AboutJScrollPane.setBounds(100, 150, 600, 300);
                AboutJScrollPane.getViewport().setOpaque(false);
                AboutJScrollPane.setOpaque(false);
                AboutJScrollPane.setBorder(null);

                dialog.add(AboutJScrollPane);
                dialog.add(AboutBackground);

                dialog.setVisible(true);

            }
        });
        file.add(exitItem);

        About.add(AboutItem);

        mb.add(file);
        mb.add(About);

        setJMenuBar(mb);
    }

    public void setBackgroundContainer(ImageIcon icon) {
        this.BackgroundContainer.setIcon(icon);
    }

    public void setAboutBackground(ImageIcon icon) {
        this.AboutBackground.setIcon(icon);
    }

    public void setBackGroundDecorate(int i, ImageIcon icon) {
        BackgroundDecorate[i].setIcon(icon);
    }

    public void addAllAtrToFrame() {
        for (int i = 0; i < BackgroundDecorate.length; i++) {
            add(BackgroundDecorate[i]);
        }
        add(BackgroundContainer);
        add(StartButton);

    }
}
