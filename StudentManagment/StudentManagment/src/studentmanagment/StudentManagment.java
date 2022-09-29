package studentmanagment;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class StudentManagment {
    
    private final List<String> list = new ArrayList<String>();
    private final Scanner s = new Scanner(System.in);
    
    public void CreateMenu() {
        System.out.println("STUDENT NAMES MANAGER");
        System.out.printf("\t1. Add a name\n");
        System.out.printf("\t2. Show names list\n");
        System.out.printf("\t3. Search for name\n");
        System.out.printf("\t4. Exit\n");
        System.out.printf("Please enter your choice: ");
    }
    
    public void AddStudent() {
        
        System.out.print("Please enter name : ");
        String name = s.nextLine();
        this.list.add(name);
        System.out.println("*** Name added! ***");
        s.nextLine();
    }
    
    public void ShowNameList() {
        System.out.println("* Name list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        s.nextLine();
    }
    
    public void Search() {
        System.out.println(" - Please enter keyword: ");
        String keyword = s.next();
        System.out.println(" - Search results: ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).substring(0, keyword.length()).equals(keyword)) {
                System.out.println("    + " + list.get(i));
            }
        }
        s.nextLine();
    }
}
