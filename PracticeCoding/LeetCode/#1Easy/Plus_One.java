public class Plus_One {
    public static void main(String[] args) {
        int arr[] = { 9, 9, 9, 9 };
        arr = plusOne(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static int[] plusOne(int[] digits) {
        int value = digits[digits.length - 1] + 1;
        digits[digits.length - 1] = value % 10;
        int remaining = value >= 10 ? 1 : 0;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (remaining == 1) {
                value = digits[i] + remaining;
                remaining = value >= 10 ? 1 : 0;
                digits[i] = value % 10;
            } else {
                break;
            }
        }
        if (remaining == 1) {
            int arr[] = new int[digits.length + 1];
            arr[0] = remaining;
            for (int i = 1; i < arr.length; i++) {
                arr[i] = digits[i - 1];
            }
            return arr;
        }
        return digits;
    }
}
