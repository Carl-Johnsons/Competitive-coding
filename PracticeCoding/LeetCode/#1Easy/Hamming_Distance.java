public class Hamming_Distance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 1));
    }

    public static int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int count1 = 0;
        while (temp != 0) {
            if (temp % 2 == 1)
                count1++;
            temp >>= 1;
        }
        return count1;
    }
}
