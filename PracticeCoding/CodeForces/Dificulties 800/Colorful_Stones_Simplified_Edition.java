
//https://codeforces.com/problemset/problem/265/A
import java.util.Scanner;

public class Colorful_Stones_Simplified_Edition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String way = sc.next();
        String instruction = sc.next();
        sc.close();
        char[] i = instruction.toCharArray(), w = way.toCharArray();
        int a = 0, j = 0;
        for (a = 0; a < instruction.length(); a++) {
            if (w[j] == i[a])
                j++;
        }
        System.out.print(j + 1);

    }
}
