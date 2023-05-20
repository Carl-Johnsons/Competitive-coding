public class Reverse_Integer {
    public static void main(String[] args) {
        int x = -1234567899;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        long r = 0;
        while (x != 0) {
            r = x % 10 + r * 10;
            x /= 10;
        }
        if (!(r > -Math.pow(2, 31) - 1 && r < Math.pow(2, 31))) {
            return 0;
        }
        return (int) r;
    }
}