

public class XOR_Operation_in_an_Array {
    public static void main(String[] args) {
        int n = 3;
        int start = 5;
        System.out.println(xorOperation(n, start));
    }

    public static int xorOperation(int n, int start) {
        int sum = start;
        for (int i = 1; i < n; i++) {
            sum ^= start + 2 * i;
        }

        return sum;
    }
}
