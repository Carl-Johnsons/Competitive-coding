/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvecaro;

import java.awt.Dimension;
import java.awt.GridLayout;

/**
 *
 * @author Acer
 */
public class NormalCaro extends javax.swing.JPanel {
    
    private ImproveCaro parent;
    // For THREE_THREE
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private int numRows;
    private int numCols;
    private int CELL_SIZE = 300;
    
    public static final int BLANK_CELL = 25;
    
    private int mapType = 0;
    public static final int THREE_THREE = 3;
    public static final int FIVE_FIVE = 5;

    /**
     * Creates new form NormalCaro
     */
    public NormalCaro(ImproveCaro parent) {
        this.parent = parent;
        numRows = 0;
        numCols = 0;
        setBounds(0, 0, 1920, 1080);
        initComponents();
    }
    
    public void initNormalMode() {
        parent.removeAllComponent(parent.getBoard());
        parent.removeAllComponent(pnlBoard);
        
        parent.setBoard(new Board(parent, (int) pnlBoard.getPreferredSize().getWidth(), (int) pnlBoard.getPreferredSize().getHeight()));
        pnlBoard.add(parent.getBoard());
        
        parent.removeAllComponent(parent.getRedInfo());
        parent.removeAllComponent(parent.getBlueInfo());
        
        parent.setRedInfo(new GameInfo(parent, GameInfo.Red, (int) pnlOGameInfo.getPreferredSize().getWidth(), (int) pnlOGameInfo.getPreferredSize().getHeight()));
        parent.setBlueInfo(new GameInfo(parent, GameInfo.Blue, (int) pnlXGameInfo.getPreferredSize().getWidth(), (int) pnlXGameInfo.getPreferredSize().getHeight()));
        
        pnlOGameInfo.add(parent.getRedInfo());
        pnlXGameInfo.add(parent.getBlueInfo());
        
    }
    
    public void generateBoard() {
        checkMapType();
        initNormalMode();

        //reset the board before add something to it
        parent.getBoard().removeAll();
        parent.getBoard().revalidate();
        parent.getBoard().repaint();
        
        parent.getBoard().setVisible(true);
        parent.setMap(new Cell[numRows][numCols]);
        
        parent.setNumRows(numRows);
        parent.setNumCols(numCols);
        
        parent.getBoard().setLayout(new GridLayout(numRows, numCols));
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                parent.getMap()[i][j] = new Cell(parent, i, j, BLANK_CELL, CELL_SIZE);
                parent.getBoard().add(parent.getMap()[i][j]);
            }
        }
        
        parent.setTurn(ImproveCaro.OCell);
        parent.getLblReturn().setVisible(true);
        //Garbage collecting each time generating a new board
        System.gc();
        
    }
    
    private void checkMapType() {
        int x = 510;
        int y = 60;
        int width = 900;
        int height = 900;
        int xActor = 10;
        int yActor = 350;
        int widthActor = 300;
        int heightActor = 300;
        
        if (mapType == THREE_THREE) {
            numRows = ROWS;
            numCols = COLS;
            CELL_SIZE = 300;
            //Setting the size of required components
            pnlBoard.setPreferredSize(new Dimension(900, 900));
            pnlBoard.setBounds(x, y, width, height);
            
            pnlOGameInfo.setPreferredSize(new Dimension(300, 300));
            pnlOGameInfo.setBounds(xActor, yActor, widthActor, heightActor);
            
            pnlXGameInfo.setPreferredSize(new Dimension(300, 300));
            pnlXGameInfo.setBounds(1920 - widthActor - 10, yActor, widthActor, heightActor);
            
            parent.setNumberOfCellUnOccupied(3 * 3);
        } else if (mapType == FIVE_FIVE) {
            numRows = ImproveCaro.ROWS;
            numCols = ImproveCaro.COLS;
            CELL_SIZE = 50;
            pnlBoard.setPreferredSize(new Dimension(1600, 900));
            width = 1600;
            pnlBoard.setBounds(x - 350, y, width, height);
            
            widthActor = 150;
            heightActor = 150;
            yActor = ((1080 - heightActor) / 2) - 40;
            pnlOGameInfo.setPreferredSize(new Dimension(widthActor, heightActor));
            pnlOGameInfo.setBounds(xActor, yActor, widthActor, heightActor);
            
            pnlXGameInfo.setPreferredSize(new Dimension(widthActor, heightActor));
            pnlXGameInfo.setBounds(1920 - widthActor - 10, yActor, widthActor, heightActor);
            
            parent.setNumberOfCellUnOccupied(18 * 32);
        }
    }
    
    public int getCELL_SIZE() {
        return CELL_SIZE;
    }
    
    public void setCELL_SIZE(int CELL_SIZE) {
        this.CELL_SIZE = CELL_SIZE;
    }
    
    public int getMapType() {
        return mapType;
    }
    
    public void setMapType(int mapType) {
        this.mapType = mapType;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBoard = new javax.swing.JPanel();
        pnlOGameInfo = new javax.swing.JPanel();
        pnlXGameInfo = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(null);

        pnlBoard.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        pnlBoard.setPreferredSize(new java.awt.Dimension(900, 900));
        pnlBoard.setLayout(new java.awt.GridLayout(1, 0));
        add(pnlBoard);
        pnlBoard.setBounds(510, 60, 900, 900);

        pnlOGameInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlOGameInfo.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout pnlOGameInfoLayout = new javax.swing.GroupLayout(pnlOGameInfo);
        pnlOGameInfo.setLayout(pnlOGameInfoLayout);
        pnlOGameInfoLayout.setHorizontalGroup(
            pnlOGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        pnlOGameInfoLayout.setVerticalGroup(
            pnlOGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        add(pnlOGameInfo);
        pnlOGameInfo.setBounds(10, 350, 300, 300);

        pnlXGameInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlXGameInfo.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout pnlXGameInfoLayout = new javax.swing.GroupLayout(pnlXGameInfo);
        pnlXGameInfo.setLayout(pnlXGameInfoLayout);
        pnlXGameInfoLayout.setHorizontalGroup(
            pnlXGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        pnlXGameInfoLayout.setVerticalGroup(
            pnlXGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        add(pnlXGameInfo);
        pnlXGameInfo.setBounds(1610, 360, 300, 300);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlOGameInfo;
    private javax.swing.JPanel pnlXGameInfo;
    // End of variables declaration//GEN-END:variables

}
