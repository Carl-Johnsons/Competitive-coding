public class N_th_Tribonacci_Number {
    static int arr[] = new int[38];

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        if (arr[n] == 0) {
            arr[n] = tribonacci(n-1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
        return arr[n];
    }
}
