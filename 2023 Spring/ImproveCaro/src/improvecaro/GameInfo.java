/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvecaro;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */
public class GameInfo extends JPanel {

    public static int Red = 0;
    public static int Blue = 1;
    private int color;

    public final static Color RedTurn = new Color(255, 66, 66);
    public final static Color RedWait = new Color(166, 44, 44);
    public final static Color BlueTurn = new Color(0, 149, 239);
    public final static Color BlueWait = new Color(60, 80, 177);

    public final static String RedName = "red";
    public final static String BlueName = "blue";

    private ImproveCaro parent;

    private JLabel lblBg;
    private int BgValue;
    private JLabel ActorHolder;
    //Skill
    private Skill ActorSkill;
    private JLabel lblSkill;
    private MouseListener lblSkillClicked;
    private boolean isSkillUsed;
    private int HP;

    // For making the skill button more clear if the button is toggle or not
    private JLabel lblBelowSkill;
    private JLabel lblAboveSkill;

    public GameInfo(ImproveCaro parent, int color, int width, int height) {
        this.parent = parent;
        this.color = color;
        setBounds(0, 0, width, height);
        setBorder(BorderFactory.createRaisedBevelBorder());
        init();
    }

    private void init() {
        ActorSkill = new Skill(parent);
        // Init all the required components in the game info panel
        setLayout(null);

        GenerateActorImage();
        add(ActorHolder);

        if (parent.isRPG()) {
            HP = 3;
            GenerateSkillImage();
            GenerateRandomSkill();

            lblBg = new JLabel();

            add(lblBg);
            add(lblBelowSkill);
            add(lblSkill);
            add(lblAboveSkill);

            // The z-index of 3 lables, Lower z-index mean it on top of all other components
            setComponentZOrder(lblAboveSkill, 1);
            setComponentZOrder(lblSkill, 2);
            setComponentZOrder(lblBelowSkill, 3);
        }

        repaint();
    }

    private void GenerateActorImage() {
        ActorHolder = new JLabel();

        int width = 100;
        int height = 100;
        int y = 150;

        if (parent.isNormal()) {
            width = (int) this.getWidth();
            height = (int) this.getHeight();
            y = 0;
        }
        int x = (int) (getPreferredSize().getWidth() - width) / 2;

        ActorHolder.setBounds(x, y, width, height);
        ActorHolder.setBackground(Color.BLACK);
        setDefaultActor();
    }

    private void GenerateSkillImage() {
        lblSkill = new JLabel();

        lblBelowSkill = new JLabel();
        lblAboveSkill = new JLabel();

        int SkillAndActorGap = 10;

        //Vi tri
        int x = ActorHolder.getX() + ActorHolder.getWidth() * 1 / 6;
        int y = ActorHolder.getY() + ActorHolder.getHeight() + SkillAndActorGap;
        int width = ActorHolder.getWidth() * 2 / 3;
        int height = ActorHolder.getHeight() * 2 / 3;

        lblSkill.setBounds(x, y, width, height);
        lblBelowSkill.setBounds(x - 9999, y - 9999, width, height);
        lblAboveSkill.setBounds(x - 10 - 9999, y - 10 - 9999, width + 20, height + 20);

        lblSkill.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
//        lblAboveSkill.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
//        lblBelowSkill.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

        lblSkill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblAboveSkill.setIcon(resizeImageIcon(getSkillIcon("empty-skill"), width + 20, height + 20));
        lblBelowSkill.setOpaque(true);
        lblBelowSkill.setBackground(Color.yellow);

        lblSkillClicked = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                HandlingSkill();
            }
        };

        lblSkill.addMouseListener(lblSkillClicked);
    }

    private void GenerateRandomSkill() {
        this.ActorSkill.setCurrentSkill(ActorSkill.getRandomSkill());
        updateSkillIcon();
    }

    public void HandlingSkill() {

        switch (ActorSkill.getCurrentSkill()) {
            case Skill.UNDO:
                ActorSkill.Undo();
                break;
            case Skill.REMOVE:
                ActorSkill.Remove();
                break;
            case Skill.STEAL:
                ActorSkill.Steal();
                break;
            case Skill.STOPTIME:
                ActorSkill.StopTime();
                break;
            case Skill.SILENCE:
                ActorSkill.Silence();
                break;
            case Skill.BLIND:
                ActorSkill.Blind();
                break;
            case Skill.BLOCK:
                ActorSkill.Block();
                break;
        }

        boolean isStopTimeActive = ActorSkill.isStopTimeActive();
        boolean isBlindActive = (ActorSkill.getBlindTurn() != 0);
        boolean isBlockActive = (ActorSkill.getBlockTurn() != 0);
        boolean isSilenceActive = (ActorSkill.getSilenceTurn() != 0);

        if (isSkillActive()) {
            lblSkill.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));
            if (isBlindActive || isBlockActive || isSilenceActive || isStopTimeActive) {
                activeSkill();
            } else {
                disableSkill();
            }
            isSkillUsed = true;
            lockSkill();
        } else {
            lblSkill.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        }
    }

    public void updateSkillIcon() {
        int width = ActorHolder.getWidth() * 2 / 3;
        int height = ActorHolder.getWidth() * 2 / 3;
        String skillname = "";
        switch (ActorSkill.getCurrentSkill()) {
            case Skill.UNDO:
                skillname = "undo";
                break;
            case Skill.REMOVE:
                skillname = "remove";
                break;
            case Skill.STEAL:
                skillname = "steal";
                break;
            case Skill.STOPTIME:
                skillname = "stopTime";
                break;
            case Skill.SILENCE:
                skillname = "silence";
                break;
            case Skill.BLIND:
                skillname = "blind";
                break;
            case Skill.BLOCK:
                skillname = "block";
                break;
        }
        lblSkill.setIcon(resizeImageIcon(getSkillIcon(skillname), width, height));

    }

    public void reducedHp() {
        HP--;
        updateHPbar();
        if (this.HP > 0) {
            animateHPBar();
            resetSkill();
        }
    }

    public void animateHPBar() {
        Timer timer = new Timer();
        TimerTask tt = parent.ShakeComponent(lblBg, lblBg.getX() - 4, lblBg.getX() + 4, 2);
        timer.schedule(tt, 0, 5);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                tt.cancel();
                timer.cancel();
            }
        }, 300, 5);
    }

    public void resetSkill() {
        GameInfo player = (parent.getRedInfo() == this ? parent.getRedInfo() : parent.getBlueInfo());
        GameInfo otherPlayer = (parent.getRedInfo() == this ? parent.getBlueInfo() : parent.getRedInfo());

        player.getActorSkill().setCurrentSkill(Skill.getRandomSkill());
        otherPlayer.getActorSkill().setCurrentSkill(Skill.getRandomSkill());
        parent.resetSkill();
        player.updateSkillIcon();
        otherPlayer.updateSkillIcon();
    }

    public void updateHPbar() {

        int width = getWidth() * 2 / 3;
        int y = (lblSkill.getY() + lblSkill.getHeight() + 40);
        int height = (getHeight()) / 2;
        int x = (getWidth() - width) / 2;
        lblBg.setBounds(x, y, width, height);
        lblBg.setIcon(resizeImageIcon(getHPBarValue(BgValue), width, height));
    }

    public ImageIcon getHPBarValue(int Color) {
        return new ImageIcon(getClass().getResource("/img/Menu/" + (Color == ImproveCaro.OCell ? RedName : BlueName) + "-" + HP + "-health.png"));
    }

    public int getBgValue() {
        return BgValue;
    }

    public void setBgValue(int BgValue) {
        this.BgValue = BgValue;
        updateHPbar();
    }

    /* ============ Other function ============*/
    public boolean isSkillActive() {
        boolean isUndo = ActorSkill.isUndoActive();
        boolean isRemove = ActorSkill.isRemoveActive();
        boolean isStopTime = ActorSkill.isStopTimeActive();
        boolean isBlindActive = (ActorSkill.getBlindTurn() != 0);
        boolean isBlockActive = (ActorSkill.getBlockTurn() != 0);
        boolean isSilenceActive = (ActorSkill.getSilenceTurn() != 0);

        return isUndo || isRemove || isStopTime || isBlindActive || isBlockActive || isSilenceActive;
    }

    public void activeSkill() {
        int SkillAndActorGap = 10;
        int x = ActorHolder.getX() + ActorHolder.getWidth() * 1 / 6;
        int y = ActorHolder.getY() + ActorHolder.getHeight() + SkillAndActorGap;
        int width = ActorHolder.getWidth() * 2 / 3;
        int height = ActorHolder.getHeight() * 2 / 3;

        lblBelowSkill.setBounds(x, y, width, height);
    }

    public void disableSkill() {
        int SkillAndActorGap = 10;
        int x = ActorHolder.getX() + ActorHolder.getWidth() * 1 / 6;
        int y = ActorHolder.getY() + ActorHolder.getHeight() + SkillAndActorGap;
        int width = ActorHolder.getWidth() * 2 / 3;
        int height = ActorHolder.getHeight() * 2 / 3;

        lblBelowSkill.setBackground(Color.gray);

        lblBelowSkill.setBounds(x, y, width, height);
        lblAboveSkill.setBounds(x - 10, y - 10, width + 20, height + 20);
    }

    public void enableSkill() {
        int SkillAndActorGap = 10;
        int x = ActorHolder.getX() + ActorHolder.getWidth() * 1 / 6;
        int y = ActorHolder.getY() + ActorHolder.getHeight() + SkillAndActorGap;
        int width = ActorHolder.getWidth() * 2 / 3;
        int height = ActorHolder.getHeight() * 2 / 3;

        lblBelowSkill.setBackground(Color.yellow);

        lblBelowSkill.setBounds(x - 9999, y - 9999, width, height);
        lblAboveSkill.setBounds(x - 10 - 9999, y - 10 - 9999, width + 20, height + 20);

    }

    public void lockSkill() {
        if (parent.isRPG()) {
            lblSkill.removeMouseListener(lblSkillClicked);
            lblSkill.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public void unlockSkill() {
        if (parent.isRPG()) {
            lblSkill.addMouseListener(lblSkillClicked);
            lblSkill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    /* ============ Other function ============*/
 /* =============Getters and Setters===============*/
    public ImproveCaro getParent() {
        return parent;
    }

    public void setParent(ImproveCaro parent) {
        this.parent = parent;
    }

    public boolean isSkillUsed() {
        return isSkillUsed;
    }

    public void setIsSkillUsed(boolean isSkillUsed) {
        this.isSkillUsed = isSkillUsed;
    }

    public void setDefaultActor() {
        int width = (int) ActorHolder.getWidth();
        int height = (int) ActorHolder.getHeight();
        ActorHolder.setIcon(resizeImageIcon(getActorIcon(1), width, height));
    }

    public ImageIcon getActorIcon(int version) {
        return new ImageIcon(getClass().getResource("/img/Actor/" + (color == Red ? "Red" : "Blue") + "Actor" + version + "-removebg.png"));
    }

    public ImageIcon getSkillIcon(String SkillName) {
        return new ImageIcon(getClass().getResource("/img/Skill/" + SkillName + ".png"));
    }

    public ImageIcon resizeImageIcon(ImageIcon oldImg, int width, int height) {
        return new ImageIcon(oldImg.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Skill getActorSkill() {
        return ActorSkill;
    }

    public void setActorSkill(Skill ActorSkill) {
        this.ActorSkill = ActorSkill;
    }

    public JLabel getLblSkill() {
        return lblSkill;
    }

    public void setLblSkill(JLabel lblSkill) {
        this.lblSkill = lblSkill;
    }

    public MouseListener getLblSkillClicked() {
        return lblSkillClicked;
    }

    public void setLblSkillClicked(MouseListener lblSkillClicked) {
        this.lblSkillClicked = lblSkillClicked;
    }

    public JLabel getLblBelowSkill() {
        return lblBelowSkill;
    }

    public void setLblBelowSkill(JLabel lblBelowSkill) {
        this.lblBelowSkill = lblBelowSkill;
    }

    public JLabel getLblAboveSkill() {
        return lblAboveSkill;
    }

    public void setLblAboveSkill(JLabel lblAboveSkill) {
        this.lblAboveSkill = lblAboveSkill;
    }

    public JLabel getActorHolder() {
        return ActorHolder;
    }

    public void setActorHolder(JLabel ActorHolder) {
        this.ActorHolder = ActorHolder;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

}
