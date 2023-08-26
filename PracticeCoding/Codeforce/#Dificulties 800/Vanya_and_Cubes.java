
//https://codeforces.com/problemset/problem/492/A
import java.util.Scanner;

public class Vanya_and_Cubes {
    public static void main(String[] args) {
        int cubes, height = 0, sum = 0;
        Scanner sc = new Scanner(System.in);
        cubes = sc.nextInt();
        while (true) {
            sum += ((height + 1) * height) / 2;
            if (sum > cubes) {
                height--;
                break;
            }
            height++;
        }
        System.out.print(height);
        sc.close();
    }
}
