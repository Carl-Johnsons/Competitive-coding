
//https://codeforces.com/problemset/problem/1616/A
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Integer_Diversity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                int temp = sc.nextInt();
                if (set.contains(temp))
                    set.add(-temp);
                else
                    set.add(temp);
            }
            System.out.print(set.size());
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
