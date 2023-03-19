/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvecaro;

import java.awt.Color;
import java.awt.Cursor;

/**
 *
 * @author Acer
 */
public class Skill {

    private int currentSkill;

    public static final int UNDO = 0;
    public static final int REMOVE = 1;
    public static final int STEAL = 2;
    public static final int STOPTIME = 3;
    public static final int SILENCE = 4;
    public static final int BLIND = 5;
    public static final int BLOCK = 6;

    public static final int numSkills = 7;

    //For UNDO, BLIND skill, an old map is need
    private int oldMap[][];
    private int oldMap2[][];
    private int oldMap3[][];
    private int oldMap4[][];
    private int oldMap5[][];

    //For UNDO of self  deny BLIND of enemy, a boolean is needed
    private boolean isUndoActive;
    // For STOPTIME skill, a boolean is needed
    private boolean isStopTimeActive;
    // For BLIND skill , a countTurn is need to check
    private int BlindTurn;
    // For REMOVE skill, a boolean is need
    private boolean isRemoveActive;
    //For Block skill, a countTurn is need to check
    private int BlockTurn;
    // For SILENCE skill, a countTurn is needed
    private int SilenceTurn;

    //For modifying the parent
    private ImproveCaro parent;

    public Skill(ImproveCaro parent) {
        this.parent = parent;

        //Old map declaring
        oldMap = new int[parent.getNumRows()][parent.getNumCols()];
        oldMap2 = new int[parent.getNumRows()][parent.getNumCols()];
        oldMap3 = new int[parent.getNumRows()][parent.getNumCols()];
        oldMap4 = new int[parent.getNumRows()][parent.getNumCols()];
        oldMap5 = new int[parent.getNumRows()][parent.getNumCols()];

    }

    public static int getRandomSkill() {
        return randomNumber(0, numSkills - 1);
    }

    private static int randomNumber(int MIN, int MAX) {
        return MIN + (int) (Math.random() * (MAX - MIN + 1));
    }

    /* ============ Skill Section ============*/
    public void Undo() {
        if (parent.getCountTurn() >= 3) {
            isUndoActive = !isUndoActive;
            parent.reDraw(parent.getRedInfo().getActorSkill().getOldMap3());
        }
    }

    public void Remove() {
        isRemoveActive = !isRemoveActive;

        Skill otherPlayerSkill;
        if (parent.getRedInfo().getActorSkill() != this) {
            otherPlayerSkill = parent.getRedInfo().getActorSkill();
        } else {
            otherPlayerSkill = parent.getBlueInfo().getActorSkill();
        }

        /*  
        Khi red BLIND doi thu,:
             [BLIND, REMOVE]  Thi blue khong duoc REMOVE nguoc lai
         */
        if (isRemoveActive && otherPlayerSkill.getBlindTurn() == 0) {
            int nextTurn = 1 - parent.getTurn();
            int r = parent.getNumRows(), c = parent.getNumCols();

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (parent.hasChess(i, j)
                            && parent.SameColor(i, j, nextTurn)) {
                        parent.getMap()[i][j].setIcon(parent.getMap()[i][j].getImageIconRemove());
                        parent.getMap()[i][j].setRemoveEvent();
                    } else if (!parent.hasChess(i, j)) {// Empty cell can't be clicked 
                        parent.getMap()[i][j].removeMouseListener(parent.getMap()[i][j].getMouseClicked());
                        parent.getMap()[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            }
        }
    }

    public void Steal() {
        /*
          [STEAL, BLIND], khi player dang bi BLIND, thi mat skill STEAL
          [STEAL, STEAL] khi player STEAL ky nang STEAL, thi ca hai deu bi mat skill
         */

        GameInfo player = (parent.getRedInfo().getActorSkill() == this) ? parent.getRedInfo() : parent.getBlueInfo();
        GameInfo otherPlayer = (parent.getRedInfo().getActorSkill() == this) ? parent.getBlueInfo() : parent.getRedInfo();

        if (otherPlayer.getActorSkill().getBlindTurn() == 0) {
            currentSkill = otherPlayer.getActorSkill().getCurrentSkill();
        }

        otherPlayer.disableSkill();
        otherPlayer.lockSkill();
        otherPlayer.setIsSkillUsed(true);

        if (currentSkill == STEAL) {
            player.disableSkill();
            player.lockSkill();
            player.setIsSkillUsed(true);
        }

        player.updateSkillIcon();
    }

    public void StopTime() {//toggle on/off
        isStopTimeActive = !isStopTimeActive;
    }

    public void Silence() {
        SilenceTurn = 5;
    }

    public void Blind() {
        BlindTurn = 2;
    }

    public void Block() {
        BlockTurn = 3;
    }

    /* ============ Skill Section ============*/
    public int getCurrentSkill() {
        return currentSkill;
    }

    public void setCurrentSkill(int currentSkill) {
        this.currentSkill = currentSkill;
    }

    public boolean isStopTimeActive() {
        return isStopTimeActive;
    }

    public void setIsStopTimeActive(boolean isStopTimeActive) {
        this.isStopTimeActive = isStopTimeActive;
    }

    public int getBlindTurn() {
        return BlindTurn;
    }

    public void setBlindTurn(int BlindTurn) {
        this.BlindTurn = BlindTurn;
    }

    public boolean isUndoActive() {
        return isUndoActive;
    }

    public void setIsUndoActive(boolean isUndoActive) {
        this.isUndoActive = isUndoActive;
    }

    public boolean isRemoveActive() {
        return isRemoveActive;
    }

    public void setIsRemoveActive(boolean isRemoveActive) {
        this.isRemoveActive = isRemoveActive;
    }

    public int getBlockTurn() {
        return BlockTurn;
    }

    public void setBlockTurn(int BlockTurn) {
        this.BlockTurn = BlockTurn;
    }

    public int getSilenceTurn() {
        return SilenceTurn;
    }

    public void setSilenceTurn(int SilenceTurn) {
        this.SilenceTurn = SilenceTurn;
    }

    /*==================== Old map get and set ====================  */
    public int[][] getOldMap2() {
        return oldMap2;
    }

    public void setOldMap2(int[][] oldMap2) {
        this.oldMap2 = oldMap2;
    }

    public int[][] getOldMap3() {
        return oldMap3;
    }

    public void setOldMap3(int[][] oldMap3) {
        this.oldMap3 = oldMap3;
    }

    public int[][] getOldMap4() {
        return oldMap4;
    }

    public void setOldMap4(int[][] oldMap4) {
        this.oldMap4 = oldMap4;
    }

    public int[][] getOldMap5() {
        return oldMap5;
    }

    public void setOldMap5(int[][] oldMap5) {
        this.oldMap5 = oldMap5;
    }

    public void setOldMap(Cell[][] oldMap) {
        //Make a copy of the current map
        int r = parent.getNumRows();
        int c = parent.getNumCols();

        System.out.println(r);
        System.out.println(c);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                this.oldMap[i][j] = oldMap[i][j].getValue();
            }
        }
    }

    public int[][] getOldMap() {
        return oldMap;
    }

}
