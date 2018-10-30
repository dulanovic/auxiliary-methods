package api;

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

    public static long fibonacciDyn(int n) {
        long[] values = new long[n + 1];
        values[0] = 0;
        values[1] = 1;
        for (int i = 2; i <= n; i++) {
            values[i] = values[i - 1] + values[i - 2];
        }
        return values[n];
    }

}
