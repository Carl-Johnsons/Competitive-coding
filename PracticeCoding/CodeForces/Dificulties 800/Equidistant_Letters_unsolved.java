
//https://codeforces.com/problemset/problem/1626/A
import java.util.Scanner;

public class Equidistant_Letters_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int min_distance = 9999, dem = 0;
            int[] distance = new int[30], count = new int[30];
            String str = sc.next();
            char s[] = str.toCharArray(), temp;
            for (int i = 0; i < str.length(); i++) {
                int k = s[i] - (int) 'a';
                count[k]++;

            }
            for (int i = 0; i < 26; i++) {
                if (count[i] == 2) {
                    distance[i] = Math.abs((i - distance[i]));
                    dem++;
                }
            }
            for (int i = 0; i < 26; i++) {
                if (min_distance > distance[i] && distance[i] != 0)
                    min_distance = distance[i];
            }
            if (dem == 1)
                min_distance = 0;
            min_distance++;
            for (int i = 0; i < 26; i++) {
                boolean okay = false;
                if (count[i] == 2) {
                    for (int j = 0; j < str.length(); j++) {
                        if (s[j] == i + (int) 'a' && s[min_distance] != i + (int) 'a') {
                            for (int k = j + 1; k < str.length(); k++) {
                                if (s[k] == i + (int) 'a') {
                                    temp = s[j + min_distance];
                                    s[j + min_distance] = s[k];
                                    s[k] = temp;
                                    okay = true;
                                    break;
                                }
                            }
                        }
                        if (okay)
                            break;
                    }
                }
            }
            String a = new String(s);
            System.out.print(a);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
