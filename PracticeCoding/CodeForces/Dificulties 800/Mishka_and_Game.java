//https://codeforces.com/problemset/problem/703/A

import java.util.Scanner;

public class Mishka_and_Game {
    public static void main(String[] args) {
        int testcase, countMis = 0, countChris = 0;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int Mishka, Chris;
            Mishka = sc.nextInt();
            Chris = sc.nextInt();
            if (Chris - Mishka > 0)
                countChris++;
            else if (Chris - Mishka < 0)
                countMis++;
        }
        if (countChris > countMis)
            System.out.print("Chris");
        else if (countChris == countMis)
            System.out.print("Friendship is magic!^^");
        else
            System.out.print("Mishka");
        sc.close();
    }

}
