public class Power_of_Four {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-9));
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        while (n != 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }
}
