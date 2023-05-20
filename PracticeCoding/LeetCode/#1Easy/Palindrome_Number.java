public class Palindrome_Number {
    public static void main(String[] args) {
        int x = 1100011;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int x2 = x;
        while (x2 != 0) {
            reverse = x2 % 10 + reverse * 10;
            x2 /= 10;
        }

        return x == reverse;
    }

}