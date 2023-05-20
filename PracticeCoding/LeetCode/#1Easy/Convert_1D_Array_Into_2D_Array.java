public class Convert_1D_Array_Into_2D_Array {
    public static void main(String[] args) {

    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length)
            return new int[0][0];
        int newArray[][] = new int[m][n];

        int k = 0, l = 0;
        for (int i = 0; i < original.length; i++) {
            newArray[k][l] = original[i];
            l++;
            if (l == n) {
                l = 0;
                k++;
            }
        }

        return newArray;
    }
}
