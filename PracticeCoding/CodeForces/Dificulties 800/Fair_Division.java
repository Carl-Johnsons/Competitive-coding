import java.util.Scanner;

//https://codeforces.com/problemset/problem/1472/B

public class Fair_Division {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n, count1 = 0, count2 = 0, sum = 0;
            n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            for (int j = 0; j < n; j++) {
                if (arr[j] == 1)
                    count1++;
                else if (arr[j] == 2)
                    count2++;
                sum += arr[j];
            }
            if (sum % 2 == 1 || (count1 == 0 && count2 % 2 == 1))
                System.out.print("NO");
            else
                System.out.print("Yes");
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
