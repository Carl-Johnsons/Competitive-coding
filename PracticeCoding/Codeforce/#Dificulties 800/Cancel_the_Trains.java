
//https://codeforces.com/problemset/problem/1453/A
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Cancel_the_Trains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int lena = sc.nextInt();
            int lenb = sc.nextInt();
            int crash = 0;
            Set<Integer> a = new HashSet<>(), b = new HashSet<>();
            for (int i = 0; i < lena; i++) {
                a.add(sc.nextInt());
            }
            for (int i = 0; i < lenb; i++) {
                int temp = sc.nextInt();
                if (a.contains(temp))
                    crash++;
                b.add(temp);
            }
            System.out.print(crash);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
