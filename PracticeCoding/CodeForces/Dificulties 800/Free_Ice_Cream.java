
//https://codeforces.com/problemset/problem/686/A
import java.util.Scanner;

public class Free_Ice_Cream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), distress = 0;
        long x = sc.nextLong();
        while (n != 0) {
            n--;
            char op = sc.next().toCharArray()[0];
            long num = sc.nextLong();
            if (op == '+') {
                x += num;
            } else if (op == '-') {
                if (x >= num)
                    x -= num;
                else
                    distress++;
            }
        }
        System.out.print(x + " " + distress);
        sc.close();
    }
}
