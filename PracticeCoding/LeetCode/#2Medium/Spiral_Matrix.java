import java.util.LinkedList;
import java.util.List;

public class Spiral_Matrix {
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        boolean horizontal = true;
        int increment = 1;
        int count = 0, available = m * n;
        while (available-- != 0) {
            list.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;

            i += (!horizontal ? increment : 0);
            j += (horizontal ? increment : 0);

            if ((!horizontal && i == -1)
                    || (horizontal && j == -1)
                    || (!horizontal && i == m) || (horizontal && j == n)
                    || matrix[i][j] == Integer.MAX_VALUE) {
                i -= (!horizontal ? increment : 0);
                j -= (horizontal ? increment : 0);
                horizontal = !horizontal;
                count++;
                if (count % 2 == 0) {
                    increment = -increment;
                }
                i += (!horizontal ? increment : 0);
                j += (horizontal ? increment : 0);
            }
        }

        return list;
    }
}
