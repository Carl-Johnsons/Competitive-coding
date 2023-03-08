package grocerystoremanagement;

import grocerystoremanagement.Custom.FilterSearchTextField;
import grocerystoremanagement.Custom.CustomJFrame;
import grocerystoremanagement.StoreManagement.Application;
import grocerystoremanagement.StoreManagement.Bill;
import grocerystoremanagement.StoreManagement.Customer;
import grocerystoremanagement.StoreManagement.Product;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public final class GUI {

    //<editor-fold defaultstate="collapsed" desc="Declaration">
    private CustomJFrame mainFrame;
    private JTextArea header;
    private JLabel StartJLabel;
    private JButton CloseButton;
    private JTextArea CloseBackgroundButton;

    //Data
    private Application Data;
    private Set<String> ProductNameSet;
    private Set<String> ProductTypeSet;
    private Set<Integer> ExpiredItemIndex;
    private ArrayList<Integer> Product_Total;
    private Set<String> Phone_Number;

    //Menu Panel
    private JPanel MenuPanel;
    private final JButton[] MenuButtons = new JButton[3];
    private final JLabel[] MenuButtonLabel = new JLabel[MenuButtons.length];
    
    private JTable KhachhangJTable;
    private JTable HangHoaJTable;
    
    private JScrollPane KhachhangScrollPane;
    private JScrollPane HangHoaScrollPane;
    
    private JLabel TitleBackground;
    private JLabel Title;

    //CUSTOMER PANEL
    private JPanel CustomerPanel;
    private JButton ReturnButtonCus;
    private JLabel ReturnLabelCus;
    private FilterSearchTextField SearchCustomerField;
    private JTextArea SearchCustomerArea;
    private JTextField AddCustomerField[] = new JTextField[2];
    private JList CustomerBillJList;
    private JLabel[] CusLabels = new JLabel[2];

    //PRODUCT PANEL
    private JPanel ProductPanel;
    private JButton ReturnButtonPro;
    private JLabel ReturnLabelPro;
    private final JButton ProButton[] = new JButton[5];
    private final JLabel ProButtonLabel[] = new JLabel[ProButton.length];
    private FilterSearchTextField ProductSearchField;
    private boolean[] ProButtonCLicked = new boolean[2];
    private JTable ProductTable;
    private JScrollPane ProductScrollPane;
    private JLabel SearchProductLabel;
    
    private JDialog Notify_Expired_Product_Dialog;
    private JTable NotifyDialogTable;
    private JScrollPane NotifyDialogJScrollPane;
    private JButton NotifyDeleteButton;
    
    private JDialog Product_Add_Dialog;
    private JButton Pro_Add_Button;
    private FilterSearchTextField Pro_Add_Field[] = new FilterSearchTextField[5];

    //SELL PANEL
    private JPanel SellPanel;
    private JButton ReturnButtonSell;
    private FilterSearchTextField SearchSellField;
    private JTextArea SearchSellArea;
    private JTable SellTable;
    private JScrollPane SellScrollPane;
    private JLabel SellLabel[] = new JLabel[2];
    private JButton SellButton[] = new JButton[4];
    private JLabel SellButtonLabel[] = new JLabel[4];
    
    private FilterSearchTextField AddSellField[] = new FilterSearchTextField[5];
    private JDialog AddSellDialog;
    private JButton Dialog_OK_OPTION;

    //Other
    File[] allFile = new File("src\\grocerystoremanagement\\res").listFiles();
    BufferedImage allImg[] = new BufferedImage[allFile.length];
    private JTextArea CoordinateArea;
    private boolean Closed;

    //</editor-fold>
    
    public GUI() throws IOException, FontFormatException {
        prepareData();
        prepareGUI();
    }
    
    public static void main(String[] args) throws IOException, FontFormatException {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    new GUI().ProgramStart();
//                } catch (IOException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (FontFormatException ex) {
//                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
        new Login().Start();
    }
    
    public void prepareGUI() throws IOException, FontFormatException {

        //<editor-fold defaultstate="collapsed" desc="MAINFRAME AND OTHER STUFF">
        //MAIN FRAME
        Closed = false;
        
        mainFrame = new CustomJFrame();
        mainFrame.setFocusable(true);
        mainFrame.setUndecorated(true);
        
        StartJLabel = new JLabel("CLICK ANYWHERE TO CONTINUE");
        StartJLabel.setFont(GetFuronsFont(60));
        StartJLabel.setForeground(new Color(50, 200, 200));
        StartJLabel.setBounds(300, 500, 750, 60);
        
        StartButtonEffect();
        //OTHER STUFF

        for (int i = 0; i < allFile.length; i++) {
            allImg[i] = ImageIO.read(allFile[i]);
        }
        CoordinateArea = new JTextArea();
        CoordinateArea.setBounds(10, 10, 100, 100);
        CoordinateArea.setEditable(false);
        CoordinateArea.setFont(GetFuronsFont(30));
        CoordinateArea.setOpaque(false);
        CoordinateArea.setForeground(Color.GREEN);
        
        CloseButton = new JButton();
        CloseButton.setContentAreaFilled(false);
        CloseButton.setBorder(null);
        CloseButton.setBounds(1080, 580, 150, 100);
        CloseButton.setIcon(new ImageIcon(allImg[21].getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        
        CloseBackgroundButton = new JTextArea();
        CloseBackgroundButton.setBounds(CloseButton.getX() + 2, CloseButton.getY() + 37, CloseButton.getWidth() - 2, CloseButton.getHeight() - 42);
        CloseBackgroundButton.setEditable(false);
        CloseBackgroundButton.setBackground(Color.WHITE);
        CloseBackgroundButton.setBorder(null);

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="MENU PANEL">
        // -----------------------------------------------------------------
        //                  MENU PANEL
        // -----------------------------------------------------------------
        MenuPanel = new JPanel();
        MenuPanel.setSize(mainFrame.getSize());
        MenuPanel.setOpaque(false);
        MenuPanel.setLayout(null);
        
        for (int i = 0; i < MenuButtons.length; i++) {
            MenuButtons[i] = new JButton();
            MenuButtons[i].setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
            MenuButtons[i].setContentAreaFilled(false);
            MenuButtons[i].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK));
            
            MenuButtonLabel[i] = new JLabel();
            MenuButtonLabel[i].setFont(GetFuronsFont(40));
            MenuButtonLabel[i].setHorizontalAlignment(JLabel.CENTER);
            MenuButtonLabel[i].setForeground(new Color(160, 200, 210));
            
            ButtonEffect(MenuButtons[i], MenuButtonLabel[i]);
        }
        MenuButtons[0].setBounds(-200, 530, 200, 70);
        MenuButtonLabel[0].setBounds(MenuButtons[0].getBounds());
        MenuButtonLabel[0].setText("Add");
        
        MenuButtons[1].setBounds(1300, 530, 200, 70);
        MenuButtonLabel[1].setBounds(MenuButtons[1].getBounds());
        MenuButtonLabel[1].setText("Add");
        
        MenuButtons[2].setBounds(530, 730, 200, 70);
        MenuButtonLabel[2].setBounds(MenuButtons[2].getBounds());
        MenuButtonLabel[2].setText("Sell");
        
        TitleBackground = new JLabel(new ImageIcon(allImg[8].getScaledInstance(700, 150, Image.SCALE_SMOOTH)));
        TitleBackground.setBounds(390, -200, 500, 150);
        
        Title = new JLabel("Grocery Store Management");
        Title.setBounds(TitleBackground.getBounds());
        Title.setHorizontalAlignment(JLabel.CENTER);
        Title.setFont(GetFuronsFont(40));
        Title.setBorder(new CompoundBorder(Title.getBorder(), new EmptyBorder(0, 30, 0, 0)));
        Title.setForeground(new Color(160, 200, 210));
        Title.setVisible(false);

        //<editor-fold defaultstate="collapsed" desc="2 TABLE">
        //2 TABLE
        // -----------------------------------------------------------------
        //                                  TABLE #1
        // -----------------------------------------------------------------
        KhachhangJTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new Object[]{
                    "NAME", "PHONE", "ACCUMULATION "
                })) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        
        DefaultTableModel KhachHangModel = (DefaultTableModel) KhachhangJTable.getModel();
        
        for (Customer i : Data.Custom) {
            if (i.getC_Name().compareToIgnoreCase("Default") != 0) {
                String allAtr = i.getC_Name() + ";" + i.getSTD() + ";" + i.getC_Point();
                String rowData[] = allAtr.split(";");
                KhachHangModel.addRow(rowData);
            }
        }
        
        KhachhangJTable.getTableHeader().setFont(GetFuronsFont(15));
        KhachhangJTable.getTableHeader().setBackground(new Color(32, 136, 203));
        KhachhangJTable.getTableHeader().setForeground(new Color(255, 255, 255));
        
        KhachhangJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        KhachhangJTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        KhachhangJTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        KhachhangJTable.getColumnModel().getColumn(2).setMinWidth(130);
        KhachhangJTable.setRowHeight(30);
        KhachhangJTable.setFont(GetFuronsFont(20));
        KhachhangJTable.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.lightGray));
        
        KhachhangScrollPane = new JScrollPane();
        KhachhangScrollPane.setViewportView(KhachhangJTable);
        
        KhachhangScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        KhachhangScrollPane.setBounds(-570, 250, 500, 270);
        KhachhangScrollPane.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.darkGray));

        // -----------------------------------------------------------------
        //                                  TABLE #2
        // -----------------------------------------------------------------
        HangHoaJTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new Object[]{
                    "NAME", "TYPE", "NUMBER", "UNIT PRICE", "NEAR EXPIRY"})) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        
        DefaultTableModel HangHoaModel = (DefaultTableModel) HangHoaJTable.getModel();
        
        Date today = new Date();
        
        for (String P_NAME : ProductNameSet) {
            int count = 0;
            Date near_expire = new Date();
            for (int i = 0; i < Data.Store.size(); i++) {
                if (P_NAME.compareToIgnoreCase(Data.Store.get(i).getP_Name()) == 0 && today.before(Data.Store.get(i).getHSD()) || today.equals(Data.Store.get(i).getHSD())) {
                    count += Data.Store.get(i).getP_Number();
                    if (near_expire.equals(today) || near_expire.after(Data.Store.get(i).getHSD())) {
                        near_expire = Data.Store.get(i).getHSD();
                    }
                }
            }
            Product_Total.add(count);
            for (Product i : Data.Store) {
                if (P_NAME.compareTo(i.getP_Name()) == 0 && count > 0) {
                    String d = new SimpleDateFormat("dd/MM/yyyy").format(near_expire);
                    String allAtr = P_NAME + ";" + i.getP_type() + ";" + count + ";" + i.getOut_Price() + ";" + d;
                    String rowData[] = allAtr.split(";");
                    HangHoaModel.addRow(rowData);
                    break;
                }
            }
        }
        
        HangHoaJTable.getTableHeader().setFont(GetFuronsFont(15));
        HangHoaJTable.getTableHeader().setBackground(new Color(32, 136, 203));
        HangHoaJTable.getTableHeader().setForeground(new Color(255, 255, 255));
        
        HangHoaJTable.setFont(GetFuronsFont(20));
        HangHoaJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        HangHoaJTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        HangHoaJTable.getColumnModel().getColumn(1).setPreferredWidth(70);
        HangHoaJTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        HangHoaJTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        HangHoaJTable.getColumnModel().getColumn(4).setMinWidth(150);
        HangHoaJTable.setRowHeight(30);
        
        HangHoaScrollPane = new JScrollPane();
        HangHoaScrollPane.setViewportView(HangHoaJTable);
        HangHoaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        HangHoaScrollPane.setBounds(1300, 250, 500, 270);

        //</editor-fold>
        //                  MENU PANEL ADD ELEMENTS
        for (int i = 0; i < MenuButtons.length; i++) {
            MenuPanel.add(MenuButtonLabel[i]);
            MenuPanel.add(MenuButtons[i]);
        }
        MenuPanel.add(KhachhangScrollPane);
        MenuPanel.add(HangHoaScrollPane);

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CUSTOMER PANEL">
        //                  CUSTOMER PANEL
        CustomerPanel = new JPanel();
        CustomerPanel.setLayout(null);
        CustomerPanel.setBounds(-1280, 0, 1280, 720);
        CustomerPanel.setOpaque(false);
        CustomerPanel.setFocusable(true);
        
        ReturnButtonCus = new JButton("BACK");
        ReturnButtonCus.setFont(GetFuronsFont(40));
        ReturnButtonCus.setOpaque(false);
        ReturnButtonCus.setContentAreaFilled(false);
        ReturnButtonCus.setBorder(null);
        ReturnButtonCus.setForeground(Title.getForeground());
        ReturnButtonCus.setBounds(30, 800, 150, 70);
        
        ReturnLabelCus = new JLabel();
        ReturnLabelCus.setIcon(new ImageIcon(allImg[9].getScaledInstance(150, 70, Image.SCALE_SMOOTH)));
        ReturnLabelCus.setBounds(ReturnButtonCus.getBounds());
        
        SearchCustomerField = new FilterSearchTextField("Add new customer");
        SearchCustomerField.setBounds(500, 200, 500, 50);
        SearchCustomerField.addData(Phone_Number);
        SearchCustomerField.bindItem();
        SearchCustomerField.setFont(GetFuronsFont(30));
        
        SearchCustomerField.myList.setFont(GetFuronsFont(20));
        
        SearchCustomerArea = new JTextArea();
        SearchCustomerArea.setFont(SearchCustomerField.getFont());
        SearchCustomerArea.setEditable(false);
        SearchCustomerArea.setBounds(SearchCustomerField.getX(), SearchCustomerField.getY() + SearchCustomerField.getHeight() + 10, SearchCustomerField.getWidth(), SearchCustomerField.getHeight());
        
        for (int i = 0; i < 2; i++) {
            AddCustomerField[i] = new JTextField();
        }
        
        CustomerBillJList = new JList();
        CustomerBillJList.setFont(GetFuronsFont(20));
        CustomerBillJList.setBounds(SearchCustomerArea.getX() - 200, SearchCustomerArea.getY() + SearchCustomerArea.getHeight() + 10, SearchCustomerArea.getWidth() + 200, SearchCustomerArea.getHeight() * 3);
        
        for (int i = 0; i < 2; i++) {
            CusLabels[i] = new JLabel();
            CusLabels[i].setForeground(Title.getForeground());
            CusLabels[i].setFont(GetFuronsFont(32));
        }
        CusLabels[0].setBounds(SearchCustomerField.getX() - 200, SearchCustomerField.getY(), CustomerBillJList.getWidth() - SearchCustomerField.getWidth(), SearchCustomerField.getHeight());
        CusLabels[1].setBounds(SearchCustomerField.getX() - 200, SearchCustomerArea.getY(), CustomerBillJList.getWidth() - SearchCustomerField.getWidth(), SearchCustomerField.getHeight());
        
        CusLabels[0].setText("So Dien Thoai");
        CusLabels[1].setText("Khach Hang");

        //                  CUSTOMER PANEL ADD ELEMENTS
        CustomerPanel.add(SearchCustomerField);
        CustomerPanel.add(SearchCustomerField.myList);
        CustomerPanel.add(SearchCustomerArea);
        CustomerPanel.add(ReturnLabelCus);
        CustomerPanel.add(ReturnButtonCus);
        CustomerPanel.add(CustomerBillJList);
        for (int i = 0; i < 2; i++) {
            CustomerPanel.add(CusLabels[i]);
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="PRODUCT PANEL">
        //                  PRODUCT PANEL
        ProductPanel = new JPanel();
        ProductPanel.setLayout(null);
        ProductPanel.setBounds(1280, 0, 1280, 720);
        ProductPanel.setOpaque(false);
        ProductPanel.setFocusable(true);
        
        ReturnButtonPro = new JButton("BACK");
        ReturnButtonPro.setFont(GetFuronsFont(40));
        ReturnButtonPro.setOpaque(false);
        ReturnButtonPro.setContentAreaFilled(false);
        ReturnButtonPro.setBorder(null);
        ReturnButtonPro.setForeground(Title.getForeground());
        ReturnButtonPro.setBounds(30, 800, 150, 70);
        ReturnLabelPro = new JLabel();
        ReturnLabelPro.setIcon(new ImageIcon(allImg[9].getScaledInstance(150, 70, Image.SCALE_SMOOTH)));
        ReturnLabelPro.setBounds(ReturnButtonPro.getBounds());
        
        ProductSearchField = new FilterSearchTextField("(None)");
        ProductSearchField.setHint("       INPUT HERE");
        ProductSearchField.setBounds(SearchCustomerField.getX(), SearchCustomerField.getY(), SearchCustomerField.getWidth(), 70);
        ProductSearchField.setFont(GetFuronsFont(SearchCustomerField.getFont().getSize() + 10));
        ProductSearchField.myList.setFont(SearchCustomerField.myList.getFont());
        ProductSearchField.addData(ProductNameSet);
        ProductSearchField.bindItem();
        
        SearchProductLabel = new JLabel("PRODUCT");
        SearchProductLabel.setForeground(Title.getForeground());
        SearchProductLabel.setFont(GetFuronsFont(50));
        
        SearchProductLabel.setBounds(ProductSearchField.getX() - 200, ProductSearchField.getY(), 200, ProductSearchField.getHeight());
        
        for (int i = 0; i < ProButton.length; i++) {
            ProButton[i] = new JButton();
            ProButton[i].setOpaque(false);
            ProButton[i].setBounds(ProductSearchField.getX() + ProductSearchField.getWidth(), ProductSearchField.getY() + (ProductSearchField.getHeight() + 32) * ((i + 1) % ProButton.length), 200, 70);
            ProButton[i].setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
            ProButton[i].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK));
            
            ProButtonLabel[i] = new JLabel();
            ProButtonLabel[i].setBounds(ProButton[i].getBounds());
            ProButtonLabel[i].setOpaque(false);
            ProButtonLabel[i].setFont(GetFuronsFont(i < 3 ? 45 : 15));
            ProButtonLabel[i].setHorizontalAlignment(JLabel.CENTER);
            ProButtonLabel[i].setForeground(Title.getForeground());
            if (i < 3) {
                ButtonEffect(ProButton[i], ProButtonLabel[i]);
            } else {
                ProductSearchButtonEffect(ProButton[i], ProButtonLabel[i], i - 3);
            }
        }
        ProButtonLabel[0].setText("ADD");
        ProButtonLabel[1].setText("Delete");
        ProButtonLabel[2].setText("Report");
        
        ProButton[3].setBounds(ProductSearchField.getX() + ProductSearchField.getWidth(), ProductSearchField.getY(), ProButton[0].getWidth(), ProductSearchField.getHeight() / 2);
        ProButtonLabel[3].setBounds(ProButton[3].getBounds());
        ProButtonLabel[3].setText("PRODUCT");
        ProButton[4].setBounds(ProductSearchField.getX() + ProductSearchField.getWidth(), ProductSearchField.getY() + ProButton[3].getHeight(), ProButton[0].getWidth(), ProductSearchField.getHeight() / 2);
        ProButtonLabel[4].setBounds(ProButton[4].getBounds());
        ProButtonLabel[4].setText("TYPE");
        
        ProButton[3].setIcon(new ImageIcon(allImg[5].getScaledInstance(ProButton[3].getWidth() + 100, ProButton[3].getHeight() + 80, Image.SCALE_SMOOTH)));
        ProButton[3].setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
        ProButtonLabel[3].setForeground(new Color(200, 60, 60));
        ProButtonLabel[3].setFont(GetFuronsFont(ProButtonLabel[3].getFont().getSize() + 10));
        
        ProButtonCLicked[0] = true;
        ProButtonCLicked[1] = false;

        // ----------------------------------- PRODUCT TABLE ----------------------------
        ProductTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new Object[]{
                    "TYPE", "NUMBER", "EXPIRY DATE", "PRICE PER UNIT"}
        )) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        
        ProductTable.getTableHeader().setForeground(KhachhangJTable.getTableHeader().getForeground());
        ProductTable.getTableHeader().setBackground(KhachhangJTable.getTableHeader().getBackground());
        ProductTable.getTableHeader().setFont(GetFuronsFont(20));
        
        ProductTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ProductTable.getColumnModel().getColumn(0).setMinWidth(200);
        ProductTable.getColumnModel().getColumn(1).setMinWidth(150);
        ProductTable.getColumnModel().getColumn(2).setMinWidth(130);
        ProductTable.getColumnModel().getColumn(3).setMinWidth(200);
        
        ProductTable.setFont(GetFuronsFont(20));
        ProductTable.setRowHeight(30);
        
        ProductScrollPane = new JScrollPane();
        ProductScrollPane.setViewportView(ProductTable);
        ProductScrollPane.setBounds(SearchProductLabel.getX(), ProductSearchField.getY() + ProductSearchField.getHeight() + 10, ProductSearchField.getWidth() + SearchProductLabel.getWidth(), 300);
        ProductScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ProductScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // ----------------------------------- PRODUCT NOTIFY TABLE ----------------------------
        NotifyDialogTable = new JTable(new DefaultTableModel(
                new Object[][]{},
                new Object[]{
                    "NAME", "TYPE", "NUMBER", "PRICE PER UNIT"}
        )) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        
        NotifyDialogTable.getTableHeader().setForeground(KhachhangJTable.getTableHeader().getForeground());
        NotifyDialogTable.getTableHeader().setBackground(KhachhangJTable.getTableHeader().getBackground());
        NotifyDialogTable.getTableHeader().setFont(GetFuronsFont(20));
        
        DefaultTableModel NotifyDialogTableModel = (DefaultTableModel) NotifyDialogTable.getModel();
        
        for (Integer i : ExpiredItemIndex) {
            Product temp = Data.Store.get(i);
            String allAtr = temp.getP_Name() + ";" + temp.getP_type() + ";" + temp.getP_Number() + ";" + temp.getOut_Price();
            String rowData[] = allAtr.split(";");
            NotifyDialogTableModel.addRow(rowData);
        }
        
        NotifyDialogTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        NotifyDialogTable.getColumnModel().getColumn(0).setMinWidth(200);
        NotifyDialogTable.getColumnModel().getColumn(1).setMinWidth(70);
        NotifyDialogTable.getColumnModel().getColumn(2).setMinWidth(130);
        NotifyDialogTable.getColumnModel().getColumn(3).setMinWidth(200);
        
        NotifyDialogTable.setFont(GetFuronsFont(20));
        NotifyDialogTable.setRowHeight(30);
        
        NotifyDialogJScrollPane = new JScrollPane();
        NotifyDialogJScrollPane.setViewportView(NotifyDialogTable);
        NotifyDialogJScrollPane.setSize(300, 400);
        NotifyDialogJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        NotifyDialogJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        NotifyDeleteButton = new JButton("REMOVE FROM THE LIST");
        NotifyDeleteButton.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        
        JLabel notify = new JLabel("Notice: The following item has expired");
        notify.setFont(new Font("TimesRoman", Font.BOLD, 30));
        
        JOptionPane Notify_Option_Pane = new JOptionPane(new JComponent[]{
            notify,
            NotifyDialogJScrollPane,
            NotifyDeleteButton
        }, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        
        Notify_Expired_Product_Dialog = new JDialog();
        Notify_Expired_Product_Dialog.setContentPane(Notify_Option_Pane);
        Notify_Expired_Product_Dialog.setBounds(600, 300, 700, 400);
        Notify_Expired_Product_Dialog.setFocusable(true);
        Notify_Expired_Product_Dialog.setModal(true);

        //                  ADD DIALOG
        Pro_Add_Button = new JButton("ADD");
        Pro_Add_Button.setSize(300, 100);
        
        for (int i = 0; i < Pro_Add_Field.length; i++) {
            Pro_Add_Field[i] = new FilterSearchTextField("(None)");
            Pro_Add_Field[i].setSize(300, 100);
            Pro_Add_Field[i].setFont(new Font("TimesRoman", Font.PLAIN, 20));
            if (i > 1) {
                Pro_Add_Field[i].setDisableFocusListener();
            }
        }
        
        Pro_Add_Field[0].setData(ProductNameSet);
        Pro_Add_Field[0].bindItem();
        
        Pro_Add_Field[1].setData(ProductTypeSet);
        Pro_Add_Field[1].bindItem();
        
        JOptionPane Pro_A_D = new JOptionPane(new JComponent[]{
            new JLabel("NAME"), Pro_Add_Field[0], Pro_Add_Field[0].myList,
            new JLabel("TYPE"), Pro_Add_Field[1], Pro_Add_Field[1].myList,
            new JLabel("NUMBER"), Pro_Add_Field[2],
            new JLabel("PRICE PER UNIT"), Pro_Add_Field[3],
            new JLabel("EXPIRY DATE"), Pro_Add_Field[4],
            Pro_Add_Button
        }, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        
        Product_Add_Dialog = new JDialog();
        Product_Add_Dialog.setContentPane(Pro_A_D);
        Product_Add_Dialog.setBounds(Notify_Expired_Product_Dialog.getBounds());
        Product_Add_Dialog.setFocusable(true);
        Product_Add_Dialog.setModal(true);

        //                  PRODUCT PANEL ADD ELEMENTS
        for (int i = 0; i < ProButton.length; i++) {
            ProductPanel.add(ProButtonLabel[i]);
            ProductPanel.add(ProButton[i]);
        }
        ProductPanel.add(ProductSearchField.myList);
        ProductPanel.add(ProductSearchField);
        ProductPanel.add(ReturnButtonPro);
        ProductPanel.add(ReturnLabelPro);
        ProductPanel.add(SearchProductLabel);
        ProductPanel.add(ProductScrollPane);

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="SELL PANEL">
        SellPanel = new JPanel();
        SellPanel.setBounds(0, 720, 1280, 720);
        SellPanel.setLayout(null);
        SellPanel.setOpaque(false);
        SellPanel.setFocusable(true);
        
        ReturnButtonSell = new JButton();
        ReturnButtonSell.setBounds(390, 20, 500, 150);
        ReturnButtonSell.setOpaque(false);
        ReturnButtonSell.setContentAreaFilled(false);
        ReturnButtonSell.setBorder(null);
        ReturnButtonSell.setVisible(false);
        
        SearchSellField = new FilterSearchTextField("(None)");
        SearchSellField.setBounds(500, 200, 500, 50);
        SearchSellField.addData(Phone_Number);
        SearchSellField.bindItem();
        SearchSellField.setFont(GetFuronsFont(30));
        
        SearchSellField.myList.setFont(GetFuronsFont(20));
        
        SearchSellArea = new JTextArea();
        SearchSellArea.setFont(SearchCustomerArea.getFont());
        SearchSellArea.setBounds(SearchSellField.getX(), SearchSellField.getY() + SearchSellField.getHeight() + 10, SearchSellField.getWidth(), SearchSellField.getHeight());
        SearchSellArea.setEditable(false);
        
        SellTable = new JTable(new DefaultTableModel(new Object[][]{},
                new Object[]{
                    "STT", "Ten", "So Luong", "Don gia", "Tong"
                })) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        
        SellTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        SellTable.getColumnModel().getColumn(0).setMinWidth(70);
        SellTable.getColumnModel().getColumn(1).setMinWidth(150);
        SellTable.getColumnModel().getColumn(2).setMinWidth(100);
        SellTable.getColumnModel().getColumn(3).setMinWidth(170);
        SellTable.getColumnModel().getColumn(4).setMinWidth(200);
        
        SellTable.getTableHeader().setFont(GetFuronsFont(25));
        SellTable.getTableHeader().setBackground(new Color(32, 136, 203));
        SellTable.getTableHeader().setForeground(new Color(255, 255, 255));
        
        SellTable.setFont(GetFuronsFont(20));
        SellTable.setRowHeight(30);
        
        SellScrollPane = new JScrollPane();
        SellScrollPane.setViewportView(SellTable);
        SellScrollPane.setBounds(SearchSellArea.getX() - 200, SearchSellArea.getY() + SearchSellArea.getHeight() + 10, SearchSellArea.getWidth() + 200, 210);
        SellScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SellScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        for (int i = 0; i < 2; i++) {
            SellLabel[i] = new JLabel();
            SellLabel[i].setForeground(Title.getForeground());
            SellLabel[i].setFont(GetFuronsFont(32));
        }
        SellLabel[0].setBounds(SellScrollPane.getX(), SearchSellField.getY(), SellScrollPane.getWidth() - SearchSellField.getWidth() - 10, SearchSellField.getHeight());
        SellLabel[1].setBounds(SellScrollPane.getX(), SearchSellArea.getY(), SellScrollPane.getWidth() - SearchSellField.getWidth() - 10, SearchSellField.getHeight());
        
        SellLabel[0].setText("So Dien Thoai");
        SellLabel[1].setText("Khach Hang");
        
        for (int i = 0; i < SellButton.length; i++) {
            SellButton[i] = new JButton();
            SellButton[i].setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
            SellButton[i].setContentAreaFilled(false);
            SellButton[i].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK));
            SellButton[i].setBounds(SellScrollPane.getX() + SellScrollPane.getWidth() + 5, SellScrollPane.getY() + (i % SellButton.length) * 75, 200, 70);
            
            SellButtonLabel[i] = new JLabel();
            SellButtonLabel[i].setFont(GetFuronsFont(40));
            SellButtonLabel[i].setHorizontalAlignment(JLabel.CENTER);
            SellButtonLabel[i].setForeground(new Color(160, 200, 210));
            SellButtonLabel[i].setBounds(SellButton[i].getBounds());
            
            ButtonEffect(SellButton[i], SellButtonLabel[i]);
        }
        SellButton[3].setLocation(SellScrollPane.getX() + (SellScrollPane.getWidth() / 2) - SellButton[3].getWidth() / 2, SellButton[3].getY());
        SellButtonLabel[3].setBounds(SellButton[3].getBounds());
        
        SellButtonLabel[0].setText("+");
        SellButtonLabel[1].setText("-");
        SellButtonLabel[2].setText("CLEAR");
        SellButtonLabel[3].setText("SELL");
        
        for (int i = 0; i < AddSellField.length; i++) {
            AddSellField[i] = new FilterSearchTextField("(None)");
            AddSellField[i].setHint("");
            AddSellField[i].setFont(GetFuronsFont(20));
            if (i >= 2) {
                AddSellField[i].setEditable(false);
            }
            if (i >= 1) {
                AddSellField[i].setDisableFocusListener();
            }
        }
        
        Dialog_OK_OPTION = new JButton("OK");
        Dialog_OK_OPTION.setSize(100, 30);
        
        JOptionPane optionPane = new JOptionPane(new JComponent[]{
            new JLabel("Product"), AddSellField[0],
            AddSellField[0].myList,
            new JLabel("Number"), AddSellField[1],
            AddSellField[1].myList,
            new JLabel("Type"), AddSellField[2],
            new JLabel("Price Per Unit"), AddSellField[3],
            new JLabel("Total"), AddSellField[4],
            Dialog_OK_OPTION
        }, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        
        AddSellDialog = new JDialog();
        AddSellDialog.setContentPane(optionPane);
        AddSellDialog.setBounds(600, 300, 700, 400);
        AddSellDialog.setFocusable(true);
        AddSellDialog.setModal(true);

        //                  SELL PANEL ADD ELEMENTS
        SellPanel.add(SearchSellField.myList);
        SellPanel.add(SearchSellField);
        SellPanel.add(SearchSellArea);
        SellPanel.add(SellScrollPane);
        for (int i = 0; i < SellButton.length; i++) {
            SellPanel.add(SellButtonLabel[i]);
            SellPanel.add(SellButton[i]);
        }
        
        for (int i = 0; i < 2; i++) {
            SellPanel.add(SellLabel[i]);
        }

        //</editor-fold>
        //                  MAIN FRAME ADD ELEMENTS
        mainFrame.add(CloseButton);
        mainFrame.add(CloseBackgroundButton);
        mainFrame.add(ReturnButtonSell);
        mainFrame.add(Title);
        mainFrame.add(TitleBackground);
        mainFrame.add(CoordinateArea);
        mainFrame.add(CustomerPanel);
        mainFrame.add(ProductPanel);
        mainFrame.add(SellPanel);
        mainFrame.add(MenuPanel);
        mainFrame.add(StartJLabel);
        mainFrame.add(mainFrame.BackgroundDecorate01);
        mainFrame.add(mainFrame.BackgroundContainer);
        mainFrame.add(mainFrame.StartButton);
    }
    
    private void prepareData() {
        Date today = new Date();
        
        Data = new Application();
        Data.readCustomer();
        Data.readProduct();
        Data.readBill();
        
        ProductNameSet = new HashSet<>();
        ProductTypeSet = new HashSet<>();
        Product_Total = new ArrayList<>();
        Phone_Number = new HashSet<>();
        ExpiredItemIndex = new HashSet<>();
        
        for (int i = 0; i < Data.Custom.size(); i++) {
            Phone_Number.add(Data.Custom.get(i).getSTD());
        }
        
        for (int i = 0; i < Data.Store.size(); i++) {
            ProductNameSet.add(Data.Store.get(i).getP_Name());
            ProductTypeSet.add(Data.Store.get(i).getP_type());
        }
        
        for (int i = 0; i < Data.Store.size(); i++) {
            if (today.after(Data.Store.get(i).getHSD())) {
                ExpiredItemIndex.add(i);
            }
        }
        
    }
    
    private void updateData() {
        Date today = new Date();
        
        ProductNameSet.clear();
        ProductTypeSet.clear();
        Phone_Number.clear();
        ExpiredItemIndex.clear();
        
        for (int i = 0; i < Data.Custom.size(); i++) {
            Phone_Number.add(Data.Custom.get(i).getSTD());
        }
        
        for (int i = 0; i < Data.Store.size(); i++) {
            ProductNameSet.add(Data.Store.get(i).getP_Name());
            ProductTypeSet.add(Data.Store.get(i).getP_type());
        }
        
        for (int i = 0; i < Data.Store.size(); i++) {
            if (today.after(Data.Store.get(i).getHSD())) {
                ExpiredItemIndex.add(i);
            }
        }
        
        SearchCustomerField.setData(Phone_Number);
        SearchCustomerField.bindItem();
        
        ProductSearchField.setData(ProductNameSet);
        ProductSearchField.bindItem();
        
        Pro_Add_Field[0].setData(ProductNameSet);
        Pro_Add_Field[0].bindItem();
        
        Pro_Add_Field[1].setData(ProductTypeSet);
        Pro_Add_Field[1].bindItem();
        
        AddSellField[0].setData(ProductNameSet);
        AddSellField[0].bindItem();
        
        AddSellField[1].setData(ProductTypeSet);
        AddSellField[1].bindItem();
        
        SearchSellField.setData(Phone_Number);
        SearchSellField.bindItem();
        
        DefaultTableModel HangHoaModel = (DefaultTableModel) HangHoaJTable.getModel();
        HangHoaModel.setRowCount(0);
        
        for (String P_NAME : ProductNameSet) {
            int count = 0;
            Date near_expire = new Date();
            for (int i = 0; i < Data.Store.size(); i++) {
                if (P_NAME.compareToIgnoreCase(Data.Store.get(i).getP_Name()) == 0 && today.before(Data.Store.get(i).getHSD()) || today.equals(Data.Store.get(i).getHSD())) {
                    count += Data.Store.get(i).getP_Number();
                    if (near_expire.equals(today) || near_expire.after(Data.Store.get(i).getHSD())) {
                        near_expire = Data.Store.get(i).getHSD();
                    }
                }
            }
            Product_Total.add(count);
            for (Product i : Data.Store) {
                if (P_NAME.compareTo(i.getP_Name()) == 0 && count > 0) {
                    String d = new SimpleDateFormat("dd/MM/yyyy").format(near_expire);
                    String allAtr = P_NAME + ";" + i.getP_type() + ";" + count + ";" + i.getOut_Price() + ";" + d;
                    String rowData[] = allAtr.split(";");
                    HangHoaModel.addRow(rowData);
                    break;
                }
            }
        }
        
        DefaultTableModel NotifyDialogModel = (DefaultTableModel) NotifyDialogTable.getModel();
        NotifyDialogModel.setRowCount(0);
        
        for (Integer i : ExpiredItemIndex) {
            Product temp = Data.Store.get(i);
            String allAtr = temp.getP_Name() + ";" + temp.getP_type() + ";" + temp.getP_Number() + ";" + temp.getOut_Price();
            String rowData[] = allAtr.split(";");
            NotifyDialogModel.addRow(rowData);
        }
        
        DefaultTableModel KhachHangModel = (DefaultTableModel) KhachhangJTable.getModel();
        KhachHangModel.setRowCount(0);
        
        for (Customer i : Data.Custom) {
            if (i.getC_Name().compareToIgnoreCase("Default") != 0) {
                String allAtr = i.getC_Name() + ";" + i.getSTD() + ";" + i.getC_Point();
                String rowData[] = allAtr.split(";");
                KhachHangModel.addRow(rowData);
            }
        }
        
        DefaultListModel listModel = new DefaultListModel();
        
        for (Bill i : Data.Bill) {
            listModel.addElement(new SimpleDateFormat("dd/MM/yyyy").format(i.getBillOutDate()));
        }
        CustomerBillJList.setModel(listModel);
        
    }
    
    public void ProgramStart() {
        
        Timer FlashTimer = new Timer();
        FlashTimer.schedule(FlashComponent(StartJLabel), 0, 500);
        
        CloseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                CloseBackgroundButton.setBounds(1080 + 2, 580 + 37, 150 - 2, 100 - 42);
                CloseButton.setIcon(new ImageIcon(allImg[21].getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                CloseBackgroundButton.setBackground(Color.red);
                mainFrame.repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                CloseBackgroundButton.setBounds(1080 + 2, 580 + 37, 150 - 2, 100 - 42);
                CloseButton.setIcon(new ImageIcon(allImg[21].getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                CloseBackgroundButton.setBackground(Color.WHITE);
                mainFrame.repaint();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                CloseButton.setIcon(new ImageIcon(allImg[22].getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
                CloseBackgroundButton.setBounds(CloseBackgroundButton.getX(), CloseBackgroundButton.getY() + 10, CloseBackgroundButton.getWidth(), CloseBackgroundButton.getHeight() - 10);
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                CloseBackgroundButton.setBounds(1080 + 2, 580 + 37, 150 - 2, 100 - 42);
                CloseButton.setIcon(new ImageIcon(allImg[21].getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
            }
            
        });
        CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Closed = true;
                
                Data.saveBill();
                Data.saveCustomer();
                Data.saveProduct();
                
                mainFrame.setVisible(false);
                mainFrame.dispose();
                try {
                    new Login().Start();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mainFrame.StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.StartButton.setVisible(false);
                StartJLabel.setVisible(false);
                FlashTimer.schedule(FlashComponent(StartJLabel), 0, 50);
                FlashTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        StartJLabel.setVisible(false);
                        FlashTimer.cancel();
                    }
                }, 700, 50);
                
                Timer timer = new Timer();
                
                timer.schedule(moveComponentTopToBottom(Title, -70, 5), 700, 5);
                timer.schedule(moveComponentTopToBottom(TitleBackground, -70, 5), 700, 5);
                timer.schedule(moveComponentTopToBottom(Title, -200, 5), 1200, 5);
                timer.schedule(moveComponentTopToBottom(TitleBackground, -200, 5), 1200, 5);
                timer.schedule(moveComponentTopToBottom(Title, 20, 5), 1700, 5);
                timer.schedule(moveComponentTopToBottom(TitleBackground, 20, 5), 1700, 5);
                
                timer.schedule(FlashComponent(Title), 2000, 15);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setVisible(true);
                        timer.cancel();
                    }
                }, 2300, 5);
                
                timer.schedule(moveComponentLeftToRight(KhachhangScrollPane, 70, 13), 1000, 5);
                timer.schedule(moveComponentRightToLeft(HangHoaScrollPane, 700, 13), 1000, 5);
                
                timer.schedule(moveComponentLeftToRight(MenuButtons[0], 200, 7), 1500, 5);
                timer.schedule(moveComponentLeftToRight(MenuButtonLabel[0], 200, 7), 1500, 5);
                timer.schedule(moveComponentBottomToTop(MenuButtons[2], 530, 7), 1600, 10);
                timer.schedule(moveComponentBottomToTop(MenuButtonLabel[2], 530, 7), 1600, 10);
                timer.schedule(moveComponentRightToLeft(MenuButtons[1], 830, 8), 1700, 5);
                timer.schedule(moveComponentRightToLeft(MenuButtonLabel[1], 830, 8), 1700, 5);
                
                timer.schedule(moveComponentTopToBottom(mainFrame.BackgroundDecorate01, -100, 7), 1000, 5);
                timer.schedule(moveComponentTopToBottom(mainFrame.BackgroundDecorate01, -120, 7), 1300, 5);
                timer.schedule(moveComponentTopToBottom(mainFrame.BackgroundDecorate01, -70, 7), 1600, 5);
                timer.schedule(moveComponentTopToBottom(mainFrame.BackgroundDecorate01, 30, 7), 1900, 5);
                
            }
        });
        
        mainFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                CoordinateArea.setText("X = " + e.getX() + "\nY = " + e.getY());
            }
        });
        
        MenuButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer();
                timer.schedule(moveComponentBottomToTop(ReturnButtonCus, 570, 5), 500, 5);
                timer.schedule(moveComponentBottomToTop(ReturnLabelCus, 570, 5), 500, 5);
                timer.schedule(moveComponentLeftToRight(MenuPanel, 1280, 20), 0, 1);
                timer.schedule(moveComponentLeftToRight(CustomerPanel, 0, 20), 0, 1);
                timer.schedule(FlashComponent(Title), 0, 10);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setText("CUSTOMER MANAGEMENT");
                    }
                }, 500, 1);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setVisible(true);
                        timer.cancel();
                    }
                }, 1000, 1);
            }
        });
        MenuButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer();
                timer.schedule(moveComponentBottomToTop(ReturnButtonPro, 570, 5), 500, 5);
                timer.schedule(moveComponentBottomToTop(ReturnLabelPro, 570, 5), 500, 5);
                timer.schedule(moveComponentRightToLeft(MenuPanel, -1280, 20), 10, 1);
                timer.schedule(moveComponentRightToLeft(ProductPanel, 0, 20), 10, 1);
                timer.schedule(FlashComponent(Title), 0, 10);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setText("PRODUCT MANAGEMENT");
                    }
                }, 500, 1);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setVisible(true);
                        timer.cancel();
                    }
                }, 1000, 1);
                
                if (ExpiredItemIndex.size() > 0) {
                    Timer timer2 = new Timer();
                    timer2.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Notify_Expired_Product_Dialog.setVisible(true);
                            timer2.cancel();
                        }
                    }, 1010, 1);
                }
            }
        });
        MenuButtons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer();
                timer.schedule(moveComponentBottomToTop(MenuPanel, -720, 30), 100, 5);
                timer.schedule(moveComponentBottomToTop(SellPanel, 0, 30), 100, 5);
                timer.schedule(FlashComponent(Title), 0, 10);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setText("BACK TO MENU");
                    }
                }, 500, 1);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ReturnButtonSell.setVisible(true);
                        Title.setVisible(true);
                        timer.cancel();
                    }
                }, 1000, 1);
            }
        });
        
        CustomerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CustomerPanel.grabFocus();
            }
        });
        SellPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SellPanel.grabFocus();
            }
        });
        ProductPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ProductPanel.grabFocus();
            }
        });
        AddSellDialog.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddSellDialog.requestFocus();
            }
            
        });
        Product_Add_Dialog.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Product_Add_Dialog.requestFocus();
            }
            
        });
        
        ReturnButtonCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer();
                timer.schedule(moveComponentTopToBottom(ReturnButtonCus, 800, 10), 0, 5);
                timer.schedule(moveComponentTopToBottom(ReturnLabelCus, 800, 10), 0, 5);
                timer.schedule(moveComponentRightToLeft(MenuPanel, 0, 40), 100, 5);
                timer.schedule(moveComponentRightToLeft(CustomerPanel, -1280, 40), 100, 5);
                timer.schedule(FlashComponent(Title), 0, 10);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setVisible(true);
                        Title.setText("Grocery Store Management");
                    }
                }, 500, 1);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        timer.cancel();
                    }
                }, 1000, 1);
            }
        });
        ReturnButtonPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer();
                timer.schedule(moveComponentTopToBottom(ReturnButtonPro, 800, 10), 0, 5);
                timer.schedule(moveComponentTopToBottom(ReturnLabelPro, 800, 10), 0, 5);
                timer.schedule(moveComponentLeftToRight(MenuPanel, 0, 40), 100, 5);
                timer.schedule(moveComponentLeftToRight(ProductPanel, 1280, 40), 100, 5);
                timer.schedule(FlashComponent(Title), 0, 10);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setVisible(true);
                        Title.setText("Grocery Store Management");
                    }
                }, 500, 1);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        timer.cancel();
                    }
                }, 1000, 1);
            }
        });
        ReturnButtonSell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ReturnButtonSell.setVisible(false);
                    }
                }, 0, 1);
                timer.schedule(moveComponentTopToBottom(MenuPanel, 0, 30), 100, 5);
                timer.schedule(moveComponentTopToBottom(SellPanel, 720, 30), 100, 5);
                timer.schedule(FlashComponent(Title), 0, 10);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ReturnButtonCus.setVisible(true);
                        Title.setText("Grocery Store Management");
                    }
                }, 500, 1);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Title.setVisible(true);
                        timer.cancel();
                    }
                }, 1000, 1);
            }
        });
        
        CreateActionListenerForSearchProButton(3);
        CreateActionListenerForSearchProButton(4);
        
        ProButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product_Add_Dialog.setVisible(true);
            }
        });
        
        ProductSearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String SearchTerm = ProductSearchField.getText();
                DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
                model.setRowCount(0);
                for (Product i : Data.Store) {
                    if (i.getP_Name().toLowerCase().contains(SearchTerm.toLowerCase()) || i.getP_type().toLowerCase().contains(SearchTerm.toLowerCase())) {
                        String allAtr = "";
                        if (ProButtonCLicked[0]) {
                            allAtr = i.getP_type();
                        } else if (ProButtonCLicked[1]) {
                            allAtr = i.getP_Name();
                        }
                        String hsd = new SimpleDateFormat("dd/MM/yyyy").format(i.getHSD());
                        allAtr = allAtr + ";" + i.getP_Number() + ";" + hsd + ";" + i.getOut_Price();
                        String rowData[] = allAtr.split(";");
                        model.addRow(rowData);
                    }
                }
            }
            
        });
        
        SellButton[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> P_DATA = new ArrayList<>();
                for (Product i : Data.Store) {
                    boolean Item_Exist = false;
                    for (int j = 0; j < P_DATA.size(); j++) {
                        if (P_DATA.get(j).compareToIgnoreCase(i.getP_Name()) == 0) {
                            Item_Exist = true;
                        }
                    }
                    if (!Item_Exist) {
                        P_DATA.add(i.getP_Name());
                    }
                }
                AddSellField[0].setData(P_DATA);
                AddSellField[0].bindItem();
                
                AddSellDialog.setVisible(true);
            }
        });
        SellButton[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) SellTable.getModel();
                if (model.getRowCount() > 0) {
                    model.setRowCount(model.getRowCount() - 1);
                }
            }
        });
        SellButton[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) SellTable.getModel();
                model.setRowCount(0);
            }
        });
        SellButton[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean has_Customer = false;
                    Customer temp = new Customer();
                    Set<String> Buy_Product = new LinkedHashSet<>();
                    ArrayList<Integer> Product_SUM = new ArrayList<>();
                    String Buy_Customer = SearchSellField.getText();
                    DefaultTableModel model = (DefaultTableModel) SellTable.getModel();
                    for (int i = 0; i < model.getRowCount(); i++) {
                        Buy_Product.add(model.getValueAt(i, 1).toString());
                    }
                    
                    for (String i : Buy_Product) {
                        int count = 0;
                        for (int j = 0; j < model.getRowCount(); j++) {
                            if (i.compareToIgnoreCase(model.getValueAt(j, 1).toString()) == 0) {
                                count += Integer.parseInt(model.getValueAt(j, 2).toString());
                            }
                        }
                        Product_SUM.add(count);
                    }
                    
                    for (int i = 0; i < Data.Custom.size(); i++) {
                        if (Buy_Customer.compareToIgnoreCase(Data.Custom.get(i).getSTD()) == 0) {
                            Customer t = Data.Custom.get(i);
                            temp.setName(t.getC_Name());
                            temp.setPoint(t.getC_Point());
                            temp.setSTD(t.getSTD());
                            
                            has_Customer = true;
                            break;
                        }
                    }
                    if (has_Customer) {
                        if (Buy_Product.size() > 0) {
                            Data.Bill.add(Data.exportBill(temp, Buy_Product, Product_SUM));
                            JOptionPane.showMessageDialog(null, "Sell Successfull", "Notice!", JOptionPane.INFORMATION_MESSAGE);
                            updateData();
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR: The Sell list can't be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR: Phone number not found", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An Error has occured", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Dialog_OK_OPTION.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Choosing_Item = AddSellField[0].getText();
                    int number_Of_this_item_On_The_List = 0;
                    int number_Of_this_item_available = 0;
                    int number = Integer.parseInt(AddSellField[1].getText());
                    
                    boolean Item_Not_Exist = true;
                    boolean Number_NA = true;
                    
                    DefaultTableModel model = (DefaultTableModel) SellTable.getModel();
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (model.getValueAt(i, 1).toString().compareToIgnoreCase(Choosing_Item) == 0) {
                            number_Of_this_item_On_The_List += Integer.parseInt(model.getValueAt(i, 2).toString());
                        }
                    }
                    for (Product i : Data.Store) {
                        if (i.getP_Name().compareToIgnoreCase(Choosing_Item) == 0) {
                            number_Of_this_item_available += i.getP_Number();
                            Item_Not_Exist = false;
                        }
                        if (number <= number_Of_this_item_available - number_Of_this_item_On_The_List) {
                            Number_NA = false;
                        }
                        
                        if (!Item_Not_Exist && !Number_NA) {
                            break;
                        }
                    }
                    if (Item_Not_Exist || Number_NA) {
                        JOptionPane.showMessageDialog(null, "Error:\nItem not exist or number is exceeding the number which has in store", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } else {
                        AddSellDialog.setVisible(false);
                        String t = (model.getRowCount() + 1) + ";" + Choosing_Item + ";" + number + ";" + AddSellField[3].getText() + ";" + AddSellField[4].getText();
                        String rowData[] = t.split(";");
                        
                        model.addRow(rowData);
                        SellTable.setModel(model);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An Error has Occured!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
        SearchCustomerField.myList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String choice = SearchCustomerField.myList.getSelectedValue().toString();
                if (choice.compareToIgnoreCase("Add new customer") != 0) {
                    SearchCustomerField.setText(SearchCustomerField.myList.getSelectedValue().toString());
                    SearchCustomerField.myList.setVisible(false);
                    for (Customer i : Data.Custom) {
                        if (choice.compareToIgnoreCase(i.getSTD()) == 0) {
                            SearchCustomerArea.setText(i.getC_Name());
                            break;
                        }
                        
                    }
                    DefaultListModel listModel = new DefaultListModel();
                    
                    for (Bill i : Data.Bill) {
                        if (i.getBuyCustomer().getSTD().compareToIgnoreCase(choice) == 0) {
                            listModel.addElement(new SimpleDateFormat("dd/MM/yyyy").format(i.getBillOutDate()));
                        }
                    }
                    CustomerBillJList.setModel(listModel);
                    
                    SearchCustomerArea.grabFocus();
                } else {
                    boolean Input_Error = false;
                    do {
                        AddCustomerField[0].setText(SearchCustomerField.getText());
                        AddCustomerField[1].setText("");
                        int result = JOptionPane.showConfirmDialog(null, new JComponent[]{
                            new JLabel("Phone number"),
                            AddCustomerField[0],
                            new JLabel("Customer's name"),
                            AddCustomerField[1]
                        },
                                "Add new Costumer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (result == JOptionPane.OK_OPTION) {
                            boolean Ok = true;
                            for (int i = 0; i < 2; i++) {
                                if (AddCustomerField[i].getText().isEmpty()) {
                                    Ok = false;
                                    Input_Error = true;
                                    JOptionPane.showMessageDialog(null, "Please input all requirement cells", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (Ok) {
                                Customer temp = new Customer();
                                temp.setName(AddCustomerField[1].getText());
                                temp.setSTD(AddCustomerField[0].getText());
                                temp.setPoint(0);
                                Data.Custom.add(temp);
                                updateData();
                            }
                        } else {
                            Input_Error = false;
                        }
                    } while (Input_Error);
                }
            }
        });
        
        NotifyDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date today = new Date();
                int delete = 0;
                for (Integer i : ExpiredItemIndex) {
                    Data.Store.remove(i - delete);
                    delete++;
                }
                JOptionPane.showMessageDialog(null, "Remove successfully", "NOTICE!", JOptionPane.INFORMATION_MESSAGE);
                Notify_Expired_Product_Dialog.setVisible(false);
                updateData();
            }
        });
        ProductSearchField.myList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                DefaultTableModel ProductModel = (DefaultTableModel) ProductTable.getModel();
                ProductModel.setRowCount(0);
                
                String choice = ProductSearchField.myList.getSelectedValue().toString();
                if (choice.compareToIgnoreCase(ProductSearchField.getOption()) != 0) {
                    ProductSearchField.setText(choice);
                    for (Product i : Data.Store) {
                        if (ProButtonCLicked[0] && choice.compareToIgnoreCase(i.getP_Name()) == 0) {
                            String HSD = new SimpleDateFormat("dd/MM/yyyy").format(i.getHSD());
                            String AllAtr = i.getP_type() + ";" + i.getP_Number() + ";" + HSD + ";" + i.getOut_Price();
                            String rowData[] = AllAtr.split(";");
                            ProductModel.addRow(rowData);
                            
                            ProductPanel.grabFocus();
                        } else if (ProButtonCLicked[1] && choice.compareToIgnoreCase(i.getP_type()) == 0) {
                            String HSD = new SimpleDateFormat("dd/MM/yyyy").format(i.getHSD());
                            String AllAtr = i.getP_Name() + ";" + i.getP_Number() + ";" + HSD + ";" + i.getOut_Price();
                            String rowData[] = AllAtr.split(";");
                            ProductModel.addRow(rowData);
                            
                            ProductPanel.grabFocus();
                        }
                    }
                    ProductTable.setModel(ProductModel);
                } else {
                    ProductSearchField.setText("");
                    ProductPanel.grabFocus();
                }
            }
            
        });
        Pro_Add_Field[0].myList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String choice = Pro_Add_Field[0].myList.getSelectedValue().toString();
                if (choice.compareToIgnoreCase(Pro_Add_Field[0].getOption()) != 0) {
                    Pro_Add_Field[0].setText(choice);
                } else {
                    Pro_Add_Field[0].setText("");
                }
                Pro_Add_Field[1].grabFocus();
            }
        });
        Pro_Add_Field[1].myList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String choice = Pro_Add_Field[1].myList.getSelectedValue().toString();
                if (choice.compareToIgnoreCase(Pro_Add_Field[1].getOption()) != 0) {
                    Pro_Add_Field[1].setText(choice);
                } else {
                    Pro_Add_Field[1].setText("");
                }
                Pro_Add_Field[2].grabFocus();
            }
            
        });
        Pro_Add_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    Product temp = new Product();
                    temp.setP_Name(Pro_Add_Field[0].getText());
                    temp.setP_type(Pro_Add_Field[1].getText());
                    temp.setP_Number(Integer.parseInt(Pro_Add_Field[2].getText()));
                    temp.setOut_Price(Double.parseDouble(Pro_Add_Field[3].getText()));
                    temp.setHSD(new SimpleDateFormat("dd/MM/yyyy").parse(Pro_Add_Field[4].getText()));
                    Data.addProduct(temp);
                    Product_Add_Dialog.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Add successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    for (int i = 0; i < 5; i++) {
                        Pro_Add_Field[i].setText("");
                    }
                    updateData();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: Please check Number and Price per Unit again!\n They can't have words in it or leave it empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: Please check date Format again\n (dd/mm/yyyy)", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR: An error has occured, Please try again!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        SearchSellField.myList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String choice = SearchSellField.myList.getSelectedValue().toString();
                if (choice.compareToIgnoreCase("(None)") != 0) {
                    SearchSellField.setText(SearchSellField.myList.getSelectedValue().toString());
                    
                    for (Customer i : Data.Custom) {
                        if (choice.compareToIgnoreCase(i.getSTD()) == 0) {
                            SearchSellArea.setText(i.getC_Name());
                            break;
                        }
                    }
                    
                } else {
                    SearchSellField.setText("");
                }
                SellPanel.grabFocus();
                SearchSellField.myList.setVisible(false);
            }
        });
        AddSellField[0].myList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String choice = AddSellField[0].myList.getSelectedValue().toString();
                if (choice.compareToIgnoreCase(AddSellField[0].getOption()) != 0) {
                    AddSellField[0].setText(choice);
                    for (Product i : Data.Store) {
                        if (i.getP_Name().compareToIgnoreCase(choice) == 0) {
                            AddSellField[2].setText(i.getP_type());
                            AddSellField[3].setText(String.valueOf(i.getOut_Price()));
                            AddSellField[4].setText(i.getOut_Price() + "");
                            break;
                        }
                    }
                }
                AddSellField[1].grabFocus();
            }
            
        });
        AddSellField[1].addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    int number = Integer.parseInt(AddSellField[1].getText());
                    AddSellField[4].setText((Double.parseDouble(AddSellField[3].getText()) * (double) number) + "");
                } catch (Exception ex) {
                    AddSellField[4].setText("N/A");
                }
            }
            
        });
        
        mainFrame.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="Animation">
    public void ButtonEffect(JButton button, JLabel label) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            //70, 150, 90
            public void mouseEntered(MouseEvent e) {
                button.setBorder(new CompoundBorder(
                        BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
                        BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 1, Color.BLACK));
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                button.setIcon(new ImageIcon(allImg[5].getScaledInstance(button.getWidth() + 100, button.getHeight() + 80, Image.SCALE_SMOOTH)));
                button.setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
                label.setForeground(new Color(200, 60, 60));
                try {
                    label.setFont(GetFuronsFont(label.getFont().getSize() + 10));
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                button.setIcon(new ImageIcon(allImg[4].getScaledInstance(button.getWidth() + 100, button.getHeight() + 30, Image.SCALE_SMOOTH)));
                button.setBorder(new CompoundBorder(
                        BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
                        BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
                label.setForeground(new Color(160, 200, 210));
                try {
                    label.setFont(GetFuronsFont(label.getFont().getSize() - 10));
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    public void ProductSearchButtonEffect(JButton button, JLabel label, int i) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            //70, 150, 90
            public void mouseEntered(MouseEvent e) {
                if (!ProButtonCLicked[i]) {
                    button.setBorder(new CompoundBorder(
                            BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
                            BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!ProButtonCLicked[i]) {
                    button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 1, Color.BLACK));
                }
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                if (!ProButtonCLicked[i]) {
                    button.setIcon(new ImageIcon(allImg[5].getScaledInstance(button.getWidth() + 100, button.getHeight() + 80, Image.SCALE_SMOOTH)));
                    button.setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
                    label.setForeground(new Color(200, 60, 60));
                }
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!ProButtonCLicked[i]) {
                    button.setIcon(new ImageIcon(allImg[4].getScaledInstance(button.getWidth() + 100, button.getHeight() + 30, Image.SCALE_SMOOTH)));
                    button.setBorder(new CompoundBorder(
                            BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
                            BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
                    label.setForeground(new Color(160, 200, 210));
                }
            }
        });
    }
    
    public void StartButtonEffect() {
        mainFrame.StartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mainFrame.StartButton.setBorder(BorderFactory.createLineBorder(new Color(70, 150, 90), 3));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                mainFrame.StartButton.setBorder(null);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                mainFrame.StartButton.setIcon(new ImageIcon(allImg[5].getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
                mainFrame.StartButton.setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
                StartJLabel.setForeground(new Color(200, 60, 60));
                try {
                    StartJLabel.setVisible(true);
                    StartJLabel.setFont(GetFuronsFont(55));
                    StartJLabel.setLocation(StartJLabel.getX() + 20, StartJLabel.getY());
                    
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                mainFrame.StartButton.setIcon(new ImageIcon(allImg[4].getScaledInstance(300, 100, Image.SCALE_SMOOTH)));
                mainFrame.StartButton.setBorder(BorderFactory.createLineBorder(new Color(70, 150, 90), 3));
                StartJLabel.setForeground(new Color(50, 200, 210));
                try {
                    StartJLabel.setFont(GetFuronsFont(60));
                    StartJLabel.setLocation(StartJLabel.getX() - 20, StartJLabel.getY());
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public TimerTask moveComponentRightToLeft(Component o, int location, int speed) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (o.getX() > location) {
                    o.setLocation(o.getX() - speed, o.getY());
                }
            }
        };
        return tt;
    }
    
    public TimerTask moveComponentLeftToRight(Component o, int location, int speed) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (o.getX() < location) {
                    o.setLocation(o.getX() + speed, o.getY());
                }
            }
        };
        return tt;
    }
    
    public TimerTask moveComponentTopToBottom(Component o, int location, int speed) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (o.getY() < location) {
                    o.setLocation(o.getX(), o.getY() + speed);
                }
            }
        };
        return tt;
    }
    
    public TimerTask moveComponentBottomToTop(Component o, int location, int speed) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if (o.getY() > location) {
                    o.setLocation(o.getX(), o.getY() - speed);
                }
            }
        };
        return tt;
    }
    
    public TimerTask FlashComponent(Component o) {
        
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                o.setVisible(!o.isVisible());
            }
        };
        return tt;
    }

    //</editor-fold>
    public Font GetFuronsFont(int Size) throws FontFormatException, IOException {
        File font_file = new File("src\\grocerystoremanagement\\futronsFont\\FutronsDemo.ttf");
        Font FutronsFont = Font.createFont(Font.TRUETYPE_FONT, font_file);
        Font sizedFont = FutronsFont.deriveFont((float) Size);
        return sizedFont;
    }
    
    public boolean getMainFrameStatus() {
        return Closed;
    }
    
    public void CreateActionListenerForSearchProButton(int i) {
        ProButton[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!ProButtonCLicked[i - 3]) {
                    Timer timer = new Timer();
                    timer.schedule(FlashComponent(SearchProductLabel), 0, 10);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            SearchProductLabel.setVisible(true);
                            if (i - 3 == 0) {
                                ProductTable.getColumnModel().getColumn(0).setHeaderValue("TYPE");
                                DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
                                model.setRowCount(0);
                                ProductTable.setModel(model);
                                ProductSearchField.setText("");
                                ProductSearchField.setData(ProductNameSet);
                                ProductSearchField.bindItem();
                                //
                                //              BIND ITEM HERE
                                //
                                ProductScrollPane.setViewportView(ProductTable);
                                SearchProductLabel.setText("PRODUCT");
                            } else {
                                ProductTable.getColumnModel().getColumn(0).setHeaderValue("PRODUCT");
                                DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
                                model.setRowCount(0);
                                ProductTable.setModel(model);
                                ProductSearchField.setText("");
                                ProductSearchField.setData(ProductTypeSet);
                                ProductSearchField.bindItem();
                                //
                                //              BIND ITEM HERE
                                //
                                ProductScrollPane.setViewportView(ProductTable);
                                
                                SearchProductLabel.setText("TYPE");
                            }
                            timer.cancel();
                        }
                    }, 500, 1);
                    
                    for (int j = 3; j < 5; j++) {
                        if (!ProButtonCLicked[j - 3]) {
                            ProButton[j].setIcon(new ImageIcon(allImg[5].getScaledInstance(ProButton[j].getWidth() + 100, ProButton[j].getHeight() + 80, Image.SCALE_SMOOTH)));
                            ProButton[j].setBorder(BorderFactory.createLineBorder(new Color(200, 60, 60), 3));
                            ProButtonLabel[j].setForeground(new Color(200, 60, 60));
                            
                            try {
                                ProButtonLabel[j].setFont(GetFuronsFont(ProButtonLabel[j].getFont().getSize() + 10));
                            } catch (FontFormatException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            ProButton[j].setIcon(new ImageIcon(allImg[4].getScaledInstance(ProButton[j].getWidth() + 100, ProButton[j].getHeight() + 30, Image.SCALE_SMOOTH)));
                            ProButton[j].setBorder(new CompoundBorder(
                                    BorderFactory.createMatteBorder(3, 3, 0, 0, new Color(70, 150, 90)),
                                    BorderFactory.createMatteBorder(0, 0, 4, 2, Color.BLACK)));
                            ProButtonLabel[j].setForeground(new Color(160, 200, 210));
                            
                            try {
                                ProButtonLabel[j].setFont(GetFuronsFont(ProButtonLabel[j].getFont().getSize() - 10));
                            } catch (FontFormatException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        ProButtonCLicked[j - 3] = !ProButtonCLicked[j - 3];
                    }
                }
            }
        });
    }
}
