public class Minimum_Cuts_to_Divide_a_Circle {
    public static void main(String[] args) {

    }

    public static int numberOfCuts(int n) {
        return (n == 1 ? 0 : n % 2 == 0 ? n / 2 : n);
    }
}
