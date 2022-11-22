package grocerystoremanagement.StoreManagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;

public class Application {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);
    public ArrayList<Product> Store = new ArrayList<>();
    public ArrayList<Customer> Custom = new ArrayList<>();
    public ArrayList<Bill> Bill = new ArrayList<>();
    Product P = new Product();
    Customer C = new Customer();

    public void addProduct(Product temp) throws Exception {
        Store.add(temp);
    }

    public void Add_P() throws Exception {// them san pham moi vao kho...
        P.addProduct(Store);
    }

    public void Add_C_TToan() {// thanh toan hoac them khanh hang...
        // String SearchNum = sc.nextLine();
        //C.SearchNumber(Custom, SearchNum);
        //////////////// thanh toan bill //////////////////
//        String chose = sc.nextLine();
//        if (chose.compareTo("Ten") == 0) {
//            for (int i = 0; i < Custom.size(); i++) {
//                if (Custom.get(i).getSTD().compareTo(SearchNum) == 0) {
//                    Bill.add(exportBill(Custom.get(i)));
//
//                }
//            }
//
//        } // else if (chose.compareTo("Loai") == 0) {
        // String SearchToBuy = sc.nextLine();// tim theo loai;
        // for (int i = 0; i < Store.size(); i++) {
        // if (Store.get(i).getP_type().compareToIgnoreCase(SearchToBuy) == 0) {
        // Store.get(i).ShowProduct();
        // }
        // }
        // }

    }

    public Bill exportBill(Customer buy_Customer) {
        Bill exBill = new Bill();
        ArrayList<Product> buy_list = new ArrayList<>();
        Date now = new Date();
        double sum_price = 0.0;
        boolean exit = true;
//        while (exit) {
//            for (int i = 0; i < Store.size(); i++) {
//                if (Store.get(i).getP_Name().compareTo(SearchToBuy) == 0) {
//                    int Buy_Num = Integer.parseInt(sc.nextLine());
//                    if (Buy_Num <= Store.get(i).getP_Number()) {
//                        Product temp = Store.get(i);
//                        temp.setP_Number(Buy_Num);
//                        buy_list.add(temp);
//                        sum_price = sum_price + Buy_Num * temp.getOut_Price();
//                    }
//                }
//            }
//        }
        for (int i = 0; i < Custom.size(); i++) {
            if (Custom.get(i).getSTD().compareTo(buy_Customer.getSTD()) == 0) {
                Custom.get(i).setPoint(Custom.get(i).getC_Point() + sum_price);
            }
        }
        exBill.setBillOutDate(now);
        exBill.setBillPrice(sum_price);
        exBill.setBuyProduct(buy_list);
        exBill.setBuyCostomer(buy_Customer);

        System.out.println("Bill added");
        return exBill;
    }

   public Bill exportBill(Customer buy_Customer, Set<String> buy_Product, ArrayList<Integer> Product_sum) {
        sortPbyHSD();
        Bill exBill = new Bill();
        ArrayList<Product> buy_list = new ArrayList<>();
        Date now = new Date();
        double sum_price = 0.0;

        int index = 0;
        for (String i : buy_Product) {
            for (int j = 0; j < Store.size(); j++) {
                if (Store.get(j).getP_Name().compareToIgnoreCase(i) == 0) {
                    // EASY
                    if (Product_sum.get(index) <= Store.get(j).getP_Number()) {

                        Product temp = new Product();
                        
                        temp.setP_Name(Store.get(j).getP_Name());
                        temp.setP_type((Store.get(j).getP_type()));
                        temp.setP_Number(Product_sum.get(index));
                        temp.setOne_PCost(Store.get(j).getOne_PCost());
                        temp.setOut_Price(Store.get(j).getOut_Price());
                        temp.setSum_Cost(Store.get(j).getSum_Cost());
                        temp.setHSD(Store.get(j).getHSD());
                        
                        buy_list.add(temp);
                        sum_price = sum_price + Product_sum.get(index) * temp.getOut_Price();

                        Store.get(j).setP_Number(Store.get(j).getP_Number() - Product_sum.get(index));
                        break;
                    } // HARD
                    else {
                        int sumP = 0;
                        for (int k = 0; k < Store.size(); k++) {
                            if (Store.get(k).getP_Name().compareTo(i) == 0) {
                                sumP = sumP + Store.get(k).getP_Number();
                            }
                        }
                        // HANDLE ERROR
                        if (sumP >= Product_sum.get(index)) {
                            int tempSoLuong = Product_sum.get(index);
                            for (int l = 0; l < Store.size(); l++) {
                                if (Store.get(l).getP_Name().compareTo(i) == 0) {
                                    // EASY 2
                                    if (tempSoLuong >= Store.get(l).getP_Number()) {

                                        Product temp = new Product();
                                        
                                        temp.setP_Name(Store.get(l).getP_Name());
                                        temp.setP_type((Store.get(l).getP_type()));
                                        temp.setP_Number(Store.get(l).getP_Number());
                                        temp.setOne_PCost(Store.get(l).getOne_PCost());
                                        temp.setOut_Price(Store.get(l).getOut_Price());
                                        temp.setSum_Cost(Store.get(l).getSum_Cost());
                                        temp.setHSD(Store.get(l).getHSD());
                                        
                                        buy_list.add(temp);
                                        tempSoLuong = tempSoLuong - Store.get(l).getP_Number();
                                        Store.get(l).setP_Number(0);

                                    } else if (tempSoLuong <= Store.get(l).getP_Number()) {
                                        Product temp = new Product();
                                        
                                        temp.setP_Name(Store.get(l).getP_Name());
                                        temp.setP_type((Store.get(l).getP_type()));
                                        temp.setP_Number(tempSoLuong);
                                        temp.setOne_PCost(Store.get(l).getOne_PCost());
                                        temp.setOut_Price(Store.get(l).getOut_Price());
                                        temp.setSum_Cost(Store.get(l).getSum_Cost());
                                        temp.setHSD(Store.get(l).getHSD());
                                        
                                        buy_list.add(temp);
                                        Store.get(l).setP_Number((Store.get(l).getP_Number() - tempSoLuong));
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
            index++;
        }

        for (int i = 0; i < Custom.size(); i++) {
            if (Custom.get(i).getSTD().compareTo(buy_Customer.getSTD()) == 0) {
                Custom.get(i).setPoint(Custom.get(i).getC_Point() + sum_price);
            }
        }
        exBill.setBillOutDate(now);
        exBill.setBillPrice(sum_price);
        exBill.setBuyProduct(buy_list);
        exBill.setBuyCostomer(buy_Customer);
        System.out.println("Bill added");
        return exBill;
    }

    public void sortPbyHSD() {
        for (int i = 0; i < Store.size(); i++) {
            for (int j = i + 1; j < Store.size(); j++) {
                if (Store.get(i).getHSD().after(Store.get(j).getHSD())) {
                    Product temp = Store.get(i);
                    Store.set(i, Store.get(j));
                    Store.set(j, temp);
                }
            }
        }
    }

    public void removeNUM() {
        int delete = 0;
        for (int i = 0; i < Store.size(); i++) {
            if (Store.get(i).getP_Number() == 0) {
                Store.remove(i - delete);
                delete++;
            }
        }
    }

    public void saveProduct() {

        try (FileWriter fw = new FileWriter(
                "src\\grocerystoremanagement\\StoreManagement\\AllProduct.txt",
                false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            for (int i = 0; i < Store.size(); i++) {
                out.println(Store.get(i).getP_Name());
                out.println(Store.get(i).getP_Number());
                out.println(Store.get(i).getP_type());
                out.println(Store.get(i).getOne_PCost());
                out.println(Store.get(i).getOut_Price());
                out.println(Store.get(i).getSum_Cost());
                out.println(dateFormat.format(Store.get(i).getHSD()));
            }
        } catch (IOException io) {

        }
    }

    public void readProduct() {
        try {
            Scanner sc = new Scanner(new File(
                    "src\\grocerystoremanagement\\StoreManagement\\AllProduct.txt"));
            while (sc.hasNextLine()) {
                Product temp = new Product();
                temp.setP_Name(sc.nextLine());
                temp.setP_Number(Integer.parseInt(sc.nextLine()));
                temp.setP_type(sc.nextLine());
                temp.setOne_PCost(Double.parseDouble(sc.nextLine()));
                temp.setOut_Price(Double.parseDouble(sc.nextLine()));
                temp.setSum_Cost(Double.parseDouble(sc.nextLine()));
                temp.setHSD(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
                Store.add(temp);
            }

        } catch (FileNotFoundException io) {

        } catch (Exception e) {

        }
    }

    public void saveCustomer() {
        try (FileWriter fw = new FileWriter(
                "src\\grocerystoremanagement\\StoreManagement\\AllCustomer.txt",
                false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            for (int i = 0; i < Custom.size(); i++) {
                out.println(Custom.get(i).getC_Name());
                out.println(Custom.get(i).getSTD());
                out.println(Custom.get(i).getC_Point());
            }
        } catch (IOException io) {

        }
    }

    public void readCustomer() {
        try {
            Scanner sc = new Scanner(new File(
                    "src\\grocerystoremanagement\\StoreManagement\\AllCustomer.txt"));
            while (sc.hasNextLine()) {
                Customer temp = new Customer();
                temp.setName(sc.nextLine());
                temp.setSTD(sc.nextLine());
                temp.setPoint(Double.parseDouble(sc.nextLine()));
                Custom.add(temp);
            }
        } catch (FileNotFoundException io) {

        } catch (Exception e) {

        }
    }

    public void saveBill() {
        try (FileWriter fw = new FileWriter(
                "src\\grocerystoremanagement\\StoreManagement\\AllBill.txt",
                false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            for (int i = 0; i < Bill.size(); i++) {
                out.println(Bill.get(i).getBillPrice());
                out.println(Bill.get(i).getBuyCustomer().getC_Name());
                out.println(Bill.get(i).getBuyCustomer().getSTD());
                out.println(Bill.get(i).getBuyCustomer().getC_Point());
                out.println(dateFormat.format(Bill.get(i).getBillOutDate()));
                for (int j = 0; j < Bill.get(i).getBuyProduct().size(); j++) {
                    out.println("$$$");
                    out.println(Bill.get(i).getBuyProduct().get(j).getP_Name());
                    out.println(Bill.get(i).getBuyProduct().get(j).getP_Number());
                    out.println(Bill.get(i).getBuyProduct().get(j).getP_type());
                    out.println(Bill.get(i).getBuyProduct().get(j).getOne_PCost());
                    out.println(Bill.get(i).getBuyProduct().get(j).getOut_Price());
                    out.println(Bill.get(i).getBuyProduct().get(j).getSum_Cost());
                    out.println(dateFormat.format(Bill.get(i).getBuyProduct().get(j).getHSD()));
                }
                out.println("@@@");

            }
        } catch (IOException io) {

        }
    }

    public void readBill() {
        try {
            Scanner sc = new Scanner(new File(
                    "src\\grocerystoremanagement\\StoreManagement\\AllBill.txt"));
            while (sc.hasNextLine()) {
                Bill temp = new Bill();
                Customer tempC = new Customer();
                ArrayList<Product> tempPlist = new ArrayList<>();
                temp.setBillPrice(Double.parseDouble(sc.nextLine()));
                tempC.setName(sc.nextLine());
                tempC.setSTD(sc.nextLine());
                tempC.setPoint(Double.parseDouble(sc.nextLine()));
                temp.setBuyCostomer(tempC);
                temp.setBillOutDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
                while (sc.nextLine().compareTo("@@@") != 0) {
                    Product tempP = new Product();
                    tempP.setP_Name(sc.nextLine());
                    tempP.setP_Number(Integer.parseInt(sc.nextLine()));
                    tempP.setP_type(sc.nextLine());
                    tempP.setOne_PCost(Double.parseDouble(sc.nextLine()));
                    tempP.setOut_Price(Double.parseDouble(sc.nextLine()));
                    tempP.setSum_Cost(Double.parseDouble(sc.nextLine()));
                    tempP.setHSD(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
                    tempPlist.add(tempP);
                }
                temp.setBuyProduct(tempPlist);
                Bill.add(temp);
            }
        } catch (FileNotFoundException io) {

        } catch (Exception e) {

        }
    }
}
