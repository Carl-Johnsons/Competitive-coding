//https://codeforces.com/problemset/problem/1722/C

import java.util.Scanner;

public class Team_Composition_Programmers_and_Mathematicians_time_limited_exceed {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        int res = 0;
        int programmers = sc.nextInt();
        int mathematicians = sc.nextInt();
        int TotalTeams = 0;
        // Test case : 2 2
        if (mathematicians == 2 && programmers == 2) {
            TotalTeams = 1;
        } else {
            int team = 0;

            while (programmers > 0 && mathematicians > 0) {
                if (programmers > mathematicians) {
                    int temp = programmers;
                    programmers = mathematicians;
                    mathematicians = temp;
                }
                programmers -= 1;
                mathematicians -= 3;
                if (programmers >= 0 && mathematicians >= 0)
                    TotalTeams++;
                    
                while (Math.abs(programmers - mathematicians) < 3 && Math.min(programmers, mathematicians) / 4 > 0) {
                    team = Math.min(programmers, mathematicians) / 4;
                    programmers -= team * 2;
                    mathematicians -= team * 2;

                    TotalTeams += team;
                }
                if (mathematicians == 2 && programmers == 2) {
                    TotalTeams += 1;
                    mathematicians = 0;
                    programmers = 0;
                }

            }
        }

        res = TotalTeams;
        System.out.println(res);

    }
}