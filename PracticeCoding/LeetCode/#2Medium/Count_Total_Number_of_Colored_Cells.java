public class Count_Total_Number_of_Colored_Cells {
    public static void main(String[] args) {
        System.out.println(coloredCells(3));
    }

    public static long coloredCells(int n) {
        return 1l + 4l * (((long) n * ((long) n - 1) / 2));
    }
}