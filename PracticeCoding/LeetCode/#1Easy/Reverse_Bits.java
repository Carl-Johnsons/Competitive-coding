public class Reverse_Bits {
    public static void main(String[] args) {
        int test = 43261596;
        int res = reverseBits(test);
        System.out.println(test + " | " + Integer.toBinaryString(test));
        System.out.println(res + " | " + Integer.toBinaryString(res));

    }

    public static int reverseBits(int n) {
        int reverse = 0;
        int countBit = 0;
        while (countBit != 32) {
            reverse <<= 1;
            reverse += (n & 1);
            n >>>= 1;
            countBit++;
        }
        return reverse;
    }
}
