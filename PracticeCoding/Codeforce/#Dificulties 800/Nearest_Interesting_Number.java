
//https://codeforces.com/problemset/problem/1183/A
import java.util.Scanner;

public class Nearest_Interesting_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while (true) {
            int sum = 0;
            int temp = num;

            while (temp != 0) {
                sum += (temp % 10);
                temp /= 10;
            }
            int remainder = sum % 4;
            if (remainder == 0) {
                break;
            } else if (num % 10 == 9) {
                num += 1;
                continue;
            } else {
                num += (4 - remainder);
            }
        }

        System.out.print(num);
        sc.close();
    }

}

class Pokemon {

}
