public class Climbing_Stairs {
    static int arr[] = new int[46];
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(climbStairs(40));
        System.out.println(count);
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (arr[n] == 0)
            arr[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return arr[n];
    }
}
