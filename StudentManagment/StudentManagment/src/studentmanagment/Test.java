package studentmanagment;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagment a = new StudentManagment();
        int option = 0;
        do {
            a.CreateMenu();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    a.AddStudent();
                    break;
                case 2:
                    a.ShowNameList();
                    break;
                case 3:
                    a.Search();
                    break;
                case 4:
                    System.out.println("Exitting the program...");
                    break;
                default:
                    System.out.println("NO");
                    break;
            }
        } while (option != 4);
        sc.close();
    }
}
