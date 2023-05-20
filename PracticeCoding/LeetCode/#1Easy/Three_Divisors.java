public class Three_Divisors {
    public static void main(String[] args) {
        System.out.println(isThree(9));
    }

    public static boolean isThree(int n) {
        if (n <= 2)
            return false;
        int sqrt = (int) Math.sqrt(n);
        if ((sqrt * sqrt) != n) {
            return false;
        }
        n = sqrt;
        return isPrime(n);
    }

    public static boolean isPrime(int x) {
        if (x <= 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
