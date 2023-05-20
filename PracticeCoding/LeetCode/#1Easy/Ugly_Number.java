public class Ugly_Number {
    public static void main(String[] args) {
        System.out.println(isUgly(-5));
    }

    public static boolean isUgly(int n) {
        if (n <= 0)
            return false;
        while (n % 5 == 0) {
            n /= 5;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while ((n & 1) == 0) {
            n >>>= 1;
        }
        return n == 1;
    }
}
