public class Defuse_the_Bomb {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 9, 3 };
        int k = -2;
        int de[] = decrypt(arr, k);
        for (int i = 0; i < de.length; i++) {
            System.out.print(de[i] + " ");
        }
    }

    public static int[] decrypt(int[] code, int k) {
        int result[] = new int[code.length];
        if (k == 0)
            return result;
        int index;
        for (int i = 0; i < result.length; i++) {
            if (k > 0)
                for (int j = i + 1; j < i + 1 + k; j++) {
                    index = j % result.length;
                    result[i] += code[index];
                }
            else if (k < 0)
                for (int j = i + k; j < i; j++) {
                    index = (j < 0 ? result.length + j : j);
                    result[i] += code[index];
                }
        }
        return result;
    }
}
