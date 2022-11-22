package grocerystoremanagement.StoreManagement;

public class Main {
    public static void main(String[] args) throws Exception {
        Application a = new Application();
        a.readBill();
        a.readCustomer();
        a.readProduct();
        a.Add_C_TToan();
        a.Add_C_TToan();
        a.saveBill();
        a.saveCustomer();
        a.saveProduct();
    }
}
