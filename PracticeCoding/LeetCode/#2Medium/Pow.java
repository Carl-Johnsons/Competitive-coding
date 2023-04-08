public class Pow {
    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (n == 0 || x == 1 || (x == -1 && n % 2 == 0)) {
            return 1;
        }
        if (x == -1 && n % 2 == 1)
            return -1;

        double res = 1;
        boolean minusExponent = false;
        if (n < 0) {
            n = -n;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
            }
            minusExponent = true;
        }
        while (n > 0) {
            if (n % 2 == 0) {
                x *= x;
                n /= 2;
            } else {
                res *= x;
                n--;
            }
            if (Double.isInfinite(x))
                break;
        }
        // for (int i = 0; i < n; i++) {
        // mul *= res;
        // if (Double.isInfinite(mul))
        // break;
        // }
        if (minusExponent) {
            res = 1 / res;
        }

        return res;
    }
}