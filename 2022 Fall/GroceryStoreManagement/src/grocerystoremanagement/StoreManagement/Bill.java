package grocerystoremanagement.StoreManagement;

import java.util.ArrayList;
import java.util.Date;

public class Bill {

    private ArrayList<Product> BuyProduct = new ArrayList<>();
    private Customer BuyCustomer;// ten, sdt khach hang
    private double BillPrice; // gia bill
    // private double MoneyCustomer; // Tien khach hang dua
    // private double Change; // tien thoi
    private Date BillOutDate;// ngay xuat hoa don

    public void setBuyProduct(ArrayList<Product> BuyProduct) {
        this.BuyProduct = BuyProduct;
    }

    public void setBuyCostomer(Customer BuyCustomer) {
        this.BuyCustomer = BuyCustomer;
    }

    public void setBillPrice(double BillPrice) {
        this.BillPrice = BillPrice;
    }

    // public void setMoneyCustomer(double MoneyCustomer) {
    // this.MoneyCustomer = MoneyCustomer;
    // }
    // public void setChange(double Change) {
    // this.Change = Change;
    // }
    public void setBillOutDate(Date BillOutDate) {
        this.BillOutDate = BillOutDate;
    }

    public ArrayList<Product> getBuyProduct() {
        return this.BuyProduct;
    }

    public Customer getBuyCustomer() {
        return this.BuyCustomer;
    }

    public double getBillPrice() {
        return this.BillPrice;
    }

    // public double getMoneyCustomer() {
    // return this.MoneyCustomer;
    // }
    // public double getChange() {
    // return this.Change;
    // }
    public Date getBillOutDate() {
        return this.BillOutDate;
    }

}
