
//https://codeforces.com/problemset/problem/1421/A
import java.util.Scanner;

public class XORwice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            System.out.print(sc.nextInt() ^ sc.nextInt());
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
