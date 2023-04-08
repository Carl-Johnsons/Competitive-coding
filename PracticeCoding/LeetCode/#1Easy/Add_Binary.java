public class Add_Binary {
    public static void main(String[] args) {
        String a = "11", b = "11";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        String sum = "";

        int i = a.length() - 1; // for a
        int j = b.length() - 1; // for b
        int remaining = 0;
        int value = 0;
        int m, n;
        while (i >= 0 && j >= 0) {
            m = (int) (a.charAt(i) - '0');
            n = (int) (b.charAt(j) - '0');
            value = m + n + remaining;

            if (value > 1) {
                value = (value % 2 == 0 ? 0 : 1);
                remaining = 1;
            } else {
                remaining = 0;
            }

            sum = String.valueOf(value) + sum;

            i--;
            j--;
        }
        // if a still have binary number
        while (i >= 0) {
            m = (int) (a.charAt(i) - '0');
            value = m + remaining;

            if (value > 1) {
                value = (value % 2 == 0 ? 0 : 1);
                remaining = 1;
            } else {
                remaining = 0;
            }

            sum = String.valueOf(value) + sum;

            i--;
        }
        // if b still have binary number
        while (j >= 0) {
            n = (int) (b.charAt(j) - '0');
            value = n + remaining;

            if (value > 1) {
                value = (value % 2 == 0 ? 0 : 1);
                remaining = 1;
            } else {
                remaining = 0;
            }

            sum = String.valueOf(value) + sum;

            j--;
        }

        // Handle if still have remaining
        if (remaining > 0) {
            sum = String.valueOf(remaining) + sum;
        }

        return sum;
    }
}
