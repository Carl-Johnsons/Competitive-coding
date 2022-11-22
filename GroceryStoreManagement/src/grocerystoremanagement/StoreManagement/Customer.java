package grocerystoremanagement.StoreManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    Scanner sc = new Scanner(System.in);
    // ArrayList<Customer> MyCustomer = new ArrayList<>();
    private String STD;
    private String C_Name;
    private double C_Point;

    public void setSTD(String STD) {
        this.STD = STD;
    }

    public void setName(String C_Name) {
        this.C_Name = C_Name;
    }

    public void setPoint(double C_Point) {
        this.C_Point = C_Point;
    }

    public String getSTD() {
        return this.STD;
    }

    public String getC_Name() {
        return this.C_Name;
    }

    public double getC_Point() {
        return this.C_Point;
    }

    public void addCustomer(String NumAdd, String CusName, ArrayList<Customer> MyCustomer) {
        Customer temp = new Customer();
        temp.STD = NumAdd;
        temp.C_Name = CusName;
        temp.C_Point = 0.0;
        MyCustomer.add(temp);
    }

    public void SearchNumber(ArrayList<Customer> MyCustomer, String SearchNum) {
        int dem = 0;
        for (int i = 0; i < MyCustomer.size(); i++) {
            if (MyCustomer.get(i).getSTD().compareTo(SearchNum) == 0) {
                System.out.print("Customer Name: " + MyCustomer.get(i).C_Name);
                System.out.println("-------Thanh toan-------");
                dem++;
            }
        }
        if (dem == 0) {
            System.out.println("Enter Custom name: ");
            String CusName = sc.nextLine();
            addCustomer(SearchNum, CusName, MyCustomer);
            System.out.println("-------Thanh toan-------");
        }
    }

}
