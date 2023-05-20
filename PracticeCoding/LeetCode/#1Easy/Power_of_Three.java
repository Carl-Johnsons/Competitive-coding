public class Power_of_Three {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(-9));
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
