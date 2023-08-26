
//https://codeforces.com/problemset/problem/1207/A
import java.util.Scanner;

public class There_Are_Two_Types_Of_Burgers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int buns = sc.nextInt(), beef_patties = sc.nextInt(), chicken = sc.nextInt();
            int h = sc.nextInt(), c = sc.nextInt();
            // hamburger need 2 buns and 1 beef
            // Chicken burger need 2 buns and 1 chicken cutlet
            int profit = 0;
            int sanluong = 0, conlai = 0;
            if (buns >= 2) {
                if (beef_patties * 2 + chicken * 2 <= buns) {
                    profit = h * beef_patties + c * chicken;
                } else {
                    if (h > c) {
                        sanluong = beef_patties * 2 > buns ? buns / 2 : beef_patties;
                        conlai = beef_patties * 2 > buns ? 0 : (buns - sanluong * 2) / 2;
                        profit = h * sanluong + conlai * c;
                    } else {
                        sanluong = chicken * 2 > buns ? buns / 2 : chicken;
                        conlai = chicken * 2 > buns ? 0 : (buns - sanluong * 2) / 2;
                        profit = c * sanluong + conlai * h;
                    }
                }
            }
            System.out.print(profit);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
