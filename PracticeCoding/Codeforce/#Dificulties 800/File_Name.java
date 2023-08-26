
//https://codeforces.com/problemset/problem/978/B
import java.util.Scanner;

public class File_Name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();
        char s[] = str.toCharArray();
        int count = 0, delete = 0;
        for (int i = 0; i < num; i++) {
            if (s[i] == 'x')
                count++;
            else {
                if (count > 2)
                    delete += (count - 2);
                count = 0;
            }
        }
        if (count > 2)
            delete += (count - 2);
        System.out.print(delete);
        sc.close();
    }
}
