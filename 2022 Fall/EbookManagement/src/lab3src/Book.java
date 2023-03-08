package lab3src;

import java.util.Scanner;

public class Book {

    private String ID;
    private String name;
    private int year;
    private String Author;

    public Book() {
        this.ID = "";
        this.name = "";
        this.year = 0;
        this.Author = "";
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    public String getAuthor() {
        return this.Author;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public void setYear(int Year) {
        this.year = Year;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void Input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Add new ebook -----");
        System.out.print("Input ID: ");
        ID = sc.nextLine();
        System.out.print("Input name: ");
        name = sc.nextLine();
        System.out.print("Input year: ");
        year = sc.nextInt();
        sc.nextLine();
        System.out.print("Input authors: ");
        Author = sc.nextLine();
    }

    public String Output() {
        return "-- " + ID + " -- " + name + " -- " + year + " -- " + Author;
    }
}
