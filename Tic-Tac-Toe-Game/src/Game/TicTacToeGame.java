package Game;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.Random;


import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JTextArea;

public class TicTacToeGame {

    private JFrame mainFrame;
    
    
    private JTextArea header;
    
    
    JTextArea notify;
    
    
    private JTextArea Coordinate;
    
    final JButton CellButton[] = new JButton[9];
    
    final JButton RestartButton = new JButton("Retry?");
    
    final JTextArea CellArea[] = new JTextArea[9];
    
    
    private final Font Headerfont = new Font("TimesRoman", Font.BOLD, 30);
    private final Font Normalfont = new Font("TimesRoman", Font.PLAIN, 20);
    private final Font Cellfont = new Font("TimesRoman", Font.BOLD, 90);
    
    
    private final JPanel ButtonPanel = new JPanel();
    
    
    private Random random = new Random();
    
    private Robot auto = new Robot();
    private boolean ClickConfirmed = false;
    
    boolean YourTurn = true;
    
    boolean PreviousTurn = true;

    int win1 = 0;
    int win2 = 0;
    int win3 = 0;
    Color DefaultColour;

    public TicTacToeGame() throws AWTException {
        prepareGUI();
    }

    private void prepareGUI() {
        int x = 470;
        int y = 150;
        
        
        mainFrame = new JFrame("Tic-Tac-Toe Game");
        mainFrame.setLocation(320, 180);
 
        mainFrame.setSize(1280, 720);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        ButtonPanel.setBounds(x - 10, y - 10, 110 * 3 + 10, 110 * 3 + 10);
        ButtonPanel.setBackground(Color.BLACK);

        header = new JTextArea("");
        header.setFont(Headerfont);
        header.setBounds(390, 20, 500, 50);
        header.setMargin(new Insets(10, 100, 0, 0));
        header.setEditable(false);
        header.setBackground(mainFrame.getBackground());

        notify = new JTextArea("");
        notify.setFont(Normalfont);
        notify.setBounds(1000, 150, 200, 400);
        notify.setEditable(false);
        notify.setBackground(mainFrame.getBackground());

        Coordinate = new JTextArea("***********");
        Coordinate.setFont(Headerfont);
        Coordinate.setBounds(30, 250, 300, 200);
        Coordinate.setMargin(new Insets(10, 100, 0, 0));
        Coordinate.setEditable(false);
        Coordinate.setBackground(mainFrame.getBackground());

        for (int i = 0; i < 9; i++) {
            CellButton[i] = new JButton("");
            CellButton[i].setVisible(true);
            CellButton[i].setBounds(x + (i % 3) * 110, y + (i / 3) % 3 * 110, 100, 100);
            mainFrame.add(CellButton[i]);
        }
        for (int i = 0; i < 9; i++) {
            CellArea[i] = new JTextArea("");
            CellArea[i].setEditable(false);
            CellArea[i].setBounds(x + (i % 3) * 110, y + (i / 3) % 3 * 110, 100, 100);
            CellArea[i].setFont(Cellfont);
            CellArea[i].setMargin(new Insets(0, 20, 90, 0));
            CellArea[i].setBackground(CellButton[i].getBackground());
            mainFrame.add(CellArea[i]);
        }
        RestartButton.setBounds(580, 500, 100, 50);
        RestartButton.setVisible(false);

        DefaultColour = mainFrame.getBackground();
        mainFrame.add(RestartButton);
        mainFrame.add(header);
        mainFrame.add(notify);
        mainFrame.add(Coordinate);
        mainFrame.add(ButtonPanel);
    }

    public void PlayGame() {
        header.setText("Tic-Tac-Toe Timeeee!!");
        JButton RulesButton = new JButton("Rules");

        RulesButton.setBounds(540, 600, 150, 50);

        RulesButton.addActionListener((e) -> {
            notify.setText(Rules());
            notify.setBackground(Color.white);
        });

        for (int i = 0; i < 9; i++) {
            CellButton(i);
        }

        RestartButton.addActionListener((e) -> {
            SetCellDefaultColor();
            RestartButton.setVisible(false);
            this.YourTurn = true;
        }
        );
        mainFrame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e
            ) {
                Coordinate.setText("X = " + e.getX() + "\n" + "Y = " + e.getY());
            }
        }
        );
        mainFrame.add(header);

        mainFrame.add(notify);

        mainFrame.add(RulesButton);

        mainFrame.setVisible(true);

    }

    private String Rules() {
        return "No rules for now!";
    }

    public boolean IsOccupied(JTextArea a) {
        return !(a.getText()).equals("");
    }

    public boolean IsWin() {
        boolean Win = false;
        if (CellArea[0].getText().equals(CellArea[4].getText()) && CellArea[0].getText().equals(CellArea[8].getText()) && (IsOccupied(CellArea[0]) && (IsOccupied(CellArea[4]) && (IsOccupied(CellArea[8]))))) {
            this.win1 = 0;
            this.win2 = 4;
            this.win3 = 8;
            Win = true;
        } else if (CellArea[2].getText().equals(CellArea[4].getText()) && CellArea[2].getText().equals(CellArea[6].getText()) && (IsOccupied(CellArea[2]) && (IsOccupied(CellArea[4]) && (IsOccupied(CellArea[6]))))) {
            this.win1 = 2;
            this.win2 = 4;
            this.win3 = 6;
            Win = true;
        } else {
            for (int i = 0; i < 3; i++) {
                if (CellArea[i * 3].getText().equals(CellArea[i * 3 + 1].getText()) && CellArea[i * 3].getText().equals(CellArea[i * 3 + 2].getText()) && (IsOccupied(CellArea[i * 3]) && (IsOccupied(CellArea[i * 3 + 1]) && (IsOccupied(CellArea[i * 3 + 2]))))) {
                    this.win1 = i * 3;
                    this.win2 = i * 3 + 1;
                    this.win3 = i * 3 + 2;
                    Win = true;
                } else if (CellArea[i].getText().equals(CellArea[i + 3].getText()) && CellArea[i].getText().equals(CellArea[i + 6].getText()) && (IsOccupied(CellArea[i]) && (IsOccupied(CellArea[i + 3]) && (IsOccupied(CellArea[i + 6]))))) {
                    this.win1 = i;
                    this.win2 = i + 3;
                    this.win3 = i + 6;
                    Win = true;
                }
            }
        }
        return Win;
    }

    private void SetCellDefaultColor() {
        for (int i = 0; i < 9; i++) {
            CellButton[i].setVisible(true);
            CellArea[i].setBackground(DefaultColour);
            CellArea[i].setText("");
        }
        
        for (int i = 0; i < 9; i++) {
            CellButton[i].setVisible(true);
            CellArea[i].setBackground(DefaultColour);
            CellArea[i].setText("");
        }
         for (int i = 0; i < 9; i++) {
            CellButton[i].setVisible(true);
            CellArea[i].setBackground(DefaultColour);
            CellArea[i].setText("");
        }
        notify.setText("");
    }

    public void setCellButtonVisilityFalse(int i) {
        CellButton[i].setVisible(false);
    }

    public void setButtonVisility(JButton b, boolean a) {
        b.setVisible(a);
    }

    public void addButtonToMainFrame(JButton a) {
        mainFrame.add(a);
    }

    public void SetMainFrameDefaultLocation() {
        mainFrame.setLocation(320, 180);
    }

    public void GameSystem() throws AWTException, InterruptedException {
        PlayGame();
        notify.setText("Your Turn");
        while (true) {
            boolean AllOccupied = true;
            for (int i = 0; i < 9; i++) {
                if (!IsOccupied(CellArea[i])) {
                    AllOccupied = false;
                }
            }
            if (PreviousTurn != YourTurn) {
                PreviousTurn = YourTurn;
                if (YourTurn && !IsWin()) {
                    notify.setText("Your Turn");
                } else if (!YourTurn && !IsWin()) {
                    notify.setText("My Turn");
                    EnemyBehaviour();
                }
            }
            if (IsWin()) {
                notify.setText(YourTurn ? "Lose" : "Win");
                for (int i = 0; i < 9; i++) {
                    setCellButtonVisilityFalse(i);
                }
                CellArea[win1].setBackground(Color.GREEN);
                CellArea[win2].setBackground(Color.GREEN);
                CellArea[win3].setBackground(Color.GREEN);
                setButtonVisility(RestartButton, true);
            } else if (AllOccupied) {
                notify.setText("DRAW!!");
                for (int i = 0; i < 9; i++) {
                    setCellButtonVisilityFalse(i);
                }
                setButtonVisility(RestartButton, true);
            }

        }

    }

    public void EnemyBehaviour() throws AWTException, InterruptedException {
        SetMainFrameDefaultLocation();
        for (int i = 0; i < 9; i++) {
            setCellButtonVisilityFalse(i);
        }
        int x;
        int y;
        int r;
        do {
            r = random.nextInt(9);
        } while (IsOccupied(CellArea[r]));
        Thread.sleep(500);
        CellArea[r].setText(YourTurn ? "X" : "O");
        YourTurn = !YourTurn;
        CellButton[r].setVisible(false);
        for (int i = 0; i < 9; i++) {
            if (!IsOccupied(CellArea[i])) {
                CellButton[i].setVisible(true);
            }
        }
    }

    private void CellButton(int i) {
        CellButton[i].addActionListener((e) -> {
            if (!IsOccupied(CellArea[i])) {
                CellArea[i].setText(YourTurn ? "X" : "O");
                YourTurn = !YourTurn;
                CellButton[i].setVisible(false);
            }
        });
    }

}
