public class Fibonacci {

    private Fibonacci() {}

    private static long[] values = new long[101];

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static long fibonacciEff(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (values[n] == 0) {
            values[n] = fibonacciEff(n - 1) + fibonacciEff(n - 2);
        }
        return values[n];
    }

}
