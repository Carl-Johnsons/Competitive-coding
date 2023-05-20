public class Valid_Perfect_Square {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }

    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return Math.abs(sqrt * sqrt - num) <= 0.00001;
    }
}
