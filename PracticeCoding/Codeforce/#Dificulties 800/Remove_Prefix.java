
//https://codeforces.com/problemset/problem/1714/B
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Remove_Prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt();
            Set<Integer> s = new HashSet<Integer>();
            int arr[] = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = len - 1; i >= 0; i--) {
                if (!s.contains(arr[i]))
                    s.add(arr[i]);
                else
                    break;
            }
            System.out.print(len -s.size());
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
