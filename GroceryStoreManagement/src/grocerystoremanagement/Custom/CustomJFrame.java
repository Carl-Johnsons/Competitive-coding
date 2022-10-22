package grocerystoremanagement.Custom;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomJFrame extends JFrame {
    
    public JLabel BackgroundContainer;
    public JMenuItem ViewItem[] = new JMenuItem[4];
    public JButton StartButton;
    
    File[] allFile = new File("src\\grocerystoremanagement\\res").listFiles();
    BufferedImage allImg[] = new BufferedImage[allFile.length];
    
    public CustomJFrame() throws IOException {
        super("Grocery Store Management");
        setBounds(320, 180, 1280, 720);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //          START BUTTON
        StartButton = new JButton();
        StartButton.setBounds(0, 0, 1280, 720);
        StartButton.setBorder(null);
        StartButton.setText("CLICK ANYWHERE TO START");
        StartButton.setFont(new Font("Impact", Font.PLAIN, 50));
        StartButton.setForeground(new Color(50, 200, 200));
        StartButton.setContentAreaFilled(false);
        StartButton.setBorder(null);
        
        add(StartButton);
        //          BACK GROUND
        for (int i = 0; i < allFile.length; i++) {
            allImg[i] = ImageIO.read(allFile[i]);
        }
        
        BackgroundContainer = new JLabel();
        BackgroundContainer.setSize(getSize());
        BackgroundContainer.setIcon(new ImageIcon(allImg[0].getScaledInstance((int) getSize().getWidth(), (int) getSize().getHeight(), Image.SCALE_SMOOTH)));
        
        

        //                                  MENU BAR
        JMenuBar mb = new JMenuBar();
        
        JMenu file = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        JMenu Size = new JMenu("View");
        ViewItem[0] = new JMenuItem("Default");
        ViewItem[1] = new JMenuItem("1366x768");
        ViewItem[2] = new JMenuItem("1600x900");
        ViewItem[3] = new JMenuItem("1920x1080");
        
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
                JLabel AboutBackground = new JLabel();
                AboutBackground.setBounds(0, 0, 800, 600);
                AboutBackground.setIcon(new ImageIcon(allImg[2].getScaledInstance(800, 600, Image.SCALE_SMOOTH)));
                
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
                
                dialog.setIconImage(allImg[3]);
                
                dialog.add(AboutJScrollPane);
                dialog.add(AboutBackground);
                
                dialog.setVisible(true);
                
            }
        });
        file.add(exitItem);
        
        for (int i = 0; i < 4; i++) {
            Size.add(ViewItem[i]);
        }
        
        About.add(AboutItem);
        
        mb.add(file);
        mb.add(Size);
        mb.add(About);
        
        setJMenuBar(mb);
    }
    
}