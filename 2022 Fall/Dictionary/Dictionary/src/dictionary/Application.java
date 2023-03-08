package dictionary;

import java.util.Scanner;

public class Application {

//    public static void main(String[] args) {
//        Dictionary myDictionary = new Dictionary();
//        Scanner sc = new Scanner(System.in);
//        int option = 0;
//        myDictionary.Read();
//        do {
//            Menu();
//        option = sc.nextInt();
//            sc.nextLine();
//            switch (option) {
//                case 1:
//                    myDictionary.SearchEn();
//                    break;
//                case 2:
//                    myDictionary.SearchVi();
//                    break;
//                case 3:
//                    myDictionary.addNewWord();
//                    break;
//                case 4:
//                    myDictionary.TestSkill();
//                    break;
//                case 5:
//                    System.out.println("Exit the program ... ");
//                    myDictionary.Save();
//                    System.exit(0);
//                    break;
//                default:
//                    break;
//            }
//            
//        } while (option != 5);
//        sc.close();
//    }

    public static void Menu() {
        System.out.print("Menu" + "\n"
                + "1.Tra tu dien Tieng Viet" + "\n"
                + "2.Tra tu dien Tieng Anh" + "\n"
                + "3.Them chu moi" + "\n"
                + "4.Kiem tra tu vung" + "\n"
                + "5.Thoat chuong trinh" + "\n"
                + "Choose your function: ");
    }

}
