
//https://codeforces.com/problemset/problem/1607/A
import java.util.Scanner;

public class Linear_Keyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int k = 0, total = 0, arr[] = new int[10000];
            String keyboard = sc.next(), word = sc.next();
            char[] key = keyboard.toCharArray(), w = word.toCharArray();
            for (int j = 0; j < word.length(); j++) {
                for (int h = 0; h < keyboard.length(); h++) {
                    if (w[j] == key[h]) {
                        arr[k] = h;
                        k++;
                        break;
                    }
                }
            }
            for (int j = 0; j < k - 1; j++) {
                total += Math.abs(arr[j] - arr[j + 1]);
            }
            System.out.print(total);
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
