
//https://codeforces.com/problemset/problem/1452/A
import java.util.Scanner;

public class Robot_Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int hang = sc.nextInt();
            int cot = sc.nextInt();
            int diff = Math.abs(hang - cot);
            if (diff <= 1) {
                System.out.print(hang + cot);
            } else {
                int rowPath, linePath;
                if (hang > cot) {
                    rowPath = (hang - cot - 1) * 2;
                    linePath = cot * 2;
                } else {
                    rowPath = hang * 2;
                    linePath = (cot - hang - 1) * 2;
                }
                System.out.print(rowPath + linePath + 1);
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

}
