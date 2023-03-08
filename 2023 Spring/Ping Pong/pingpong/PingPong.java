/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Acer
 */
public class PingPong extends javax.swing.JFrame {
    
    public static int BallSize = 20;
    public static int BallRadius = BallSize / 2;
    
    public static int ScenceWidth = 800;
    public static int ScenceHeight = 400;
    public static int racketWidth = 5;
    public static int racketHeight = 40;
    
    int redPoint;
    int bluePoint;
    
    int xRed, yRed;
    JLabel red;
    
    int xBlue, yBlue;
    JLabel blue;
    
    int xBall, yBall, dxBall, dyBall;
    JLabel ball;
    
    int BallSpeed, RacketSpeed;
    
    int time;
    Thread timer;
    Thread game;
    
    public void reset() {
        redPoint = 0;
        bluePoint = 0;
        // Reset the x coordinate of the red and blue racket
        xRed = 10;
        xBlue = ScenceWidth - racketWidth - 10;
        yRed = yBlue = (ScenceHeight - racketHeight) / 2;

        //The coordinate of the ball is the center of the screen
        xBall = (ScenceWidth - BallSize) / 2;
        yBall = (ScenceHeight - BallSize) / 2;

        //Random the direction
        int dx = Randomizer.random(0, 1);
        dxBall = dx == 0 ? -1 : 1;
        int dy = Randomizer.random(0, 1);
        dyBall = dy == 0 ? -1 : 1;
        
        BallSpeed = 2;
        RacketSpeed = 20;
        time = 0;
    }
    
    public void replay() {
        //The coordinate of the ball is the center of the screen
        xBall = (ScenceWidth - BallSize) / 2;
        yBall = (ScenceHeight - BallSize) / 2;

        //Random the direction
        int dx = Randomizer.random(0, 1);
        dxBall = dx == 0 ? -1 : 1;
        int dy = Randomizer.random(0, 1);
        dyBall = dy == 0 ? -1 : 1;
        
        time = 0;
        
        lblNotification.setText("");
        lblReplay.setText("");
        
        runTimer();
        runGame();
    }
    
    public void initScence() {
        lblUpperBorder.setVisible(false);
        lblLowerBorder.setVisible(false);
        
        red = new JLabel();
        red.setOpaque(true);
        red.setBackground(Color.red);
        red.setBounds(xRed, yRed, racketWidth, racketHeight);
        
        blue = new JLabel();
        blue.setOpaque(true);
        blue.setBackground(Color.blue);
        blue.setBounds(xBlue, yBlue, racketWidth, racketHeight);
        
        ball = new JLabel();
        ball.setBounds(xBall, yBall, BallSize, BallSize);
        ball.setIcon(new ImageIcon(getClass().getResource("/image/ball2.png")));
        
        pnlScene.add(red);
        pnlScene.add(blue);
        pnlScene.add(ball);
        
    }
    
    private String intToTime(int time) {
        return String.format("%02d:%02d:%02d", time / 3600, (time / 60) % 60, time % 60);
    }
    
    public void runTimer() {
        timer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    time++;
                    lbTime.setText(intToTime(time));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        };
        timer.start();
    }
    
    public void runGame() {
        game = new Thread() {
            @Override
            public void run() {
                while (true) {

                    //3 things need to do
                    //Move the red racket
                    red.setBounds(xRed, yRed, racketWidth, racketHeight);

                    //Move the blue racket
                    blue.setBounds(xBlue, yBlue, racketWidth, racketHeight);

                    //Move the ball
                    xBall = xBall + BallSpeed * dxBall;
                    yBall = yBall + BallSpeed * dyBall;

                    //Check if game over
                    if (isGameOver()) {
                        gameOver();
                    } else if (isRedHit() || isBlueHit()) {
                        dxBall = -dxBall;
                    }

                    //Change the direction of the ball
                    if (xBall < 0) {
                        xBall = 0;
                        dxBall = -dxBall;
                    } else if (xBall > ScenceWidth - BallSize) {
                        xBall = ScenceWidth - BallSize;
                        dxBall = -dxBall;
                    }
                    if (yBall < 0) {
                        yBall = 0;
                        dyBall = -dyBall;
                        lblUpperBorder.setVisible(!lblUpperBorder.isVisible());
                    } else if (yBall > ScenceHeight - BallSize) {
                        yBall = ScenceHeight - BallSize;
                        dyBall = -dyBall;
                        lblLowerBorder.setVisible(!lblLowerBorder.isVisible());
                    }
                    
                    ball.setBounds(xBall, yBall, BallSize, BallSize);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        game.start();
    }
    
    public boolean isGameOver() {
        return xBall <= 0 || xBall >= ScenceWidth - BallSize;
    }
    
    public void gameOver() {

        //Update the score
        if (xBall <= 0) {
            bluePoint++;
            lblNotification.setForeground(Color.BLUE);
            lblNotification.setText("Blue Player is the winner!");
        }
        if (xBall >= ScenceWidth - BallSize) {
            redPoint++;
            lblNotification.setForeground(Color.red);
            lblNotification.setText("Red Player is the winner!");
        }
        
        lblReplay.setText("Press SPACE BAR to REPLAY");
        plRed.setText(redPoint + "");
        plBlue.setText(bluePoint + "");
        
        timer.stop();
        game.stop();
    }
    
    public boolean isRedHit() {

        // Computing the center of the object
        int bX = xBall + BallRadius;
        int bY = yBall + BallRadius;
        
        int rX = xRed + racketWidth / 2;
        
        if ((Math.abs(bX - rX) <= BallRadius)) {
            //The center of the ball confirm hit between the yRed and yRed + Racket Height
            if (yRed - BallRadius <= bY && bY <= yRed + racketHeight + BallRadius) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isBlueHit() {

        // Computing the center of the object
        int bX = xBall + BallRadius;
        int bY = yBall + BallRadius;
        
        int blueX = xBlue + racketWidth / 2;
        
        if ((Math.abs(bX - blueX) <= BallRadius)) {
            //The center of the ball confirm hit between the yBlue and yBlue + Racket Height
            if (yBlue - BallRadius <= bY && bY <= yBlue + racketHeight + BallRadius) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates new form PingPong
     */
    public PingPong() {
        initComponents();
        this.setLocationRelativeTo(null);// Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        reset();
        initScence();
        runTimer();
        runGame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGameInfo = new javax.swing.JPanel();
        plRed = new javax.swing.JLabel();
        playerRedIcon = new javax.swing.JLabel();
        plBlueLabel = new javax.swing.JLabel();
        plBlue = new javax.swing.JLabel();
        lbTimeLabel = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();
        lblNotification = new javax.swing.JLabel();
        lblReplay = new javax.swing.JLabel();
        plRedLabel1 = new javax.swing.JLabel();
        playerRedIcon1 = new javax.swing.JLabel();
        pnlScene = new javax.swing.JPanel();
        lblLowerBorder = new javax.swing.JLabel();
        lblUpperBorder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        pnlGameInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Game Infomation"));

        plRed.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        plRed.setForeground(new java.awt.Color(204, 0, 51));
        plRed.setText("0");

        playerRedIcon.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        playerRedIcon.setForeground(new java.awt.Color(255, 102, 102));
        playerRedIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-removebg-preview.png"))); // NOI18N

        plBlueLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        plBlueLabel.setForeground(new java.awt.Color(51, 153, 255));
        plBlueLabel.setText("Blue");

        plBlue.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        plBlue.setForeground(new java.awt.Color(0, 204, 255));
        plBlue.setText("0");

        lbTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTimeLabel.setForeground(new java.awt.Color(153, 153, 153));
        lbTimeLabel.setText("Time");

        lbTime.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTime.setForeground(new java.awt.Color(153, 153, 153));
        lbTime.setText("00:00:00");

        lblNotification.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        lblNotification.setForeground(new java.awt.Color(153, 153, 153));

        lblReplay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblReplay.setForeground(new java.awt.Color(153, 153, 153));

        plRedLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        plRedLabel1.setForeground(new java.awt.Color(255, 102, 102));
        plRedLabel1.setText("Red");

        playerRedIcon1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        playerRedIcon1.setForeground(new java.awt.Color(255, 102, 102));
        playerRedIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/red-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout pnlGameInfoLayout = new javax.swing.GroupLayout(pnlGameInfo);
        pnlGameInfo.setLayout(pnlGameInfoLayout);
        pnlGameInfoLayout.setHorizontalGroup(
            pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameInfoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plRedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerRedIcon1))
                .addGap(1, 1, 1)
                .addComponent(plRed, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlGameInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(playerRedIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(plBlueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGameInfoLayout.createSequentialGroup()
                        .addComponent(lblReplay, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlGameInfoLayout.createSequentialGroup()
                        .addComponent(lblNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTime)
                        .addGap(23, 23, 23))))
        );
        pnlGameInfoLayout.setVerticalGroup(
            pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(lblReplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlGameInfoLayout.createSequentialGroup()
                .addGroup(pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plRed, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plBlueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plRedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerRedIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(playerRedIcon1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pnlScene.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlScene.setPreferredSize(new java.awt.Dimension(800, 400));
        pnlScene.setLayout(null);

        lblLowerBorder.setBackground(new java.awt.Color(153, 0, 51));
        lblLowerBorder.setOpaque(true);
        pnlScene.add(lblLowerBorder);
        lblLowerBorder.setBounds(0, 390, 800, 10);

        lblUpperBorder.setBackground(new java.awt.Color(0, 204, 204));
        lblUpperBorder.setOpaque(true);
        pnlScene.add(lblUpperBorder);
        lblUpperBorder.setBounds(0, 0, 800, 10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlScene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlGameInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(pnlGameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlScene, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            yBlue -= RacketSpeed;
        }
        if (key == KeyEvent.VK_DOWN) {
            yBlue += RacketSpeed;
        }
        
        if (key == KeyEvent.VK_W) {
            yRed -= RacketSpeed;
        }
        if (key == KeyEvent.VK_S) {
            yRed += RacketSpeed;
        }
        if (isGameOver() && key == KeyEvent.VK_SPACE) {
            replay();
            repaint();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PingPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PingPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PingPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PingPong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PingPong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbTimeLabel;
    private javax.swing.JLabel lblLowerBorder;
    private javax.swing.JLabel lblNotification;
    private javax.swing.JLabel lblReplay;
    private javax.swing.JLabel lblUpperBorder;
    private javax.swing.JLabel plBlue;
    private javax.swing.JLabel plBlueLabel;
    private javax.swing.JLabel plRed;
    private javax.swing.JLabel plRedLabel1;
    private javax.swing.JLabel playerRedIcon;
    private javax.swing.JLabel playerRedIcon1;
    private javax.swing.JPanel pnlGameInfo;
    private javax.swing.JPanel pnlScene;
    // End of variables declaration//GEN-END:variables
}
