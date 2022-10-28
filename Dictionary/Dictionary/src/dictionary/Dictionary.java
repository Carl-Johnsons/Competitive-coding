package dictionary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {

    private String key;
    private String value;

    public Hashtable<String, String> myDictionary = new Hashtable<>();
    private Scanner sc = new Scanner(System.in);

    public void SearchVi() {
        Read();
        char option = 'a';
        do {
            System.out.println("Input ");
            String tempKey = sc.nextLine().toLowerCase();
            boolean HasKey = false;
            tempKey = tempKey.substring(0, 1).toUpperCase() + tempKey.substring(1, tempKey.length());
            if (myDictionary.containsValue(tempKey) || myDictionary.containsValue(tempKey.toLowerCase())) {
                for (String i : myDictionary.keySet()) {
                    if (myDictionary.get(i).compareToIgnoreCase(tempKey) == 0) {
                        System.out.println(myDictionary.get(i) + ":" + i);
                        HasKey = true;
                        break;
                    }
                }
            } else {
                for (String i : myDictionary.keySet()) {
                    if (myDictionary.get(i).contains(tempKey) || myDictionary.get(i).contains(tempKey.toLowerCase())) {
                        System.out.println(myDictionary.get(i));
                        HasKey = true;
                    }
                }
            }
            if (!HasKey) {
                System.out.println("No result match your keyword !");
            }
            System.out.println("Do you want to continue? (y/n)");
            do {
                option = sc.nextLine().toCharArray()[0];
                if (option != 'n' || option != 'N' || option != 'Y' || option != 'y') {
                    System.out.println("Please input y or n");
                }
            } while (option != 'n' && option != 'N' && option != 'Y' && option != 'y');
        } while (option != 'n' && option != 'N');
    }

    public void SearchEn() {
        Read();
        char option = 'a';
        do {
            System.out.println("Input ");
            String tempKey = sc.nextLine().toLowerCase();
            boolean HasKey = false;
            tempKey = tempKey.substring(0, 1).toUpperCase() + tempKey.substring(1, tempKey.length());
            if (myDictionary.containsKey(tempKey) || myDictionary.containsKey(tempKey.toLowerCase())) {
                System.out.println(tempKey + ":" + myDictionary.get(tempKey));
                HasKey = true;
            } else {
                for (String i : myDictionary.keySet()) {
                    if (i.contains(tempKey) || i.contains(tempKey.toLowerCase())) {
                        System.out.println(i);
                        HasKey = true;
                    }
                }
            }
            if (!HasKey) {
                System.out.println("No result match your keyword !");
            }
            System.out.println("Do you want to continue? (y/n)");
            do {
                option = sc.nextLine().toCharArray()[0];
                if (option != 'n' || option != 'N' || option != 'Y' || option != 'y') {
                    System.out.println("Please input y or n");
                }
            } while (option != 'n' && option != 'N' && option != 'Y' && option != 'y');
        } while (option != 'n' && option != 'N');
    }

    public void addNewWord() {
        System.out.println("Input new Word:");
        String tempKey = sc.nextLine();
        System.out.println("Input the meaning:");
        String tempValue = sc.nextLine();
        myDictionary.put(tempKey, tempValue);
        System.out.println("Added!");
        for (String i : myDictionary.keySet()) {
            System.out.println(i + "\n" + myDictionary.get(i));
            System.out.println();

        }
        System.out.println("Press Enter to continue!!");
        sc.nextLine();
    }

    public void TestSkill() {
        int score = 0;
        //RANDOM KEY
        Map<String, String> RandomWord = new LinkedHashMap<>();
        Random rand = new Random();
        ArrayList<String> t = new ArrayList<>();
        ArrayList<Boolean> checkAns = new ArrayList<>();
        for (String i : myDictionary.keySet()) {
            t.add(i);
        }
        while (RandomWord.size() < 10) {
            String temp = t.get(rand.nextInt(myDictionary.size()));
            RandomWord.put(temp, myDictionary.get(temp));
        }
        //TEST
        System.out.println("Begin Test");
        for (String i : RandomWord.keySet()) {
            System.out.println(RandomWord.get(i) + " ?");
            String ans = sc.nextLine();
            if (ans.compareTo(i) == 0) {
                score++;
                checkAns.add(true);
            } else {
                checkAns.add(false);
            }
        }
        System.out.println("Result");
        int question = 0;

        for (String i : RandomWord.keySet()) {
            System.out.print(RandomWord.get(i));
            if (checkAns.get(question)) {
                System.out.print("    +1");
            } else {
                System.out.print("     X    ( result : " + i + " ) ");
            }
            System.out.println("");
            question++;
        }

        System.out.println("You get " + score + "/10");
        System.out.println("Press Enter to continue!");
        sc.nextLine();
    }

    public void Save() {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src\\dictionary\\EnVn.txt")))) {
            for (String i : myDictionary.keySet()) {
                pw.println(i);
                pw.println(myDictionary.get(i));
            }
        } catch (Exception e) {
        }
    }

    public void Read() {
        try {
            Scanner read = new Scanner(new File("src\\dictionary\\EnVn.txt"));
            while (read.hasNextLine()) {
                String tempKey = read.nextLine();
                String tempValue = read.nextLine();
                myDictionary.put(tempKey, tempValue);
            }
        } catch (FileNotFoundException e) {
        }
    }

}
