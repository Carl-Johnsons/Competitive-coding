package lab3src;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EBook extends Book {

    private String URL;
    private int size;

    public EBook() {
        super();
        this.URL = "";
        this.size = 0;
    }

    public String getURL() {
        return this.URL;
    }

    public int getSize() {
        return this.size;
    }

    public void SetURL(String URL) {
        this.URL = URL;
    }

    public void SetSize(int Size) {
        this.size = Size;
    }

    @Override
    public void Input() {

        Scanner sc = new Scanner(System.in);
        super.Input();
        System.out.print("Input URL: ");
        this.URL = sc.nextLine();
        System.out.print("Input size (kilobyte): ");
        this.size = sc.nextInt();
        System.out.println("Ebook created and added to list of ebooks successful!");
    }


    @Override
    public String Output() {
        return "-- " + super.getID() + " -- " + super.getName() + " -- " + super.getYear() + " -- " + super.getAuthor() + " -- " + this.URL + " - " + this.size + " --";
    }
}
