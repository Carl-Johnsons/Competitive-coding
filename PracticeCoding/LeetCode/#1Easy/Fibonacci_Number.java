public class Fibonacci_Number {
    static int arr[] = new int[31];

    public static void main(String[] args) {
        System.out.println(fib(1));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (arr[n] == 0)
            arr[n] = fib(n - 1) + fib(n - 2);
        return arr[n];
    }
}
