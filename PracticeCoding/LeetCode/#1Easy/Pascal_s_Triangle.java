import java.util.ArrayList;
import java.util.List;

public class Pascal_s_Triangle {
    public static void main(String[] args) {
        System.out.println(generate(30));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            pascalTriangle.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    pascalTriangle.get(i).add(1);
                } else {
                    pascalTriangle.get(i).add(pascalTriangle.get(i - 1).get(j) + pascalTriangle.get(i - 1).get(j - 1));
                }
            }
        }

        return pascalTriangle;
    }
}
