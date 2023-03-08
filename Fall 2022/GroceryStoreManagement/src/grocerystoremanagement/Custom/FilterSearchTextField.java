package grocerystoremanagement.Custom;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

public class FilterSearchTextField extends JTextField {

    public JList myList;
    public DefaultListModel defaultListModel;
    public ArrayList<String> arrayList;
    private String hint = "   Input phone number here!";
    private final int MAXLIST = 6;
    private String option;
    private boolean showingHint;
    private FocusListener FocusShowHint;

    public FilterSearchTextField(String option) {
        this.option = option;
        initComponent();
    }

    private void initComponent() {
        showingHint = true;

        arrayList = new ArrayList<>();

        myList = new JList();
        myList.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK), BorderFactory.createEmptyBorder(3, 3, 3, 3)));
        defaultListModel = new DefaultListModel();

        myList.setModel(defaultListModel);
        myList.setVisible(false);

        FocusShowHint = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().isEmpty() && showingHint) {
                    setText("");
                    setForeground(Color.BLACK);
                    showingHint = false;
                }
                myList.setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(hint);
                    setForeground(Color.LIGHT_GRAY);
                    showingHint = true;
                }
                myList.setVisible(false);
            }
        };

        addFocusListener(FocusShowHint);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                Filter(getText(), option);
            }
        });

    }

    public void bindItem() {
        DefaultListModel temp = new DefaultListModel();
        for (String i : arrayList) {
            temp.addElement(i);
        }
        defaultListModel = temp;
        myList.setModel(defaultListModel);
    }

    public ArrayList<String> getData() {
        return this.arrayList;
    }

    public void addData(ArrayList<String> a) {
        arrayList.addAll(a);
    }

    public void addData(String a) {
        arrayList.add(a);
    }

    public void addData(Set<String> a) {
        arrayList.addAll(a);
    }

    public void setData(ArrayList<String> a) {
        arrayList.clear();
        arrayList.addAll(a);
    }

    public void setData(Set<String> a) {
        arrayList.clear();
        arrayList.addAll(a);
    }

    private void Filter(String t, String option) {
        DefaultListModel filtermodel = new DefaultListModel();
        getData().stream().forEach((i) -> {
            if (i.toString().toLowerCase().contains(t.toLowerCase())) {
                filtermodel.addElement(i);
            }
        });
        if (filtermodel.size() == 0) {
            filtermodel.addElement(option);
        }
        defaultListModel = filtermodel;
        myList.setModel(defaultListModel);
        myList.setSize(myList.getWidth(), (myList.getModel().getSize() > MAXLIST) ? 30 * MAXLIST : 30 * myList.getModel().getSize());
    }

    public void setDisableFocusListener() {
        showingHint = false;
        removeFocusListener(this.FocusShowHint);
    }

    public String getOption() {
        return option;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        myList.setBounds(getX(), getY() + getHeight(), getWidth(), 30 * 5);
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }
}
