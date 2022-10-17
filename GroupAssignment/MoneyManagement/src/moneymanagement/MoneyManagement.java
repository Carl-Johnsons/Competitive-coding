package moneymanagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MoneyManagement {

    private Date currentDate;
    private String Reason;
    private int ThuChi;
    private Scanner sc = new Scanner(System.in);
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private boolean In = false;
    private ArrayList<MoneyManagement> Money = new ArrayList<>();

    public MoneyManagement() {
        currentDate = new Date();
        ThuChi = 0;
        Reason = "No Reason";
    }

    public ArrayList<MoneyManagement> getList() {
        return this.Money;
    }

    public Date getDate() {
        return this.currentDate;
    }

    public void add() throws ParseException {
        MoneyManagement temp = new MoneyManagement();
        System.out.println("Please input the date");
        temp.currentDate = dateFormat.parse(sc.nextLine());
        if (temp.currentDate.after(currentDate)) {
            System.out.println("The day you input is in the future");
        } else {
            System.out.println("Reason?");
            temp.Reason = sc.nextLine();
            System.out.println("Thu chi ?");
            temp.ThuChi = sc.nextInt();
            Money.add(temp);
            for (int i = 0; i < Money.size(); i++) {
                System.out.println(PrintAllAtr(i) + "\n" + Space());
            }
            System.out.println("Press Enter to continue");
            sc.nextLine();
            sc.nextLine();
        }

    }

    public void Update() throws ParseException {

        ArrayList<Integer> index = new ArrayList<>();
        boolean hasDate = false;
        int count = 0;
        System.out.println("Date ?");
        Date datetemp = dateFormat.parse(sc.nextLine());
        for (int i = 0; i < Money.size(); i++) {
            if (Money.get(i).currentDate.compareTo(datetemp) == 0) {
                hasDate = true;
                index.add(i);
                System.out.println(count + ". " + PrintAllAtr(i));
                count++;
            }
        }
        if (hasDate) {
            System.out.println("Choose date you want to update");
            int d = sc.nextInt();
            sc.nextLine();
            System.out.println("New Reason ? ");
            Money.get(index.get(d)).Reason = sc.nextLine();
            System.out.println("New Thu CHi ?");
            Money.get(index.get(d)).ThuChi = sc.nextInt();
            System.out.println("Update successfully!");
            for (int i = 0; i < Money.size(); i++) {
                System.out.println(PrintAllAtr(i) + "\n" + Space());
            }
            System.out.println("Press Enter to continue");
            sc.nextLine();
        } else {
            System.out.println("Error: Date not found: " + datetemp);
        }
    }

    public void Delete() throws ParseException {
        ArrayList<Integer> index = new ArrayList<>();
        boolean hasDate = false;
        int count = 0;
        System.out.println("Date ?");
        Date datetemp = dateFormat.parse(sc.nextLine());
        for (int i = 0; i < Money.size(); i++) {
            String date = Money.get(i).currentDate.toString();
            if (Money.get(i).currentDate.compareTo(datetemp) == 0) {
                hasDate = true;
                index.add(i);
                System.out.println(count + ". " + PrintAllAtr(i));
                count++;
            }
        }
        if (hasDate) {
            System.out.println("Choose date you want to Delete");
            boolean deleted = false;
            int d = sc.nextInt();
            sc.nextLine();
            char option = 'a';
            do {
                System.out.println("Delete " + PrintAllAtr(index.get(d)) + "?");
                option = sc.next().toCharArray()[0];
                switch (option) {
                    case 'y':
                    case 'Y':
                        Money.remove((int) index.get(d));
                        deleted = true;
                        break;
                    case 'n':
                    case 'N':
                        break;
                    default:
                        System.out.println("Please choose y/n");
                        break;
                }
            } while (option != 'y' && option != 'Y' && option != 'n' && option != 'N');
            if (deleted) {
                System.out.println("Delete Successfully!");
                for (int i = 0; i < Money.size(); i++) {
                    System.out.println(PrintAllAtr(i) + "\n" + Space());
                }
                System.out.println("Press Enter to continue");
                sc.nextLine();
                sc.nextLine();
            }
        } else {
            System.out.println("Error: Date not found: " + datetemp);
        }
    }

    public void ThongKe() throws ParseException {
        System.out.println("From ?");
        Date from = dateFormat.parse(sc.nextLine());
        System.out.println("To ?");
        Date after = dateFormat.parse(sc.nextLine());
        for (int i = 0; i < Money.size(); i++) {
            if (Money.get(i).currentDate.after(from) && Money.get(i).currentDate.before(after)) {
                System.out.println(PrintAllAtr(i) + "\n" + Space());
            }
        }
    }

    public void Save() throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src\\moneymanagement\\wallet.txt")))) {
            for (int i = 0; i < Money.size(); i++) {
                pw.println(dateFormat.format(Money.get(i).currentDate));
                pw.println(Money.get(i).Reason);
                pw.println(Money.get(i).ThuChi);
            }
        } catch (FileNotFoundException e) {
        }
    }

    public void Read() throws FileNotFoundException, ParseException {
        try {
            Money.clear();
            Scanner read = new Scanner(new File("src\\moneymanagement\\wallet.txt"));
            while (read.hasNextLine()) {
                MoneyManagement temp = new MoneyManagement();
                temp.currentDate = dateFormat.parse(read.nextLine());
                temp.Reason = read.nextLine();
                temp.ThuChi = Integer.parseInt(read.nextLine());
                if (temp.ThuChi > 0) {
                    temp.In = true;
                }
                Money.add(temp);
            }
        } catch (FileNotFoundException e) {
        }

    }

    public MoneyManagement(Date currentDate, int ThuChi, String Reason) {
        this.currentDate = currentDate;
        this.ThuChi = ThuChi;
        this.Reason = Reason;
    }

    public String PrintAllAtr(int i) {
        return dateFormat.format(Money.get(i).currentDate) + " ---- " + Math.abs(Money.get(i).ThuChi) + " ---- " + (Money.get(i).In ? "In    " : "Out") + " ---- " + Money.get(i).Reason;
    }

    public String Space() {
        return "#####################";
    }

    public String Menu() {
        return "1.Add" + "\n"
                + "2.Update" + "\n"
                + "3.Delete" + "\n"
                + "4.Thong Ke" + "\n"
                + "5.Exit" + "\n"
                + "   Please choose any function (1~5) : ";
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public String getReason() {
        return Reason;
    }

    public int getThuChi() {
        return ThuChi;
    }

    public boolean isIn() {
        return In;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public void setThuChi(int ThuChi) {
        this.ThuChi = ThuChi;
        this.In = this.ThuChi >= 0;
    }

    public void setMoney(ArrayList<MoneyManagement> Money) {
        this.Money = Money;
    }

}
