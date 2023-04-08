public class Palindrome_Number {
    public static void main(String[] args) {
        int x = 1000001;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        int len = str.length();
        int i = 0;
        int j = len - 1;
        do {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        } while (i < j);
        return true;
    }

}