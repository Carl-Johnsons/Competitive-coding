import java.util.Scanner;

public class FGT_Arr01_2Complement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        String res;
        if (L <= 0) {
            System.out.println("Number of bit must be greater than 0");
            return;
        }
        if (Math.abs(N) >= (int) Math.pow(2, L)) {
            System.out.println("Not enough bit");
            return;
        }
        res = Integer.toBinaryString(N);
        if (N < 0) {
            res = res.substring(res.length() - L, res.length());
        } else {
            while (res.length() < L) {
                res = "0" + res;
            }
        }
        System.out.println(res);
    }
}