
//https://codeforces.com/problemset/problem/80/A
import java.util.Scanner;

public class Panoramix_Prediction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result;
        int a = sc.nextInt(), b = sc.nextInt();
        for (int j = a + 1; j <= b; j++) {
            if (IsPrime(j)) {
                a = j;
                break;
            }
        }
        result = (a == b) ? "YES" : "NO";
        System.out.print(result);
        sc.close();
    }

    public static boolean IsPrime(int x) {
        int count = 0;
        if (x < 2)
            return false;
        else {
            for (int i = 2; i <= Math.sqrt((double) x); i++) {
                if (x % i == 0) {
                    count++;
                    break;
                }
            }
            if (count == 1)
                return false;
            else
                return true;
        }
    }
}
