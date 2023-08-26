
//https://codeforces.com/problemset/problem/1690/C
import java.util.Scanner;

public class Restoring_the_Duration_of_Tasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt();
            int task_arrive[] = new int[len];
            int task_finnished[] = new int[len];
            for (int i = 0; i < len; i++) {
                task_arrive[i] = sc.nextInt();
            }
            for (int i = 0; i < len; i++) {
                task_finnished[i] = sc.nextInt();
            }
            System.out.print(task_finnished[0] - task_arrive[0]);
            for (int i = 1; i < len; i++) {
                System.out.print(" ");
                if (task_finnished[i - 1] > task_arrive[i])
                    System.out.print(task_finnished[i] - task_finnished[i - 1]);
                else {
                    System.out.print(task_finnished[i] - task_arrive[i]);
                }
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}