
//https://codeforces.com/problemset/problem/1626/A
import java.util.Scanner;

public class Equidistant_Letters {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        String str = sc.nextLine();
        int alphabet[] = new int[26];
        int indices[] = new int[26];

        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        for (int i = 0; i < str.length(); i++) {
            int k = (int) str.charAt(i) - 'a';
            alphabet[k]++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            for (int j = i + 1; j < alphabet.length; j++) {
                if (alphabet[i] < alphabet[j]) {
                    int temp = alphabet[i];
                    alphabet[i] = alphabet[j];
                    alphabet[j] = temp;

                    temp = indices[i];
                    indices[i] = indices[j];
                    indices[j] = temp;
                }
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0)
                break;
            for (int j = 0; j < alphabet[i]; j++) {
                System.out.print((char) (indices[i] + 'a'));
            }
        }
        System.out.println();
    }

}
