public class Smallest_Even_Multiple {

    public static void main(String[] args) {
        int n = 202;
        System.out.println(smallestEvenMultiple(n));
    }

    public static int smallestEvenMultiple(int n) {
        if (n % 2 == 0)
            return n;
        return n * 2;
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    public static int LCM(int a, int b) {
        return a * b / (GCD(a, b));
    }
}