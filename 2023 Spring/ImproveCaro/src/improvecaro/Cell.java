package improvecaro;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Group 2
 */
public final class Cell extends JLabel {
    
    private int row, col, value, width;
    private final ImproveCaro parent;
    private MouseListener mouseClicked;

    //For the Skill REMOVE to work, new Event have to created
    private MouseListener removeEvent;
    
    public Cell(ImproveCaro parent, int row, int col, int value, int width) {
        this.parent = parent;
        this.row = row;
        this.col = col;
        this.value = value;
        this.width = width;
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.mouseClicked = new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                cardClicked();
            }
            
        };
        
        this.addMouseListener(mouseClicked);
        updateIcon();
        updateSize();
    }
    
    private void cardClicked() {
        if (parent.isRPG()) {
            handleRPG();
        } else if (parent.isNormal()) {
            handleNormal();
        }
    }
    
    private void handleRPG() {
        GameInfo playerRed = parent.getRedInfo();
        GameInfo playerBlue = parent.getBlueInfo();
        
        int RedBlockTurn = parent.getRedInfo().getActorSkill().getBlockTurn();
        int BlueBlockTurn = parent.getBlueInfo().getActorSkill().getBlockTurn();
        //Before turn on
        // In BLOCK skill, the first turn is normal but the next 2 turn is turnOnBlock instead of normal turnOn
        if (RedBlockTurn == 3 || BlueBlockTurn == 3) {
            turnOn();
        } else if (RedBlockTurn > 0 || BlueBlockTurn > 0) {
            turnOnBlock();
        } else {
            turnOn();
        }

        //After turn on

        /* ============== Save the old map for UNDO, BLIND skill ==============*/
        saveOldMap();
        /* ============== Save the old map for UNDO, BLIND skill ==============*/
        this.removeMouseListener(mouseClicked);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        // ==== Dieu kien de thang va ve luon duong chien thang ====
        checkWinCondition();
        // Lam moi start end de khong ve duong chien thang
        parent.clearStartEnd();
        // ==== Dieu kien de thang va ve luon duong chien thang ====

        // Qua luot tiep theo
        parent.nextTurn();
        // 0 luot

        boolean RedUndo = parent.getRedInfo().getActorSkill().isUndoActive();
        boolean BlueUndo = parent.getBlueInfo().getActorSkill().isUndoActive();
        handleUndoEvent(playerRed, playerBlue, RedUndo);
        handleUndoEvent(playerBlue, playerRed, BlueUndo);

        // 2 luot, khong giu turn, muon xong tra
        int RedBlindTurn = parent.getRedInfo().getActorSkill().getBlindTurn();
        int BlueBlindTurn = parent.getBlueInfo().getActorSkill().getBlindTurn();
        handleBlindEvent(playerRed, playerBlue, RedBlindTurn);
        handleBlindEvent(playerBlue, playerRed, BlueBlindTurn);

        // 3 luot, next Turn
        RedBlockTurn = parent.getRedInfo().getActorSkill().getBlockTurn();
        BlueBlockTurn = parent.getBlueInfo().getActorSkill().getBlockTurn();
        handleBlockEvent(playerRed, playerBlue, RedBlockTurn);
        handleBlockEvent(playerBlue, playerRed, BlueBlockTurn);

        // 3 luot, next Turn
        int RedSilenceTurn = parent.getRedInfo().getActorSkill().getSilenceTurn();
        int BlueSilenceTurn = parent.getBlueInfo().getActorSkill().getSilenceTurn();
        handleSilenceEvent(playerRed, playerBlue, RedSilenceTurn);
        handleSilenceEvent(playerBlue, playerRed, BlueSilenceTurn);

        // 2 luot, next Turn
        boolean RedStopTime = parent.getRedInfo().getActorSkill().isStopTimeActive();
        boolean BlueStopTime = parent.getBlueInfo().getActorSkill().isStopTimeActive();
        handleStopTimeEvent(playerRed, playerBlue, RedStopTime);
        handleStopTimeEvent(playerBlue, playerRed, BlueStopTime);

//        System.out.println("Up down :" + ud);
//        System.out.println("Left Right :" + lr);
//        System.out.println("Left Down Right Up :" + ldru);
//        System.out.println("Left Up Right Down :" + lurd);
    }
    
    private void handleNormal() {
        turnOn();
        
        checkWinCondition();
        
        parent.nextTurn();
        
        this.removeMouseListener(mouseClicked);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    private boolean checkWinCondition() {
        // ==== Dieu kien de thang va ve luon duong chien thang ====
        int win_condition = (parent.isRPG() ? 4 : 2);
        int ud = parent.CountUpAndDown(row, col);
        if (ud >= win_condition) {
            drawWinningLine();
            return true;
        }
        int lr = parent.CountLeftAndRight(row, col);
        if (lr >= win_condition) {
            drawWinningLine();
            return true;
        }
        int lurd = parent.CountLeftUpAndRightDown(row, col);
        if (lurd >= win_condition) {
            drawWinningLine();
            return true;
        }
        int ldru = parent.CountLeftDownAndRightUp(row, col);
        if (ldru >= win_condition) {
            drawWinningLine();
            return true;
        }
        return false;
    }
    
    private void saveOldMap() {
        // 5 -> 4
        // 4 -> 3
        // 3 -> 2
        // 2 -> 1
        // 1 -> current
        if (parent.getCountTurn() >= 4) {
            parent.getRedInfo().getActorSkill().setOldMap5(parent.getCopy2DimesionalArray(parent.getRedInfo().getActorSkill().getOldMap4()));
            parent.getBlueInfo().getActorSkill().setOldMap5(parent.getCopy2DimesionalArray(parent.getBlueInfo().getActorSkill().getOldMap4()));
        }
        if (parent.getCountTurn() >= 3) {
            parent.getRedInfo().getActorSkill().setOldMap4(parent.getCopy2DimesionalArray(parent.getRedInfo().getActorSkill().getOldMap3()));
            parent.getBlueInfo().getActorSkill().setOldMap4(parent.getCopy2DimesionalArray(parent.getBlueInfo().getActorSkill().getOldMap3()));
        }
        if (parent.getCountTurn() >= 2) {
            parent.getRedInfo().getActorSkill().setOldMap3(parent.getCopy2DimesionalArray(parent.getRedInfo().getActorSkill().getOldMap2()));
            parent.getBlueInfo().getActorSkill().setOldMap3(parent.getCopy2DimesionalArray(parent.getBlueInfo().getActorSkill().getOldMap2()));
        }
        if (parent.getCountTurn() >= 1) {
            parent.getRedInfo().getActorSkill().setOldMap2(parent.getCopy2DimesionalArray(parent.getRedInfo().getActorSkill().getOldMap()));
            parent.getBlueInfo().getActorSkill().setOldMap2(parent.getCopy2DimesionalArray(parent.getBlueInfo().getActorSkill().getOldMap()));
        }
        parent.getRedInfo().getActorSkill().setOldMap(parent.getMap());
        parent.getBlueInfo().getActorSkill().setOldMap(parent.getMap());
    }

    /* ============= Handle Event Section ============= */
    private void handleUndoEvent(GameInfo player, GameInfo otherPlayer, boolean Undo) {
        /* Khi red UNDO, se co nhung quy luat sau:
          [ UNDO, BLIND ]    Khi red bi blue BLIND, skill Blind cua blue se mat
         */
        if (Undo) {
            otherPlayer.getActorSkill().setBlindTurn(0);
            player.getActorSkill().setIsUndoActive(false);
        }
    }
    
    private void handleStopTimeEvent(GameInfo player, GameInfo otherPlayer, boolean StopTime) {
        // Check neu co ky nang stopTime dang hoat dong, thi tat no di!
        if (StopTime) {
            parent.nextTurn();
            player.getActorSkill().setIsStopTimeActive(false);
            
            player.disableSkill();
        }
    }
    
    private void handleBlockEvent(GameInfo player, GameInfo otherPlayer, int BlockTurn) {
        if (BlockTurn > 0) {
            if (BlockTurn > 1) {
                parent.nextTurn();
            }
            BlockTurn--;
            player.getActorSkill().setBlockTurn(BlockTurn);

            // This is for disable skill in game info, it has nothing to do with the game
            if (BlockTurn == 0) {
                player.disableSkill();
                player.lockSkill();
            }
            
        }
    }
    
    private void handleBlindEvent(GameInfo player, GameInfo otherPlayer, int BlindTurn) {

        /*  
        Khi red BLIND doi thu,:
             [BLIND, BLIND]  Thi blue khong duoc BLIND nguoc lai
             [BLIND, REMOVE]  Thi blue khong duoc REMOVE nguoc lai
             [BLIND, STOP TIME] , ma blue su dung STOP TIME thi lui ve oldMap 2, nhung muon xong khong tra.
         */
        //Red
        if (BlindTurn != 0) {
            otherPlayer.getActorSkill().setBlindTurn(0);
        }
        
        if (otherPlayer.getActorSkill().getBlindTurn() == 0) {
            if (BlindTurn == 2) {
                parent.resetBoard();
                BlindTurn--;
                player.getActorSkill().setBlindTurn(BlindTurn);
                return;
            }
            if (BlindTurn == 1) {
                BlindTurn--;
                player.getActorSkill().setBlindTurn(BlindTurn);
                
                parent.reDraw(player.getActorSkill().getOldMap2());
                
                if (!parent.hasChess(row, col) && !parent.isBlock(row, col)) {
                    //Muon xong tra
                    // Stop time will keep the current color panel
                    if (otherPlayer.getActorSkill().isStopTimeActive()) {
                        parent.nextTurn();
                    } else {
                        // if not stop time is active, don't change color panel
                        parent.setTurn(1 - parent.getTurn());
                    }

                    //Before Turn on
                    turnOn();

                    //After Turn on
                    if (!otherPlayer.getActorSkill().isStopTimeActive()) {// Neu stop time dang active, khong tra va set ve false
                        parent.setTurn(1 - parent.getTurn());
                    } else {
                        otherPlayer.getActorSkill().setIsStopTimeActive(false);
                    }
                    this.removeMouseListener(mouseClicked);
                    this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
                updateIcon();

                // This is for disable skill in game info, it has nothing to do with the game
                if (BlindTurn == 0) {
                    player.disableSkill();
                }
                return;
            }
        }
        
    }
    
    private void handleSilenceEvent(GameInfo player, GameInfo otherPlayer, int SilenceTurn) {
        if (SilenceTurn > 0) {
            otherPlayer.disableSkill();
            otherPlayer.lockSkill();
            SilenceTurn--;
            player.getActorSkill().setSilenceTurn(SilenceTurn);
            
            if (SilenceTurn == 0) {
                player.disableSkill();
                
                if (!otherPlayer.isSkillUsed()) {
                    otherPlayer.enableSkill();
                    otherPlayer.unlockSkill();
                }
            }
        }
        
    }

    /* ============= Handle Event Section ============= */
    public void drawWinningLine() {
        // Neu diem bat dau bi null, thi set start la ban than cai nay luon. Vi du O duoi cua no co 4 o duoc dau 'X' thi win, va nguoc lai
        parent.getPnlGameNotfication().setVisible(true);
        
        
        
        if (parent.getStart() == null) {
            parent.setStart(this);
        } else if (parent.getEnd() == null) {
            parent.setEnd(this);
        }
        if (parent.isRPG()) {
            disableWinningLine(parent.getStart(), parent.getEnd(), parent.getTurn());
        }
        parent.repaint();
    }
    
    public void disableWinningLine(Cell Start, Cell End, int turn) {
        int StartRow = Start.getRow();
        int StartCol = Start.getCol();
        int EndRow = End.getRow();
        int EndCol = End.getCol();

        //Hang ngang
        if (StartRow == EndRow) {
            int i = StartCol;
            do {
                parent.getMap()[StartRow][i].setValue(turn == ImproveCaro.XCell ? -2 : -3);
                parent.getMap()[StartRow][i].updateIcon();
                i++;
            } while (i < parent.getNumCols() && parent.getMap()[StartRow][i - 1] != End);
        } else if (StartCol == EndCol) {         //Hang doc
            int i = StartRow;
            do {
                parent.getMap()[i][StartCol].setValue(turn == ImproveCaro.XCell ? -2 : -3);
                parent.getMap()[i][StartCol].updateIcon();
                i++;
            } while (i < parent.getNumRows() && parent.getMap()[i - 1][StartCol] != End);
        } else if (StartRow < EndRow && StartCol < EndCol) { //Cheo tu ben trai sang ben phai
            int i = StartRow;
            int j = StartCol;
            do {
                parent.getMap()[i][j].setValue(turn == ImproveCaro.XCell ? -2 : -3);
                parent.getMap()[i][j].updateIcon();
                i++;
                j++;
            } while (i < parent.getNumRows() && j < parent.getNumCols() && parent.getMap()[i - 1][j - 1] != End);
        } else {//Cheo tu ben phai sang trai
            int i = StartRow;
            int j = StartCol;
            do {
                parent.getMap()[i][j].setValue(turn == ImproveCaro.XCell ? -2 : -3);
                parent.getMap()[i][j].updateIcon();
                i++;
                j--;
            } while (i < parent.getNumRows() && j >= 0 && parent.getMap()[i - 1][j + 1] != End);
        }
        
    }
    
    public void turnOn() {
        value = value * ImproveCaro.turnOnValue + parent.getTurn();
        System.out.println(value);
        updateIcon();
    }
    
    private void turnOnBlock() {
        value = -1;
        updateIcon();
    }
    
    public void updateSize() {
        this.setSize(new Dimension(width, width));
    }
    
    public void updateIcon() {
        this.setIcon(resizeImageIcon(getImageIcon(), width, width));
    }
    
    public ImageIcon getImageIcon() {
        return new ImageIcon(getClass().getResource("/img/" + value + ".png"));
    }
    
    public ImageIcon getImageIconRemove() {
        return new ImageIcon(getClass().getResource("/img/" + value + "-remove.png"));
    }
    
    public ImageIcon resizeImageIcon(ImageIcon oldImg, int width, int height) {
        return new ImageIcon(oldImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
    
    public void setRemoveEvent() {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        removeEvent = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int r = parent.getNumRows(), c = parent.getNumCols();
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        
                        if (!(i == row && j == col)) {
                            if (parent.hasChess(i, j)
                                    && parent.DifferentColor(i, j, parent.getTurn())) {
                                parent.getMap()[i][j].updateIcon();
                                parent.getMap()[i][j].removeMouseListener(parent.getMap()[i][j].getRemoveEvent());
                                parent.getMap()[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                            } else if (!parent.hasChess(i, j) && !parent.isBlock(i, j)) {
                                parent.getMap()[i][j].addMouseListener(parent.getMap()[i][j].getMouseClicked());
                                parent.getMap()[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            }
                        }
                    }
                }
                value = value / ImproveCaro.turnOnValue;
                removeMouseListener(removeEvent);
                addMouseListener(mouseClicked);
                updateIcon();
            }
            
        };
        addMouseListener(removeEvent);
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getCol() {
        return col;
    }
    
    public void setCol(int col) {
        this.col = col;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public MouseListener getRemoveEvent() {
        return removeEvent;
    }
    
    public void setRemoveEvent(MouseListener removeEvent) {
        this.removeEvent = removeEvent;
    }
    
    public MouseListener getMouseClicked() {
        return mouseClicked;
    }
    
    public void setMouseClicked(MouseListener mouseClicked) {
        this.mouseClicked = mouseClicked;
    }
    
}
