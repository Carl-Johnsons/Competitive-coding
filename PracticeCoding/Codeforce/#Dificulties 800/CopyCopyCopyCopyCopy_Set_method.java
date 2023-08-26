
//https://codeforces.com/problemset/problem/1325/B
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class CopyCopyCopyCopyCopy_Set_method {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int num = sc.nextInt();
            // Tao stack, Set chi chua nhung phan tu khong giong nhau
            Set<Integer> arr = new HashSet<Integer>();
            for (int j = 0; j < num; j++) {
                int a = sc.nextInt();
                arr.add(a);
            }
            System.out.print(arr.size());
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
