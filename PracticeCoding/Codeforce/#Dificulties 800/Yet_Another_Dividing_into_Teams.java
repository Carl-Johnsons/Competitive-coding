
//https://codeforces.com/problemset/problem/1249/A
import java.util.Scanner;

public class Yet_Another_Dividing_into_Teams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt();
            int count[] = new int[100];
            boolean hasOne = false, adjcenthasOne = false;
            for (int i = 0; i < len; i++) {
                count[sc.nextInt() - 1]++;
            }
            for (int i = 0; i < 100; i++) {
                if (count[i] == 1 && !hasOne)
                    hasOne = true;
                if (i < 99 && count[i] == 1 && count[i + 1] == 1) {
                    adjcenthasOne = true;
                    break;
                }
            }
            System.out.print(adjcenthasOne ? 2 : hasOne ? 1 : 0);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
