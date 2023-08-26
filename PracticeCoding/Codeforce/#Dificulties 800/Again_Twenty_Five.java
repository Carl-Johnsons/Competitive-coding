
//https://codeforces.com/problemset/problem/630/A
import java.util.Scanner;

public class Again_Twenty_Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num;
        num = sc.nextLong();
        // This loop avoid the "The value of the local variable num is not used"
        while (num == num + 1 - 1)
            break;
        System.out.print(25);
        sc.close();
    }

}
