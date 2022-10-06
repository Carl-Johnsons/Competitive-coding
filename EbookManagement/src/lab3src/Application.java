package lab3src;

import com.sun.imageio.plugins.common.I18N;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    static ArrayList<EBook> MyBook = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new GUI().RunSystem();
        /*
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int maxIndex = 0;
        Read();
        do {
            System.out.print(Menu());
            option = sc.nextInt();
            switch (option) {
                case 1:
                    EBook temp = new EBook();
                    temp.Input();
                    MyBook.add(temp);
                    break;
                case 2:
                    System.out.println("----- List of ebooks -----\n"
                            + "-- ID -- Ebook name -- Year – Authors -- URL -- Size --");
                    for (int i = 0; i < MyBook.size(); i++) {
                        MyBook.get(i).Output();
                    }
                    break;
                case 3:
                    System.out.println("----- List of the biggest size ebooks -----\n"
                            + "-- ID -- Ebook name -- Year – Authors -- URL -- Size --");
                    for (int i = 0; i < MyBook.size(); i++) {
                        if (MyBook.get(maxIndex).getSize() < MyBook.get(i).getSize()) {
                            maxIndex = i;
                        }
                    }
                    MyBook.get(maxIndex).Output();
                    break;
                case 4:
                    System.out.println("THANK FOR USING MY APPLICATION!\n"
                            + "SEE YOU AGAIN!");
                    break;
                default:
                    System.out.println("The function of application must be from 1 to 3!");
                    break;
            }
        } while (option != 4);
        Save();
         */
    }

    public static String Menu() {
        return "----- EBOOK MANAGEMENT -----\n"
                + "1. Adds new ebook.\n"
                + "2. Shows all ebooks.\n"
                + "3. The biggest size ebook.\n"
                + "4. Quit.\n"
                + "Please select a function:";
    }

    public static String Show(EBook a) {
        return "-- " + a.getID() + " -- " + a.getName() + " -- " + a.getYear() + " –- " + a.getAuthor() + " -- " + a.getURL() + " – " + a.getSize() + " --";
    }



  

   
}
