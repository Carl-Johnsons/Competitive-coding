
import java.util.Scanner;
//https://codeforces.com/problemset/problem/894/A

public class Strange_Table {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // int testcase = Integer.parseInt(sc.nextLine());
        // while (testcase-- > 0) {
        //     solve();
        // }
        // sc.close();
    }


    static long res = 0;

    public static void solve() {
        // numbering by column, value = Table_col * ( m - 1 ) + n
        // numbering by row , value = Table_row * ( n - 1) + m
        // Where m,n is the row and the col of the value
        long Table_row = sc.nextLong(), Table_col = sc.nextLong();
        long value = sc.nextLong();

        // m and n is the position of the cell when counting by row
        // This varible handle the case when the value divisible by Table_row
        long temp = (value % Table_row == 0 ? 1 : 0);

        long n = (long) Math.ceil((double) value / Table_row);
        long m = value - ((long) Math.ceil(value / Table_row) - temp) * Table_row;

        // This is the cell value in mth row and nth column in the table counting by
        // columns
        res = Table_col * (m - 1) + n;
        System.out.println(res);
    }

}
