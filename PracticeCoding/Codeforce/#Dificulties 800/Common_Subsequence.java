
//https://codeforces.com/problemset/problem/1382/A
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Common_Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int lenA = sc.nextInt(), lenB = sc.nextInt(), maxlen, result = 0;
            int arrA[] = new int[lenA], arrB[] = new int[lenB];
            Set<Integer> a = new HashSet<Integer>(), b = new HashSet<Integer>();
            boolean okay = false;
            for (int i = 0; i < lenA; i++) {
                arrA[i] = sc.nextInt();
                a.add(arrA[i]);
            }
            for (int i = 0; i < lenB; i++) {
                arrB[i] = sc.nextInt();
                b.add(arrB[i]);
            }
            maxlen = lenA;
            if (maxlen < lenB)
                maxlen = lenB;
            if (maxlen == lenA) {
                for (int i = 0; i < maxlen; i++) {
                    if (b.contains(arrA[i])) {
                        result = arrA[i];
                        okay = true;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < maxlen; i++) {
                    if (a.contains(arrB[i])) {
                        result = arrB[i];
                        okay = true;
                        break;
                    }
                }
            }
            if (okay) {
                System.out.println("YES");
                System.out.print(1 + " " + result);
            } else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
