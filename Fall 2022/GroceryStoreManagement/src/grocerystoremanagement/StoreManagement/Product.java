package grocerystoremanagement.StoreManagement;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.lang.StringBuffer;

public class Product {

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Scanner sc = new Scanner(System.in);
    // ArrayList<Product> MyStore = new ArrayList<>();
    private String P_Name;
    private String P_type;
    private int P_Number;
    // private Date Date_in;
    private Date HSD;
    // private Date NSX;
    private double Sum_Cost;
    private double Out_Price;
    private double One_PCost;

    public String getP_Name() {
        return this.P_Name;
    }

    public int getP_Number() {
        return this.P_Number;
    }

    public String getP_type() {
        return this.P_type;
    }

    // public Date getDate_in() {
    // return this.Date_in;
    // }
    public Date getHSD() {
        return this.HSD;
    }

    // public Date getNSX() {
    // return this.NSX;
    // }
    public double getSum_Cost() {
        return this.Sum_Cost;
    }

    public double getOut_Price() {
        return this.Out_Price;
    }

    public double getOne_PCost() {
        return this.One_PCost;
    }

    public void setP_Name(String P_Name) {
        this.P_Name = P_Name;
    }

    public void setP_Number(int P_Number) {
        this.P_Number = P_Number;
    }

    public void setP_type(String P_type) {
        this.P_type = P_type;
    }

    // public void setDate_in(Date Date_in) {
    // this.Date_in = Date_in;
    // }
    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }

    // public void setNSX(Date NSX) {
    // this.NSX = NSX;
    // }
    public void setSum_Cost(double Sum_Cost) {
        this.Sum_Cost = Sum_Cost;
    }

    public void setOut_Price(double Out_Price) {
        this.Out_Price = Out_Price;
    }

    public void setOne_PCost(double One_PCost) {
        this.One_PCost = One_PCost;
    }

    double Property = 0.0;

    public void addProduct(ArrayList<Product> MyStore) throws Exception {
        boolean exit = true;
        Date now = new Date();
        while (exit) {
            Product temp = new Product();
            System.out.println("-----------Add Product----------");
            System.out.print("Enter Product Name: ");
            temp.P_Name = sc.nextLine();
            System.out.print("Enter Product Type: ");
            temp.P_type = sc.nextLine();
            System.out.print("Enter Product HSD(dd/MM/yyyy): ");
            temp.HSD = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
            if (temp.HSD.compareTo(now) < 0) {
                System.out.println("HSD must be after now!!!");
            } else {
                System.out.print("Enter Number of Product: ");
                temp.P_Number = Integer.parseInt(sc.nextLine());
                int dem = 0;
                for (int i = 0; i < MyStore.size(); i++) {
                    if ((temp.P_Name.compareTo(MyStore.get(i).P_Name) == 0)
                            && (temp.P_type.compareTo(MyStore.get(i).P_type) == 0)
                            && (temp.HSD.compareTo(MyStore.get(i).HSD) == 0)) {
                        System.out.println("This Product is exist in your Store ");
                        System.out.println("We will add this Product!!!");
                        MyStore.get(i).P_Number = MyStore.get(i).P_Number + temp.P_Number;
                        Property = Property - MyStore.get(i).getOne_PCost() * temp.P_Number;
                        exit = false;
                        dem++;
                    }
                }
                if (dem == 0) {
                    System.out.print("Enter new Product sum cost: ");
                    temp.Sum_Cost = moneyFormatIn(sc.nextLine());
                    temp.One_PCost = Math.ceil((double) (temp.Sum_Cost / temp.P_Number) * 10) / 10;
                    System.out.println(
                            "One product is cost : " + moneyFormatOut(temp.One_PCost));
                    System.out.print("Enter new price of Product(1 product): ");
                    temp.Out_Price = moneyFormatIn(sc.nextLine());
                    MyStore.add(temp);
                    Property = Property - temp.Sum_Cost;
                    System.out.println(temp.P_Name + " add successful!!!");
                    exit = false;
                }
            }
        }
    }

  

    public void ShowProduct() {
        System.out.println("Product Name: " + this.P_Name);
        System.out.println("Product Type : " + this.P_type);
        System.out.println("Number remain: " + this.P_Number);

    }

    public double moneyFormatIn(String moneyIn) {
        String Money = "";
        String s[] = moneyIn.split(",");
        for (int i = 0; i < s.length; i++) {
            Money = Money.concat(s[i]);
        }
        return Double.parseDouble(Money);
    }

    public String moneyFormatOut(double moneyOut) {
        StringBuffer Money = new StringBuffer(String.valueOf(moneyOut));
        for (int i = Money.length() - 6; i >= 0; i = i - 3) {
            Money = Money.insert(i + 1, ",");
        }
        return Money.toString();
    }

}
