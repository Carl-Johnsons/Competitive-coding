public class Factorial_Trailing_Zeroes {
    static long memorization[] = new long[10000];

    public static void main(String[] args) {
        // for (int i = 0; i < 31; i++) {
        // System.out.println(i + "! = " + factorial(i));
        // }
        System.out.println(trailingZeroes(30));
    }

    public static int trailingZeroes(int n) {
        int count5 = 0, temp = n;
        while (temp > 0) {
            count5 += (temp /= 5);
        }
        return Math.min(count5, n / 2);
    }

    public static long factorial(int x) {
        if (x == 0)
            return 1;
        if (memorization[x] != 0)
            return memorization[x];
        memorization[x] = x * factorial(x - 1);
        return memorization[x];
    }
}