
public class Number_of_1_Bits {
    public static void main(String[] args) {
    }

    public static int hammingWeight(int n) {
        int count1 = 0;
        while (n != 0) {
            count1 += (n & 1);
            n >>>= 1;
        }

        return count1;
    }
}
